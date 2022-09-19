package Config;

import Models.BrowserModel;
import Models.EnvironmentModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;
import java.util.stream.Collectors;

public class AppProperties {
    static Logger logger = LoggerFactory.getLogger(AppProperties.class);
    YamlReader yamlReader = new YamlReader();
    public Map<String, EnvironmentModel> allEnvModels;
    public Map<String, EnvironmentModel> filteredEnvModels;
    public Map<String, BrowserModel> allBrowserModels;
    public Map<String, BrowserModel> filteredBrowserModels;
    public String activeEnv;
    public String activeBrowser;

    public AppProperties() {
        setEnvironmentProperties();
        setBrowserProperties();
    }

    public static AppProperties getInstance() {
        return AppPropertiesSingleton.INSTANCE;
    }

    public void setEnvironmentProperties() {
        activeEnv = getActiveElement("activeEnvironment");
        allEnvModels = getAllEnvModels();
        filteredEnvModels = getFilteredEnv(allEnvModels);
        logger.info("Setting environment properties...");
        for (Map.Entry<String, EnvironmentModel> entry : filteredEnvModels.entrySet()) {
            for (Map.Entry<String, Object> properties : entry.getValue().getEnvironmentProperties().entrySet()) {
                System.setProperty(properties.getKey(), properties.getValue().toString());
                logger.info("{}:{}", properties.getKey(), properties.getValue().toString());
                System.out.println(properties.getKey() + ":" + properties.getValue().toString());
            }
        }
    }

    public void setBrowserProperties() {
        activeBrowser = getActiveElement("activeBrowser");
        allBrowserModels = getAllBrowserModels();
        filteredBrowserModels = getFilteredBrowser(allBrowserModels);
        logger.info("Setting browser properties...");
        for (Map.Entry<String, BrowserModel> entry : filteredBrowserModels.entrySet()) {
            for (Map.Entry<String, Object> properties : entry.getValue().getBrowserProperties().entrySet()) {
                System.setProperty(properties.getKey(), properties.getValue().toString());
                logger.info("{}:{}", properties.getKey(), properties.getValue().toString());
                System.out.println(properties.getKey() + ":" + properties.getValue().toString());
            }
        }
    }

    private Map<String, EnvironmentModel> getAllEnvModels() {
        return yamlReader.getCfg().environment.getEnvironmentProperties();
    }

    private Map<String, BrowserModel> getAllBrowserModels() {
        return yamlReader.getCfg().browser.getBrowserProperties();
    }

    public Map<String, EnvironmentModel> getFilteredEnv(Map<String, EnvironmentModel> models) {
        return models
                .entrySet()
                .stream()
                .filter(entry -> entry.getKey().equals(activeEnv))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }

    public Map<String, BrowserModel> getFilteredBrowser(Map<String, BrowserModel> models) {
        return models
                .entrySet()
                .stream()
                .filter(entry -> entry.getKey().equals(activeBrowser))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }

    private String getActiveElement(String activeElement) {
        return yamlReader.getCfg().getActive().getActiveParams().get(activeElement).toString();
    }

    private static class AppPropertiesSingleton {
        private static final AppProperties INSTANCE = new AppProperties();
    }
}
