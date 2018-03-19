package bll.validators;

import model.Card;

import java.util.regex.Pattern;

public class DataExpirareValidator implements Validator<Card>{

    private static final String DATA_EXPIRARE_VALIDATOR="(?:0[1-9]|1[0-2])/[0-9]{2}";
    public void validate(Card t) {
        Pattern pattern = Pattern.compile(DATA_EXPIRARE_VALIDATOR);

        if (!pattern.matcher(t.getDataExpirare()).matches()) {
            throw new IllegalArgumentException("Data de expirare nu este valida!");
        }
    }
}
