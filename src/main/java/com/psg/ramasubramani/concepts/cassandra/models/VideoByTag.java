package com.psg.ramasubramani.concepts.cassandra.models;

import java.io.Serializable;
import java.util.Date;

import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import com.psg.ramasubramani.concepts.cassandra.models.primarykey.VideoTagPrimaryKey;

/**
 * @author rn5
 *
 */
@Table(value="video_by_tag")
public class VideoByTag implements Serializable{
	@PrimaryKey
	private VideoTagPrimaryKey videoTagPrimaryKey;
	
	@Column(value="name")
	private String name;
	
	@Column(value="added_date")
	private Date addedDate;
	
	@Column(value="tagged_date")
	private Date taggedDate;

	public VideoTagPrimaryKey getVideoTagPrimaryKey() {
		return videoTagPrimaryKey;
	}

	public void setVideoTagPrimaryKey(VideoTagPrimaryKey videoTagPrimaryKey) {
		this.videoTagPrimaryKey = videoTagPrimaryKey;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getAddedDate() {
		return addedDate;
	}

	public void setAddedDate(Date addedDate) {
		this.addedDate = addedDate;
	}

	public Date getTaggedDate() {
		return taggedDate;
	}

	public void setTaggedDate(Date taggedDate) {
		this.taggedDate = taggedDate;
	}
	
}
