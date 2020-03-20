package com.psg.ramasubramani.concepts.cassandra.repository;

import java.util.Optional;

import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.cassandra.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.psg.ramasubramani.concepts.cassandra.models.UserLoginInfo;

@Repository
public interface UserLoginRepository extends CassandraRepository<UserLoginInfo, String> {
	@Query(value = "SELECT * FROM user_login WHERE email = :email")
	Optional<UserLoginInfo> findUserByEmail(@Param("email")String email);
}
