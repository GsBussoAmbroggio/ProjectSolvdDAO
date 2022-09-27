package dao;

import models.Employee;

import java.util.List;

public interface IEmployeeDAO extends DAO<Employee, Long> {
    void insert(Employee emp) throws DAOException;
    void modify(Employee emp) throws DAOException;
    void delete(Employee emp) throws DAOException;

    List<Employee> GetAll() throws DAOException;
    Employee GetBy(Long ID) throws DAOException;

}
