package com.example.githubapiproxy.model.dto;

import com.example.githubapiproxy.model.github.Repository;

import java.util.List;

public record RepositoryDTO(String name, String owner_login, List<BranchDTO> branches) {

    public static RepositoryDTO mapToDTO(Repository repository) {
        List<BranchDTO> branches = repository.getBranches().stream().map(BranchDTO::mapToDTO).toList();

        return new RepositoryDTO(repository.getName(), repository.getOwner().getLogin(), branches);
    }
}
