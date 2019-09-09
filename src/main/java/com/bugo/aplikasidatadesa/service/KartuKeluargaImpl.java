package com.bugo.aplikasidatadesa.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bugo.aplikasidatadesa.dto.KartuKeluargaDTO;
import com.bugo.aplikasidatadesa.entity.KartuKeluarga;
import com.bugo.aplikasidatadesa.repository.KartuKeluargaRepository;
import com.bugo.aplikasidatadesa.util.ObjectMapperUtils;
import com.bugo.aplikasidatadesa.util.PendudukUtil;

@Service
public class KartuKeluargaImpl implements KartuKeluargaService {
	
	@Autowired
	KartuKeluargaRepository kkRepo;

	@Override
	public void insert(KartuKeluargaDTO kartuKeluargaDTO) {
		KartuKeluarga kk  = ObjectMapperUtils.map(kartuKeluargaDTO, KartuKeluarga.class);
		kk.setAlamatDesa(PendudukUtil.getAlamatDesaDesc(kartuKeluargaDTO.getAlamatDesa()));
		kk.setCreatedDate(new Date());
		kk.setCreatedBy("admin");
		kkRepo.save(kk);
	}
	
	

}
