package com.psg.ramasubramani.concepts.cassandra.service;

import java.util.Date;
import java.util.UUID;

import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.psg.ramasubramani.concepts.cassandra.models.Video;
import com.psg.ramasubramani.concepts.cassandra.models.VideoByTag;
import com.psg.ramasubramani.concepts.cassandra.models.primarykey.VideoTagPrimaryKey;
import com.psg.ramasubramani.concepts.cassandra.repository.YoutubeVideoRepository;
import com.psg.ramasubramani.concepts.cassandra.repository.YoutubeVideoTagRepository;

/**
 * @author rn5
 *
 */
@Service
public class YoutubeVideoService {
	
	private YoutubeVideoRepository youtubeRepository;
	private YoutubeVideoTagRepository youtubeVideoTagRepository;
	
	@Autowired
	public YoutubeVideoService(YoutubeVideoRepository youtubeRepository,
			YoutubeVideoTagRepository youtubeVideoTagRepository) {
		this.youtubeRepository = youtubeRepository;
		this.youtubeVideoTagRepository = youtubeVideoTagRepository;
	}
	
	public Video findById(UUID videoId) {
		return youtubeRepository.findById(videoId).get();
	}
	
	public VideoByTag findByTag(String tag) {
		return youtubeVideoTagRepository.findByTag(tag).get();
	}
	
	public Video uploadVideo(Video video) {
		video.setVideoId(UUID.randomUUID());
		video.setUserId(UUID.randomUUID());
		
		//Make an entry in tag table for every tag entry.
		if(CollectionUtils.isNotEmpty(video.getTags())) {
			for(String tag : video.getTags()) {
				
				VideoByTag videoByTag = new VideoByTag();
				
				VideoTagPrimaryKey videoTagPrimaryKey = new VideoTagPrimaryKey();
				videoTagPrimaryKey.setTag(tag);
				videoTagPrimaryKey.setVideoId(video.getVideoId());
				
				videoByTag.setVideoTagPrimaryKey(videoTagPrimaryKey);
				
				videoByTag.setName(video.getName());
				videoByTag.setAddedDate(new Date());
				
				youtubeVideoTagRepository.save(videoByTag);
			}
		}
		return youtubeRepository.save(video);
	}
}
