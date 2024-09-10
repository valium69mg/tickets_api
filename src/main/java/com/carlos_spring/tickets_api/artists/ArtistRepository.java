package com.carlos_spring.tickets_api.artists;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArtistRepository extends JpaRepository<Artist,Integer> {
	
	public Artist findArtistByName(String name);
	
	public Artist findArtistByImage(String image);
	
	
}
