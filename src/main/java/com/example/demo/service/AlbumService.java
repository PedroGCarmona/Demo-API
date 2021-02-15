package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Album;
import com.example.demo.repository.AlbumRepository;

@Service
public class AlbumService {

	@Autowired
	AlbumRepository albumRepository;
	
	public void createAlbum(Album album ) {
		albumRepository.save(album);
	}
	
	public void updateAlbum(Album album ) {
		albumRepository.save(album);
	}
	
	public Album findAlbumById(Long idAlbum) {
		return albumRepository.findById(idAlbum).get();
	}
	
	public List<Album> findAllAlbums(){
		return albumRepository.findAll();
	}
	
	public void deleteAlbum(Long idAlbum) {
		albumRepository.deleteById(idAlbum);
	}
	
}
