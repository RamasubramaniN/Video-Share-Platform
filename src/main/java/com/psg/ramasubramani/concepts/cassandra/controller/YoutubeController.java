package com.psg.ramasubramani.concepts.cassandra.controller;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.psg.ramasubramani.concepts.cassandra.models.Video;
import com.psg.ramasubramani.concepts.cassandra.service.YoutubeService;

/**
 * @author rn5
 *
 */
@RestController
@RequestMapping(path = "/videos")
public class YoutubeController {
	
	private YoutubeService youtubeService;
	
	@Autowired
	public YoutubeController(YoutubeService youtubeService) {
		this.youtubeService = youtubeService;
	}
	
	@RequestMapping("/{videoId}")
	@GetMapping(produces = "application/json" )
	public Video getVideoById(@PathVariable("videoId") String videoId) {
		Video video = youtubeService.findById(UUID.fromString(videoId));
		System.out.println(video);
		return video;
	}
	
}
