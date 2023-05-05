package Models;

public class IngredientItem
{
    private long ID;

    private double Price;

    private double Calories;

    private String Name;


    public long getID()
    {
        return ID;
    }

    public void setID(long ID) {
        this.ID = ID;
    }

    public double getPrice() {
        return Price;
    }

    public void setPrice(double price) {
        Price = price;
    }

    public double getCalories() {
        return Calories;
    }

    public void setCalories(double calories) {
        Calories = calories;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }
}
