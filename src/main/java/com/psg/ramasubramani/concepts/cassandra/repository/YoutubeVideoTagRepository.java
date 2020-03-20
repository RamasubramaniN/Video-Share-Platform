package com.psg.ramasubramani.concepts.cassandra.repository;

import java.util.Optional;

import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.cassandra.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.psg.ramasubramani.concepts.cassandra.models.VideoByTag;
import com.psg.ramasubramani.concepts.cassandra.models.primarykey.VideoTagPrimaryKey;

@Repository
public interface YoutubeVideoTagRepository extends CassandraRepository<VideoByTag, VideoTagPrimaryKey> {
	@Query("SELECT * FROM video_by_tag WHERE tag = :tag")
	Optional<VideoByTag> findByTag(@Param("tag")String tag);
}
