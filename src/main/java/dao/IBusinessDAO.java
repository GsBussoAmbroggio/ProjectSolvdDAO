package dao;
import models.Business;
import models.Employee;

import java.util.List;

public interface IBusinessDAO extends DAO<Business,Long>{
    void insert(Business b)throws DAOException;
    void modify(Business b)throws DAOException;
    void delete(Business b)throws DAOException;

    List<Business> GetAll()throws DAOException;
    Business GetBy(Long ID)throws DAOException;
}
