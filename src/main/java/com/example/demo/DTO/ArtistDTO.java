package com.example.demo.DTO;

import java.util.List;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ArtistDTO {
	
	private Long idArtist;
	private String nameArtist;
	private Integer albumQuantity;
	private List<AlbumDTO> albums;
}
