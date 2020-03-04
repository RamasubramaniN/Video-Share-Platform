package com.intuit.ramasubramani.concepts.autoconfig.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.intuit.ramasubramani.concepts.autoconfig.models.PlayerEntity;
import com.intuit.ramasubramani.concepts.autoconfig.service.PlayerService;

/**
 * @author rn5
 *
 */
@RestController
@RequestMapping(path = "/players")
public class PlayerController {
	
	private PlayerService playerService;
	
	@Autowired
	public PlayerController(PlayerService playerService) {
		System.out.println("Init controller");
		this.playerService = playerService;
	}
	
	//localhost:8080/rmspsgtech/players
	//localhost:8080/rmspsgtech/players?maxAge=40 - Print all players whose age < 30
	@GetMapping(produces = "application/json")//Age is optional parameter
	public List<PlayerEntity> getAllPlayers(@RequestParam(required = false) Integer maxAge) {
		if(maxAge == null)
			return playerService.getAllPlayers();
		else
			return playerService.findByMaxAge(maxAge);
	}
	
	@RequestMapping("/{id}")
	@GetMapping(produces = "application/json" )
	public PlayerEntity getPlayerById(@PathVariable("id") String id) {
		return playerService.getPlayerById(id);
	}
}
