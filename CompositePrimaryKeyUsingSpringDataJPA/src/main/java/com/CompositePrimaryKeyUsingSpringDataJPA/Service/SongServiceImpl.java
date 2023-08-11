package com.CompositePrimaryKeyUsingSpringDataJPA.Service;

import com.CompositePrimaryKeyUsingSpringDataJPA.Repository.SongRepo;
import com.CompositePrimaryKeyUsingSpringDataJPA.Entity.Song;
import com.CompositePrimaryKeyUsingSpringDataJPA.Entity.SongId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SongServiceImpl implements  SongService{

    @Autowired
    private SongRepo sRepo;


    @Override
    public Song createSong(Song song) {
        Song savedSong = sRepo.save(song);
        return savedSong;
    }

    @Override
    public Song getSongById(SongId songId) {
        Optional<Song> song = sRepo.findById(songId);
        return song.get();
    }

    @Override
    public List<Song> getSongByIdName(String name) {
        List<Song> songs = sRepo.findBySongIdName(name);
        return songs;
    }
}
