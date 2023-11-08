package api_supermarche.project.dto;

import api_supermarche.project.model.entity.Product;
import lombok.Data;

@Data
public class ProductDTO {

    private Integer id;
    private String nom;
    private String description;
    private Integer prix;
    private Integer stock;

    public ProductDTO(Product p){
        this.id = p.getId();
        this.nom = p.getNom();
        this.description = p.getDescription();
        this.prix = p.getPrix();
        this.stock = p.getStock();

    }
    
    
}
