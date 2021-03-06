package bll;

import bll.validators.ClientLogatValidator;
import bll.validators.CosNefinalizatValidator;
import bll.validators.ExistaCosCreat;
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

    public Cos findById(int cosId)
    {
        return CosDAO.findById(cosId);
    }

    public void adaugaInCos(int produsId,int cantitate)
    {
        if(cantitate<0) throw new IllegalArgumentException("Cantitatea introdusa nu se incadreaza in limite!");
        CosDAO.adaugaInCos(produsId,cantitate);
    }

    public void setPretCos(int idCos,float pret)
    {


        CosDAO.setPretCos(idCos,pret);
    }

    public int veziPret()
    {
        return CosDAO.pretCos();
    }

    public void finalizareComanda(Boolean card,float pret_final)
    {
        Validator<Cos> v=new ExistaCosCreat();
        v.validate(new Cos());
        CosDAO.finalizareComanda(card,pret_final);
    }

    public ArrayList<String[]> veziCosuri()
    {
        return CosDAO.veziCosuri();
    }

    public static ArrayList<String[]> adminVeziCosuri(int id)
    {
        return  CosDAO.adminVeziCosuri(id);
    }

}
