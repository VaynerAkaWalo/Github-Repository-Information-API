package com.example.githubapiproxy.services;

import com.example.githubapiproxy.model.dto.RepositoryDTO;
import com.example.githubapiproxy.model.github.RepositoriesPage;
import com.example.githubapiproxy.model.github.Repository;
import com.example.githubapiproxy.proxy.GithubAPIProxy;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
public class RepositoryService {

    private final GithubAPIProxy githubAPIProxy;
    private final BranchService branchService;
    private final UserService userService;

    public RepositoryService(GithubAPIProxy githubAPIProxy, BranchService branchService, UserService userService) {
        this.githubAPIProxy = githubAPIProxy;
        this.branchService = branchService;
        this.userService = userService;
    }

    public List<RepositoryDTO> getAllByUsername(String username) {
        userService.CheckIfUserExist(username);

        return getRepositoriesFromApi(username)
                .stream()
                .map(RepositoryDTO::mapToDTO)
                .toList();
    }

    private List<Repository> getRepositoriesFromApi(String username) {
        List<Repository> repositories = new LinkedList<>();

        RepositoriesPage page = githubAPIProxy.fetchUserRepositories(username, 0);
        int numberOfRepositories = page.getTotal_count();
        int currentPage = 0;

        while (repositories.size() < numberOfRepositories && page.getRepositories().size() > 0) {
            page = githubAPIProxy.fetchUserRepositories(username, currentPage);

            populateRepositoryWithBranchData(page.getRepositories());

            repositories.addAll(page.getRepositories());
            currentPage++;
        }

        return repositories;
    }

    private void populateRepositoryWithBranchData(List<Repository> repositories) {
        repositories.forEach(x -> x.setBranches(branchService.getRepositoryBranches(x.getFullName())));
    }
}
