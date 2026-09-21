package com.playyourlist.api;

import com.playyourlist.playlists.Playlist;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(name = "playlists-client", url = "${app.base-url:http://localhost:8080}")
public interface PlaylistClient {

    @GetMapping("/playlists/{id}")
    Playlist buscar(@PathVariable("id") Integer id);

    @PostMapping("/playlists/{playlistId}/musicas/{musicaId}")
    void adicionarMusica(@PathVariable("playlistId") Integer playlistId,
                         @PathVariable("musicaId") Integer musicaId);
}
