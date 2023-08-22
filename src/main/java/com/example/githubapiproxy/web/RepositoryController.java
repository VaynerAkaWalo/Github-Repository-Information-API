package com.example.githubapiproxy.web;

import com.example.githubapiproxy.model.github.Repository;
import com.example.githubapiproxy.services.RepositoryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/repositories")
public class RepositoryController {

    private final RepositoryService repositoryService;

    public RepositoryController(RepositoryService repositoryService) {
        this.repositoryService = repositoryService;
    }

    @GetMapping
    public ResponseEntity<List<Repository>> repositories(@RequestParam String username) {
        List<Repository> repositories = repositoryService.getAllByUsername(username);
        return ResponseEntity.ok(repositories);
    }
}
