package bll.validators;

import model.Produs;

/**
 * Created by Andrei on 19/04/2017.
 */
public class PretValidator implements Validator<Produs> {

    private static final int MIN_PRET = 0;


    public void validate(Produs t) {

        if (t.getCantitate() < MIN_PRET ){
            throw new IllegalArgumentException("Cantitatea introdusa nu se incadreaza in limite!");
        }

    }
}
