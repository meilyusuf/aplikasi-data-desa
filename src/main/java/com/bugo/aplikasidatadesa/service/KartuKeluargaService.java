package com.bugo.aplikasidatadesa.service;

import java.util.List;

import com.bugo.aplikasidatadesa.dto.KartuKeluargaDTO;
import com.bugo.aplikasidatadesa.entity.KartuKeluarga;

public interface KartuKeluargaService  {
	
	public void insert(KartuKeluargaDTO kartuKeluargaDTO);

	public List<KartuKeluargaDTO> getAll();

}
