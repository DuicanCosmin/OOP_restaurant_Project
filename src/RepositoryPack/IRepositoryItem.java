
package RepositoryPack;
import Models.Person;

import java.util.List;

public interface IRepositoryItem<T>
{
    void Insert(T entity);
    T FindById(Long id);

    T FindById(String id);

    List<T> findAll();
    void Update(T entity);
    void DeleteById(Long id);

    Repository ParentRepo=null;

    void DeleteById(String id);
}
