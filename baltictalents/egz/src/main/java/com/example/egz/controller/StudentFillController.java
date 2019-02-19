package com.example.egz.controller;

import com.example.egz.model.Pazymys;
import com.example.egz.model.Studentas;
import com.example.egz.repository.StudentasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
public class StudentFillController {
    @Autowired
    StudentasRepository studentasRepository;
    @GetMapping("/fill")
    private String fillUp(){


        Studentas studentas = new Studentas();
        studentas.setVardas("Gediminas");
        studentas.setPavarde("Jonaitis");
        studentas.setEl_pastas("g.jonaitis@gmail.com");



        Pazymys pazymys = new Pazymys();

        pazymys.setDate(java.sql.Date.valueOf("2018-08-12"));
        pazymys.setPazymys(10);

        Pazymys pazymys2 = new Pazymys();
        pazymys2.setDate(java.sql.Date.valueOf("2018-08-16"));
        pazymys2.setPazymys(9);

        Pazymys pazymys3 = new Pazymys();
        pazymys3.setDate(java.sql.Date.valueOf("2018-08-17"));
        pazymys3.setPazymys(10);

        List<Pazymys> pazymiai = new ArrayList<>();

        pazymiai.add(pazymys);
        pazymiai.add(pazymys2);
        pazymiai.add(pazymys3);

        studentas.setPazymys(pazymiai);

        studentasRepository.save(studentas);

        Studentas studentas1 = new Studentas();
        studentas1.setVardas("Jonas");
        studentas1.setPavarde("Petraitis");
        studentas1.setEl_pastas("j.petraitis@gmail.com");

        Pazymys pazymys4 = new Pazymys();
        pazymys4.setDate(java.sql.Date.valueOf("2018-08-12"));
        pazymys4.setPazymys(8);

        Pazymys pazymys5 = new Pazymys();
        pazymys5.setDate(java.sql.Date.valueOf("2018-08-16"));
        pazymys5.setPazymys(8);

        List<Pazymys> pazymiai1 = new ArrayList<>();
        pazymiai1.add(pazymys4);
        pazymiai1.add(pazymys5);

        studentas1.setPazymys(pazymiai1);

        studentasRepository.save(studentas1);

        Studentas studentas2 = new Studentas();
        studentas2.setVardas("Kazimieras");
        studentas2.setPavarde("Luksys");
        studentas2.setEl_pastas("k.luksys.com");

        Pazymys pazymys6 = new Pazymys();
        pazymys6.setDate(java.sql.Date.valueOf("2018-08-12"));
        pazymys6.setPazymys(8);

        Pazymys pazymys7 = new Pazymys();
        pazymys7.setDate(java.sql.Date.valueOf("2018-08-16"));
        pazymys7.setPazymys(9);

        List<Pazymys> pazymiai2 = new ArrayList<>();
        pazymiai2.add(pazymys6);
        pazymiai2.add(pazymys7);

        studentas2.setPazymys(pazymiai2);

        studentasRepository.save(studentas2);

        Studentas studentas3 = new Studentas();
        studentas3.setVardas("Rimas");
        studentas3.setPavarde("Motuza");
        studentas3.setEl_pastas("r.motuza.com");

        Pazymys pazymys8 = new Pazymys();
        pazymys8.setDate(java.sql.Date.valueOf("2018-08-12"));
        pazymys8.setPazymys(9);

        List<Pazymys> pazymiai3 = new ArrayList<>();
        pazymiai3.add(pazymys8);

        studentas3.setPazymys(pazymiai3);

        studentasRepository.save(studentas3);

        return "done";
    }
}
