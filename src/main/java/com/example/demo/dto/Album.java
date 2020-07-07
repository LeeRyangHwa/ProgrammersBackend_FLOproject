package com.example.demo.dto;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


// @Expose // gson에서 serialized 할 필드 선택
// @Expose(serialize = false) // 해당 변수는 json 변환 제외시키기
@Entity
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PUBLIC)
public class Album {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //앨범 기본 키
    private long id;

    //앨범 제목
    @Column(nullable = false)
    private String albumTitle;

    //지역 (','로 구분)
    @Column(nullable = false)
    private String locales;

    @OneToMany(mappedBy = "album", cascade = CascadeType.ALL)
    private List<Song> songs = new ArrayList<>();

    // 이렇게 Builder를 받아야 id를 받지 않고 빌더 생성 가능
    @Builder
    public Album(String albumTitle, String locales) {
        this.albumTitle = albumTitle;
        this.locales = locales;
    }
}