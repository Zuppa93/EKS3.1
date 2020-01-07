package de.thkoeln.eksa.osgi.impl1;

import de.thkoeln.eksa.osgi.entityverwaltung.AlleKunden;
import de.thkoeln.eksa.osgi.sonstigedienste.NummernSpeichern;

public class NummernSpeichernImpl implements NummernSpeichern {
    private static NummernSpeichernImpl instance;
    private int lastKundennummer;
    private int lastKontonummer;

    private NummernSpeichernImpl() {
    }

    public static NummernSpeichernImpl getInstance(){
        if(instance == null)
            instance = new NummernSpeichernImpl();
        return instance;
    }

    @Override
    public int getNeueKontoNr() {
        lastKontonummer++;
        return lastKontonummer;
    }

    @Override
    public int getNeueKundenNr() {
        lastKundennummer++;
        return lastKundennummer;
    }
}
