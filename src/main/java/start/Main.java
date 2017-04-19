package start;

import dao.CosDAO;
import model.Cos;

/**
 * Created by Andrei on 18/04/2017.
 */
public class Main {

    public static void main(String[] args) {
        //ClientDAO clientDAO = new ClientDAO();
        /*Client update=new Client(2,"Barbu Alexandru","Cugir,Vinerea","barbualex@gmail.com",21,"omugnom2");
        //clientDAO.update(update);
        ClientBLL clientBLL=new ClientBLL();
        clientBLL.insert(update);
        Client client = clientBLL.findClientById(2);
        System.out.println(client.getNume());*/

        Cos cos=new Cos(2,1);
        CosDAO c=new CosDAO();
        c.insert(cos);

       /* Produs insert=new Produs(1,"Paine",2,3);
        ProdusBLL prod=new ProdusBLL();
        prod.insert(insert);*/
    }
}
