package dao;

import models.Account_trans;

import java.util.List;

public interface IAccount_transDAO extends DAO<Account_trans,Long> {
    void insert(Account_trans at) throws DAOException;
    void modify(Account_trans at) throws DAOException;
    void delete(Account_trans at) throws DAOException;

    List<Account_trans> GetAll() throws DAOException;
    Account_trans GetBy(Long txnID) throws DAOException;
}
