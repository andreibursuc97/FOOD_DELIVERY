package bll;


import bll.validators.AdminDejaLogatValidator;
import bll.validators.ExistaUsernameAdminValidator;
import bll.validators.ParolaAdminValidator;
import bll.validators.Validator;
import dao.AdminDAO;
import model.Admin;

import java.util.ArrayList;
import java.util.List;

public class AdminBLL {

    private List<Validator<Admin>> validators;

    public AdminBLL() {
        validators = new ArrayList<Validator<Admin>>();
        validators.add(new AdminDejaLogatValidator());
        validators.add(new ExistaUsernameAdminValidator());
        validators.add(new ParolaAdminValidator());

    }

    public void logare(String username,String parola)
    {
        Admin admin=new Admin(username,parola);
        for(Validator<Admin> t : validators)
            t.validate(admin);
        AdminDAO.logare(username,parola);
    }

    public void delogare()
    {
        AdminDAO.delogare();
    }


}
