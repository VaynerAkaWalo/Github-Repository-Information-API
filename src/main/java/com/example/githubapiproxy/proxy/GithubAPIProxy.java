package com.example.githubapiproxy.proxy;

import org.springframework.cloud.openfeign.FeignClient;


@FeignClient(name = "GithubProxy", url = "${github.api.url}")
public interface GithubAPIProxy {
}
