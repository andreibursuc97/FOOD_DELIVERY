package bll.validators;
import model.Client;

/**
 * Created by Andrei on 18/04/2017.
 */
public class AgeValidator implements Validator<Client> {
    private static final int MIN_AGE = 18;
    private static final int MAX_AGE = 100;

    public void validate(Client t) {

        if (t.getVarsta() < MIN_AGE || t.getVarsta() > MAX_AGE) {
            throw new IllegalArgumentException("Varsta introdusa nu se incadreaza in limite!");
        }

    }

}
