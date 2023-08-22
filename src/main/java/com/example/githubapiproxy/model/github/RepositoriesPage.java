package com.example.githubapiproxy.model.github;

import com.fasterxml.jackson.annotation.JsonAlias;

import java.util.List;

public class RepositoriesPage {
    private int total_count;
    private boolean incomplete_results;

    @JsonAlias(value = "items")
    private List<Repository> repositories;

    public RepositoriesPage() {
    }

    public int getTotal_count() {
        return total_count;
    }

    public void setTotal_count(int total_count) {
        this.total_count = total_count;
    }

    public boolean isIncomplete_results() {
        return incomplete_results;
    }

    public void setIncomplete_results(boolean incomplete_results) {
        this.incomplete_results = incomplete_results;
    }

    public List<Repository> getRepositories() {
        return repositories;
    }

    public void setRepositories(List<Repository> repositories) {
        this.repositories = repositories;
    }
}
