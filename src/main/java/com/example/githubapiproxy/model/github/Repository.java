package com.example.githubapiproxy.model.github;

import com.fasterxml.jackson.annotation.JsonAlias;

import java.util.List;

public class Repository {
    @JsonAlias(value = "full_name")
    private String name;

    private Owner owner;

    private List<Branch> branches;

    public Repository() {

    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    public List<Branch> getBranches() {
        return branches;
    }

    public void setBranches(List<Branch> branches) {
        this.branches = branches;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
