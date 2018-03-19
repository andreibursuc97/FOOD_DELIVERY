package bll.validators;

import model.Card;

import java.util.regex.Pattern;

public class NumarCardValidator implements Validator<Card> {

    private static final String NUMAR_CARD_VALIDATOR="^(?:4[0-9]{12}(?:[0-9]{3})?|5[1-5][0-9]{14})$";
    public void validate(Card t) {
        Pattern pattern = Pattern.compile(NUMAR_CARD_VALIDATOR);
        String card=t.getNumarCard();
        card=card.replaceAll("-","");
        card=card.replaceAll(" ","");
        if (!pattern.matcher(card).matches()) {
            throw new IllegalArgumentException("Numarul cardului nu este Valid!");
        }
    }
}
