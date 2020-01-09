package de.thkoeln.eksa.osgi.entityverwaltung;

import de.thkoeln.eksa.osgi.entitaetsklassen.Konto;

import java.util.ArrayList;

public class AlleKonten {
    private static AlleKonten instance;
    private ArrayList<Konto> alleKonten;

    private AlleKonten(){

        alleKonten = new ArrayList<Konto>();

    }

    public static AlleKonten getInstance(){

        if(instance == null)
            instance = new AlleKonten();
        return instance;

    }

    public ArrayList<Konto> getAlleKonten(){
        return alleKonten;
    }

    public void addKonto(Konto konto){
        alleKonten.add(konto);
    }

}

