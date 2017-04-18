package bll;

import bll.validators.AgeValidator;
import bll.validators.EmailValidator;
import bll.validators.Validator;
import dao.ClientDAO;
import model.Client;

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

    public int insert(Client client) {
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

}
