package com.playyourlist.playlists;

import jakarta.persistence.*;

@Entity
@Table(name = "playlist_musicas")
public class PlaylistMusica {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "playlistid", nullable = false)
    private Integer playlistId;

    @Column(name = "musicaid", nullable = false)
    private Integer musicaId;

    public PlaylistMusica() {}

    public PlaylistMusica(Integer playlistId, Integer musicaId) {
        this.playlistId = playlistId;
        this.musicaId = musicaId;
    }

    public Integer getId() { return id; }
    public Integer getPlaylistId() { return playlistId; }
    public void setPlaylistId(Integer playlistId) { this.playlistId = playlistId; }
    public Integer getMusicaId() { return musicaId; }
    public void setMusicaId(Integer musicaId) { this.musicaId = musicaId; }
}
