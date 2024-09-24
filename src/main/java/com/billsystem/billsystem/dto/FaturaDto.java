package com.billsystem.billsystem.dto;

import com.billsystem.billsystem.entity.FaturaDetaylari;
import jakarta.persistence.Column;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.time.LocalDate;

@Data
public class FaturaDto {

    @NotEmpty(message = "hizmetno alanı boş bırakılamaz")
    @Size(min = 2,max = 30)
    private String hizmetNo;
    private double faturaUcreti;
    private LocalDate odemeTarihi;

    @NotEmpty(message = "fatura ödeme durumu boş bırakılamaz")
    @Size(min = 1,max = 10)
    private String faturaodemedurumu;





    }

