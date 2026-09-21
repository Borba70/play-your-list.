package com.playyourlist.reproducoes;

import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ReproducaoService {

    private final ReproducaoRepository repository;

    public ReproducaoService(ReproducaoRepository repository) {
        this.repository = repository;
    }

    public Reproducao criar(Integer playlistId) {
        Reproducao reproducao = new Reproducao(playlistId, LocalDateTime.now());
        return repository.save(reproducao);
    }

    public List<Reproducao> listarPorPlaylist(Integer playlistId) {
        return repository.findByPlaylistId(playlistId);
    }

    public long totalPorPlaylist(Integer playlistId) {
        return repository.countByPlaylistId(playlistId);
    }
}
