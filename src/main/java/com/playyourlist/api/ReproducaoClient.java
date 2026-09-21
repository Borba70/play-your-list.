package com.playyourlist.api;

import com.playyourlist.reproducoes.Reproducao;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Map;

@FeignClient(name = "reproducoes-client", url = "${app.base-url:http://localhost:8080}")
public interface ReproducaoClient {

    @PostMapping("/statistic")
    Reproducao criar(@RequestBody Map<String, Integer> body);
}
