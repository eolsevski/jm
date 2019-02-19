package lt.lessons.baltictalents.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.List;


@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@Table(name = "student")
public class Student extends Person {



    @OneToMany(mappedBy="student")
    @JsonBackReference("lesson")
    private List<Lesson> lessons;

}
