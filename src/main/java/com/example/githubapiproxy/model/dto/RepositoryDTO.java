package com.example.githubapiproxy.model.dto;

import com.example.githubapiproxy.model.github.Branch;
import com.example.githubapiproxy.model.github.Repository;

import java.util.List;

public record RepositoryDTO(String name, String owner_login, List<BranchDTO> branches) {

    public static RepositoryDTO mapToDTO(Repository repository, List<Branch> branches) {
        List<BranchDTO> branchesDTO = branches
                .stream()
                .map(BranchDTO::mapToDTO)
                .toList();

        return new RepositoryDTO(repository.name(), repository.owner().login(), branchesDTO);
    }
}
