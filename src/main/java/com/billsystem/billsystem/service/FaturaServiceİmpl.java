package com.billsystem.billsystem.service;

import com.billsystem.billsystem.dto.FaturaDto;
import com.billsystem.billsystem.entity.FaturaDetaylari;
import com.billsystem.billsystem.repository.FaturaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FaturaServiceİmpl implements FaturaService{

    @Autowired
    private FaturaRepository faturaRepository;



    public List<FaturaDetaylari> tumFaturalar() {        // tüm faturalar

        return faturaRepository.findAll();
    }

    private FaturaDetaylari faturadtofatura(FaturaDetaylari faturaDetaylari,FaturaDto faturaDto) {
        faturaDetaylari.setHizmetNo(faturaDto.getHizmetNo());
        faturaDetaylari.setFaturaUcreti(faturaDto.getFaturaUcreti());
        faturaDetaylari.setOdemeTarihi(faturaDto.getOdemeTarihi());
        faturaDetaylari.setFaturaodemedurumu(faturaDto.getFaturaodemedurumu());

      return   faturaRepository.save(faturaDetaylari);
    }



        public FaturaDetaylari faturagoruntuleme(Long hizmetno){ /// hizmet no ile fatura bulma
     Optional<FaturaDetaylari> faturaDetaylari =   faturaRepository.findById(hizmetno);
     return faturaDetaylari.get();
    }


    public String yenifaturaolustur(FaturaDto faturaDto){
        faturadtofatura(new FaturaDetaylari(),faturaDto);
        return "fatura oluşturuldu";
    }

    public String faturaodeme(Long hizmetno, double ucret){
           FaturaDetaylari faturaDetaylari =   (faturaRepository.findById(hizmetno)).get();

          faturaDetaylari.setFaturaUcreti(faturaDetaylari.getFaturaUcreti()-ucret);
          if (faturaDetaylari.getFaturaUcreti()!=0){
              return "Lütfen borcunuzu sıfırlayınız";
          }
          else {  faturaDetaylari.setFaturaodemedurumu("ödendi");
              faturaRepository.save(faturaDetaylari);
              return "Ödemeniz için teşekkür ederiz.";
          }




    }
    public String faturasil(Long hizmetno){
        faturaRepository.deleteById(hizmetno);
        return "fatura bilgileri silindi";
    }

}
