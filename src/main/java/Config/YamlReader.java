package Config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

import java.io.File;
import java.io.IOException;

public class YamlReader {
    public static Configuration cfg;
    File file = new File("src/main/resources/config.yml");

    public Configuration getCfg() {
        return cfg;
    }

    public YamlReader() {
        try {
            ObjectMapper objectMapper = new ObjectMapper(new YAMLFactory());
            cfg = objectMapper.readValue(file, Configuration.class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
