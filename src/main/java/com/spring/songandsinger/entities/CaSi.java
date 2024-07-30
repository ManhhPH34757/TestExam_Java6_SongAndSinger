package com.spring.songandsinger.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Nationalized;

@Getter
@Setter
@Entity
public class CaSi {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Nationalized
    private String tencasi;

    @Nationalized
    private String quequan;

    private Integer tuoi;

    @Nationalized
    private String congty;

    private String sdt;

    private Boolean gioitinh;

}