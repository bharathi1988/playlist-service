package com.galvanize.playlistservice.controller;

import com.galvanize.playlistservice.entities.Playlist;
import com.galvanize.playlistservice.service.PlaylistService;
import io.swagger.annotations.Api;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(tags = "playlist")
public class PlaylistController {

    private PlaylistService playlistService;

    public PlaylistController(PlaylistService playlistService) {
        this.playlistService = playlistService;
    }

    @PostMapping("/api/v1/playlist")
    @ResponseStatus(HttpStatus.CREATED)
    public Playlist createPlaylist(@RequestBody Playlist playlist){
        return playlistService.createPlaylist(playlist);
    }


}
