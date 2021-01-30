package com.galvanize.playlistservice.service;

import com.galvanize.playlistservice.entities.Playlist;
import com.galvanize.playlistservice.entities.Song;
import com.galvanize.playlistservice.repositories.PlaylistRepository;
import com.galvanize.playlistservice.repositories.SongRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AddSongService {

    private PlaylistRepository playlistRepository;

    private SongRepository songRepository;

    public AddSongService(PlaylistRepository playlistRepository, SongRepository songRepository) {
        this.playlistRepository = playlistRepository;
        this.songRepository = songRepository;
    }


    public Playlist addSongsToPlaylist(Long playlistId, Long songId) {
        Playlist playlist = playlistRepository.findById(playlistId).get();
        Optional<Song> song = songRepository.findById(songId);
        if(song.isPresent()){
            List<Song> songList = playlist.getSongs();
            songList.add(song.get());
            playlist.setSongs(songList);
        }

        return playlistRepository.save(playlist);
    }
}
