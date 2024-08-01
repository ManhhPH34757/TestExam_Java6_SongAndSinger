package com.spring.songandsinger.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Nationalized;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "baihat")
public class BaiHat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty(message = "TenBaiHat could not be null")
    @Nationalized
    private String tenbaihat;

    @NotEmpty(message = "TenTacGia could not be null")
    @Nationalized
    private String tentacgia;

    @NotNull(message = "ThoiLuong could not be null")
    private Integer thoiluong;

    @NotNull(message = "NgaySanXuat could not be null")
    private LocalDate ngaysanxuat;

    @NotNull(message = "Gia could not be null")
    private Double gia;

    @NotNull(message = "CaSiId could not be null")
    private Integer casiid;

    @NotNull(message = "PhathanhDia could not be null")
    private Boolean phathanhdia;

    @NotNull(message = "NgayRamaMat could not be null")
    private LocalDate ngayramat;

}