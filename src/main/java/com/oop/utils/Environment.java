import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class Environment {
    public static HashMap<String, String> load() {
        HashMap<String, String> envVariables = new HashMap<String, String>();

        try (BufferedReader br = new BufferedReader(new FileReader(".env"))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (line.trim().isEmpty() || line.startsWith("#")) {
                    continue;
                }
                String[] parts = line.split("=", 2);
                if (parts.length == 2) {
                    parts[1] = parts[1].trim();
                    parts[1] = (parts[1].startsWith("\"") && parts[1].endsWith("\""))
                        ? parts[1].substring(1, parts[1].length() - 1)
                        : parts[1];
                    envVariables.put(parts[0].trim(), parts[1]);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return envVariables;
    }
}
