package com.example.demo.controller;

import com.example.demo.dto.Album;
import com.example.demo.dao.AlbumRepository;
import com.example.demo.dto.Song;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.toList;

@Controller
public class SearchController {
    @Autowired
    AlbumRepository albumRepository;


    @RequestMapping(path = "/search", produces = "application/json; charset=UTF-8")
    @ResponseBody
    public Map<String,List<?>> search(@RequestParam String title,
                              @RequestParam String locale) {

        Map<String, List<?>> map = new HashMap<>();
        List<Album> albumList = albumRepository.findAllByAlbumTitleAndLocales(title, locale);
//
        List<Song> songList = albumList.stream()
                .flatMap(album -> album.getSongs().stream())
                .filter(song -> song.getTitle().contains(title))
                .collect(toList());

        map.put("albums", albumList);
        map.put("songs", songList);

        return map;
    }

}
