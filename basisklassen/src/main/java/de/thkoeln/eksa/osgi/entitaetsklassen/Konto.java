package de.thkoeln.eksa.osgi.entitaetsklassen;

public class Konto {
    private int kontonr; // eindeutige Kontonummer

    public Konto(int kontonr){
        this.kontonr = kontonr;
    }

    // Getter und Setter:
    public int getKontonr(){
        return kontonr;
    }
    public void setKontonr(int kontonr){
        this.kontonr = kontonr;
    }
}