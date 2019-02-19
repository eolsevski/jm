package lt.lessons.baltictalents.controller;


import lombok.val;
import lt.lessons.baltictalents.model.Student;
import lt.lessons.baltictalents.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class StudentRestController {
    @Autowired
    StudentRepository studentRepository;

    @GetMapping("/students")
    public Iterable<Student> getStudents() {
        val students = studentRepository.findAll();
        return students ;
    }
    @GetMapping("/students/{id}")
    private Optional<Student> oneStudent (@PathVariable("id")Integer id){
        return studentRepository.findById(id);
    }
}
