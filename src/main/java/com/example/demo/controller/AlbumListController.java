package com.example.demo.controller;

import com.example.demo.dao.AlbumRepository;
import com.example.demo.dto.Album;
import com.example.demo.dto.Song;
import com.example.demo.service.AlbumsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.*;

@Controller
public class AlbumListController {
    @Autowired
    AlbumsService albumsService;

    @RequestMapping(path = "/albums", produces = "application/json; charset=UTF-8")
    @ResponseBody
    public Map<String, Object> search(@RequestParam String locale,
                                       @RequestParam int page) {

        Map<String, Object> map = albumsService.albumPageList(page, locale);

        return map;
    }
}
