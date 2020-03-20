package com.psg.ramasubramani.concepts.cassandra.models.primarykey;

import java.io.Serializable;
import java.util.UUID;

import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyClass;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;

/**
 * @author rn5
 *
 */
@PrimaryKeyClass
public class VideoTagPrimaryKey implements Serializable {
	
	@PrimaryKeyColumn(value = "tag", type = PrimaryKeyType.PARTITIONED)
	private String tag;
	
	@PrimaryKeyColumn(value = "videoid", ordinal = 0)
	private UUID videoId;

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	public UUID getVideoId() {
		return videoId;
	}

	public void setVideoId(UUID videoId) {
		this.videoId = videoId;
	}
	
}
