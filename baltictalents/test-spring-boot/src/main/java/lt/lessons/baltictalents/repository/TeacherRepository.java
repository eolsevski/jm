package lt.lessons.baltictalents.repository;

import lt.lessons.baltictalents.model.Teacher;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

//@Repository
public interface TeacherRepository extends CrudRepository<Teacher, Integer> {
}
