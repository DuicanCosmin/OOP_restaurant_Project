package Models;

import java.util.ArrayList;

public class Order
{
    private Long ID;

    public ArrayList<MenuItem> OrderedItems;

    public Long getID()
    {
        return ID;
    }

    public void setID(Long ID)
    {
        this.ID = ID;
    }

    private String OrderStatus;

    private long OrderByID;

    public String getOrderStatus()
    {
        return OrderStatus;
    }

    public void setOrderStatus(String orderStatus)
    {
        OrderStatus = orderStatus;
    }

    public long getOrderByID()
    {
        return OrderByID;
    }

    public void setOrderByID(long orderByID)
    {
        OrderByID = orderByID;
    }

    public double totalOrderCost()
    {
        double returnTotal=0;

        for (MenuItem OrderedItem:OrderedItems)
        {
            returnTotal += OrderedItem.Price();
        }
        return 0;
    }

    public enum StatusList
    {
        Ordered,
        Cooked,
        Paid
    }
}
