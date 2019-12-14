package bd.aliaserprointerface;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class IngredientCollector {
    private HashMap<String, List<String>> recipes = new HashMap<>();
    void collectIngredients(String filepath) {
        try {
            var file = new File(filepath);
            var scanner = new Scanner(file);
            var lineNumber = 0;
            while (scanner.hasNextLine()) {
                List<String> treatment = new ArrayList<>();
                var line = scanner.nextLine();
                var values = line.split(":");
                String product_name = values[0];
                String product_treatment = values[1];
                String[] treatment_split = values[1].split(" ");
                for (String s : treatment_split) {
                    treatment.add(s);
                }
                var items = (line.split(" "));
                recipes.put(product_name, treatment);
                lineNumber++;
            }
        } catch (FileNotFoundException e) {
            System.err.println("File not found!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public HashMap<String, List<String>> getRecipes() {
        return recipes;
    }
}
