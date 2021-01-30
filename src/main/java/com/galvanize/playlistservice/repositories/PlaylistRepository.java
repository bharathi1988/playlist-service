package com.galvanize.playlistservice.repositories;

import com.galvanize.playlistservice.entities.Playlist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface PlaylistRepository extends JpaRepository<Playlist, Long> {
}
