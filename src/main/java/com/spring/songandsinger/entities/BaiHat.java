package com.spring.songandsinger.entities;

import jakarta.persistence.*;
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

    @Nationalized
    private String tenbaihat;

    @Nationalized
    private String tentacgia;

    private Integer thoiluong;

    private LocalDate ngaysanxuat;

    private Double gia;

    private Integer casiid;

    private Boolean phathanhdia;

    private LocalDate ngayramat;

}