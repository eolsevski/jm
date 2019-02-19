package com.example.egz.repository;

import com.example.egz.model.Studentas;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentasRepository extends CrudRepository<Studentas, Long> {
}
