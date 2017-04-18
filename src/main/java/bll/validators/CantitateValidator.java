package bll.validators;

import model.Produs;

/**
 * Created by Andrei on 18/04/2017.
 */
public class CantitateValidator implements Validator<Produs> {

    private static final int MIN_CANTITATE = 0;


    public void validate(Produs t) {

        if (t.getCantitate() < MIN_CANTITATE ){
            throw new IllegalArgumentException("Cantitatea introdusa nu se incadreaza in limite!");
        }

    }

        }

