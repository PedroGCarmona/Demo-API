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

import com.example.demo.DTO.ArtistDTO;
import com.example.demo.model.Artist;
import com.example.demo.service.ArtistService;
import com.example.demo.service.DTO.ArtistDTOConverterService;

@RestController
@RequestMapping("/artist")
public class ArtistController {

	@Autowired
	ArtistService artistService;
	@Autowired
	ArtistDTOConverterService artistDTOConverterService;
	
	@PostMapping("/create")
	@ResponseStatus(HttpStatus.CREATED)
	public void createArtist(@RequestBody ArtistDTO artistDTO) {
		artistService.createArtist(artistDTOConverterService.artistDTOToEntity(artistDTO));
	}
	
	@PutMapping("/update")
	@ResponseStatus(HttpStatus.OK)
	public void updateArtist(@RequestBody ArtistDTO artistDTO) {
		artistService.updateArtist(artistDTOConverterService.artistDTOToEntity(artistDTO));
	}
	
	@GetMapping("/findById")
	public ResponseEntity<ArtistDTO> findArtistById(@RequestParam Long idArtist){
		Artist artist = artistService.findArtistById(idArtist);
		return ResponseEntity.ok(artistDTOConverterService.artistEntityToDTO(artist));
	}
	
	@GetMapping("/findAll")
	public ResponseEntity<List<ArtistDTO>> findAllArtists(){
		List<Artist> listArtist = artistService.findAllArtists();
		return ResponseEntity.ok(listArtist.stream().map(a -> artistDTOConverterService.artistEntityToDTO(a)).collect(Collectors.toList()));
	}
	
	@DeleteMapping("/delete")
	@ResponseStatus(HttpStatus.OK)
	public void deleteArtist(@RequestParam Long idArtist){
		artistService.deleteArtist(idArtist);
	}
	
}
