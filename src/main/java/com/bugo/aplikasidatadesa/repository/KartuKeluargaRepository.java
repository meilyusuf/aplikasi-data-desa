package com.bugo.aplikasidatadesa.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.bugo.aplikasidatadesa.entity.KartuKeluarga;

@Repository
public interface KartuKeluargaRepository extends CrudRepository<KartuKeluarga, Long>  {

}
