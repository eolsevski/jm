package lt.lessons.baltictalents.controller;


import lombok.val;
import lt.lessons.baltictalents.model.Lesson;
import lt.lessons.baltictalents.repository.LessonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
@RestController
@RequestMapping("/api")
public class LessonRestController {
    @Autowired
    LessonRepository lessonRepository;


    @GetMapping("/lessons/type")
    public List<Lesson> getLessonsType() {
        val lessons =  (List<Lesson>) lessonRepository.findAll();
        lessons.sort(Comparator.comparing(Lesson::getType).reversed());
        return lessons;
    }
    @GetMapping("/lessons")
    public List<Lesson> getLessons() {
        val lessons =  (List<Lesson>) lessonRepository.findAll();
        return lessons;
    }
    @GetMapping("/lessons/{type}")
    public List<Lesson> getLessonsBt(@PathVariable("type")String type) {
        val lessons =   lessonRepository.findByType(type);
        return lessons;
    }
}