package start;

import bll.ProdusBLL;
import model.Produs;

/**
 * Created by Andrei on 18/04/2017.
 */
public class Main {

    public static void main(String[] args) {
        //ClientDAO clientDAO = new ClientDAO();
        /*Client update=new Client(3,"Bursuc Andrei Ioan","Neamt, Rediu, str. Polobocului nr. 23A","bursucandrei@gmail.com",21);
        //clientDAO.update(update);
        ClientBLL clientBLL=new ClientBLL();
        clientBLL.insert(update);
        Client client = clientBLL.findClientById(4);
        System.out.println(client.getNume());*/

        Produs insert=new Produs(1,"Paine",2,3);
        ProdusBLL prod=new ProdusBLL();
        prod.insert(insert);
    }
}
