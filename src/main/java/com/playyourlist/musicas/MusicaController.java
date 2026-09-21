package com.playyourlist.musicas;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/musicas")
public class MusicaController {

    private final MusicaService service;

    public MusicaController(MusicaService service) {
        this.service = service;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Musica criar(@Valid @RequestBody Musica musica) {
        return service.criar(musica);
    }

    @GetMapping
    public List<Musica> listar() {
        return service.listar();
    }

    @GetMapping("/{id}")
    public Musica buscar(@PathVariable Integer id) {
        return service.buscar(id);
    }

    @PutMapping("/{id}")
    public Musica atualizar(@PathVariable Integer id, @Valid @RequestBody Musica musica) {
        return service.atualizar(id, musica);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void excluir(@PathVariable Integer id) {
        service.excluir(id);
    }
}
