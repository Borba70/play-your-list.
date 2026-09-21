package com.playyourlist.playlists;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PlaylistMusicaRepository extends JpaRepository<PlaylistMusica, Integer> {
    List<PlaylistMusica> findByPlaylistId(Integer playlistId);
    Optional<PlaylistMusica> findByPlaylistIdAndMusicaId(Integer playlistId, Integer musicaId);
    void deleteByPlaylistId(Integer playlistId);
}
