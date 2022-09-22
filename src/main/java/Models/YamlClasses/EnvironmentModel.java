package Models.YamlClasses;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import lombok.Getter;

import java.util.HashMap;
import java.util.Map;


public class EnvironmentModel {
    @Getter
    String envName;

    Map<String, Object> properties = new HashMap<>();

    @JsonAnySetter
    void setEnvironmentProperties(String key, Object value) {
        properties.put(key, value);
    }

    @JsonAnyGetter
    public Map<String, Object> getEnvironmentProperties() {
        return properties;
    }

}
