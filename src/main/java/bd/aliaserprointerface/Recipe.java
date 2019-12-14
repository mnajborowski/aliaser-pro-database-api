package bd.aliaserprointerface;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.HashMap;

public class Recipe {
    public String name;
    public boolean isVege;
    public String description;
    String alphabet = "abcdefghijklmnoprstquwxyz";


    public Recipe() {
        this.name = createName();
        this.description = createDescription();
        this.isVege = !((description.contains("kurczaka")||description.contains("wolowine")||description.contains("wieprzowine")|| description.contains("konine")|| description.contains("kozine")|| description.contains("drob") ||description.contains("jagniecina")|| description.contains("cielecina") || description.contains("dziczyzna") || description.contains("baranine") || description.contains("indyka")));
    }

    public boolean isVege() {
        return isVege;
    }

    public void setVege(boolean vege) {
        isVege = vege;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void getRecipe(Recipe recipe) {
        if (recipe.isVege) {
            System.out.println("Wegetarianska potrawa o nazwie: " + recipe.getName() + ", przepis: " + recipe.getDescription() + "\n");
        } else
            System.out.println("Miesna potrawa o nazwie: " + recipe.getName() + ", przepis: " + recipe.getDescription() + "\n");
    }

    public String createName() {
        String name = "";
        List<String> podmiot = new ArrayList<String>();
        List<String> przydawka = new ArrayList<String>();
        try {
            File plik_podmiot = new File("podmiot.txt");
            File plik_przydawka = new File("przydawka.txt");


            Scanner sc = new Scanner(plik_podmiot);
            while (sc.hasNext()) {
                podmiot.add(sc.next());
            }
            sc.close();

            sc = new Scanner(plik_przydawka);
            while (sc.hasNext()) {
                przydawka.add(sc.next());
            }
            sc.close();
        } catch (FileNotFoundException e) {
            System.err.println("Brak pliku, zla sciezka");
            e.printStackTrace();
        }
        Collections.shuffle(podmiot);
        Collections.shuffle(przydawka);
        name = name + podmiot.get(0) + " " + przydawka.get(0);
        return name;
    }

    public String createDescription() {
        String description = "";

        IngredientCollector ingredientCollector = new IngredientCollector();
        ingredientCollector.collectIngredients("produkty.txt");


        Random random = new Random();
        HashMap<String, List<String>> map = ingredientCollector.getRecipes();
        List<String> ingredients = new ArrayList<>(map.keySet());

        var iteracja = random.nextInt((30-15)+1)+15; //okresla dlugosc przepisu
        for(int i =0;i<iteracja;i++)
        {
            String randomIngredient = ingredients.get(random.nextInt(ingredients.size()));

            List<String> actions = map.get(randomIngredient);
            String randomAction = actions.get(random.nextInt(actions.size()));
            if(randomAction.length()>2)
            {
                description= description + randomAction + " " + randomIngredient + ". ";
            }
           else
            {
               continue;
            }

            if(i==random.nextInt((30-15)+1)+15)
            {
                String second = ingredients.get(random.nextInt(ingredients.size()));


                String first = actions.get(random.nextInt(actions.size()));

                first = first.substring(0,2) + alphabet.charAt(random.nextInt(alphabet.length())) + first.substring(3);

                second = second.substring(0,2) + alphabet.charAt(random.nextInt(alphabet.length())) + second.substring(3);
                description = description + first + " " + second + ". ";
            }
        }



        return description;

    }
}
