package com.example.demo.dao;

import com.example.demo.dto.Album;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AlbumRepository extends JpaRepository<Album, Long>
{
    @Query("select distinct a from Album a join fetch a.songs")
    List<Album> findAllJoinFetch();

    List<Album> findByAlbumTitle(String s);
}
