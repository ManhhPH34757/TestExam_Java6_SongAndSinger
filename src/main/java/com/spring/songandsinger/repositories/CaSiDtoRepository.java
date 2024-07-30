package com.spring.songandsinger.repositories;

import com.spring.songandsinger.dto.CaSiDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CaSiDtoRepository extends JpaRepository<CaSiDto, Integer> {

    @Query(
            value = "SELECT " +
                    "cs.ID," +
                    "cs.TenCaSi," +
                    "SUM(bh.ThoiLuong) as tongthoiluong " +
                    "FROM CaSi cs JOIN BaiHat bh ON cs.id = bh.casiid group by cs.ID, cs.TenCaSi ",
            nativeQuery = true
    )
    List<CaSiDto> getCaSiDtoList();
}