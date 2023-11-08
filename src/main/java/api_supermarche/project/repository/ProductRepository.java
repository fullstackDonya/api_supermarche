package api_supermarche.project.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import api_supermarche.project.model.entity.Product;

@Repository
public interface ProductRepository extends CrudRepository<Product, Integer> {
    
}
