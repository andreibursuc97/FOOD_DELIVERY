package bll;

import bll.validators.CantitateValidator;
import bll.validators.PretValidator;
import bll.validators.Validator;
import dao.ProdusDAO;
import model.Produs;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * Created by Andrei on 18/04/2017.
 */
public class ProdusBLL {
    private List<Validator<Produs>> validators;

    public ProdusBLL() {
        validators = new ArrayList<Validator<Produs>>();
        validators.add(new CantitateValidator());
        validators.add(new PretValidator());
    }

    public Produs findProdusById(int id) {
        Produs st = ProdusDAO.findById(id);
        if (st == null) {
            throw new NoSuchElementException("Produs-ul cu id-ul =" + id + " nu a fost gasit!");
        }
        return st;
    }

    public int insert(Produs produs) {
        for (Validator<Produs> v : validators) {
            v.validate(produs);
        }
        return ProdusDAO.insert(produs);
    }

    public void update(Produs produs)
    {
        for (Validator<Produs> v : validators) {
            v.validate(produs);
        }
        ProdusDAO.update(produs);
    }

    public void delete(Produs produs)
    {
        for (Validator<Produs> v : validators) {
            v.validate(produs);
        }
        ProdusDAO.deleteProdus(produs);
    }

    public ArrayList<String[]> afiseazaProduse()
    {
        return ProdusDAO.afiseazaProduse();
    }

}

