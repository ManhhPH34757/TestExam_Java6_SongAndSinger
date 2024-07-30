package com.spring.songandsinger.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

/**
 * DTO for {@link com.spring.songandsinger.entities.BaiHat}
 */
@Getter
@Setter
@Entity
public class BaiHatDto{
    @Id
    private Integer id;
    private String tenbaihat;
    private String tentacgia;
    private Integer thoiluong;
    private LocalDate ngaysanxuat;
    private Double gia;
    private String tencasi;
    private String quequan;
    private LocalDate ngayramat;
}