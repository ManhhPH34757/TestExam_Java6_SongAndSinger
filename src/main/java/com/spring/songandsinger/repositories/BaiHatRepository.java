package com.spring.songandsinger.repositories;

import com.spring.songandsinger.entities.BaiHat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BaiHatRepository extends JpaRepository<BaiHat, Integer> {
}