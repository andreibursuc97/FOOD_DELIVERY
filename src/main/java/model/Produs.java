package model;

/**
 * Created by Andrei on 18/04/2017.
 */
public class Produs {
    private int id;
    private String descriere;
    private float pret;
    private int cantitate;

    public Produs(int id, String descriere, float pret, int cantitate) {
        this.id = id;
        this.descriere = descriere;
        this.pret = pret;
        this.cantitate = cantitate;
    }


    public int getId() {
        return id;
    }

    public String getDescriere() {
        return descriere;
    }

    public float getPret() {
        return pret;
    }

    public int getCantitate() {
        return cantitate;
    }

    public void setCantitate(int cantitate) {
        this.cantitate = cantitate;
    }
}
