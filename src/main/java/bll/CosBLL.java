package bll;

import bll.validators.ClientLogatValidator;
import bll.validators.Validator;
import dao.CosDAO;
import model.Cos;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Andrei on 20/04/2017.
 * CosBLL
 */
public class CosBLL {

    private List<Validator<Cos>> validators;

    public CosBLL() {
        validators = new ArrayList<Validator<Cos>>();
        validators.add(new ClientLogatValidator());
    }

    public int insert(Cos cos)
    {
        for (Validator<Cos> v : validators) {
            v.validate(cos);
        }

        return CosDAO.insert(cos);
    }

    public void adaugaInCos(int produsId,int cantitate)
    {
        CosDAO.adaugaInCos(produsId,cantitate);
    }

    public void finalizareComanda()
    {
        CosDAO.finalizareComanda();
    }

}
