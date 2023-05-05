package Models;

import java.util.List;

public abstract class BaseFoodClass
{
    private long ID;


    public long getID() {
        return ID;
    }

    public void setID(long ID) {
        this.ID = ID;
    }

    private String Name;


    public String getName()
    {
        return Name;
    }

    public void setName(String name)
    {
        Name = name;
    }

    protected List<IngredientItem> IngredientList;


    public List<IngredientItem> getIngredientList() {
        return IngredientList;
    }
    /*
    public void setIngredientList(List<IngredientItem> ingredientList) {
        IngredientList = ingredientList;
    }
    */

}
