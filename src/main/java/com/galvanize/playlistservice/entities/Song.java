package com.galvanize.playlistservice.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Song {

    @Column(name = "id")
    @Id
    private Long songId;
    private String name;
}
