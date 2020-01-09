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

        ServiceReference[] refs = bundleContext.getServiceReferences(NummernSpeichern.class.getName(),"(Implementation=NummernSpeichern)");

        if(refs==null){
            System.out.println("ERROR 404");
            return;
        }

        NummernSpeichern nummernSpeichern = (NummernSpeichern) bundleContext.getService(refs[0]);

        KundeKontoVerwaltungImpl kundeKontoVerwaltung = new KundeKontoVerwaltungImpl();

        kundeKontoVerwaltung.setMyService(nummernSpeichern);

        Hashtable<String, String> properties = new Hashtable<String, String>();
        properties.put("Implementation", "KundeKontoVerwaltung");
        KundeKontoVerwaltung instance = new KundeKontoVerwaltungImpl();
        instance.setMyService(nummernSpeichern);
        /*
        Objekt welches wir bei registerService übergeben wird bei getService zurückgegeben
        Sodass wir eine Referenz des hier erstellten Objektes erhalten und darauf arbeiten
        Das heisst wenn wir hier den Service setzen ist er immer gesetzt wenn wir uns den
        Service holen
         */
        impl2Service = bundleContext.registerService(KundeKontoVerwaltung.class.getName(), instance, properties);

        System.out.println("Bundle impl2 wurde gestartet");
    }

    @Override
    public void stop(BundleContext bundleContext) throws Exception {

        impl2Service.unregister();
        System.out.println("BUndle impl2 beendet");
    }
}
