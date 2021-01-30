package com.galvanize.playlistservice.entities;

import javax.persistence.*;
import java.util.List;

@Entity
public class Playlist {

    @Id
    @GeneratedValue
    private Long id;
    private String playlistName;
    @ElementCollection
    private List<Song> songs;
}
