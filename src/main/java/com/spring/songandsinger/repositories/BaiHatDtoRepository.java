package com.spring.songandsinger.repositories;

import com.spring.songandsinger.dto.BaiHatDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BaiHatDtoRepository extends JpaRepository<BaiHatDto, Integer> {

    @Query(
            value = "SELECT " +
                    "bh.ID," +
                    "bh.TenBaiHat," +
                    "bh.TenTacGia," +
                    "bh.ThoiLuong," +
                    "bh.NgaySanXuat," +
                    "bh.Gia," +
                    "cs.TenCaSi," +
                    "cs.QueQuan," +
                    "bh.NgayRaMat" +
                    " FROM BaiHat bh JOIN CaSi cs ON bh.casiid = cs.id",
            nativeQuery = true
    )
    List<BaiHatDto> getBaiHatDtoList();

    @Query(
            value = "SELECT " +
                    "bh.ID," +
                    "bh.TenBaiHat," +
                    "bh.TenTacGia," +
                    "bh.ThoiLuong," +
                    "bh.NgaySanXuat," +
                    "bh.Gia," +
                    "cs.TenCaSi," +
                    "cs.QueQuan," +
                    "bh.NgayRaMat" +
                    " FROM BaiHat bh JOIN CaSi cs ON bh.casiid = cs.id",
            nativeQuery = true
    )
    Page<BaiHatDto> getBaiHatDtoPage(Pageable pageable);

    @Query(
            value = "SELECT " +
                    "bh.ID," +
                    "bh.TenBaiHat," +
                    "bh.TenTacGia," +
                    "bh.ThoiLuong," +
                    "bh.NgaySanXuat," +
                    "bh.Gia," +
                    "cs.TenCaSi," +
                    "cs.QueQuan," +
                    "bh.NgayRaMat " +
                    "FROM BaiHat bh JOIN CaSi cs ON bh.casiid = cs.id " +
                    "WHERE (cs.TenCaSi like ?1+'%' OR ?1 IS NULL ) AND " +
                    "(bh.Gia >= ?2 OR ?2 IS NULL ) AND " +
                    "(bh.Gia <= ?3 OR ?3 IS NULL)",
            nativeQuery = true
    )
    List<BaiHatDto> getBaiHatByGiaAndTenCaSi(String tenCaSi, Double to, Double from);

}