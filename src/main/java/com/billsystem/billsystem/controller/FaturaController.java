package com.billsystem.billsystem.controller;

import com.billsystem.billsystem.dto.FaturaDto;
import com.billsystem.billsystem.entity.FaturaDetaylari;
import com.billsystem.billsystem.service.FaturaService;
import com.billsystem.billsystem.service.FaturaServiceİmpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/fatura")
public class FaturaController {

    @Autowired
    private FaturaService faturaService;


    @GetMapping("/all")
    public ResponseEntity<List<FaturaDetaylari>> faturalar(){
        List<FaturaDetaylari>faturalar = faturaService.tumFaturalar();
        return new ResponseEntity<>(faturalar, HttpStatus.OK);
    }
    @GetMapping("/id/{id}")
    public ResponseEntity<FaturaDetaylari> fatura(@PathVariable Long id){
        FaturaDetaylari faturaDetaylari= faturaService.faturagoruntuleme(id);
        return new ResponseEntity<>(faturaDetaylari,HttpStatus.OK);
    }

    @PostMapping("/ekle")
    public ResponseEntity<String> faturaekle(@RequestBody FaturaDto faturaDetaylari){
        faturaService.yenifaturaolustur(faturaDetaylari);
        return new ResponseEntity<>("Fatura olusturuldu",HttpStatus.CREATED);
    }

    @PutMapping("/odeme/{hizmetno}/{miktar}")
    public ResponseEntity<String>odeme(@PathVariable Long hizmetno,@PathVariable double miktar){
       faturaService.faturaodeme(hizmetno,miktar);
       return new ResponseEntity<>("Ödenemiz için teşekkür ederiz",HttpStatus.OK);

    }
    @DeleteMapping("/delete/{hizmetno}")
    public ResponseEntity<String>delete(@PathVariable Long hizmetno){
        faturaService.faturasil(hizmetno);
        return new ResponseEntity<>("fatura bilgileri silinmiştir",HttpStatus.OK);
    }
}
