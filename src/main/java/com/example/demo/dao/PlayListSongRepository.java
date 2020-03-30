package com.example.demo.dao;

import com.example.demo.dto.PlayListSong;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayListSongRepository extends JpaRepository<PlayListSong, Long>
{
}
