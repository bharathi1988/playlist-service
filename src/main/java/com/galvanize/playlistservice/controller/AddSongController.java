package com.galvanize.playlistservice.controller;

import com.galvanize.playlistservice.entities.Playlist;
import com.galvanize.playlistservice.exception.GenericNotFoundException;
import com.galvanize.playlistservice.service.AddSongService;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(tags="add songs")
public class AddSongController {

    private AddSongService addSongService;

    public AddSongController(AddSongService addSongService) {
        this.addSongService = addSongService;
    }


    @PatchMapping("api/v1/playlist/{playlistId}/{songId}")
    public Playlist addSongsToPlaylist(@PathVariable Long playlistId, @PathVariable Long songId) throws GenericNotFoundException {
        Playlist playList = addSongService.addSongsToPlaylist(playlistId,songId);
        return playList;
    }

    @DeleteMapping("api/v1/playlist/{playlistId}/{songId}")
    public Playlist removeSongFromPlaylist(@PathVariable Long playlistId, @PathVariable Long songId){
        Playlist playList = addSongService.deleteSongFromPlaylist(playlistId,songId);
        return playList;
    }
}
