package com.bugo.aplikasidatadesa.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class KartuKeluargaDTO {
	
	private Long noKk;
	private String namaKepalaKk;
	private String alamatDesa;
	private String desa;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private Date tanggalKeluar;

}
