package lt.lessons.baltictalents.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NonNull;

import javax.persistence.Entity;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotBlank;

@EqualsAndHashCode(callSuper = true)
@Data
@MappedSuperclass
public class Person extends BaseEntity {
    @NotBlank
    private String name;
    @NotBlank(message = "butinas parametras")
    private String surname;
}
