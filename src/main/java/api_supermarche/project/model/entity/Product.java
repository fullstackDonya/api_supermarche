package api_supermarche.project.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = true)
    private String nom;

    @Column(nullable = true)
    private String description;

    @Column(nullable = true)
    private Integer prix;

    @Column(nullable = true)
    private Integer stock;


}
