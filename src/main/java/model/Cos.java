package model;

import bll.ClientBLL;
import bll.ComandaBLL;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Andrei on 19/04/2017.
 */
public class Cos {

    private int id;
    private float pretTotal;
    private int clientId;
    private boolean comandaFinalizata;
    private String data;

    public Cos(int id, int client_id,String data,int pretTotal) {
        this.id = id;
        this.pretTotal = pretTotal;
        this.clientId = client_id;
        this.comandaFinalizata = false;
        this.data=data;
    }

    public Cos()
    {

    }

    public int getId() {
        return id;
    }

    public float getPretTotal() {
        return pretTotal;
    }

    public int getClientId() {
        return clientId;
    }

    public boolean isComandaFinalizata() {
        return comandaFinalizata;
    }

    public void setPretTotal(int pretTotal) {
        this.pretTotal = pretTotal;
    }

    public void setComandaFinalizata(boolean comandaFinalizata) {
        this.comandaFinalizata = comandaFinalizata;
    }

    public void creareFactura()
    {
        ClientBLL clientBLL=new ClientBLL();
        // out = null;
        try {
            PrintStream out = new PrintStream(new FileOutputStream("factura_"+this.getId()+".txt"));
            //out = new PrintWriter("factura"+this.getId()+".txt");

            Client client=clientBLL.findClientById(this.getClientId());
            out.println("--------------------------------------------------------------------------------------------------");
            out.println("Date client:");
            out.println("Nume:"+client.getNume());
            out.println("Adresa:"+client.getAdresa());
            out.println("Email:"+client.getEmail());
            out.println("--------------------------------------------------------------------------------------------------");
            out.println("Numar  |   Descriere   |   Cantitate   |   Pret bucata |");

            ComandaBLL comandaBLL=new ComandaBLL();
            ArrayList<String[]> produse=comandaBLL.veziComenzi();
            out.println("--------------------------------------------------------------------------------------------------");
            int i=1;
            for(String[] produs:produse)
            {
                String filled = this.getStringWithLengthAndFilledWithCharacter(18-produs[1].length(),' ');

                out.println("   "+i+".       "+produs[1]+filled+produs[2]+"                 "+produs[3]+"           ");
                i++;
            }

            out.println("--------------------------------------------------------------------------------------------------");

            out.println("Total de plata:"+this.getPretTotal()+" lei");

            out.println("--------------------------------------------------------------------------------------------------");


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }








    }
    protected String getStringWithLengthAndFilledWithCharacter(int length, char charToFill) {
        if (length > 0) {
            char[] array = new char[length];
            Arrays.fill(array, charToFill);
            return new String(array);
        }
        return "";
    }
}
