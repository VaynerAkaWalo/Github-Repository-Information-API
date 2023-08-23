package com.example.githubapiproxy.model.github;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public record Repository (
        String name,
        Owner owner,
        @JsonProperty("full_name") String fullName
) {
}