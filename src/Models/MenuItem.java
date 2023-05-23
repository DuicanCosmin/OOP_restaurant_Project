package Models;

public class MenuItem  extends BaseFoodClass
{


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


}
