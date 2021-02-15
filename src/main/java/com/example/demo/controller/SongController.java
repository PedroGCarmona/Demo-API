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

import com.example.demo.DTO.SongDTO;
import com.example.demo.model.Song;
import com.example.demo.service.SongService;
import com.example.demo.service.DTO.SongDTOConverterService;

@RestController
@RequestMapping("/song")
public class SongController {

	@Autowired
	SongService songService;
	@Autowired
	SongDTOConverterService songDTOConverterService;
	
	@PostMapping("/create")
	@ResponseStatus(HttpStatus.CREATED)
	public void createSong(@RequestBody SongDTO songDTO) {
		songService.createSong(songDTOConverterService.songDTOToEntity(songDTO));
	}
	
	@PutMapping("/update")
	@ResponseStatus(HttpStatus.OK)
	public void updateSong(@RequestBody SongDTO songDTO) {
		songService.updateSong(songDTOConverterService.songDTOToEntity(songDTO));
	}
	
	@GetMapping("/findById")
	public ResponseEntity<SongDTO> findSongById(@RequestParam Long idSong){
		Song song = songService.findSongById(idSong);
		return ResponseEntity.ok(songDTOConverterService.songEntityToDTO(song));
	}
	
	@GetMapping("/findAll")
	public ResponseEntity<List<SongDTO>> findAllSongs(){
		List<Song> listSong = songService.findAllSongs();
		return ResponseEntity.ok(listSong.stream().map(s -> songDTOConverterService.songEntityToDTO(s)).collect(Collectors.toList()));
	}
	
	@DeleteMapping("/delete")
	@ResponseStatus(HttpStatus.OK)
	public void deleteSong(@RequestParam Long idSong){
		songService.deleteSong(idSong);
	}
	
}
