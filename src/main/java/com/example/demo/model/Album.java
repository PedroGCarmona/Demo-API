package com.example.demo.model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
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
@Table(name="album")
public class Album {
	
	@Id
	@Column(name="id_album")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idAlbum;
	@Column(name="name_album")
	private String nameAlbum;
	@Column(name="song_qt")
	private Integer songQuantity;
	@Column(name="release_dt", columnDefinition="TIMESTAMP")
	private LocalDate releaseDate;
	@ManyToOne
	@JoinColumn(name="fk_artist")
	private Artist artist;
	@OneToMany(mappedBy="album", cascade=CascadeType.ALL)
	private List<Song> songs;
	
}
