package com.example.githubapiproxy.model.github;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public record RepositoriesPage(
        @JsonProperty("total_count") int totalCount,
        @JsonProperty("incomplete_results") boolean incompleteResults,
        @JsonProperty("items") List<Repository> repositories
) { }
