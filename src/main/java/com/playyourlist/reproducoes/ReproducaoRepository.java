package com.playyourlist.reproducoes;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReproducaoRepository extends JpaRepository<Reproducao, Integer> {
    List<Reproducao> findByPlaylistId(Integer playlistId);
    long countByPlaylistId(Integer playlistId);
}
