package Config;

import Models.YamlClasses.ActiveEnvironment;
import Models.YamlClasses.Browser;
import Models.YamlClasses.Environment;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class Configuration {
    public ActiveEnvironment activeEnvironment;
    public Browser browser;
    public Environment environment;

}
