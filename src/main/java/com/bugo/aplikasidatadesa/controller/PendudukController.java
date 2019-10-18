package com.bugo.aplikasidatadesa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.bugo.aplikasidatadesa.dto.PendudukDTO;
import com.bugo.aplikasidatadesa.entity.Penduduk;
import com.bugo.aplikasidatadesa.service.PendudukService;



@RestController
@RequestMapping("/api/penduduk")
public class PendudukController {
	
	@Autowired
	PendudukService pendudukService;
	
	@PostMapping(value="/insert")
	@ResponseStatus(HttpStatus.CREATED)
	public void insertPenduduk(@RequestBody PendudukDTO penduduk) {
		pendudukService.insert(penduduk);
	}
	
	@GetMapping(value="/getAll")
	public ResponseEntity<List<PendudukDTO>> getAllpenduduk() {
		List<PendudukDTO> listPenduduk = pendudukService.getAll();
		return new ResponseEntity<>(listPenduduk, HttpStatus.OK);
	}
	
	@GetMapping(value="/delete/{id}")
	public void deletePendudukById(@PathVariable Integer id) {
	   
	}

}
