package de.thkoeln.eksa.osgi.entityverwaltung;

import de.thkoeln.eksa.osgi.entitaetsklassen.Kunde;

import java.util.ArrayList;

public class AlleKunden {
    private static AlleKunden instance;
    private ArrayList<Kunde> alleKunden;

    private AlleKunden(){
        alleKunden = new ArrayList<Kunde>();
    }

    public static AlleKunden getInstance(){
        if(instance == null){
            instance = new AlleKunden();
        }
        return instance;
    }

    public void addKunde(Kunde kunde){
        alleKunden.add(kunde);
    }

    public ArrayList<Kunde> getAlleKunden(){
        return alleKunden;
    }
}
