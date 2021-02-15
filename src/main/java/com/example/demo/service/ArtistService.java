package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Artist;
import com.example.demo.repository.ArtistRepository;

@Service
public class ArtistService {
	
	@Autowired
	ArtistRepository artistRepository;
	
	public void createArtist(Artist artist ) {
		artistRepository.save(artist);
	}
	
	public void updateArtist(Artist artist ) {
		artistRepository.save(artist);
	}
	
	public Artist findArtistById(Long idArtist) {
		return artistRepository.findById(idArtist).get();
	}
	
	public List<Artist> findAllArtists(){
		return artistRepository.findAll();
	}
	
	public void deleteArtist(Long idArtist) {
		artistRepository.deleteById(idArtist);
	}
}
