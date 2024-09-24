package com.billsystem.billsystem.repository;

import com.billsystem.billsystem.entity.FaturaDetaylari;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface FaturaRepository extends JpaRepository<FaturaDetaylari,Long> {


}
