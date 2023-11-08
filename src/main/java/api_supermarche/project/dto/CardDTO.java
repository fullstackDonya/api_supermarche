package api_supermarche.project.dto;

import java.sql.Date;

import api_supermarche.project.model.entity.Card;
import lombok.Data;

@Data
public class CardDTO {
    private Integer id;
    private String clientNom;;
    private Date dateCreation;

    public CardDTO(Card c) {
        this.id =  c.getId();
        this.clientNom = c.getClientNom();
        this.dateCreation = c.getDateCreation();
    }

}
