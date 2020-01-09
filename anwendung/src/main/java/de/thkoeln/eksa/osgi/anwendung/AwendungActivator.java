package de.thkoeln.eksa.osgi.anwendung;


import de.thkoeln.eksa.osgi.verwaltung.KundeKontoVerwaltung;
import org.osgi.framework.*;

import java.util.Hashtable;

public class AwendungActivator implements BundleActivator {

    private ServiceRegistration<Anwendung> anwendungService;

    private ServiceReference<KundeKontoVerwaltung>[] impl2References;

    @Override
    public void start(BundleContext bundleContext) {
        Hashtable<String,String> properties = new Hashtable<>();

        System.out.println("Bundle Anwendung wurd nun gestartet");

        try {
            impl2References = (ServiceReference<KundeKontoVerwaltung>[]) bundleContext.getServiceReferences(KundeKontoVerwaltung.class.getName(), "Implementation=KundeKontoVerwaltung");
        } catch (InvalidSyntaxException e) {
            e.printStackTrace();
            return;
        }
        if(impl2References == null) {
            System.out.println("No Services available for KundeKontoVerwaltung. Ending Program.");
            return;
        }
        KundeKontoVerwaltung verwaltung = (KundeKontoVerwaltung) bundleContext.getService(impl2References[0]);

        anwendungService = (ServiceRegistration<Anwendung>) bundleContext.registerService(Anwendung.class.getName(),new Anwendung(),properties);


        Anwendung anwendung = new Anwendung(verwaltung);
        anwendung.doIt();
    }

    @Override
    public void stop(BundleContext bundleContext) {

        anwendungService.unregister();
        System.out.println("Bundle Anwendung wird nun beendet");

    }
}
