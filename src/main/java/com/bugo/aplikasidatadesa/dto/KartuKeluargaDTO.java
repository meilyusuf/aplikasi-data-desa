package com.bugo.aplikasidatadesa.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class KartuKeluargaDTO {
	
	private Long kkId;
	private Long noKk;
	private String namaKepalaKk;
	private String alamatDesa;
	private String desa;
	private Date tanggalKeluar;
	private List<PendudukDTO> anggotaKk = new ArrayList<>(); 

}
