package com.bugo.aplikasidatadesa.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import lombok.Data;

@Data
public class KartuKeluargaDTO implements Serializable {
	
	private static final long serialVersionUID = 3546308422922384123L;
	private Long kkId;
	private Long noKk;
	private String namaKepalaKk;
	private String alamatDesa;
	private String desa;
	private Date tanggalKeluar; 
	private List<PendudukDTO> anggotaKk= new ArrayList<>();

}
