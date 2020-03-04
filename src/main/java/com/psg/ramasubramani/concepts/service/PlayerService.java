package com.psg.ramasubramani.concepts.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.psg.ramasubramani.concepts.models.PlayerEntity;
import com.psg.ramasubramani.concepts.repository.PlayerRepository;

/**
 * @author rn5
 *
 */
@Service
public class PlayerService {

	private PlayerRepository playerRepository;

	@Autowired
	public PlayerService(PlayerRepository playerRepository) {
		this.playerRepository = playerRepository;
	}

	public List<PlayerEntity> getAllPlayers() {
		return playerRepository.findAll();
	}
	
	public PlayerEntity getPlayerById(String id) {
		return playerRepository.findById(id).get();
	}

	public List<PlayerEntity> findByMaxAge(int maxAge) {
		return playerRepository.findByMaxAge(maxAge);
	}
}
