package com.example.demo.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.DTO.AlbumDTO;
import com.example.demo.model.Album;
import com.example.demo.service.AlbumService;
import com.example.demo.service.DTO.AlbumDTOConverterService;

@RestController
@RequestMapping("/album")
public class AlbumController {

	@Autowired
	AlbumService albumService;
	@Autowired
	AlbumDTOConverterService albumDTOConverterService;

	@PostMapping("/create")
	@ResponseStatus(HttpStatus.CREATED)
	public void createAlbum(@RequestBody AlbumDTO albumDTO) {
		albumService.createAlbum(albumDTOConverterService.albumDTOToEntity(albumDTO));
	}
	
	@PutMapping("/update")
	@ResponseStatus(HttpStatus.OK)
	public void updateAlbum(@RequestBody AlbumDTO albumDTO) {
		albumService.updateAlbum(albumDTOConverterService.albumDTOToEntity(albumDTO));
	}
	
	@GetMapping("/findById")
	public ResponseEntity<AlbumDTO> findAlbumById(@RequestParam Long idAlbum){
		Album album = albumService.findAlbumById(idAlbum);
		return ResponseEntity.ok(albumDTOConverterService.albumEntityToDTO(album));
	}
	
	@GetMapping("/findAll")
	public ResponseEntity<List<AlbumDTO>> findAllAlbums(){
		List<Album> listAlbum = albumService.findAllAlbums();
		return ResponseEntity.ok(listAlbum.stream().map(a -> albumDTOConverterService.albumEntityToDTO(a)).collect(Collectors.toList()));
	}
	
	@DeleteMapping("/delete")
	@ResponseStatus(HttpStatus.OK)
	public void deleteAlbum(@RequestParam Long idAlbum){
		albumService.deleteAlbum(idAlbum);
	}
	
}
