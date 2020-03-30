package com.example.demo.dto;

import com.google.gson.annotations.Expose;
import lombok.*;
import org.hibernate.event.internal.AbstractLockUpgradeEventListener;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
//@Builder

public class Album {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Expose
    private Long id;
    @Expose
    private String albumTitle;
    @Expose
    private String locales;

    @OneToMany(mappedBy = "album" ,cascade = CascadeType.ALL)
    @Expose
    private List<Song> songs = new ArrayList<>();
    @Builder
    public Album(String albumTitle, String locales){
        this.albumTitle = albumTitle;
        this.locales = locales;
    }

    @Override
    public String toString() {
        return "Album{" +
                "id=" + id +
                ", albumTitle='" + albumTitle + '\'' +
                ", locales='" + locales + '\'' +
                ", songs=" + songs +
                '}';
    }
}
