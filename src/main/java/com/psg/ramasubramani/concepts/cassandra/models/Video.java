package com.psg.ramasubramani.concepts.cassandra.models;

import java.io.Serializable;
import java.util.Date;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.core.mapping.Table;

/**
 * @author rn5
 *
 */
@Table(value="videos")
public class Video implements Serializable {
	@PrimaryKeyColumn(value="videoid", type = PrimaryKeyType.PARTITIONED)
	private UUID videoId;
	
	@Column(value="userid")
	private UUID userId;
	
	@Column(value="name")
	private String name;
	
	@Column(value="description")
	private String description;
	
	@Column(value="preview_images")
	private Map<String, String> previewImages;
	
	@Column(value="tags")
	private Set<String> tags;
	
	@Column(value="added_date")
	private Date addedDate;

	public UUID getVideoId() {
		return videoId;
	}

	public void setVideoId(UUID videoId) {
		this.videoId = videoId;
	}

	public UUID getUserId() {
		return userId;
	}

	public void setUserId(UUID userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Map<String, String> getPreviewImages() {
		return previewImages;
	}

	public void setPreviewImages(Map<String, String> previewImages) {
		this.previewImages = previewImages;
	}

	public Set<String> getTags() {
		return tags;
	}

	public void setTags(Set<String> tags) {
		this.tags = tags;
	}

	public Date getAddedDate() {
		return addedDate;
	}

	public void setAddedDate(Date addedDate) {
		this.addedDate = addedDate;
	}
}
