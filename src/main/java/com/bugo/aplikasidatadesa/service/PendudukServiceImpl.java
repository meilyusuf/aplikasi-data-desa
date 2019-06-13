package com.bugo.aplikasidatadesa.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bugo.aplikasidatadesa.dto.type.AlamatDesa;
import com.bugo.aplikasidatadesa.entity.Penduduk;
import com.bugo.aplikasidatadesa.repository.PendudukRepository;

@Service
public class PendudukServiceImpl implements PendudukService {
	
	@Autowired
	PendudukRepository pendudukRepository;

	@Override
	public void insert(Penduduk penduduk) {
		//AlamatDesa listDukuh = new ArrayL
		
		int lookupAlamatDesa = Integer.parseInt(penduduk.getAlamatDesa());
		switch (lookupAlamatDesa) {
		  case 1:
			  penduduk.setAlamatDesa(AlamatDesa.NGANCAR.getDescription());
		    break;
		  case 2:
			  penduduk.setAlamatDesa(AlamatDesa.PENJALIN.getDescription());
		    break;
		  case 3:
			  penduduk.setAlamatDesa(AlamatDesa.TAMBAK.getDescription());
		    break;
		  case 4:
			  penduduk.setAlamatDesa(AlamatDesa.KAMANDAWA.getDescription());
		    break;
		  case 5:
			  penduduk.setAlamatDesa(AlamatDesa.MINTOROGO.getDescription());
		    break;
		  case 6:
			  penduduk.setAlamatDesa(AlamatDesa.PONDOK.getDescription());
		    break;
		  case 7:
			  penduduk.setAlamatDesa(AlamatDesa.KARANGPANAS.getDescription());
		    break;
		  default:
			  penduduk.setAlamatDesa(null);
			 break; 
		}		
		penduduk.setCreatedBy("admin");
		penduduk.setCreatedDate(new Date());
		pendudukRepository.save(penduduk);				
	}

}
