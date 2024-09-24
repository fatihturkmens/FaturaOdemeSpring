package com.billsystem.billsystem.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class FaturaDetaylari {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String hizmetNo;

    @Column
    private double faturaUcreti;

    @Column
    private LocalDate odemeTarihi;

    @Column
    private String faturaodemedurumu;


}
