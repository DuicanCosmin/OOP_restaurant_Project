package Models;

public class MenuItem  extends BaseFoodClass
{
        private double ProfitMargin=1.1;

        private double Discount=0;


        public double Price ()
        {
            double returnPrice=0;

            for (IngredientItem Ingredient : getIngredientList())
            {
                returnPrice+=Ingredient.getPrice();
            }
            return returnPrice;
        }

        public double Calories()
        {
            double returnCal=0;

            for (IngredientItem Ingredient : getIngredientList())
            {
                returnCal+=Ingredient.getCalories();
            }
            return returnCal;
        }

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

    public double getDiscount() {
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
