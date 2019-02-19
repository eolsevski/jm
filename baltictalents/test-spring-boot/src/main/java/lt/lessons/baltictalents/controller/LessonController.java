package lt.lessons.baltictalents.controller;

import lt.lessons.baltictalents.model.Lesson;
import lt.lessons.baltictalents.model.Student;
import lt.lessons.baltictalents.model.Teacher;
import lt.lessons.baltictalents.repository.LessonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Controller
@RequestMapping("/")
public class LessonController {
@Autowired
    LessonRepository lessonRepository;

    @GetMapping("/uploadLessons")
    public String uploadLesson(){
        return "uploadLessons";
    }

    @PostMapping("/uploadLessons")
    public String uploadProducts(
            @RequestParam(value = "type", required = false) String type,
            @RequestParam(value = "description", required = false) String description,
            @RequestParam(value = "course", required = false) Byte course,
            @RequestParam(value = "sname", required = false) String sname,
            @RequestParam(value = "ssurname", required = false) String ssurname,
            @RequestParam(value = "tname", required = false) String tname,
            @RequestParam(value = "tsurname", required = false) String tsurname,
            @RequestParam(value = "ttitle", required = false) String ttitle,
            Model model){

        Lesson lesson = new Lesson();
        lesson.setType(type);
        lesson.setDescription(description);
        lesson.setCourse(course);

        Student student = new Student();
        student.setName(sname);
        student.setSurname(ssurname);

        lesson.setStudent(student);

        Teacher teacher = new Teacher();
        teacher.setName(tname);
        teacher.setSurname(tsurname);
        teacher.setTitle(ttitle);

        lesson.setTeacher(teacher);

        lessonRepository.save(lesson);

        return "uploadLessons";
    }
}
