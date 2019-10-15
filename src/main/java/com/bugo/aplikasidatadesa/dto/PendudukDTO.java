package com.bugo.aplikasidatadesa.dto;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.Data;

@Data
public class PendudukDTO implements Serializable {

	private static final long serialVersionUID = 7804656700622538877L;
	private Long id;
	private Long noNik;
	private String nama;
	private Date tanggalLahir;
	private String tempatLahir;
	private String status;
	private String pekerjaan;
	private Long kkId;
	

}
