package model;

public class Admin {

    private int id;
    private String username;
    private String parola;
    private boolean logat;

    public Admin(int id, String username, String parola, boolean logat) {
        this.id = id;
        this.username = username;
        this.parola = parola;
        this.logat = logat;
    }

    public Admin(String username, String parola) {
        this.username = username;
        this.parola = parola;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getParola() {
        return parola;
    }

    public void setParola(String parola) {
        this.parola = parola;
    }

    public boolean isLogat() {
        return logat;
    }

    public void setLogat(boolean logat) {
        this.logat = logat;
    }

}
