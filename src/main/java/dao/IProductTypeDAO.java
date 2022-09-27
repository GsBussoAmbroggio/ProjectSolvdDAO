package dao;
import models.Employee;
import models.ProductType;

import java.util.List;

public interface IProductTypeDAO extends DAO<ProductType,String>{
    void insert(ProductType pt) throws DAOException;
    void modify(ProductType pt) throws DAOException;
    void delete(ProductType pt) throws DAOException;

    List<ProductType> GetAll() throws DAOException;
    ProductType GetBy(String productType) throws DAOException;
}
