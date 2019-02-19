package com.example.egz.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "pazymiai")
public class Pazymys {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(
            fetch=FetchType.LAZY
    )
    @JoinColumn(name="studentai_id")
    @JsonBackReference
    private Studentas studentas;

    java.sql.Date date;
    private int pazymys;
}
