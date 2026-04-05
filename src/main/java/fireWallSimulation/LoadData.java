package fireWallSimulation;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import com.google.gson.Gson;

public class LoadData {

    private static RuleJsonModel model;

    public static void load() throws FileNotFoundException {

        try (Reader reader = new FileReader("rules.json")) {

            Gson gson = new Gson();
            model = gson.fromJson(reader, RuleJsonModel.class);

        } catch (IOException e) {
            System.err.println("Error while reading rules.json");
        }
    }

    public static RuleJsonModel getModel() throws FileNotFoundException {
        LoadData.load();
        return model;
    }

}