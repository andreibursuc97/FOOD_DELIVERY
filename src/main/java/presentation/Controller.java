package presentation;

import bll.ClientBLL;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Andrei on 20/04/2017.
 */
public class Controller {

    private Logare logare;
    private Meniu meniu;

    public Controller(Logare logare,Meniu meniu)
    {
        this.logare=logare;
        logare.setVisible(true);
        logare.setLogareButton(new ButonLogareListener());
        this.meniu=meniu;
        meniu.setDelogareButton(new ButonDelogareListener());
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

    }

