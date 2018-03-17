package model;

/**
 * Created by Andrei on 19/04/2017.
 */
public class ComandaArticol {

    private int id;
    private int cos_id;
    private int produs_id;
    private int cantitate;
    private float pret_bucata;

    public ComandaArticol(int id, int cos_id, int produs_id, int cantitate, float pret_bucata) {
        this.id = id;
        this.cos_id = cos_id;
        this.produs_id = produs_id;
        this.cantitate = cantitate;
        this.pret_bucata = pret_bucata;
    }

    public int getId() {
        return id;
    }

    public int getCos_id() {
        return cos_id;
    }

    public int getProdus_id() {
        return produs_id;
    }

    public int getCantitate() {
        return cantitate;
    }

    public float getPret_bucata() {
        return pret_bucata;
    }
}
