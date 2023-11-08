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

import api_supermarche.project.dto.CardDTO;
import api_supermarche.project.model.entity.Card;
import api_supermarche.project.service.CardService;

@RestController
@RequestMapping("/api")
public class CardController {
    
    @Autowired
    CardService service;


    @GetMapping("/cards")
    public List<CardDTO> all() {
        List<CardDTO> list = new ArrayList<CardDTO>();

        for (Card card : service.getAllCards()) {
            list.add( new CardDTO(card) );
        }
        return list;
    }


    /**
     * la partie entre {} de l'URL est une partie variable.
     * on dit que c'est un paramètre de la route.
     */
    @GetMapping("/card/{id}")
    public CardDTO livre(@PathVariable("id") int identifier) {
        return new CardDTO(service.getCard(identifier));
    }

    @PostMapping("/card")
    /**
     * L'annotation @RequestBody permet de récupérer le contenu du corps de la 
     * requête HTTP qui sera transformé en objet JAVA.
     * @param g Card
     * @return Card
     */
    public CardDTO insertCard(@RequestBody Card c) {
        // TODO : contrôler les valeurs avant la sauvegarde
        return new CardDTO(service.saveCard(c));
    }

    @DeleteMapping("/Card/{id}")
    public Boolean deleteCard(@PathVariable("id") int id) {
        /* EXO : vérifier si le jeu existe, dans ce cas,
                supprimer le jeu et renvoyer true
                sinon renvoyer false
        */
        Card l = service.getCard(id);
        if( l != null ) {
            service.deleteCard(id);
            return true;
        } else {
            return false;
        }
    }

    /**
     * Modifier un jeu qui existe en base de données.
     * @param id int : identifiant du jeu à modifier
     * @param p  Card : objet Card contenant les anciennes valeurs et 
     *                      les valeurs à modifier
     * @return
     */
    @PutMapping("/card/{id}")
    public CardDTO updateCard(@PathVariable("id") int id, @RequestBody Card c) {
      Card cardToUpdate = service.getCard(id);

      if( cardToUpdate != null ) {
        c.setId(cardToUpdate.getId());
        return new CardDTO( service.saveCard(c) );
      }
      return null;

    }

    
   
}



