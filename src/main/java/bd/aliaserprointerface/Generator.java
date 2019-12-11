package bd.aliaserprointerface;

import java.util.ArrayList;

public class Generator {
    public ArrayList<Recipe> get100Recipes()
    {

        ArrayList<Recipe> recipes = new ArrayList<>();
        for(int i=0;i<100;i++)
        {
            Recipe recipe = new Recipe();

            recipes.add(recipe);
        }
        return recipes;
    }

}
