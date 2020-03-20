package com.psg.ramasubramani.concepts.cassandra.controller;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.psg.ramasubramani.concepts.cassandra.models.UserLoginInfo;
import com.psg.ramasubramani.concepts.cassandra.models.UserProfile;
import com.psg.ramasubramani.concepts.cassandra.service.YoutubeUserService;

/**
 * @author rn5
 *
 */
@RequestMapping(path = "/users")
@RestController
public class YoutubeUserController {
	
	private YoutubeUserService youtubeUserService;
	
	@Autowired
	public YoutubeUserController(YoutubeUserService youtubeUserService) {
		this.youtubeUserService = youtubeUserService;
	}
	
	//http://localhost:8080/rmspsgtech/users/signup
	/**
	 * {
		    "name": "Ramasubramani N",
		    "email": "ram@noemail.com",
		    "password" : "abc"
		}
	 */
	@RequestMapping(path = "/signup")
	@PostMapping(consumes = "application/json")
	public void signup(@RequestBody UserLoginInfo userLoginInfo) {
		youtubeUserService.signup(userLoginInfo);
	}
	
	//http://localhost:8080/rmspsgtech/users/9a0735fb-fb2b-41c3-9edb-0b1334fbe6b6
	@RequestMapping(path = "/{userId}")
	@GetMapping(produces = "application/json")
	public UserProfile getUserById(@PathVariable("userId") String userId) {
		return youtubeUserService.findUserByUserId(UUID.fromString(userId));
	}
	
	//http://localhost:8080/rmspsgtech/users/
	/**
	 * {
		    "firstname": "Ramasubramani",
		    "lastname": "N",
		    "email" : "ram@noemail.com"
		}
	 * 
	 */
	@RequestMapping(path = "") 
	@PostMapping(produces = "application/json")
	public UserProfile createUser(@RequestBody UserProfile userProfile) {
		UserLoginInfo userLoginInfo = youtubeUserService.findUserLoginInfo(userProfile.getEmail());
		userProfile.setUserId(userLoginInfo.getUserid());
		return youtubeUserService.createUserProfile(userProfile);
	}
}
