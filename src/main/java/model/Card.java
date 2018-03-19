package model;

public class Card {
    private String nume;
    private String numarCard;
    private String dataExpirare;
    private String codCVV;

    public Card(String nume, String numarCard, String dataExpirare, String codCVV) {
        this.nume = nume;
        this.numarCard = numarCard;
        this.dataExpirare = dataExpirare;
        this.codCVV = codCVV;
    }

    public String getNume() {
        return nume;
    }

    public String getNumarCard() {
        return numarCard;
    }

    public String getDataExpirare() {
        return dataExpirare;
    }

    public String getCodCVV() {
        return codCVV;
    }
}
