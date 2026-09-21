package com.playyourlist.reproducoes;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "reproducoes")
public class Reproducao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "playlistid", nullable = false)
    private Integer playlistId;

    @Column(name = "datahora", nullable = false)
    private LocalDateTime dataHora;

    public Reproducao() {}

    public Reproducao(Integer playlistId, LocalDateTime dataHora) {
        this.playlistId = playlistId;
        this.dataHora = dataHora;
    }

    public Integer getId() { return id; }
    public Integer getPlaylistId() { return playlistId; }
    public void setPlaylistId(Integer playlistId) { this.playlistId = playlistId; }
    public LocalDateTime getDataHora() { return dataHora; }
    public void setDataHora(LocalDateTime dataHora) { this.dataHora = dataHora; }
}
