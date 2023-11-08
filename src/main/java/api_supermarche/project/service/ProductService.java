package api_supermarche.project.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import api_supermarche.project.model.entity.Product;
import api_supermarche.project.repository.ProductRepository;



@Service
public class ProductService {
    @Autowired
     private ProductRepository productRepository;

     public List<Product> getAllProducts() {
        return (List<Product>) productRepository.findAll();
    }

    /**
     * Récupérer un joueur à partir de son identifiant
     */
    public Product getProduct(int id) {
        Optional<Product> optional = productRepository.findById(id);
        return optional.isPresent() ? optional.get() : null;
    }

    /**
     * La méthode saveProduct sera utilisée pour les inserts et les updates.
     * @param g Product
     * @return Product : retourne le joueur inséré ou actualisé
     */
    public Product saveProduct(Product p) {
        return productRepository.save(p);
    }

    /**
     * Supprime un joueur selon son id
     */
    public void deleteProduct(int id) {
        productRepository.deleteById(id);
    }

    public Optional<Product> getProductById(Integer id) {
        return null;
    }
}
