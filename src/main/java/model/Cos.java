package model;

/**
 * Created by Andrei on 19/04/2017.
 */
public class Cos {

    private int id;
    private int pret_total;
    private int client_id;
    private boolean comanda_finalizata;

    public Cos(int id, int client_id) {
        this.id = id;
        this.pret_total = 0;
        this.client_id = client_id;
        this.comanda_finalizata = false;
    }

    public int getId() {
        return id;
    }

    public int getPret_total() {
        return pret_total;
    }

    public int getClient_id() {
        return client_id;
    }

    public boolean isComanda_finalizata() {
        return comanda_finalizata;
    }

    public void setPret_total(int pret_total) {
        this.pret_total = pret_total;
    }

    public void setComanda_finalizata(boolean comanda_finalizata) {
        this.comanda_finalizata = comanda_finalizata;
    }
}
