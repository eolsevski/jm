package com.example.api.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;


@AllArgsConstructor
@NoArgsConstructor
//@EqualsAndHashCode(callSuper = false)
//@AllArgsConstructor
@Entity
@Table(name = "images")
public class Image extends BaseEntity {
@Getter
@Setter
    private String url;
    @ManyToOne(
            fetch=FetchType.LAZY
    )
    private Product product;

}
