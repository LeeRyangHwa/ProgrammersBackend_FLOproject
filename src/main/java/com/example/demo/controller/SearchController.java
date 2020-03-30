package com.example.demo.controller;

import com.example.demo.dao.AlbumRepository;
import com.example.demo.dao.SongRepository;
import com.example.demo.dto.Album;
import com.example.demo.dto.Song;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class SearchController {
    @Autowired
    AlbumRepository albumRepository;
    @Autowired
    SongRepository songRepository;

    @GetMapping("/search")
    @ResponseBody
    String Search(
            @RequestParam(value = "title")String title){
        List<Album> albumList = albumRepository.findAllJoinFetch();
        System.out.println(title);
        List<Album> albums = albumRepository.findByAlbumTitle(title);
        System.out.println(albums.size());
        for(Album a: albums){
            System.out.println(a.getAlbumTitle());
        }


        Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
        StringBuilder stringBuilder = new StringBuilder();
        for (Album album : albumList)
            stringBuilder.append(gson.toJson(album));

        return stringBuilder.toString();
        //
//        JSONArray jsongArray = new JSONArray();
//        for(Album album: albumList){
//            JSONObject jsonObject = new JSONObject();
//            JSONObject albumObject = new JSONObject();
//
//            albumObject.put("title",album.getAlbumTitle());
//            albumObject.put("id", album.getId());
//
//            List<Song> songs = album.getSongs();
//            JSONArray songArray = new JSONArray();
//            for(Song song: songs){
//                JSONObject songObject = new JSONObject();
//
//                songObject.put("title",song.getTitle());
//                songObject.put("id",song.getId());
//                songObject.put("track",song.getTrack());
//                songObject.put("length",song.getLength());
//                songArray.add(songObject);
//
//            }
//            albumObject.put("songs",songArray);
//
//            jsonObject.put("albums",albumObject);
//            jsongArray.add(jsonObject);
//        }
//
//        return jsongArray.toString();
    }
}
