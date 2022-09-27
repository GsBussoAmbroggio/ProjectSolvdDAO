package dao;

import models.Branch;
import models.Employee;

import java.util.List;

public interface IBranchDAO extends DAO<Branch,Long>{
    void insert(Branch branch) throws DAOException;
    void modify(Branch branch) throws DAOException;
    void delete(Branch branch) throws DAOException;

    List<Branch> GetAll()throws DAOException;
    Branch GetBy(Long ID)throws DAOException;
}
