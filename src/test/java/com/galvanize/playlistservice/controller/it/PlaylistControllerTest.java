package com.galvanize.playlistservice.controller.it;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.galvanize.playlistservice.entities.Playlist;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.web.server.ResponseStatusException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class PlaylistControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper mapper;

    @Test
    void createPlayList_whenReturnsEmpty201() throws Exception {
        Playlist pl1 = new Playlist("playlist1");

        mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/playlist")
        .contentType(MediaType.APPLICATION_JSON)
        .content(mapper.writeValueAsString(pl1)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.id").exists())
                .andExpect(jsonPath("$.playlistName").value("playlist1"))
                .andExpect(jsonPath("$.songs").isEmpty());

    }

    @Test
    void createPlayList_whenReturnsErrorMsg400() throws Exception {
        Playlist pl1 = new Playlist("");

        ResponseStatusException actual = (ResponseStatusException) mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/playlist")
                               .contentType(MediaType.APPLICATION_JSON)
                               .content(mapper.writeValueAsString(pl1)))
                               .andExpect(status().isBadRequest())
                               .andExpect(result -> assertThat(result.getResolvedException() instanceof ResponseStatusException))
                               .andReturn().getResolvedException();

        assertEquals("PlaylistName Required",actual.getReason());

    }


}
