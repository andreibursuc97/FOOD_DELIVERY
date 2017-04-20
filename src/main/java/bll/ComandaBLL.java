package bll;

import dao.ComandaDAO;
import dao.ProdusDAO;
import model.Produs;

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
}
