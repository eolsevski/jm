package lt.lessons.baltictalents.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@Table(name = "teacher")
public class Teacher extends  Person{

    private String title;
    @OneToMany(mappedBy="teacher")
    @JsonBackReference
    private List<Lesson> lessons;


}
