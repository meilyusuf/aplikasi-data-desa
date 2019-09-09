package com.bugo.aplikasidatadesa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.bugo.aplikasidatadesa.dto.KartuKeluargaDTO;
import com.bugo.aplikasidatadesa.service.KartuKeluargaService;

@RestController
@RequestMapping("/api/kartuKeluarga")
public class KartuKeluargaController {
	
	@Autowired
	KartuKeluargaService kkService;
	
	@PostMapping(value="/insertKk")
	@ResponseStatus(HttpStatus.CREATED)
	public void insertPenduduk(@RequestBody KartuKeluargaDTO kartukeluargaDTO) {
		System.out.println(kartukeluargaDTO.toString());
		kkService.insert(kartukeluargaDTO);
	}

}
