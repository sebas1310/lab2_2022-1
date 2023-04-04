package com.example.l2_20221.repository;

import com.example.l2_20221.Entity.Games;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GamesRepository extends JpaRepository<Games,Integer> {
}
