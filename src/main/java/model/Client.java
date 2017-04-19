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
    private String parola;
    private boolean logat;



    public Client()
    {}


    public Client(String nume, String adresa, String email, int varsta,String parola) {
        this.nume = nume;
        this.adresa = adresa;
        this.email = email;
        this.varsta = varsta;
        this.parola=parola;
        this.logat=false;
    }

    public Client(int id, String nume, String adresa, String email, int varsta,String parola) {
        this.id = id;
        this.nume = nume;
        this.adresa = adresa;
        this.email = email;
        this.varsta = varsta;
        this.parola=parola;
        this.logat=false;
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

    public String getParola() {
        return parola;
    }

    public boolean isLogat() {
        return logat;
    }

    public void setLogat(boolean logat) {
        this.logat = logat;
    }
}
