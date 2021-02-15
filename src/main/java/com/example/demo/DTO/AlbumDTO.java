package com.example.demo.DTO;

import java.time.LocalDate;
import java.util.List;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AlbumDTO {
	
	private Long idAlbum;
	private String nameAlbum;
	private Integer songQuantity;
	private LocalDate releaseDate;
	private Long idArtist;
	private List<SongDTO> songs;
	
}
