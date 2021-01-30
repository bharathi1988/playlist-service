package com.galvanize.playlistservice.service;

import com.galvanize.playlistservice.entities.Playlist;
import com.galvanize.playlistservice.repositories.PlaylistRepository;
import org.springframework.stereotype.Service;

@Service
public class PlaylistService {

    private PlaylistRepository playlistRepository;

    public PlaylistService(PlaylistRepository playlistRepository) {
        this.playlistRepository = playlistRepository;
    }

    public Playlist createPlaylist(Playlist playlist){
        return playlistRepository.save(playlist);
    }

}
