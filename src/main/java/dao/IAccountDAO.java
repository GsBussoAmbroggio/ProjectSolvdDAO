package dao;

import models.Account;
import models.Employee;

import java.util.List;

public interface IAccountDAO extends DAO<Account,Long>{
    void insert(Account e)throws DAOException;
    void modify(Account e)throws DAOException;
    void delete(Account e)throws DAOException;

    List<Account> GetAll()  throws DAOException;
    Account GetBy(Long accountID)throws DAOException;
}
