package dao;

import java.util.List;

public interface DAO<T> {
    void insert(T e) throws DAOException;
    void modify(T e) throws DAOException;
    void delete(T e) throws DAOException;
    List<T> GetAll() throws DAOException;
    T GetBy(Long id) throws DAOException;

}
