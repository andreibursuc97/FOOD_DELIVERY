package model;

/**
 * Created by Andrei on 18/04/2017.
 */
public class Client {
    private int id;

    public String getUsername() {
        return username;
    }

    private String username;
    private String nume;
    private String adresa;
    private String email;
    private int varsta;
    private String parola;
    private boolean logat;
    private boolean loial;



    public Client()
    {
        //this.username="username";
        //this.parola="parola;
        this.email="username@mail.com";
        this.varsta=18;
    }


    public Client(String username,String nume, String adresa, String email, int varsta,String parola) {
        this.username=username;
        this.nume = nume;
        this.adresa = adresa;
        this.email = email;
        this.varsta = varsta;
        this.parola=parola;
        this.logat=false;
        this.loial=false;
    }

    public Client(int id,String username,String nume, String adresa, String email, int varsta) {
        this.id=id;
        this.username=username;
        this.nume = nume;
        this.adresa = adresa;
        this.email = email;
        this.varsta = varsta;
        this.logat=false;
        this.loial=false;
    }

    public Client(int id,String username, String nume, String adresa, String email, int varsta,String parola) {
        this.id = id;
        this.username=username;
        this.nume = nume;
        this.adresa = adresa;
        this.email = email;
        this.varsta = varsta;
        this.parola=parola;
        this.logat=false;
        this.loial=false;
    }

    public Client(String username,String parola)
    {
        this.username=username;
        this.parola=parola;
        this.email="username@mail.com";
        this.varsta=18;
    }

    public Client(int id,String username, String nume, String adresa, String email, int varsta, boolean loial) {
        this.id=id;
        this.username = username;
        this.nume = nume;
        this.adresa = adresa;
        this.email = email;
        this.varsta = varsta;
        this.parola = parola;
        this.loial = loial;
    }

    public void setId(int id)
    {
        this.id=id;
    }

    public boolean isLoial() {
        return loial;
    }

    public void setLoial(boolean loial) {
        this.loial = loial;
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
