package de.thkoeln.eksa.osgi.anwendung;

import de.thkoeln.eksa.osgi.entitaetsklassen.Konto;
import de.thkoeln.eksa.osgi.entitaetsklassen.Kunde;

import de.thkoeln.eksa.osgi.verwaltung.KundeKontoVerwaltung;

import java.util.ArrayList;

public class Anwendung {

    private KundeKontoVerwaltung kundeKontoVerwaltung;

    public Anwendung(){}
    public Anwendung(KundeKontoVerwaltung verwaltung){
        kundeKontoVerwaltung=verwaltung;
    }

    public void setService(){

    }

    public void doIt() {

        int kunde1 = kundeKontoVerwaltung.neuerKunde("Tim");
        System.out.println("Kunde Tim hat Kundennummer: " + kunde1);

        int kunde2 = kundeKontoVerwaltung.neuerKunde("Stephan");
        System.out.println("Kunde Stephan hat Kundennummer: " + kunde2);

        int konto1 = kundeKontoVerwaltung.neuesKonto();
        System.out.println("Kontonummer von Konto 1 :" + konto1);

        int konto2 = kundeKontoVerwaltung.neuesKonto();
        System.out.println("Kontonummer von Konto 2 :" + konto2);

        int konto3 = kundeKontoVerwaltung.neuesKonto();
        System.out.println("Kontonummer von Konto 3 :" + konto3);

        Kunde kundenObjekt1 = kundeKontoVerwaltung.getKunde(kunde1);
        Kunde kundenObjekt2 = kundeKontoVerwaltung.getKunde(kunde2);

        kundeKontoVerwaltung.besitztKonto(kundenObjekt1,konto1);
        kundeKontoVerwaltung.besitztKonto(kundenObjekt1,konto2);
        kundeKontoVerwaltung.besitztKonto(kundenObjekt2,konto3);

        ArrayList<Konto> timskonten = kundeKontoVerwaltung.alleKonten(kundenObjekt1);
        System.out.println("Alle gefundenen Konten von Tim:");
        for(int i = 0;i<timskonten.size();i++){
            System.out.println(timskonten.get(i).getKontonr());
            System.out.println();
        }

        ArrayList<Konto> stephanskonten = kundeKontoVerwaltung.alleKonten(kundenObjekt2);
        System.out.println("Alle gefundenen Konten von Stephan:");
        for(int i = 0;i<stephanskonten.size();i++){
            System.out.println(stephanskonten.get(i).getKontonr());
            System.out.println();
        }
    }

}
