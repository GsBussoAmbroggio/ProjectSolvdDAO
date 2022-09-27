package dao;
import models.Employee;
import models.Product;

import java.util.List;

public interface IProductDAO extends DAO<Product,String>{
    void insert(Product p)throws DAOException;
    void modify(Product p)throws DAOException;
    void delete(Product p)throws DAOException;

    List<Product> GetAll()throws DAOException;
    Product GetBy(String productCD)throws DAOException;
}
