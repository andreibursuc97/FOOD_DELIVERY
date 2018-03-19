package bll.validators;

import model.Card;

import java.util.regex.Pattern;

public class CodCVVValidator implements Validator<Card> {

    private static final String CODCVV_VALIDATOR="[0-9]{3}";
    public void validate(Card t) {
        Pattern pattern = Pattern.compile(CODCVV_VALIDATOR);

        if (!pattern.matcher(t.getCodCVV()).matches()) {
            throw new IllegalArgumentException("Codul de securitate nu este valid!");
        }
    }
}
