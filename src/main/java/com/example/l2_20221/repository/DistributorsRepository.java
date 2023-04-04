package com.example.l2_20221.repository;

import com.example.l2_20221.Entity.Distributors;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DistributorsRepository extends JpaRepository<Distributors,Integer> {
}
