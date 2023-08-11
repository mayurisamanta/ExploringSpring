package com.CompositePrimaryKeyUsingSpringDataJPA.Controller;

import com.CompositePrimaryKeyUsingSpringDataJPA.Service.SongService;
import com.CompositePrimaryKeyUsingSpringDataJPA.Entity.Song;
import com.CompositePrimaryKeyUsingSpringDataJPA.Entity.SongId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/song")
public class SongController {

    @Autowired
    private SongService sSer;

    @PostMapping("/")
    public ResponseEntity<Song> createSongHandler (@RequestBody Song song){
        Song savedSong = sSer.createSong(song);
        return new ResponseEntity<>(savedSong, HttpStatus.CREATED);
    }

    @GetMapping("/")
    public ResponseEntity<Song> getSongByIdHandler (@RequestBody SongId songId){
        Song song = sSer.getSongById(songId);
        return new ResponseEntity<>(song, HttpStatus.OK);
    }

    @GetMapping("/{name}")
    public ResponseEntity<List<Song>> getSongByIdNameHandler (@PathVariable String name){
        List<Song> songs = sSer.getSongByIdName(name);
        return new ResponseEntity<>(songs, HttpStatus.OK);
    }
}
