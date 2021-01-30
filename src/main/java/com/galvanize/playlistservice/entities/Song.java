package com.galvanize.playlistservice.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Song {

    @Column(name = "id")
    @Id
    private Long songId;

    public Long getSongId() {
        return songId;
    }

    public void setSongId(Long songId) {
        this.songId = songId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String name;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Song song = (Song) o;
        return songId.equals(song.songId) && name.equals(song.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(songId, name);
    }
}
