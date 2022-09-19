package Config;

import Models.Active;
import Models.Browser;
import Models.Environment;

public class Configuration {
    public Active active;
    public Browser browser;
    public Environment environment;

    public Browser getBrowser() {
        return browser;
    }

    public Environment getEnv() {
        return environment;
    }

    public Active getActive() {
        return active;
    }

    public Configuration() {}
}
