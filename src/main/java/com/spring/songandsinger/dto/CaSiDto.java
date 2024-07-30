package com.spring.songandsinger.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

/**
 * DTO for {@link com.spring.songandsinger.entities.CaSi}
 */
@Getter
@Setter
@Entity
public class CaSiDto{
    @Id
    Integer id;
    String tencasi;
    Integer tongthoiluong;
}