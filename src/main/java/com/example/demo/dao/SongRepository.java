package com.example.demo.dao;

import com.example.demo.dto.Song;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SongRepository extends JpaRepository<Song,Long> {

    List<Song> findByalbum_id(long id);
}
