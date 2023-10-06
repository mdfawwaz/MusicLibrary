package com.library.music.entity;
import java.util.ArrayList;
import java.util.List;
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
public class RecentSong {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	@ManyToOne
    @JoinColumn(name = "song_id")
    private Song song;
	 public Long getId() {
	        return id;
	    }

	    public void setId(Long id) {
	        this.id = id;
	    }

	    public Song getSong() {
	        return song;
	    }

	    public void setSong(Song song) {
	        this.song = song;
	    }

}
