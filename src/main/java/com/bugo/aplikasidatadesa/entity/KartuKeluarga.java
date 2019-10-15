package com.bugo.aplikasidatadesa.entity;

import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;

@Entity
@Data
public class KartuKeluarga {
	
	@Id
	@Column(name="id_kk")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long kkId;
	
	@Column(name="no_kk")
	private Long noKk;
		
	@Column(name="nama_kepala_kk")
	private String namaKepalaKk;
	
	@Column(name="alamat_desa")
	private String alamatDesa;
	
	@Column(name="desa")
	private String desa;
	
	@Column(name="tanggal_keluar")
	@Temporal(TemporalType.DATE)
	private Date tanggalKeluar;
		
	 @OneToMany(mappedBy="kartuKeluarga") 
	 private List<Penduduk> anggotaKk;
	 	
	@Column(name="created_date")
	@Temporal(TemporalType.DATE)
	private Date createdDate;
	
	@Column(name="created_by")
	private String createdBy;

	
}