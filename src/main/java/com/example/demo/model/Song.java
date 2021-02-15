package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="song")
public class Song {
	
	@Id
	@Column(name="id_song")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idSong;
	@Column(name="name_song")
	private String nameSong;
	@Column(name="length_sec")
	private Integer lengthInSeconds;
	@ManyToOne
	@JoinColumn(name="fk_album")
	private Album album;
	
}
