package de.thkoeln.eksa.osgi.anwendung;

import de.thkoeln.eksa.osgi.entitaetsklassen.Konto;
import de.thkoeln.eksa.osgi.entitaetsklassen.Kunde;
import de.thkoeln.eksa.osgi.impl2.KundeKontoVerwaltungImpl;
import de.thkoeln.eksa.osgi.verwaltung.KundeKontoVerwaltung;
import org.apache.felix.framework.Felix;
import org.osgi.framework.Constants;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Anwendung {

    public void doIt() throws Exception{

        // Initialize Apache Felix Framework
        Map<String, String> configMap = new HashMap<String, String>();
        configMap.put(Constants.FRAMEWORK_STORAGE_CLEAN, "onFirstInit");
        Felix framework = new Felix(configMap);
        framework.init();

        KundeKontoVerwaltung kundeKontoVerwaltung = new KundeKontoVerwaltungImpl();

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
