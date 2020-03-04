package com.psg.ramasubramani.concepts.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.psg.ramasubramani.concepts.models.PlayerEntity;

@Repository
public interface PlayerRepository extends JpaRepository<PlayerEntity, String> {
	@Query("SELECT p FROM PlayerEntity p WHERE p.age <= :maxAge")
	List<PlayerEntity> findByMaxAge(@Param("maxAge") int maxAge);
}
