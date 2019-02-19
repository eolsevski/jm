package com.example.egz.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Table(name = "studentai")
public class Studentas {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String vardas;
    private String pavarde;
    private String el_pastas;
    @OneToMany(
            cascade=CascadeType.ALL
            ,fetch=FetchType.LAZY
//            ,mappedBy = "studentas"
    )
    @JoinColumn(name="studentai_id")
    @JsonManagedReference
    private List<Pazymys> pazymys;
}
