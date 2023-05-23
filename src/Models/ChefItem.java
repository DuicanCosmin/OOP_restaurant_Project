package Models;

import java.util.ArrayList;

public class ChefItem extends  BaseFoodClass
{

    private String RecipeString;

    public void CreateFoodRecipe (String RecipeName, ArrayList<IngredientItem> IngredientList)
    {
        this.RecipeString =RecipeName;
        this.IngredientList=IngredientList;
    }
    public void setRecipeString(String IncomingRecipe)
    {
        this.RecipeString=IncomingRecipe;
    }

    public String getRecipeString()
    {
        return RecipeString;
    }
}
