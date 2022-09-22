package Config;

import Models.ActiveEnvironment;
import Models.Browser;
import Models.Environment;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class Configuration {
    public ActiveEnvironment activeEnvironment;
    public Browser browser;
    public Environment environment;

}
