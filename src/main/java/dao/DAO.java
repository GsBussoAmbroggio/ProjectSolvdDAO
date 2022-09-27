package dao;

import models.Employee;

import java.util.List;

public interface DAO<T,K> {
    void insert(T e) throws DAOException;
    void modify(T e) throws DAOException;
    void delete(T e) throws DAOException;

    List<T> GetAll() throws DAOException;
    T GetBy(K T) throws DAOException;

}
