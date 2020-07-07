package com.example.demo.service;

import com.example.demo.dao.AlbumRepository;
import com.example.demo.dto.Album;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class AlbumsService {
    @Autowired
    AlbumRepository albumRepository;

    public Page<Album> findAlbumsByPageRequest(int page, int size, String locale){
        PageRequest pageRequest = PageRequest.of(page,size);
        return albumRepository.findAllByLocalesContains(locale, pageRequest);
    }

    public Map<String, Object> albumPageList(int page, String locale){
        Map<String, Object> map = new HashMap<>();
        Page<Album> albums = findAlbumsByPageRequest(page-1,10, locale);


        Map<String, String> pageMap = new HashMap<>();

        if(albums.isFirst()){
            pageMap.put("last",urlStr(locale,albums.getTotalPages()));
            pageMap.put("next",urlStr(locale,page+1));
        }else if(albums.isLast()){
            pageMap.put("first",urlStr(locale,1));
            pageMap.put("prev",urlStr(locale,page-1));
        }else{
            pageMap.put("first",urlStr(locale,1));
            pageMap.put("prev",urlStr(locale,page-1));
            pageMap.put("last",urlStr(locale,albums.getTotalPages()));
            pageMap.put("next",urlStr(locale,page+1));
        }

        map.put("pages", pageMap);
        map.put("albums",albums.getContent());

        return map;
    }

    private String urlStr(String locale , int page){
        if(page <1){
            page = 1;
        }
        String url =  "localhost:5000/albums?locale="+locale+"&page="+ page;
        return url;
    }
}

