package com.galvanize.playlistservice.repositories;

import com.galvanize.playlistservice.entities.Song;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SongRepository extends JpaRepository<Song,Long > {
}
