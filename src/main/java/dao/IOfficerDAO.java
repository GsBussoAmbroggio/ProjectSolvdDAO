package dao;
import models.Employee;
import models.Officer;

import java.util.List;

public interface IOfficerDAO extends DAO<Officer,Long>{
    void insert(Officer o) throws DAOException;
    void modify(Officer o) throws DAOException;
    void delete(Officer o) throws DAOException;

    List<Officer> GetAll() throws DAOException;
    Officer GetBy(Long officerID) throws DAOException;
}
