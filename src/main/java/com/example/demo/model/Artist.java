package com.example.demo.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name="artist")
public class Artist {
	
	@Id
	@Column(name="id_artist")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idArtist;
	@Column(name="name_artist")
	private String nameArtist;
	@Column(name="album_qt")
	private Integer albumQuantity;
	@OneToMany(mappedBy="artist", cascade=CascadeType.ALL)
	private List<Album> albums;
	
}
