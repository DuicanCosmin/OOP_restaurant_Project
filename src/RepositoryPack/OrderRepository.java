package RepositoryPack;

import Models.Order;

import java.util.List;

public class OrderRepository implements IRepositoryItem<Order>
{
    String TableName="Orders";

    String JoinTable ="OrderFoods";

    @Override
    public void Insert(Order entity)
    {

    }

    @Override
    public Order FindById(Long id) {
        return null;
    }

    @Override
    public Order FindById(String id) {
        return null;
    }

    @Override
    public List<Order> findAll() {
        return null;
    }

    @Override
    public void Update(Order entity) {

    }

    @Override
    public void DeleteById(Long id) {

    }

    @Override
    public void DeleteById(String id) {

    }

    @Override
    public void CreateTable() {

    }

    @Override
    public void CheckTable() {

    }

    @Override
    public void LogAction(String Action)
    {

    }
}
