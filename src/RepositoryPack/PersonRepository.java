package RepositoryPack;

import Models.Person;

import java.util.List;

public class PersonRepository implements IRepositoryItem<Person>
{

    @Override
    public void Insert(Person entity)
    {
        System.out.println("Insert with " + Repository.ConnectionStringGet());
    }

    @Override
    public Person FindById(Long id) {
        return null;
    }

    @Override
    public Person FindById(String id)
    {
        id=id.toLowerCase();

        System.out.println("In the id get");
        System.out.println("the input is "+ id) ;

        Person ReturnPerson=null;

        // test item
        if (id.equals("chef"))
        {
            System.out.println("If sccessful");
            ReturnPerson=new Person();
            ReturnPerson.Role="Chef";
        }
        else
        {
            System.out.println("Ehm why?");
        }


        return  ReturnPerson;
    }

    @Override
    public List<Person> findAll()
    {
        System.out.println("Get all");
        return null;
    }

    @Override
    public void Update(Person entity)
    {
        System.out.println("Update Person");
    }

    @Override
    public void DeleteById(Long id)
    {

    }

    @Override
    public void DeleteById(String id)
    {
        System.out.println("Delete Person");
    }

    public List<Person> FindByRole(String Role)
    {

        return null;
    }


}
