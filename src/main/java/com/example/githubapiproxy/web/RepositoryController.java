package com.example.githubapiproxy.web;

import com.example.githubapiproxy.model.dto.RepositoryDTO;
import com.example.githubapiproxy.services.RepositoryService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(
        value = "/api/repositories",
        produces = MediaType.APPLICATION_JSON_VALUE
)
public class RepositoryController {

    private final RepositoryService repositoryService;

    public RepositoryController(RepositoryService repositoryService) {
        this.repositoryService = repositoryService;
    }

    @GetMapping("/{username}")
    public ResponseEntity<List<RepositoryDTO>> repositories(@PathVariable String username) {
        List<RepositoryDTO> repositories = repositoryService.getAllByUsername(username);
        return ResponseEntity.ok(repositories);
    }
}
