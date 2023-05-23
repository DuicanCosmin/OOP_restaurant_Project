package Models;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public abstract class BaseFoodClass
{
    private long ID;


    public long getID()
    {
        return ID;
    }

    public void setID(long ID)
    {
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

    protected ArrayList<IngredientItem> IngredientList;


    public ArrayList<IngredientItem> getIngredientList()
    {
        return IngredientList;
    }

    public void setIngredientList(ArrayList<IngredientItem> ingredientList) {
        IngredientList = ingredientList;
    }


    private double ProfitMargin=1.1;

    private double Discount=0;

    public double getProfitMargin()
    {
        return ProfitMargin;
    }

    public void setProfitMargin(double profitMargin)
    {
        if (profitMargin>1)
        {
            ProfitMargin=profitMargin;
        }
        else
        {
            ProfitMargin = 1;
        }

    }

    public double getDiscount()
    {
        return Discount;
    }

    public void setDiscount(double discount)
    {
        if (discount<=1 && discount>=0)
        {
            Discount = discount;
        }
        else
        {
            Discount = 0;
        }

    }
}
