package com.example.githubapiproxy.model.dto;

import com.example.githubapiproxy.model.github.Branch;

public record BranchDTO(String name, String sha) {

    public static BranchDTO mapToDTO(Branch branch) {
        return new BranchDTO(branch.name(), branch.commit().sha());
    }
}
