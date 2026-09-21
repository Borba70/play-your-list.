package com.playyourlist.api;

import com.playyourlist.musicas.Musica;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "musicas-client", url = "${app.base-url:http://localhost:8080}")
public interface MusicaClient {

    @GetMapping("/musicas/{id}")
    Musica buscar(@PathVariable("id") Integer id);
}
