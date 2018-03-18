package bll;

import bll.validators.*;
import dao.ClientDAO;
import model.Client;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * Created by Andrei on 18/04/2017.
 */
public class ClientBLL {
    private List<Validator<Client>> validators;

    public ClientBLL() {
        validators = new ArrayList<Validator<Client>>();
        validators.add(new EmailValidator());
        validators.add(new AgeValidator());

    }

    public Client findClientById(int id) {
        Client st = ClientDAO.findById(id);
        if (st == null) {
            throw new NoSuchElementException("Client-ul cu id-ul =" + id + " nu a fost gasit!");
        }
        return st;
    }

    public static Client findByUsername(String username)
    {
        return ClientDAO.findByUsername(username);
    }

    public int insert(Client client) {
        validators.add(new UsernameValidator());
        for (Validator<Client> v : validators) {
            v.validate(client);
        }
        return ClientDAO.insert(client);
    }

    public void update(Client client)
    {
        for(Validator<Client> t:validators)
            t.validate(client);
        ClientDAO.update(client);
    }

    public void delete(Client client)
    {
        for(Validator<Client> t:validators)
            t.validate(client);
        ClientDAO.delete(client);
    }

    public void logare(String username,String parola)
    {
        validators.add(new DejaLogatValidator());
        validators.add(new ParolaValidator());
        validators.add(new ExistaUsernameValidator());

        Client client=new Client(username,parola);

        for(Validator<Client> t:validators)
            t.validate(client);

        ClientDAO.logare(username,parola);

    }

    public void delogare()
    {
        try {
            validators.add(new DejaLogatValidator());
            Client client = new Client();
            for (Validator<Client> t : validators)
                t.validate(client);

            JOptionPane.showMessageDialog(null,"Nu exista nici un client logat");
        }catch (IllegalArgumentException e)
        {
            ClientDAO.delogare();
        }
    }

    public int findIdClientLogat()
    {
        return ClientDAO.findIdClientLogat();
    }

    public ArrayList<String[]> showAll()
    {
        return ClientDAO.showAll();
    }

}
