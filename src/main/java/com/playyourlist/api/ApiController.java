package com.playyourlist.api;

import com.playyourlist.musicas.Musica;
import com.playyourlist.playlists.Playlist;
import com.playyourlist.reproducoes.Reproducao;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Map;

@RestController
@RequestMapping("/api")
public class ApiController {

    private final MusicaClient musicaClient;
    private final PlaylistClient playlistClient;
    private final ReproducaoClient reproducaoClient;

    public ApiController(MusicaClient musicaClient,
                         PlaylistClient playlistClient,
                         ReproducaoClient reproducaoClient) {
        this.musicaClient = musicaClient;
        this.playlistClient = playlistClient;
        this.reproducaoClient = reproducaoClient;
    }

    @PostMapping("/adicionar/{playlistId}/musicas/{musicaId}")
    public Map<String, String> adicionar(@PathVariable Integer playlistId,
                                         @PathVariable Integer musicaId) {
        try {
            Playlist playlist = playlistClient.buscar(playlistId);
            Musica musica = musicaClient.buscar(musicaId);

            playlistClient.adicionarMusica(playlistId, musicaId);

            return Map.of(
                    "mensagem",
                    "Música " + musica.getTitulo() +
                    " adicionada com sucesso à playlist " + playlist.getNome()
            );
        } catch (feign.FeignException.NotFound e) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND,
                    "Playlist ou música não encontrada.");
        }
    }

    @PutMapping("/executar/{playlistId}")
    public Map<String, Object> executar(@PathVariable Integer playlistId) {
        try {
            Playlist playlist = playlistClient.buscar(playlistId);

            Reproducao reproducao = reproducaoClient.criar(
                    Map.of("playlistId", playlistId)
            );

            return Map.of(
                    "mensagem", "Playlist " + playlist.getNome() + " executada com sucesso.",
                    "playlistId", playlistId,
                    "reproducaoId", reproducao.getId(),
                    "dataHora", reproducao.getDataHora()
            );
        } catch (feign.FeignException.NotFound e) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Playlist não encontrada.");
        }
    }
}
