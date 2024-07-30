package com.spring.songandsinger.repositories;

import com.spring.songandsinger.entities.CaSi;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CaSiRepository extends JpaRepository<CaSi, Integer> {
}