package lt.baltictalents.exam;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="gyventojai")
@ToString
public class Gyventojas {
    @Getter
    @Setter
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Id
    private Long id;

    @Getter
    @Setter
    private String vardas;
    @Getter
    @Setter
    private String pavarde;
    @Getter
    @Setter
    java.sql.Date gimimo_metai;
    @Getter
    @Setter
    private String gatve;
    @Getter
    @Setter
    Tautybe tautybe;

    @Transient
    public boolean isNew() {
        return this.id == null;
    }


    public enum Tautybe {
        Lietuvis, Lenkas, Rusas
    }
}