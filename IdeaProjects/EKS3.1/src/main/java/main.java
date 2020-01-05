import org.apache.felix.framework.Felix;
import org.osgi.framework.Bundle;
import org.osgi.framework.BundleContext;
import org.osgi.framework.Constants;

import java.util.HashMap;
import java.util.Map;

public class main {
    public static void main(String [] args){
        try{
            // Initialize Apache Felix Framework
            Map<String, String> configMap = new HashMap<String, String>();
            configMap.put(Constants.FRAMEWORK_STORAGE_CLEAN, "onFirstInit");
            Felix framework = new Felix(configMap);
            framework.init();

            // Load bundles
            BundleContext context = framework.getBundleContext();
            Bundle basisklassen = context.installBundle("file:basisklassen/target/basisklassen-1.0.jar");
            Bundle impl1 = context.installBundle("file:impl1/target/impl1-1.0.jar");
            Bundle impl2 = context.installBundle("file:impl2/target/impl2-1.0.jar");
            Bundle anwendung = context.installBundle("file:anwendung/target/anwendung-1.0.jar");

            framework.start();

            // Starte die Bundles
            basisklassen.start();
            impl1.start();
            impl2.start();
            // Setze den Service für impl2

            anwendung.start();



        }catch(Exception exception){
            System.err.println("Error while executing program: " + exception);
            exception.printStackTrace();
            System.exit(0);
        }
    }
}
