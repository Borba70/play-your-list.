package com.playyourlist.reproducoes;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class ReproducaoController {

    private final ReproducaoService service;

    public ReproducaoController(ReproducaoService service) {
        this.service = service;
    }

    @PostMapping({"/reproducao", "/statistic"})
    @ResponseStatus(HttpStatus.CREATED)
    public Reproducao criar(@RequestBody Map<String, Integer> body) {
        Integer playlistId = body.get("playlistId");
        if (playlistId == null) {
            playlistId = body.get("playlistid");
        }
        if (playlistId == null) {
            throw new org.springframework.web.server.ResponseStatusException(
                    HttpStatus.BAD_REQUEST, "playlistId é obrigatório.");
        }
        return service.criar(playlistId);
    }

    @GetMapping("/reproducao/{playlistId}")
    public List<Reproducao> listar(@PathVariable Integer playlistId) {
        return service.listarPorPlaylist(playlistId);
    }

    @GetMapping("/reproducao/total/{playlistId}")
    public Map<String, Object> total(@PathVariable Integer playlistId) {
        return Map.of(
                "playlistId", playlistId,
                "total", service.totalPorPlaylist(playlistId)
        );
    }
}
