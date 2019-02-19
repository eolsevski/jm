package lt.lessons.baltictalents.controller;

import lombok.val;
import lt.lessons.baltictalents.model.Teacher;
import lt.lessons.baltictalents.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;



@RestController
@RequestMapping("/api")
public class TeacherRestController {
    @Autowired
    TeacherRepository teacherRepository;

    @GetMapping("/teachers")
    public Iterable<Teacher> getTeachers() {
        val teachers = teacherRepository.findAll();
        return teachers;
    }
    @GetMapping("/teachers/{id}")
    private Optional<Teacher> oneTeacher (@PathVariable("id")Integer id){
        return teacherRepository.findById(id);
    }
}
