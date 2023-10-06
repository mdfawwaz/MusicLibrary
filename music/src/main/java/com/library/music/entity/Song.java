package com.library.music.entity;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import lombok.Data;


@Entity
@Data
public class Song {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String name;
    private String artist;
    private String musicDirector;
//    @ManyToOne
//    @JoinColumn(name = "album_id")
    private String album;
    private Long albumid;
//    
//    @ManyToOne(fetch = FetchType.EAGER)
//    @JoinColumn(name = "category_id")
//    private Category category;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "category_id")
    private Category category;
    

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getArtist() {
		return artist;
	}

	public void setArtist(String artist) {
		this.artist = artist;
	}

	public String getMusicDirector() {
		return musicDirector;
	}

	public void setMusicDirector(String musicDirector) {
		this.musicDirector = musicDirector;
	}

	
    
    
    
    // Constructors, getters, setters, and other fields as needed
}

