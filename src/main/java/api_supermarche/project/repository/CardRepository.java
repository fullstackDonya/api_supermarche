package api_supermarche.project.repository;

import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;

import api_supermarche.project.model.entity.Card;

@Repository
public interface CardRepository extends CrudRepository<Card, Integer>{
    
}
