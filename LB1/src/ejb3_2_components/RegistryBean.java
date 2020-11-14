package ejb3_2_components;

import static javax.ejb.ConcurrencyManagementType.BEAN;
import javax.ejb.Singleton;
import javax.ejb.ConcurrencyManagement;
import javax.ejb.Startup;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.Properties;
@Singleton
@ConcurrencyManagement(BEAN)
@Startup
public class RegistryBean implements PropertyRegistry {
    // Note the java.util.Properties object is a thread-safe
    // collections that uses synchronization.  If it didn't
    // you would have to use some form of synchronization
    // to ensure the PropertyRegistryBean is thread-safe.
    private final Properties properties = new Properties();

    // The @Startup method ensures that this method is
    // called when the application starts up.
    @PostConstruct
    public void applicationStartup() {
        properties.putAll(System.getProperties());
    }
    @PreDestroy
    public void applicationShutdown() {
        properties.clear();
    }
    public String getProperty(String key) {
        return properties.getProperty(key);
    }

    public String setProperty(String key, String value) {
        return (String) properties.setProperty(key, value);
    }

    public String removeProperty(String key) {
        return (String) properties.remove(key);

}
}