package de.thkoeln.eksa.osgi.impl1;

import de.thkoeln.eksa.osgi.sonstigedienste.NummernSpeichern;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

import java.util.Hashtable;

public class ActivatorImpl1 implements BundleActivator {

    private ServiceRegistration impl1Service;
    private NummernSpeichernImpl nummernSpeichernImpl;

    @Override
    public void start(BundleContext bundleContext) throws Exception {
        try {
            Hashtable<String, String> properties = new Hashtable<String, String>();
            properties.put("Implementation", "NummernSpeichern");
            nummernSpeichernImpl = NummernSpeichernImpl.getInstance();
            impl1Service = bundleContext.registerService(NummernSpeichern.class.getName(), nummernSpeichernImpl, properties);
        } catch (Exception exception) {
            System.err.println("Error while executing program: " + exception);
            exception.printStackTrace();
            System.exit(0);
        }
        System.out.println("Impl1 Bundle wurde gestartet");
    }

    @Override
    public void stop(BundleContext bundleContext) throws Exception {
        impl1Service.unregister();
        System.out.println("Impl1 Bundle wird beendet");
    }
}
