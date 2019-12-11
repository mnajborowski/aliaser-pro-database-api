package bd.aliaserprointerface;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Recipe {
    private String name;
    private boolean isVege;
    private String description;
    public Recipe()
    {
        this.name = createName();
        this.description = createDescription();
        this.isVege = !description.contains("kurczaka"); // TODO a co z wolowinka? XD
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
    public void getRecipe(Recipe recipe)
    {
        if(recipe.isVege)
        {
            System.out.println("Wegetarianska potrawa o nazwie: " + recipe.getName() + ", przepis: " + recipe.getDescription() + "\n");
        }
        else
            System.out.println("Miesna potrawa o nazwie: " + recipe.getName() + ", przepis: " + recipe.getDescription() + "\n");
    }
    public String createName()
    {
        String name = "";
        List<String> podmiot = new ArrayList<String>();
        List<String> przydawka = new ArrayList<String>();
        try
        {
            File plik_podmiot = new File("podmiot");
            File plik_przydawka = new File("przydawka");


            createFromFile(podmiot, przydawka, plik_podmiot, plik_przydawka);
        }
        catch (FileNotFoundException e)
        {
            System.err.println("Brak pliku, zla sciezka");
            e.printStackTrace();
        }
        Collections.shuffle(podmiot);
        Collections.shuffle(przydawka);
        name = name + podmiot.get(0) + " " + przydawka.get(0);
        return name;
    }

    public String createDescription()
    {
        StringBuilder description= new StringBuilder();
        List<String> czynnosci = new ArrayList<String>();
        List<String> skladniki = new ArrayList<String>();
        try
        {

            File plik_skladniki = new File("skladniki");
            File plik_czynnosci = new File("czynnosci");


            createFromFile(czynnosci, skladniki, plik_czynnosci, plik_skladniki);


        }
        catch (FileNotFoundException e)
        {
            System.err.println("Brak pliku, zla sciezka");
            e.printStackTrace();
        }

        for(int i = 0;i<100;i++)
        {
            Collections.shuffle(czynnosci);
            Collections.shuffle(skladniki);
            description.append(czynnosci.get(0)).append(" ").append(skladniki.get(0)).append(". ");
        }

        return description.toString();
    }

    private void createFromFile(List<String> list1, List<String> list2, File file1, File file2) throws FileNotFoundException {
        Scanner sc = new Scanner(file1);
        while (sc.hasNext())
        {
            list1.add(sc.next());
        }
        sc.close();

        sc = new Scanner(file2);
        while (sc.hasNext())
        {
            list2.add(sc.next());
        }
        sc.close();
    }
}
