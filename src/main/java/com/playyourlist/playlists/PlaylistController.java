package com.playyourlist.playlists;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/playlists")
public class PlaylistController {

    private final PlaylistService service;

    public PlaylistController(PlaylistService service) {
        this.service = service;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Playlist criar(@Valid @RequestBody Playlist playlist) {
        return service.criar(playlist);
    }

    @GetMapping
    public List<Playlist> listar() {
        return service.listar();
    }

    @GetMapping("/{playlistId}")
    public Playlist buscar(@PathVariable Integer playlistId) {
        return service.buscar(playlistId);
    }

    @PutMapping("/{playlistId}")
    public Playlist atualizar(@PathVariable Integer playlistId,
                              @Valid @RequestBody Playlist playlist) {
        return service.atualizar(playlistId, playlist);
    }

    @DeleteMapping("/{playlistId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void excluir(@PathVariable Integer playlistId) {
        service.excluir(playlistId);
    }

    @PostMapping("/{playlistId}/musicas/{musicaId}")
    @ResponseStatus(HttpStatus.CREATED)
    public void adicionarMusica(@PathVariable Integer playlistId,
                                @PathVariable Integer musicaId) {
        service.adicionarMusica(playlistId, musicaId);
    }

    @DeleteMapping("/{playlistId}/musicas/{musicaId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removerMusica(@PathVariable Integer playlistId,
                              @PathVariable Integer musicaId) {
        service.removerMusica(playlistId, musicaId);
    }

    @GetMapping("/{playlistId}/musicas")
    public List<Integer> listarMusicas(@PathVariable Integer playlistId) {
        return service.listarMusicas(playlistId);
    }
}
