package bll;

import bll.validators.ClientLogatValidator;
import bll.validators.CosNefinalizatValidator;
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
        validators.add(new CosNefinalizatValidator());
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
        if(cantitate<0) throw new IllegalArgumentException("Cantitatea introdusa nu se incadreaza in limite!");
        CosDAO.adaugaInCos(produsId,cantitate);
    }

    public int veziPret()
    {
        return CosDAO.pretCos();
    }

    public void finalizareComanda()
    {
        CosDAO.finalizareComanda();
    }

    public ArrayList<String[]> veziCosuri()
    {
        return CosDAO.veziCosuri();
    }

}
