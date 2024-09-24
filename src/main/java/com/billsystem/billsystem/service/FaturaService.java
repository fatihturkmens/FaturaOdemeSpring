package com.billsystem.billsystem.service;

import com.billsystem.billsystem.dto.FaturaDto;
import com.billsystem.billsystem.entity.FaturaDetaylari;

import java.util.List;

public interface FaturaService {
    public String faturaodeme(Long hizmetno, double ucret);
    public String yenifaturaolustur(FaturaDto faturaDto);
    public FaturaDetaylari faturagoruntuleme(Long hizmetno);
    public List<FaturaDetaylari> tumFaturalar();
    public String faturasil(Long hizmetno);

}
