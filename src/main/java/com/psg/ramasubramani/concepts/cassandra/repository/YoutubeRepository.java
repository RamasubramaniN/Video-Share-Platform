package com.psg.ramasubramani.concepts.cassandra.repository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.cassandra.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.psg.ramasubramani.concepts.cassandra.models.Video;

@Repository
public interface YoutubeRepository extends CassandraRepository<Video, UUID> {
	
	@Query("SELECT * FROM videos WHERE videoid = :videoId")
	Optional<Video> findById(@Param("videoId")UUID videoId);	
	
	@Query("SELECT * FROM videos WHERE tag = :tag")
	Optional<Video> findByTag(@Param("tag")String tag);
}
