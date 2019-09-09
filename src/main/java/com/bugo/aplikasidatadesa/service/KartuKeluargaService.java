package com.bugo.aplikasidatadesa.service;

import java.util.List;

import com.bugo.aplikasidatadesa.dto.KartuKeluargaDTO;

public interface KartuKeluargaService  {
	
	public void insert(KartuKeluargaDTO kartuKeluargaDTO);

	public List<KartuKeluargaDTO> getAll();

}
