package com.example.demo.dto;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@IdClass(PlayListID.class)
public class PlayListSong implements Serializable {
    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "play_list_id",foreignKey = @ForeignKey(name = "FK_PLAYLISTSONG"))
    private PlayList playList;

    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "song_id",foreignKey = @ForeignKey(name = "FK_SONG_PLAYLISTSONG"))
    private Song song;
}
class PlayListID implements Serializable{
    private Long playList;
    private Long song;
}