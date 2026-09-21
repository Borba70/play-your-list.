package com.playyourlist.musicas;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class MusicaService {

    private final MusicaRepository repository;

    public MusicaService(MusicaRepository repository) {
        this.repository = repository;
    }

    public Musica criar(Musica musica) {
        musica.setId(null);
        return repository.save(musica);
    }

    public List<Musica> listar() {
        return repository.findAll();
    }

    public Musica buscar(Integer id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Música não encontrada: " + id));
    }

    public Musica atualizar(Integer id, Musica dados) {
        Musica musica = buscar(id);
        musica.setTitulo(dados.getTitulo());
        musica.setArtista(dados.getArtista());
        musica.setAlbum(dados.getAlbum());
        musica.setDuracao(dados.getDuracao());
        musica.setGenero(dados.getGenero());
        return repository.save(musica);
    }

    public void excluir(Integer id) {
        Musica musica = buscar(id);
        repository.delete(musica);
    }
}
