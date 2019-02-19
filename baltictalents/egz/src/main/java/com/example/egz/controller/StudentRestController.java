package com.example.egz.controller;

import com.example.egz.model.Pazymys;
import com.example.egz.model.Studentas;
import com.example.egz.repository.PazymiaiRepository;
import com.example.egz.repository.StudentasRepository;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RestController
public class StudentRestController {
    @Autowired
    StudentasRepository studentasRepository;
    @Autowired
    PazymiaiRepository pazymiaiRepository;
    @GetMapping("/count")
        private int countAll(){
        Iterable<Studentas> studentai = studentasRepository.findAll();
        return ((Collection<?>) studentai).size();
        }
    @GetMapping("/marks/{date}")
    private Iterable<Pazymys>  marksByDate(@PathVariable("date") String dateInString){

        List<Pazymys> pazymiai= (List<Pazymys>)pazymiaiRepository.findAll();

//        SELECT * from studentai WHERE date='2018-08-12'
//        SELECT studentai.vardas, studentai.pavarde, avg(pazymiai.pazymys) from studentai, pazymiai WHERE studentai.id=pazymiai.studentas GROUP BY studentai.id
//        SELECT studentai.vardas, studentai.pavarde, avg(pazymiai.pazymys) from studentai, pazymiai WHERE studentai.id=pazymiai.studentas GROUP BY studentai.id HAVING avg(pazymiai.pazymys)>9
//SELECT studentai.el_pastas from studentai, pazymiai WHERE studentai.id=pazymiai.studentas GROUP BY studentai.id HAVING count(pazymiai.pazymys)<=1


        return pazymiai.stream().filter(x->x.getDate().equals(java.sql.Date.valueOf(dateInString))).collect(Collectors.toList());
    }
    @GetMapping("/sortedStudents")
    private List<Studentas> sortedStudents(){
        List<Studentas> students = (List<Studentas>)studentasRepository.findAll();


        Comparator<Studentas> comparator = Comparator.comparing(person -> person.getVardas());
        comparator = comparator.thenComparing(Comparator.comparing(person -> person.getVardas()));

        students = students.stream().sorted(comparator).collect(Collectors.toList());

        return students;
    }
    @GetMapping("/marksavg/{date}")
    private OptionalDouble marksAvg(@PathVariable("date") int dateInString){

        List<Pazymys> pazymiai= (List<Pazymys>)pazymiaiRepository.findAll();

        java.sql.Date start=java.sql.Date.valueOf(""+dateInString+"-01-01");
        java.sql.Date end=java.sql.Date.valueOf(""+dateInString+"-12-31");

        return pazymiai
                .stream()
                .filter(dates -> dates.getDate().after(start) && dates.getDate().before(end))
                .mapToDouble(Pazymys::getPazymys)
                .average()

//                .collect(Collectors.toList()
                ;
    }
}
