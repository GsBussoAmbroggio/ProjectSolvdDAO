package dao;

import models.Account;
import models.Employee;
import models.Individual;

import java.util.Date;
import java.util.List;

public interface IIndividualDAO extends DAO<Individual,Date>{

    void insert(Individual i)throws DAOException;

    void modify(Individual i)throws DAOException;

    void delete(Individual i)throws DAOException;

    List<Individual> GetAll()  throws DAOException;
    Individual GetBy(Date birthDate)throws DAOException;
}
