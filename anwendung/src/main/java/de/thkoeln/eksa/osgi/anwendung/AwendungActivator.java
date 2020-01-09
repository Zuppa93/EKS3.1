package de.thkoeln.eksa.osgi.anwendung;


import de.thkoeln.eksa.osgi.sonstigedienste.NummernSpeichern;
import de.thkoeln.eksa.osgi.verwaltung.KundeKontoVerwaltung;
import org.osgi.framework.*;

import java.util.Hashtable;

public class AwendungActivator implements BundleActivator {

    private ServiceRegistration<Anwendung> anwendungService;

    private ServiceReference<KundeKontoVerwaltung>[] impl2References;

    private ServiceReference<NummernSpeichern>[] impl1Reference;

    @Override
    public void start(BundleContext bundleContext) {

        System.out.println("Bundle Anwendung wurd nun gestartet");

        try {
            impl2References = (ServiceReference<KundeKontoVerwaltung>[]) bundleContext.getServiceReferences(KundeKontoVerwaltung.class.getName(), "(Implementation=KundeKontoVerwaltung)");
        } catch (InvalidSyntaxException e) {
            e.printStackTrace();
            return;
        }
        if(impl2References == null) {
            System.out.println("No Services available for KundeKontoVerwaltung. Ending Program.");
            return;
        }

        try{
            impl1Reference = (ServiceReference<NummernSpeichern>[]) bundleContext.getServiceReferences(NummernSpeichern.class.getName(),"(Implementation=NummernSpeichern)");
        }catch(InvalidSyntaxException e){
            e.printStackTrace();
            return;
        }

        KundeKontoVerwaltung verwaltung = (KundeKontoVerwaltung) bundleContext.getService(impl2References[0]);
        Anwendung anwendung = new Anwendung(verwaltung);

        Hashtable<String,String> properties = new Hashtable<>();
        anwendungService = (ServiceRegistration<Anwendung>) bundleContext.registerService(Anwendung.class.getName(),new Anwendung(),properties);

        anwendung.doIt();
    }

    @Override
    public void stop(BundleContext bundleContext) {

        anwendungService.unregister();
        System.out.println("Bundle Anwendung wird nun beendet");

    }
}
