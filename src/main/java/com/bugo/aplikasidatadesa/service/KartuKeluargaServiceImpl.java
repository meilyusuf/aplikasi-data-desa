package com.bugo.aplikasidatadesa.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bugo.aplikasidatadesa.dto.KartuKeluargaDTO;
import com.bugo.aplikasidatadesa.entity.KartuKeluarga;
import com.bugo.aplikasidatadesa.repository.KartuKeluargaRepository;
import com.bugo.aplikasidatadesa.util.ObjectMapperUtils;
import com.bugo.aplikasidatadesa.util.PendudukUtil;

@Service
public class KartuKeluargaServiceImpl implements KartuKeluargaService {
	
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

	@Override
	public List<KartuKeluargaDTO> getAll() {
		List<KartuKeluarga> listKk = (List<KartuKeluarga>) kkRepo.findAll();
		return  ObjectMapperUtils.mapAll(listKk, KartuKeluargaDTO.class);
	}
	
	

}
