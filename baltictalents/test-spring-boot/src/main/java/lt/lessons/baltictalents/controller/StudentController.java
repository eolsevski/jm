package lt.lessons.baltictalents.controller;

import lt.lessons.baltictalents.model.Student;
import lt.lessons.baltictalents.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/")
public class StudentController {

    @Autowired
    StudentRepository studentRepository;

    @GetMapping("/uploadStudent")
    public String getStudent(Model model) {
        model.addAttribute("student", new Student());
        return "student";
    }

    @PostMapping("/uploadStudent")
    public String addStudent(
            @ModelAttribute("student") @Valid Student student,
            BindingResult result,
            Model model
    ){
        if (result.hasErrors()) {
            return "student";
        }

        studentRepository.save(student);
        return "student";

    }
}
