package com.psg.ramasubramani.concepts.cassandra.controller;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.psg.ramasubramani.concepts.cassandra.models.Video;
import com.psg.ramasubramani.concepts.cassandra.models.VideoByTag;
import com.psg.ramasubramani.concepts.cassandra.service.YoutubeVideoService;

/**
 * @author rn5
 *
 */
@RestController
@RequestMapping(path = "/videos")
public class YoutubeVideoController {
	
	private YoutubeVideoService youtubeVideoService;
	
	@Autowired
	public YoutubeVideoController(YoutubeVideoService youtubeService) {
		this.youtubeVideoService = youtubeService;
	}
	
	//http://localhost:8080/rmspsgtech/videos/51eb9aa2-cafe-4d98-a193-b369ba5b0585
	@RequestMapping("/{videoId}")
	@GetMapping(produces = "application/json" )
	public Video getVideoById(@PathVariable("videoId") String videoId) {
		return youtubeVideoService.findById(UUID.fromString(videoId));
	}
	
	//http://localhost:8080/rmspsgtech/videos/
	/**
	 * {
		    "name": "WorldCup2015",
		    "description": "World-Cup-cricket-2015",
		    "previewImages": {
		        "image1": "url3",
		        "image2": "url4"
		    },
		    "tags": [
		        "tag4",
		        "tag5",
		        "tag6"
		    ],
		    "addedDate": "2020-03-20T14:03:46.833+0000"
		}
	 * 
	 */
	@RequestMapping("/")
	@PostMapping(produces = "application/json", consumes = "application/json")
	public Video uploadVideo(@RequestBody Video video) {
		youtubeVideoService.uploadVideo(video);
		return video;
	}
	
	//http://localhost:8080/rmspsgtech/videos/tags/tag7
	@RequestMapping("/tags/{tag}")
	@PostMapping(produces = "application/json")
	public VideoByTag getVideoByTag(@PathVariable("tag")String tag) {
		return youtubeVideoService.findByTag(tag);
	}
}
