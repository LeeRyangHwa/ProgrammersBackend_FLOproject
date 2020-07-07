package com.example.demo.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PUBLIC)
public class Song {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //곡 기본 키
    private long id;

    // 곡 제목
    @Column(nullable = false)
    private String title;

    // 곡 트랙 번호
    @Column(nullable = false)
    private int track;

    // 곡 길이
    @Column(nullable = false)
    private int length;

    // Album 필드 추가
    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "album_id", insertable = false, updatable = false)
    @JoinColumn(name = "album_id")
    private Album album;

    // 이렇게 Builder를 받아야 id를 받지 않고 빌더 생성 가능
    @Builder
    public Song(String title, int track, int length, Album album) {
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
                '}';
    }
}