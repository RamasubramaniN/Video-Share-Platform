package com.psg.ramasubramani.concepts.cassandra.service;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.psg.ramasubramani.concepts.cassandra.models.Video;
import com.psg.ramasubramani.concepts.cassandra.repository.YoutubeRepository;

/**
 * @author rn5
 *
 */
@Service
public class YoutubeService {
	
	private YoutubeRepository youtubeRepository;
	
	@Autowired
	public YoutubeService(YoutubeRepository youtubeRepository) {
		this.youtubeRepository = youtubeRepository;
	}
	
	public Video findById(UUID videoId) {
		return youtubeRepository.findById(videoId).get();
	}
	
	public Video findByTag(String tag) {
		return youtubeRepository.findByTag(tag).get();
	}
}
