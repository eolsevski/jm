package lt.lessons.baltictalents.repository;

import lt.lessons.baltictalents.model.Lesson;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LessonRepository extends CrudRepository<Lesson, Integer> {
    List<Lesson> findByType(String type);
    List<Lesson> findByCourse(Integer course);
}
