package de.thkoeln.eksa.osgi.anwendung;


import de.thkoeln.eksa.osgi.verwaltung.KundeKontoVerwaltung;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.osgi.framework.ServiceRegistration;

import java.util.Hashtable;

public class AwendungActivator implements BundleActivator {

    private ServiceRegistration anwendungService;

    private ServiceReference impl2Reference;

    @Override
    public void start(BundleContext bundleContext) throws Exception {
        Hashtable<String,String> properties = new Hashtable<>();

        anwendungService = bundleContext.registerService(Anwendung.class.getName(),new Anwendung(),properties);
        System.out.println("Bundle Anwendung wurd nun gestartet");

        impl2Reference = bundleContext.getServiceReference(KundeKontoVerwaltung.class);



        Anwendung anwendung = new Anwendung();
        anwendung.doIt();

    }

    @Override
    public void stop(BundleContext bundleContext) throws Exception {

        anwendungService.unregister();
        System.out.println("Bundle Anwendung wird nun beendet");

    }
}
