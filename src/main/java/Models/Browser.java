package Models;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;

import java.util.LinkedHashMap;
import java.util.Map;

public class Browser {
    Map<String, BrowserModel> properties = new LinkedHashMap<>();

    @JsonAnySetter
    void setBrowserProperties(String key, BrowserModel model) {
        properties.put(key, model);
    }

    @JsonAnyGetter
    public Map<String, BrowserModel> getBrowserProperties() {
        return properties;
    }
}
