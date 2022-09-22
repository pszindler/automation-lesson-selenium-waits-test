package Models;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
public class Environment {
    EnvironmentModel lab;
    EnvironmentModel prod;

    public List<EnvironmentModel> getAllEnv() {
        return new ArrayList<>(List.of(getLab(), getProd()));
    }
}
