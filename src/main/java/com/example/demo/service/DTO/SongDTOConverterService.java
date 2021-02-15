package com.example.demo.service.DTO;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.DTO.SongDTO;
import com.example.demo.model.Album;
import com.example.demo.model.Song;
import com.example.demo.service.AlbumService;

@Service
public class SongDTOConverterService {

	@Autowired
	AlbumService albumService;
	@Autowired
	AlbumDTOConverterService albumDTOConverterService;
	
	public SongDTO songEntityToDTO(Song song) {
		return SongDTO.builder()
				.idSong(song.getIdSong())
				.nameSong(song.getNameSong())
				.lengthInSeconds(song.getLengthInSeconds())
				.idAlbum(song.getAlbum().getIdAlbum())
				.build();
	}
	
	public Song songDTOToEntity(SongDTO songDTO) {
		Album album = albumService.findAlbumById(songDTO.getIdAlbum());
		return Song.builder()
				.idSong(songDTO.getIdSong())
				.nameSong(songDTO.getNameSong())
				.lengthInSeconds(songDTO.getLengthInSeconds())
				.album(Objects.isNull(album)? Album.builder().idAlbum(songDTO.getIdAlbum()).build() : album)
				.build();
	}
	
	
}
