package api_supermarche.project.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import api_supermarche.project.dto.ProductDTO;
import api_supermarche.project.model.entity.Product;
import api_supermarche.project.service.ProductService;

@RestController
@RequestMapping("/api")
public class ProductController {
   @Autowired
    ProductService service;


    @GetMapping("/products")
    public List<ProductDTO> all() {
        List<ProductDTO> list = new ArrayList<ProductDTO>();

        for (Product product : service.getAllProducts()) {
            list.add( new ProductDTO(product) );
        }
        return list;
    }


    /**
     * la partie entre {} de l'URL est une partie variable.
     * on dit que c'est un paramètre de la route.
     */
    @GetMapping("/product/{id}")
    public ProductDTO livre(@PathVariable("id") int identifier) {
        return new ProductDTO(service.getProduct(identifier));
    }

    @PostMapping("/product")
    /**
     * L'annotation @RequestBody permet de récupérer le contenu du corps de la 
     * requête HTTP qui sera transformé en objet JAVA.
     * @param g Product
     * @return Product
     */
    public ProductDTO insertProduct(@RequestBody Product p) {
        // TODO : contrôler les valeurs avant la sauvegarde
        return new ProductDTO(service.saveProduct(p));
    }

    @DeleteMapping("/product/{id}")
    public Boolean deleteProduct(@PathVariable("id") int id) {
        /* EXO : vérifier si le jeu existe, dans ce cas,
                supprimer le jeu et renvoyer true
                sinon renvoyer false
        */
        Product l = service.getProduct(id);
        if( l != null ) {
            service.deleteProduct(id);
            return true;
        } else {
            return false;
        }
    }

    /**
     * Modifier un jeu qui existe en base de données.
     * @param id int : identifiant du jeu à modifier
     * @param p  Product : objet Product contenant les anciennes valeurs et 
     *                      les valeurs à modifier
     * @return
     */
    @PutMapping("/product/{id}")
    public ProductDTO updateProduct(@PathVariable("id") int id, @RequestBody Product p) {
      Product productToUpdate = service.getProduct(id);

      if( productToUpdate != null ) {
        p.setId(productToUpdate.getId());
        return new ProductDTO( service.saveProduct(p) );
      }
      return null;

    }

    
   
}



