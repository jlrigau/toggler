package fr.jlrigau.toggler;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class Toggler {

    private Map<String, Boolean> features;

    public Toggler(Map<String, Boolean> features) {
        this.features = features;
    }

    public Toggler(Properties properties) {
        features = new HashMap<>();

        for (String name : properties.stringPropertyNames()) {
            features.put(name, Boolean.valueOf(properties.getProperty(name)));
        }
    }

    public boolean isActive(String feature) {
        return features.get(feature);
    }

}
