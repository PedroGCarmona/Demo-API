package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Song;
import com.example.demo.repository.SongRepository;

@Service
public class SongService {
	
	@Autowired
	SongRepository songRepository;
	
	public void createSong(Song song ) {
		songRepository.save(song);
	}
	
	public void updateSong(Song song ) {
		songRepository.save(song);
	}
	
	public Song findSongById(Long idSong) {
		return songRepository.findById(idSong).get();
	}
	
	public List<Song> findAllSongs(){
		return songRepository.findAll();
	}
	
	public void deleteSong(Long idSong) {
		songRepository.deleteById(idSong);
	}
	
}
