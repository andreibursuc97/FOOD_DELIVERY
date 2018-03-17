package presentation;

import bll.ClientBLL;
import bll.ComandaBLL;
import bll.CosBLL;
import bll.ProdusBLL;
import model.Client;
import model.Produs;

import javax.swing.*;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
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
    private ModificaProdus modificaProdus;
    private AdaugaProdus adaugaProdus;
    private IstoricCosuri istoricCosuri;
    private VeziClienti veziClienti;

    public Controller(Logare logare,Meniu meniu,DateClient dateClient,CosCurent cosCurent,ListaProduse listaProduse,ContNou contNou,ModificaProdus modificaProdus,AdaugaProdus adaugaProdus,IstoricCosuri istoricCosuri,VeziClienti veziClienti)
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

        meniu.setCosCurentButton(new ButonVeziCosCurent());
        this.cosCurent=cosCurent;
        this.cosCurent.setFinalizareButton(new FinalizareComanda());
        this.cosCurent.setStergeProdusDinCosButton(new StergeComanda());
        this.cosCurent.setModificaCantitateButton(new ModificaComanda());
        listaProduse.setAdaugaInCosButton(new ButonAdaugaInCos());

        this.contNou=contNou;
        logare.setContNouButton(new ButonContNou());
        this.modificaProdus=modificaProdus;
        //listaProduse.setModificaButton(new ButonActualizareProdus());
        modificaProdus.setActualizareDateButton(new ButonActualizareDateProdus());
        this.adaugaProdus=adaugaProdus;
        //listaProduse.setAdaugaButton(new ButonVeziAdaugaProdus());
        adaugaProdus.setAdaugaProdusButton(new ButonAdaugaProdus());
        this.istoricCosuri=istoricCosuri;
        meniu.setIstoricCosuriButton(new ButonIstoricCosuri());
        this.veziClienti=veziClienti;
        logare.setVeziButon(new ButonVeziClienti());
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

    public class TableListener implements TableModelListener {

        public void tableChanged(TableModelEvent e) {
            // your code goes here, whatever you want to do when something changes in the table
        }
    }

    public class FinalizareComanda implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            try {


                CosBLL cosBLL = new CosBLL();
                cosBLL.finalizareComanda();

                //ListaProduse.this.setVisible(false);
                cosCurent.modelUpdate();
                cosCurent.getTable1().setModel(cosCurent.getModel());
                //ScrollPane.add(table1);
                //ListaProduse.this.setVisible(true);
                JOptionPane.showMessageDialog(null, "Comanda a fost finalizata!");

            } catch (IllegalArgumentException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());
            }


        }

    }

    public class StergeComanda implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            try {

                ComandaBLL comandaBLL = new ComandaBLL();
                comandaBLL.stergeComanda(Integer.parseInt(cosCurent.getIdField().getText()));
                //ListaProduse.this.setVisible(false);
                cosCurent.getIdField().setText("");
                cosCurent.modelUpdate();
                cosCurent.getTable1().setModel(cosCurent.getModel());
                listaProduse.modelUpdate();
                listaProduse.getTable1().setModel(listaProduse.getModel());
                //ScrollPane.add(table1);
                //ListaProduse.this.setVisible(true);
                JOptionPane.showMessageDialog(null, "Comanda a fost finalizata!");

            } catch (IllegalArgumentException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());
            }


        }

    }

    public class ModificaComanda implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            try {

                ComandaBLL comandaBLL = new ComandaBLL();
                comandaBLL.modificaComanda(Integer.parseInt(cosCurent.getIdField().getText()),Integer.parseInt(cosCurent.getCantitateField().getText()));
                //ListaProduse.this.setVisible(false);
                cosCurent.modelUpdate();
                cosCurent.getTable1().setModel(cosCurent.getModel());
                listaProduse.modelUpdate();
                listaProduse.getTable1().setModel(listaProduse.getModel());
                //ScrollPane.add(table1);
                //ListaProduse.this.setVisible(true);
                JOptionPane.showMessageDialog(null, "Comanda a fost finalizata!");

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

    public class ButonVeziCosCurent implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {

            cosCurent.modelUpdate();
            cosCurent.getTable1().setModel(cosCurent.getModel());
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

    public class ButonActualizareProdus implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            try {
                int id = Integer.parseInt(listaProduse.getIdField().getText());
                ProdusBLL produsBLL=new ProdusBLL();
                Produs produs=produsBLL.findProdusById(id);
                modificaProdus.getIdField().setText(Integer.toString(produs.getId()));
                modificaProdus.getDescriereField().setText(produs.getDescriere());
                modificaProdus.getCantitateField().setText(Integer.toString(produs.getCantitate()));
                modificaProdus.getPretField().setText(Float.toString(produs.getPret()));

                modificaProdus.setVisible(true);
               // JOptionPane.showMessageDialog(null, "Datele tale au fost actualizate cu succes!");

            } catch (IllegalArgumentException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());
            }


        }

    }

    public class ButonVeziAdaugaProdus implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {

            adaugaProdus.setVisible(true);

        }
    }

    public class ButonVeziClienti implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {

            veziClienti.modelUpdate();
            veziClienti.setVisible(true);

        }
    }

    public class ButonIstoricCosuri implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {

            istoricCosuri.modelUpdate();
            istoricCosuri.setVisible(true);

        }
    }

    public class ButonActualizareDateProdus implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            try {
                int id = Integer.parseInt(modificaProdus.getIdField().getText());
                String descriere = modificaProdus.getDescriereField().getText();
                int cantitate = Integer.parseInt(modificaProdus.getCantitateField().getText());
                float pret = Float.parseFloat(modificaProdus.getPretField().getText());
                Produs produs = new Produs(id, descriere, pret, cantitate);
                ProdusBLL produsBLL = new ProdusBLL();

                produsBLL.update(produs);
                listaProduse.modelUpdate();
                //JOptionPane.showMessageDialog(null, "Datele tale au fost actualizate cu succes!");

            } catch (IllegalArgumentException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());
            }


        }

    }



    public class ButonAdaugaProdus implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            try {

                String descriere = adaugaProdus.getDescriereField().getText();
                int cantitate = Integer.parseInt(adaugaProdus.getCantitateField().getText());
                float pret = Float.parseFloat(adaugaProdus.getPretField().getText());
                Produs produs = new Produs( descriere, pret, cantitate);
                ProdusBLL produsBLL = new ProdusBLL();

                produsBLL.insert(produs);
                listaProduse.modelUpdate();
                //JOptionPane.showMessageDialog(null, "Datele tale au fost actualizate cu succes!");

            } catch (IllegalArgumentException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());
            }


        }

    }



    }

