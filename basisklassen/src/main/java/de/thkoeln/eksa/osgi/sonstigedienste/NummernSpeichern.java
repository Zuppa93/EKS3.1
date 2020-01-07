package de.thkoeln.eksa.osgi.sonstigedienste;

public interface NummernSpeichern {
    /**
     * Liefert eine neue, eindeutige Kontonummer
     *
     * @return eindeutige Kontonummer
     */
    public int getNeueKontoNr();
    /**
     * Liefert eine neue, eindeutige Kundennummer
     *
     * @return eindeutige Kundennummer
     */
    public int getNeueKundenNr();
}
