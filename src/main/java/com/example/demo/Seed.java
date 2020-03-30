package com.example.demo;

import com.example.demo.dao.AlbumRepository;
import com.example.demo.dao.SongRepository;
import com.example.demo.dto.Album;
import com.example.demo.dto.Song;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.applet.AppletContext;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

@Component
public class Seed implements ApplicationRunner {
    @Autowired
    AlbumRepository albumRepository;
    @Autowired
    SongRepository songRepository;

    public void insertData() {
        JSONParser parser = new JSONParser();

        try {

            ClassPathResource resource = new ClassPathResource("./albums.json");
            Object obj = parser.parse(new FileReader(resource.getURI().getPath()));
            //System.out.println(obj);

            JSONArray array = (JSONArray) obj;


//            for (Object a:array){
//                System.out.println(((JSONObject)a).get("locales"));
//            }
//
//            JSONObject object = (JSONObject) array.get(0);
//            System.out.println(object.get("locales"));

            for (Object aaa : array) {

                String albumTitle = (String) ((JSONObject) aaa).get("album_title");
                List<String> localdata = (List<String>) ((JSONObject) aaa).get("locales");
                String locales = String.join(",", localdata);


                Album album = Album.builder()
                        .albumTitle(albumTitle)
                        .locales(locales)
                        .build();
                albumRepository.save(album);
                JSONArray songobjs = (JSONArray) ((JSONObject) aaa).get("songs");
                for (Object songobj : songobjs) {
                    String songTitle = (String) ((JSONObject) songobj).get("title");
                    int songLength =  ((Long) ((JSONObject) songobj).get("length")).intValue();
                    int songTrack = ((Long) ((JSONObject) songobj).get("track")).intValue();
                    Song song = Song.builder()
                            .title(songTitle)
                            .length(songLength)
                            .track(songTrack)
                            .album(album)
                            .build();

                    songRepository.save(song);
                }
            }


        } catch (Exception e) {

            e.printStackTrace();

        }

    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        insertData();
    }
}
