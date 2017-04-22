package presentation;

import bll.ClientBLL;
import bll.CosBLL;
import model.Client;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Andrei on 20/04/2017.
 */
public class Controller {

    private Logare logare;
    private Meniu meniu;
    private DateClient dateClient;
    private ListaProduse listaProduse;
    private CosCurent cosCurent;
    private ContNou contNou;

    public Controller(Logare logare,Meniu meniu,DateClient dateClient,ListaProduse listaProduse,ContNou contNou)
    {
        this.logare=logare;
        logare.setVisible(true);
        logare.setLogareButton(new ButonLogareListener());
        this.meniu=meniu;
        meniu.setDelogareButton(new ButonDelogareListener());
        this.dateClient=dateClient;
        meniu.setDateleTaleButton(new ButonVeziDate());
        this.listaProduse=listaProduse;
        meniu.setListaProduseButton(new ButonVeziProduseListener());
        //this.cosCurent=cosCurent;
        meniu.setCosCurentButton(new ButonVeziCosCurent());
        listaProduse.setAdaugaInCosButton(new ButonAdaugaInCos());

        this.contNou=contNou;
        logare.setContNouButton(new ButonContNou());

    }

    public class ButonVeziDate implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            try{
            ClientBLL clientBLL=new ClientBLL();
            int id=clientBLL.findIdClientLogat();
            Client client=clientBLL.findClientById(id);
            dateClient.getIdField().setText(Integer.toString(client.getId()));
            dateClient.getUsernameField().setText(client.getUsername());
            dateClient.getNumeField().setText(client.getNume());
            dateClient.getAdresaField().setText(client.getAdresa());
            dateClient.getEmailField().setText(client.getEmail());
            dateClient.getVarstaField().setText(Integer.toString(client.getVarsta()));
            dateClient.getParolaField().setText(client.getParola());
            dateClient.setVisible(true);
        } catch (IllegalArgumentException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        }
    }



    public class ButonLogareListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            String username = logare.getUsernameField().getText();
            String parola = logare.getParolaField().getText();
            try {
                ClientBLL clientBLL = new ClientBLL();
                clientBLL.logare(username, parola);
                //Meniu meniu = new Meniu();
                meniu.setVisible(true);
                logare.setVisible(false);
                cosCurent=new CosCurent();
            } catch (IllegalArgumentException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());
            }
        }
    }

    public class ButonDelogareListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {

            try {
                ClientBLL clientBLL = new ClientBLL();
                clientBLL.delogare();

                meniu.setVisible(false);
                logare.setVisible(true);
            } catch (IllegalArgumentException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());
            }
        }
    }

    public class ButonVeziProduseListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {

            try {
               //ProdusBLL produsBLL = new ProdusBLL();

                //meniu.setVisible(false);
                listaProduse.setVisible(true);
            } catch (IllegalArgumentException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());
            }
        }
    }

    public class ButonVeziCosCurent implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {

            cosCurent.setVisible(true);

        }
    }

    public class ButonContNou implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {

            contNou.setVisible(true);

        }
    }

    public class ButonAdaugaInCos implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            try {
                int id = Integer.parseInt(listaProduse.getIdField().getText());
                int cantitate = Integer.parseInt(listaProduse.getCantitateField().getText());

                CosBLL cosBLL = new CosBLL();
                cosBLL.adaugaInCos(id, cantitate);

                //ListaProduse.this.setVisible(false);
                listaProduse.modelUpdate();
                listaProduse.getTable1().setModel(listaProduse.getModel());
                //ScrollPane.add(table1);
                //cosCurent=new CosCurent();
                cosCurent.modelUpdate();
                cosCurent.setVisible(true);
                //ListaProduse.this.setVisible(true);
                JOptionPane.showMessageDialog(null, "Comanda a fost adaugata in cos!");

            } catch (IllegalArgumentException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());
            }


        }

    }

    }

