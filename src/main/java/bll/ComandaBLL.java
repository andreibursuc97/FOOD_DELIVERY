package bll;

import dao.ComandaDAO;
import dao.ProdusDAO;
import model.ComandaArticol;
import model.Produs;

import java.util.ArrayList;

/**
 * Created by Andrei on 20/04/2017.
 */
public class ComandaBLL {


    public void insert(int produsId,int cantitate,int cosId)
    {



            Produs produs=ProdusDAO.findById(produsId);
            int cantitateDisponibila=produs.getCantitate();

            if(cantitate>cantitateDisponibila)
                throw new IllegalArgumentException("Nu exista atatea produse pe stoc");
            ComandaDAO.insert(produsId,cantitate,cosId);
    }

    public ArrayList<String[]> veziComenzi()
    {
        return ComandaDAO.veziComenzi();
    }

    public ComandaArticol findById(int comandaId)
    {
        return ComandaDAO.findById(comandaId);
    }

    public void stergeComanda(int idComanda)
    {
        ComandaDAO.stergeComanda(idComanda);
    }

    public void modificaComanda(int idComanda,int cantitate)
    {
        if(cantitate<0)
            throw new IllegalArgumentException("Nu poti seta cantitatea la un numar negativ!");
        if(cantitate==0)
            throw new IllegalArgumentException("Nu poti seta cantitatea la 0, trebuie sa stergi produsul din cos!");
        ComandaDAO.modificaComanda(idComanda,cantitate);
    }


}
