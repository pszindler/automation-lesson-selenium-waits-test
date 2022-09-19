package Models;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;

import java.util.LinkedHashMap;
import java.util.Map;

public class Environment {

    Map<String, EnvironmentModel> properties = new LinkedHashMap<>();

    @JsonAnySetter
    void setEnvironmentProperties(String key, EnvironmentModel model) {
        properties.put(key, model);
    }

    @JsonAnyGetter
    public Map<String, EnvironmentModel> getEnvironmentProperties() {
        return properties;
    }

}
