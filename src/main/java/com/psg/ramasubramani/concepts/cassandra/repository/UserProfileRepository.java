package com.psg.ramasubramani.concepts.cassandra.repository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.cassandra.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.psg.ramasubramani.concepts.cassandra.models.UserProfile;

/**
 * @author rn5
 *
 */
@Repository
public interface UserProfileRepository extends CassandraRepository<UserProfile, String>{
	
	@Query(value = "SELECT * FROM users WHERE userid = :userId")
	Optional<UserProfile> findUserById(@Param("userId")UUID userId); 
}
