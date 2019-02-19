package com.example.api.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;


import javax.persistence.*;
import java.util.List;


//@EqualsAndHashCode(callSuper = false)
//@AllArgsConstructor
@Entity
@Table(name = "products")

@AllArgsConstructor
@NoArgsConstructor
public class Product extends BaseEntity {
    @Getter
    @Setter
    private String description;
    @Getter
    @Setter
//    @JsonProperty("doubleprice")//keicia lauko pavadinima isvedamama jsone
    private Float price;
    @OneToMany(
            cascade=CascadeType.ALL,
            fetch=FetchType.LAZY
    )
    @JoinColumn(name="product_id")
    @Getter
    @Setter
    private List<Image> images;

}
