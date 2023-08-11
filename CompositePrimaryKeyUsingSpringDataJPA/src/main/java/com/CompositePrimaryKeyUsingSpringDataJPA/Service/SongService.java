package com.CompositePrimaryKeyUsingSpringDataJPA.Service;

import com.CompositePrimaryKeyUsingSpringDataJPA.Entity.Song;
import com.CompositePrimaryKeyUsingSpringDataJPA.Entity.SongId;

import java.util.List;

public interface SongService {

    Song createSong(Song song);

    Song getSongById (SongId songId);

    List<Song> getSongByIdName (String name);
}
