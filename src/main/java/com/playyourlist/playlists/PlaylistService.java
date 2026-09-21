package com.playyourlist.playlists;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class PlaylistService {

    private final PlaylistRepository playlistRepository;
    private final PlaylistMusicaRepository playlistMusicaRepository;

    public PlaylistService(PlaylistRepository playlistRepository,
                            PlaylistMusicaRepository playlistMusicaRepository) {
        this.playlistRepository = playlistRepository;
        this.playlistMusicaRepository = playlistMusicaRepository;
    }

    public Playlist criar(Playlist playlist) {
        playlist.setId(null);
        return playlistRepository.save(playlist);
    }

    public List<Playlist> listar() {
        return playlistRepository.findAll();
    }

    public Playlist buscar(Integer id) {
        return playlistRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Playlist não encontrada: " + id));
    }

    public Playlist atualizar(Integer id, Playlist dados) {
        Playlist playlist = buscar(id);
        playlist.setNome(dados.getNome());
        playlist.setDescricao(dados.getDescricao());
        return playlistRepository.save(playlist);
    }

    public void excluir(Integer id) {
        buscar(id);
        playlistMusicaRepository.deleteByPlaylistId(id);
        playlistRepository.deleteById(id);
    }

    public void adicionarMusica(Integer playlistId, Integer musicaId) {
        buscar(playlistId);

        if (playlistMusicaRepository.findByPlaylistIdAndMusicaId(playlistId, musicaId).isPresent()) {
            throw new ResponseStatusException(
                    HttpStatus.CONFLICT, "Música já está na playlist.");
        }

        playlistMusicaRepository.save(new PlaylistMusica(playlistId, musicaId));
    }

    public void removerMusica(Integer playlistId, Integer musicaId) {
        buscar(playlistId);

        PlaylistMusica item = playlistMusicaRepository
                .findByPlaylistIdAndMusicaId(playlistId, musicaId)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Música não está na playlist."));

        playlistMusicaRepository.delete(item);
    }

    public List<Integer> listarMusicas(Integer playlistId) {
        buscar(playlistId);
        return playlistMusicaRepository.findByPlaylistId(playlistId)
                .stream()
                .map(PlaylistMusica::getMusicaId)
                .toList();
    }
}
