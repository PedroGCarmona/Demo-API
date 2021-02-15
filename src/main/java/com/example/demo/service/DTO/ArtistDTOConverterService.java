package com.example.demo.service.DTO;

import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.DTO.ArtistDTO;
import com.example.demo.model.Artist;

@Service
public class ArtistDTOConverterService {
	
	@Autowired
	AlbumDTOConverterService albumDTOConverterService;
	
	public ArtistDTO artistEntityToDTO(Artist artist) {
		return ArtistDTO.builder()
				.idArtist(artist.getIdArtist())
				.nameArtist(artist.getNameArtist())
				.albumQuantity(artist.getAlbumQuantity())
				.albums(artist.getAlbums().stream().map(a -> albumDTOConverterService.albumEntityToDTO(a)).collect(Collectors.toList()))
				.build();
	}
	
	public Artist artistDTOToEntity(ArtistDTO artistDTO) {
		return Artist.builder()
				.idArtist(artistDTO.getIdArtist())
				.nameArtist(artistDTO.getNameArtist())
				.albumQuantity(artistDTO.getAlbumQuantity())
				.albums(artistDTO.getAlbums().stream().map(a -> albumDTOConverterService.albumDTOToEntity(a)).collect(Collectors.toList()))
				.build();
	}
	
}
