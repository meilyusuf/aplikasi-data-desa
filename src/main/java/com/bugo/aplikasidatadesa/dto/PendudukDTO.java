package com.bugo.aplikasidatadesa.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class PendudukDTO {
	
	private Long id;
	private Long noNik;
	private KartuKeluargaDTO noKK;
	private String nama;
	private Date tanggalLahir;
	private String tempatLahir;
	private String status;
	private String pekerjaan;
	

}
