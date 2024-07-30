package com.spring.songandsinger.repositories;

import com.spring.songandsinger.dto.CaSiDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CaSiDtoRepository extends JpaRepository<CaSiDto, Integer> {
}