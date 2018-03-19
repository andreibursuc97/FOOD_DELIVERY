package bll;

import bll.validators.*;
import dao.CardDAO;
import model.Card;

import java.util.ArrayList;
import java.util.List;

public class CardBLL {

    private List<Validator<Card>> validators;

    public CardBLL() {
        validators = new ArrayList<Validator<Card>>();
        validators.add(new NumeCardValidator());
        validators.add(new NumarCardValidator());
        validators.add(new DataExpirareValidator());
        validators.add(new CodCVVValidator());
    }

    public Boolean check(Card card)
    {
        for(Validator<Card> v:validators)
        {
            v.validate(card);
        }

        return CardDAO.isTrue();
    }
}
