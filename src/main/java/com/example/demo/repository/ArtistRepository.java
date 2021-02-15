package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Artist;

public interface ArtistRepository extends JpaRepository<Artist, Long>{

}
