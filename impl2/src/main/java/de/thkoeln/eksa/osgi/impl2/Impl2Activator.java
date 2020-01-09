package de.thkoeln.eksa.osgi.impl2;

import de.thkoeln.eksa.osgi.entitaetsklassen.Kunde;
import de.thkoeln.eksa.osgi.sonstigedienste.NummernSpeichern;
import de.thkoeln.eksa.osgi.verwaltung.KundeKontoVerwaltung;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.osgi.framework.ServiceRegistration;

import java.util.Hashtable;

public class Impl2Activator implements BundleActivator {

    private ServiceRegistration impl2Service;


    @Override
    public void start(BundleContext bundleContext) throws Exception {
        Hashtable<String, String> properties = new Hashtable<String, String>();
        properties.put("Implementation", "impl2");

        impl2Service = bundleContext.registerService(KundeKontoVerwaltung.class.getName(), new KundeKontoVerwaltungImpl(), properties);

        KundeKontoVerwaltungImpl kundeKontoVerwaltung = new KundeKontoVerwaltungImpl();

        System.out.println("Bundle impl2 wurde gestartet");
    }

    @Override
    public void stop(BundleContext bundleContext) throws Exception {

        impl2Service.unregister();
        System.out.println("BUndle impl2 beendet");
    }
}
