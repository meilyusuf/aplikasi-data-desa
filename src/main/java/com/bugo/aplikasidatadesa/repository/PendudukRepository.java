package com.bugo.aplikasidatadesa.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.bugo.aplikasidatadesa.entity.Penduduk;

@Repository
public interface PendudukRepository extends CrudRepository<Penduduk, Long> {

}
