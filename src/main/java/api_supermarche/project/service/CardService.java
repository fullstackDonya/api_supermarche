package api_supermarche.project.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import api_supermarche.project.model.entity.Card;
import api_supermarche.project.repository.CardRepository;

@Service
public class CardService {
    
    @Autowired
     private CardRepository cardRepository;

     public List<Card> getAllCards() {
        return (List<Card>) cardRepository.findAll();
    }

    /**
     * Récupérer un joueur à partir de son identifiant
     */
    public Card getCard(int id) {
        Optional<Card> optional = cardRepository.findById(id);
        return optional.isPresent() ? optional.get() : null;
    }

    /**
     * La méthode saveCard sera utilisée pour les inserts et les updates.
     * @param g Card
     * @return Card : retourne le joueur inséré ou actualisé
     */
    public Card saveCard(Card g) {
        return cardRepository.save(g);
    }

    /**
     * Supprime un joueur selon son id
     */
    public void deleteCard(int id) {
        cardRepository.deleteById(id);
    }

    public Optional<Card> getCardById(Integer id) {
        return null;
    }

}

    

