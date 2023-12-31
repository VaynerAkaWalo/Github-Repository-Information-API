package com.example.githubapiproxy.proxy;

import com.example.githubapiproxy.model.github.Branch;
import com.example.githubapiproxy.model.github.RepositoriesPage;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;


@FeignClient(name = "GithubProxy", url = "${github.api.url}")
public interface GithubAPIProxy {

    @GetMapping("/search/repositories?q=user:{username}&page={page}&per_page=100")
    RepositoriesPage fetchUserRepositories(@PathVariable String username, @PathVariable int page);

    @GetMapping("/repos/{repository}/branches")
    List<Branch> fetchBranchInfo(@PathVariable String repository);

    @RequestMapping(method = RequestMethod.HEAD, value = "/users/{username}")
    ResponseEntity<Void> checkIfUserExists(@PathVariable String username);
}
