package dao;
import models.Customer;
import models.Employee;

import java.util.List;

public interface ICustomerDAO extends DAO<Customer,Long>{
    void insert(Customer c) throws DAOException;
    void modify(Customer c) throws DAOException;
    void delete(Customer c) throws DAOException;

    List<Customer> GetAll() throws DAOException;
    Customer GetBy(Long cust_ID) throws DAOException;
}
