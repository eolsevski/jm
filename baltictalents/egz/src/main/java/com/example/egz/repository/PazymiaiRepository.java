package com.example.egz.repository;

import com.example.egz.model.Pazymys;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface PazymiaiRepository extends CrudRepository<Pazymys, Long> {

}
