package com.playyourlist.musicas;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "musicas")
public class Musica {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank(message = "Título é obrigatório e não pode ser vazio.")
    @Size(max = 150, message = "Título deve ter no máximo 150 caracteres.")
    private String titulo;

    @NotBlank(message = "Artista é obrigatório e não pode ser vazio.")
    @Size(max = 150, message = "Artista deve ter no máximo 150 caracteres.")
    private String artista;

    @Size(max = 150, message = "Álbum deve ter no máximo 150 caracteres.")
    private String album;

    @NotNull(message = "Duração é obrigatória.")
    @Min(value = 1, message = "Duração deve ser maior que zero.")
    private Integer duracao;

    @Size(max = 50, message = "Gênero deve ter no máximo 50 caracteres.")
    private String genero;

    public Musica() {}

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }
    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }
    public String getArtista() { return artista; }
    public void setArtista(String artista) { this.artista = artista; }
    public String getAlbum() { return album; }
    public void setAlbum(String album) { this.album = album; }
    public Integer getDuracao() { return duracao; }
    public void setDuracao(Integer duracao) { this.duracao = duracao; }
    public String getGenero() { return genero; }
    public void setGenero(String genero) { this.genero = genero; }
}
