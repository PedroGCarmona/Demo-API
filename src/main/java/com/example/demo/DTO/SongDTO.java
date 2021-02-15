package com.example.demo.DTO;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SongDTO {
	
	private Long idSong;
	private String nameSong;
	private Integer lengthInSeconds;
	private Long idAlbum;
}
