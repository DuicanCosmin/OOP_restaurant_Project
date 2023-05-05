package Models;

import java.util.List;

public class ChefItem extends  BaseFoodClass
{

    private String RecipeName ;

    public void CreateFoodRecipe (String RecipeName, List<IngredientItem>IngredientList)
    {
        this.RecipeName=RecipeName;
        this.IngredientList=IngredientList;
    }

    public String getRecipeName()
    {
        return RecipeName;
    }
}
