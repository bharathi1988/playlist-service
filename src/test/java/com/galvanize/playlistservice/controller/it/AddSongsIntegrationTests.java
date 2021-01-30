package com.galvanize.playlistservice.controller.it;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.galvanize.playlistservice.controller.AddSongController;
import com.galvanize.playlistservice.entities.Playlist;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.patch;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@AutoConfigureTestDatabase
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class AddSongsIntegrationTests {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper mapper;

    @BeforeEach
    public void init() throws Exception {
        Playlist pl1 = new Playlist("1950 Hits");

        mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/playlist")
                .contentType(MediaType.APPLICATION_JSON)
                .content(mapper.writeValueAsString(pl1)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.id").exists())
                .andExpect(jsonPath("$.playlistName").value("1950 Hits"))
                .andExpect(jsonPath("$.songs").isEmpty());

    }

    @Test
    @Order(1)
    public void addSongsToEmptyPlaylistTest() throws Exception{

        mockMvc.perform(patch("/api/v1/playlist/1/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        )
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").exists())
                .andExpect(jsonPath("$.playlistName").value("1950 Hits"))
                .andExpect(jsonPath("$.songs.[0].songId").value(1));
    }


    @Test
    @Order(2)
    public void addSongsToANotEmptyPlaylist() throws Exception{


        mockMvc.perform(patch("/api/v1/playlist/1/2")
                .contentType(MediaType.APPLICATION_JSON)
        )
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").exists())
                .andExpect(jsonPath("$.playlistName").value("1950 Hits"))
                .andExpect(jsonPath("$.songs.length()").value(2));
    }

    @Test
    @Order(3)
    public void addSongsToANotEmptyPlaylist_songDoesNotExist() throws Exception{


        mockMvc.perform(patch("/api/v1/playlist/1/5")
                .contentType(MediaType.APPLICATION_JSON)
        )       .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.error").value("Song not found"));
    }
}
