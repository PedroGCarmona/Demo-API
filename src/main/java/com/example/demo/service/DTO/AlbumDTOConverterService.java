package com.example.demo.service.DTO;

import java.util.Objects;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.DTO.AlbumDTO;
import com.example.demo.model.Album;
import com.example.demo.model.Artist;
import com.example.demo.service.ArtistService;

@Service
public class AlbumDTOConverterService {

	@Autowired
	ArtistService artistService;
	@Autowired
	SongDTOConverterService songDTOConverterService;
	
	public AlbumDTO albumEntityToDTO(Album album) {
		return AlbumDTO.builder()
				.idAlbum(album.getIdAlbum())
				.nameAlbum(album.getNameAlbum())
				.songQuantity(album.getSongQuantity())
				.releaseDate(album.getReleaseDate())
				.idArtist(album.getArtist().getIdArtist())
				.songs(album.getSongs().stream().map(s -> songDTOConverterService.songEntityToDTO(s)).collect(Collectors.toList()))
				.build();
	}
	
	public Album albumDTOToEntity(AlbumDTO albumDTO) {
		Artist artist = artistService.findArtistById(albumDTO.getIdArtist());
		return Album.builder()
				.idAlbum(albumDTO.getIdAlbum())
				.nameAlbum(albumDTO.getNameAlbum())
				.songQuantity(albumDTO.getSongQuantity())
				.releaseDate(albumDTO.getReleaseDate())
				.artist(Objects.isNull(artist) ? Artist.builder().idArtist(albumDTO.getIdAlbum()).build() : artist)
				.songs(albumDTO.getSongs().stream().map(s -> songDTOConverterService.songDTOToEntity(s)).collect(Collectors.toList()))
				.build();
	}
	
}
