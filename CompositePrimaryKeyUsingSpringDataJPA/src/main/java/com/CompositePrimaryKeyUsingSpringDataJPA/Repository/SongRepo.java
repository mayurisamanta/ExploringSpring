package com.CompositePrimaryKeyUsingSpringDataJPA.Repository;

import com.CompositePrimaryKeyUsingSpringDataJPA.Entity.Song;
import com.CompositePrimaryKeyUsingSpringDataJPA.Entity.SongId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SongRepo extends JpaRepository<Song, SongId> {

    List<Song> findBySongIdName (String name);
}
