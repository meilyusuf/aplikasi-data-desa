package com.bugo.aplikasidatadesa.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;

@Entity
@Data
public class Penduduk {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_penduduk")
	private Long id;
	
	@Column(name="no_nik", nullable = false , unique = true)
	private Long noNik;
	
	@Column(name="nama")
	private String nama;
	
	@Column(name="tanggal_lahir")
	@Temporal(TemporalType.DATE)
	private Date tanggalLahir;
	
	@Column(name="tempat_lahir")
	private String tempatLahir;
	
	@Column(name="alamat_desa")
	private String alamatDesa;
	
	@Column(name="status")
	private String status;
	
	@Column(name="pekerjaan")
	private String pekerjaan;
			
	@ManyToOne
	private KartuKeluarga kartuKeluarga;
	 	
	@Column(name="created_date")
	@Temporal(TemporalType.DATE)
	private Date createdDate;
	
	@Column(name="created_by")
	private String createdBy;
	
	
	
	
	
	
	
	
	
	

}
