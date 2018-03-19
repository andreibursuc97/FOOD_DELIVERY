package bll.validators;

import model.Card;

import java.util.regex.Pattern;

public class NumeCardValidator implements Validator<Card>{

    private static final String NUME_CARD_VALIDATOR="^[\\p{L} .'-]+$";

    public void validate(Card t) {
        Pattern pattern = Pattern.compile(NUME_CARD_VALIDATOR);
        if (!pattern.matcher(t.getNume()).matches()) {
            throw new IllegalArgumentException("Numele de pe card nu este valid!");
        }
    }
}
