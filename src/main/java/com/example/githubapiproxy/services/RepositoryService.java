package com.example.githubapiproxy.services;

import com.example.githubapiproxy.model.dto.RepositoryDTO;
import com.example.githubapiproxy.model.github.Branch;
import com.example.githubapiproxy.model.github.RepositoriesPage;
import com.example.githubapiproxy.model.github.Repository;
import com.example.githubapiproxy.proxy.GithubAPIProxy;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
public class RepositoryService {

    private final GithubAPIProxy githubAPIProxy;

    public RepositoryService(GithubAPIProxy githubAPIProxy) {
        this.githubAPIProxy = githubAPIProxy;
    }

    public List<RepositoryDTO> getAllByUsername(String username) {
        githubAPIProxy.checkIfUserExists(username);

        return getRepositoriesFromApi(username)
                .stream()
                .map(repository -> {
                    List<Branch> branches = getBranchesFromAPI(repository.fullName());
                    return RepositoryDTO.mapToDTO(repository, branches);
                })
                .toList();
    }

    private List<Repository> getRepositoriesFromApi(String username) {
        List<Repository> repositories = new LinkedList<>();

        RepositoriesPage page = githubAPIProxy.fetchUserRepositories(username, 0);
        int numberOfRepositories = page.totalCount();
        int currentPage = 0;

        while (repositories.size() < numberOfRepositories && !page.repositories().isEmpty()) {
            page = githubAPIProxy.fetchUserRepositories(username, currentPage);

            repositories.addAll(page.repositories());
            currentPage++;
        }

        return repositories;
    }

    private List<Branch> getBranchesFromAPI(String repositoryName) {
        return githubAPIProxy.fetchBranchInfo(repositoryName);
    }
}
