package lt.lessons.baltictalents.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@Table(name = "lesson")
public class Lesson extends BaseEntity {
    private String type;
    private String description;
    private Byte course;


    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="student_id")
    @JsonManagedReference
    private Student student;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="teacher_id")
    @JsonManagedReference
    private Teacher teacher;

}
