package model;

/**
 * Created by Andrei on 18/04/2017.
 */
public class Client {
    private int id;
    private String nume;
    private String adresa;
    private String email;
    private int varsta;




    public Client()
    {}


    public Client(String nume, String adresa, String email, int varsta) {
        this.nume = nume;
        this.adresa = adresa;
        this.email = email;
        this.varsta = varsta;
    }

    public Client(int id, String nume, String adresa, String email, int varsta) {
        this.id = id;
        this.nume = nume;
        this.adresa = adresa;
        this.email = email;
        this.varsta = varsta;
    }

    public void setId(int id)
    {
        this.id=id;
    }
    public int getId() {
        return id;
    }

    public String getNume() {
        return nume;
    }

    public String getAdresa() {
        return adresa;
    }

    public String getEmail() {
        return email;
    }

    public int getVarsta() {
        return varsta;
    }

}
