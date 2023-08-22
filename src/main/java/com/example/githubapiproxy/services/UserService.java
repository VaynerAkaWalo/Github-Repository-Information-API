package com.example.githubapiproxy.services;

import com.example.githubapiproxy.proxy.GithubAPIProxy;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final GithubAPIProxy githubAPIProxy;

    public UserService(GithubAPIProxy githubAPIProxy) {
        this.githubAPIProxy = githubAPIProxy;
    }

    public void CheckIfUserExist(String username) {
        githubAPIProxy.checkIfUserExists(username);
    }
}
