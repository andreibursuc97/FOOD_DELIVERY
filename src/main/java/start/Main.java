package start;

import presentation.*;

/**
 * Created by Andrei on 18/04/2017.
 */
public class Main {

    public static void main(String[] args) {
        //try{
            //ClientDAO clientDAO = new ClientDAO();
           // Client update=new Client(2,"barbuAlex","Barbu Alexandru","Cugir,Vinerea","barbualex@gmail.com",21,"omugnom2");
        //clientDAO.update(update);
        /*ClientBLL clientBLL=new ClientBLL();
       // clientBLL.logare("andreibursuc","paswd");
        //clientBLL.delogare();
        //Client client = clientBLL.findClientById(3);
        //System.out.println(client.getNume());

            Cos cos=new Cos(1,1);
            //CosDAO c=new CosDAO();
            CosBLL cosBLL=new CosBLL();
            //int index=cosBLL.insert(cos);
            //System.out.println(index);
            //cosBLL.adaugaInCos(2,3);
            cosBLL.finalizareComanda();
       Produs insert=new Produs(1,"Banane",5,10);
        ProdusBLL prod=new ProdusBLL();
        //prod.insert(insert);
            //CosBLL cosBLL=new CosBLL();
            //cosBLL.insert()*/
            //Meniu meniu=new Meniu();
            //meniu.setVisible(true);
        ListaProduse listaProduse=new ListaProduse();
        Logare logare=new Logare();
        Meniu meniu=new Meniu();
        DateClient dateClient=new DateClient();
        //CosCurent cosCurent=new CosCurent();
        ContNou contNou=new ContNou();
        ModificaProdus modificaProdus=new ModificaProdus();
        AdaugaProdus adaugaProdus=new AdaugaProdus();
        IstoricCosuri istoricCosuri=new IstoricCosuri();
        VeziClienti veziClienti=new VeziClienti();
        //listaProduse.setVisible(true);
        //dateClient.setVisible(true);
        Controller controller=new Controller(logare,meniu,dateClient,listaProduse,contNou,modificaProdus,adaugaProdus,istoricCosuri,veziClienti);



    }
}
