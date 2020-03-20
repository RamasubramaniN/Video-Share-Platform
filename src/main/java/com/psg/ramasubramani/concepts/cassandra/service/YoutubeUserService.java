package com.psg.ramasubramani.concepts.cassandra.service;

import java.util.Date;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.psg.ramasubramani.concepts.cassandra.models.UserLoginInfo;
import com.psg.ramasubramani.concepts.cassandra.models.UserProfile;
import com.psg.ramasubramani.concepts.cassandra.repository.UserLoginRepository;
import com.psg.ramasubramani.concepts.cassandra.repository.UserProfileRepository;

/**
 * @author rn5
 *
 */
@Service
public class YoutubeUserService {
	
	private UserLoginRepository userLoginRepository;
	private UserProfileRepository userProfileRepository;
	
	@Autowired
	public YoutubeUserService(UserLoginRepository userLoginRepository,
			UserProfileRepository youtubeUserProfileRepository) {
		this.userLoginRepository = userLoginRepository;
		this.userProfileRepository = youtubeUserProfileRepository;
	}
	
	public void signup(UserLoginInfo userLoginInfo) {
		userLoginInfo.setUserid(UUID.randomUUID());
		userLoginRepository.save(userLoginInfo);
	}
	
	public UserProfile findUserByUserId(UUID userId) {
		return userProfileRepository.findUserById(userId).get();
	}
	
	public UserProfile createUserProfile(UserProfile userProfile) {
		userProfile.setCreatedDate(new Date());
		return userProfileRepository.save(userProfile);
	}
	
	public UserLoginInfo findUserLoginInfo(String email) {
		return userLoginRepository.findUserByEmail(email).get();
	}
}
