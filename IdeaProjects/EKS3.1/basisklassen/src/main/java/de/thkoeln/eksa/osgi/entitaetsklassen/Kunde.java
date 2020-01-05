package de.thkoeln.eksa.osgi.entitaetsklassen;

import java.util.ArrayList;

public class Kunde {
    private String name;
    private int kundennummer;
    private ArrayList<Integer> konten = new ArrayList<Integer>();

    public Kunde(){

    }

    public void addKonto(int kontonr){
        konten.add(kontonr);
    }

    // Getter und Setter:
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }
    public int getKundennummer(){
        return kundennummer;
    }
    public void setKundennummer(int kundennummer){
        this.kundennummer = kundennummer;
    }
    public ArrayList<Integer> getKonten(){
        return konten;
    }
}
