package dao;
import models.Department;
import models.Employee;

import java.util.List;

public interface IDepartmentDAO extends DAO<Department,Long>{
    void insert(Department d)throws DAOException;
    void modify(Department d)throws DAOException;
    void delete(Department d)throws DAOException;

    List<Department> GetAll()throws DAOException;
    Department GetBy(Long ID)throws DAOException;
}
