package com.example.githubapiproxy.services;

import com.example.githubapiproxy.model.github.Branch;
import com.example.githubapiproxy.proxy.GithubAPIProxy;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BranchService {

    private final GithubAPIProxy githubAPIProxy;

    public BranchService(GithubAPIProxy githubAPIProxy) {
        this.githubAPIProxy = githubAPIProxy;
    }

    public List<Branch> getRepositoryBranches(String repositoryName) {
        return githubAPIProxy.fetchBranchInfo(repositoryName);
    }
}
