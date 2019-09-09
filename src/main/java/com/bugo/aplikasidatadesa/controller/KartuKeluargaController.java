package com.bugo.aplikasidatadesa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
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
		kkService.insert(kartukeluargaDTO);
	}
	
	@GetMapping(value="/getAll")
	public ResponseEntity<List<KartuKeluargaDTO>> getAllKartuKeluarga() {
		List<KartuKeluargaDTO> listKk = kkService.getAll();
		return new ResponseEntity<>(listKk, HttpStatus.OK);
	}

}
