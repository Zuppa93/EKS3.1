package de.thkoeln.eksa.osgi.impl2;

import de.thkoeln.eksa.osgi.entitaetsklassen.Konto;
import de.thkoeln.eksa.osgi.entitaetsklassen.Kunde;
import de.thkoeln.eksa.osgi.entityverwaltung.AlleKonten;
import de.thkoeln.eksa.osgi.entityverwaltung.AlleKunden;
import de.thkoeln.eksa.osgi.sonstigedienste.NummernSpeichern;
import de.thkoeln.eksa.osgi.verwaltung.KundeKontoVerwaltung;

import java.util.ArrayList;

public class KundeKontoVerwaltungImpl implements KundeKontoVerwaltung{

    private AlleKunden alleKunden;
    private AlleKonten alleKonten;

    private NummernSpeichern myService;

    public KundeKontoVerwaltungImpl(){
        alleKunden = AlleKunden.getInstance();
        alleKonten = AlleKonten.getInstance();
    }

    public void setMyService(NummernSpeichern newService){
        this.myService = newService;
        if(myService == null)
            System.out.println("Service nicht mehr registriert");
        else
            System.out.println("Service "+myService.getClass().getName()+" registriert");
    }

    /**
     * Erzeugt ein neues Objekt der Klasse Kunde.
     * Hierbei muss auf das Interface NummernSpeicher
     * zugegriffen werden, um eine neue Kundennummer zu erhalten.
     *
     * @param name Name des neuen Kunden
     *
     * @return vergebene Kundennummer
     */
    @Override
    public int neuerKunde(String name) {
        Kunde kunde = new Kunde();
        kunde.setName(name);
        kunde.setKundennummer(myService.getNeueKundenNr());
        alleKunden.addKunde(kunde);
        return kunde.getKundennummer();
    }

    /**
     * Das Kundenobjekt zur gegebenen Kundennummer wird
     * zurückgegeben.
     *
     * @param kundenr Kundennummer des gesuchten Kundenobjekts
     *
     * @return Objekt der Klasse Kunde mit der Kundenummer kundenr
     */
    @Override
    public Kunde getKunde(int kundenr) {
        Kunde kunde = null;
        for(int i = 0; i < alleKunden.getAlleKunden().size();i++){
            if(kundenr == alleKunden.getAlleKunden().get(i).getKundennummer()){
                kunde = alleKunden.getAlleKunden().get(i);
            }
        }
        return kunde;
    }

    /**
     * Liefert alle Konten des gegebenen Kunden.
     *
     * @param k Kundenobjekt, für das die Konten
     * ermittelt werden sollen
     *
     * @return Liste aller Konten des Kunden k.
     */
    @Override
    public ArrayList<Konto> alleKonten(Kunde k) {
        Kunde kunde = getKunde(k.getKundennummer());

        if(kunde == null)
            return null;

        ArrayList<Integer> kontenNummern =  kunde.getKonten();
        ArrayList<Konto> konten = new ArrayList<Konto>();

        // A C-Programmers Nightmare
        for(int i = 0; i< kontenNummern.size();i++){
            for(int j = 0; j < alleKonten.getAlleKonten().size() ;j++){
                if(kontenNummern.get(i) == alleKonten.getAlleKonten().get(j).getKontonr())
                    konten.add(alleKonten.getAlleKonten().get(j));
            }
        }

        return konten;
    }
    /**
     * Es wird der Kundenverwaltung mitgeteilt, dass
     * der Kunde k nun das Konto mit der
     * Kontonummer kontonr besitzt.
     *
     * @param k Kunde, der das neue Konto besitzt
     *
     * @param kontonr Kontonummer des neuen Kontos des Kunden k
     */
    @Override
    public void besitztKonto(Kunde k, int kontonr) {
        Kunde kunde = getKunde(k.getKundennummer());
        kunde.addKonto(kontonr);
    }
    /**
     * Erzeugt ein neues Objekt der Klasse Konto.
     * Hierbei muss auf das Interface NummernSpeicher
     * zugegriffen werden, um eine neue Kontonummer zu erhalten.
     * @return vergebene Kontonummer
     */
    @Override
    public int neuesKonto() {
        Konto konto = new Konto(myService.getNeueKontoNr());
        alleKonten.addKonto(konto);
        return konto.getKontonr();
    }

}
