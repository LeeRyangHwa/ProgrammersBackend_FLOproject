package com.example.demo.dto;

import com.google.gson.annotations.Expose;
import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Song {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Expose
    private Long id;
    @Expose
    private String title;
    @Expose
    private int track;
    @Expose
    private int length;

    @ManyToOne
    @JoinColumn(name = "Album_id")
    @Expose(serialize = false)
    private Album album;

    @Builder
    public Song(String title, int track, int length, Album album){
        this.title = title;
        this.track = track;
        this.length = length;
        this.album = album;
    }

    @Override
    public String toString() {
        return "Song{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", track=" + track +
                ", length=" + length +
                ", album=" + album +
                '}';
    }
}
