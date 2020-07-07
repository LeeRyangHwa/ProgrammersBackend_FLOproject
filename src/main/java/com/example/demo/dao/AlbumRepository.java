package com.example.demo.dao;

import com.example.demo.dto.Album;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AlbumRepository extends JpaRepository<Album, Long>
{
    @Query("select distinct a from Album a join fetch a.songs ")
    List<Album> findAllJoinFetch();


    Page<Album> findAllByLocalesContains(String locale, Pageable p);

    @Query("select DISTINCT a from Album a join fetch a.songs where a.albumTitle like %:albumTitle% and a.locales like %:locales%")
    List<Album> findAllByAlbumTitleAndLocales(@Param("albumTitle") String albumTitle, @Param("locales") String locale);
}
