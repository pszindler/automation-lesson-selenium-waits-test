package Config;

import Models.YamlClasses.EnvironmentModel;

import java.util.List;
import java.util.Map;

public final class AppPropertiesSingleton {
    private static AppPropertiesSingleton INSTANCE;
    YamlReader yamlReader = new YamlReader();

    private AppPropertiesSingleton() {
        setEnvironmentProperties();
        setBrowserProperties();
    }

    private void setEnvironmentProperties() {
        List<EnvironmentModel> envs = yamlReader.getConfig().environment.getAllEnv();
        for (EnvironmentModel env : envs) {
            if (env.getEnvName().equals(getActiveEnv())) {
                for (Map.Entry<String, Object> entry : env.getEnvironmentProperties().entrySet()) {
                    System.setProperty(entry.getKey(), entry.getValue().toString());
                }
            }
        }
    }

    private void setBrowserProperties() {
        for (Map.Entry<String, Object> entry : yamlReader.getConfig().getBrowser().getProperties().entrySet()) {
            System.setProperty(entry.getKey(), entry.getValue().toString());
        }
    }

    public String getActiveEnv() {
        return yamlReader.getConfig().activeEnvironment.getActiveEnvironment();
    }

    public static AppPropertiesSingleton getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new AppPropertiesSingleton();
        }
        return INSTANCE;
    }


}
