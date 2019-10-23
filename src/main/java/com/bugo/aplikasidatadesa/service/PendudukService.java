package com.bugo.aplikasidatadesa.service;

import java.util.List;

import com.bugo.aplikasidatadesa.dto.PendudukDTO;
import com.bugo.aplikasidatadesa.entity.Penduduk;

public interface PendudukService {
	
	public void insert(PendudukDTO penduduk);
	
	public List<PendudukDTO> getAll();
	
	public void deleteById(Integer id);

}
