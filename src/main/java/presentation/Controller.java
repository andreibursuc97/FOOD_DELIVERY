package presentation;

import bll.ClientBLL;
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

    public Controller(Logare logare,Meniu meniu,DateClient dateClient,ListaProduse listaProduse)
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

    }

