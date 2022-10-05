package Services;

import dao.DAOException;
import dao.IIndividualDAO;
import models.Department;
import models.Employee;
import models.Individual;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MySQLIndividualDAO implements IIndividualDAO {
    //--------------------------------------------------CRUD------------------------------------------------------------
    final String INSERT = "INSERT INTO individual (BIRTH_DATE,FIRST_NAME,LAST_NAME,customer_CUST_ID) VALUES (?,?,?,?)";
    final String UPDATE = "UPDATE individual SET BIRTH_DATE=?,FIRST_NAME=?,LAST_NAME=?,customer_CUST_ID=?";
    final String DELETE = "DELETE FROM individual WHERE BIRTH_DATE=?";
    final String GETALL = "SELECT BIRTH_DATE,FIRST_NAME,LAST_NAME,customer_CUST_ID FROM individual";
    final String GETONE = "SELECT BIRTH_DATE,FIRST_NAME,LAST_NAME,customer_CUST_ID FROM individual WHERE BIRTH_DATE=?";

    /* ATTRIBUTES */ private Connection conn;
    /* CASTING */ private Individual casting(ResultSet rs)throws SQLException {
        Date BIRTH_DATE = rs.getDate("BIRTH_DATE");
        String FIRST_NAME = rs.getString("FIRST_NAME");
        String LAST_NAME = rs.getString("LAST_NAME");
        Long customer_CUST_ID = rs.getLong("customer_CUST_ID");
        Individual i = new Individual(BIRTH_DATE,FIRST_NAME,LAST_NAME,customer_CUST_ID);
        i.setBirthDate(rs.getDate("BIRTH_DATE"));
        return i;
    }

    /* CONNECTION */public MySQLIndividualDAO(Connection conn){
        this.conn = conn;
    }

    // INTERFACE METHODS CRUD
    //TODO check insert method
    @Override
    public void insert(Individual i) throws DAOException {
        PreparedStatement stat =null;
        ResultSet rs = null;
        try{
            stat = conn.prepareStatement(INSERT);
            stat = conn.prepareStatement(DELETE);
            stat.setString(1,i.getFirstName());
            stat.setString(2,i.getLastName());
            stat.setLong(3, i.getCustID());


            if (stat.executeUpdate()==0){
                throw new DAOException("-if possible that you may not have saved successfully");
            }
            if (rs.next()){
                i.setBirthDate(rs.getDate(1));

            }else{
                throw new DAOException("could not assign an id.");
            }

        }catch (SQLException ex){
            throw new DAOException("Error in SQL", ex);
        } finally {
            if ((stat!=null)){
                try {
                    stat.close();
                }catch (SQLException ex){
                    throw new DAOException("Error in SQL", ex);
                }
            }
        }
    }

    @Override
    public void modify(Individual i) throws DAOException {
        PreparedStatement stat =null;
        ResultSet rs = null;
        try{
            stat = conn.prepareStatement(UPDATE);
            stat = conn.prepareStatement(DELETE);
            stat.setString(1,i.getFirstName());
            stat.setString(2,i.getLastName());
            stat.setLong(3, i.getCustID());

            if (stat.executeUpdate()==0){
                throw new DAOException("-if possible that you may not have saved successfully");
            }
            if (rs.next()){
                i.setBirthDate(rs.getDate(1));

            }else{
                throw new DAOException("could not assign an id.");
            }

        }catch (SQLException ex){
            throw new DAOException("Error in SQL", ex);
        } finally {
            if ((stat!=null)){
                try {
                    stat.close();
                }catch (SQLException ex){
                    throw new DAOException("Error in SQL", ex);
                }
            }
        }
    }

    @Override
    public void delete(Individual i) throws DAOException {
        PreparedStatement stat =null;
        ResultSet rs = null;
        try{
            stat = conn.prepareStatement(DELETE);
            stat.setString(1,i.getFirstName());
            stat.setString(2,i.getLastName());
            stat.setLong(3, i.getCustID());

            if (stat.executeUpdate()==0){
                throw new DAOException("-if possible that you may not have saved successfully");
            }
            if (rs.next()){
                i.setBirthDate(rs.getDate(1));

            }else{
                throw new DAOException("could not assign an id.");
            }

        }catch (SQLException ex){
            throw new DAOException("Error in SQL", ex);
        } finally {
            if ((stat!=null)){
                try {
                    stat.close();
                }catch (SQLException ex){
                    throw new DAOException("Error in SQL", ex);
                }
            }
        }
    }

    // INTERFACE METHODS GETALL & GETBY
    @Override
    public List<Individual> GetAll() throws DAOException {
        PreparedStatement stat = null;
        ResultSet rs = null;
        List<Individual> individualList = new ArrayList<>();
        try{
            stat= conn.prepareStatement(GETALL);
            rs = stat.executeQuery();
            while (rs.next()){
                individualList.add(casting(rs));
            }
        }catch (SQLException ex) {
            throw new DAOException( "ERROR in SQL", ex);

        }finally {
            if(rs!=null){
                try {
                    rs.close();
                }catch (SQLException ex){
                    new DAOException("ERROR in SQL",ex);
                }
                if(stat!=null){
                    try {
                        stat.close();
                    }catch (SQLException ex){
                        new DAOException("ERROR in SQL",ex);
                    }


                }
            }
        }
        return individualList;

    }
    @Override
    public Individual GetBy(Date birthDate) throws DAOException {
        PreparedStatement stat = null;
        ResultSet rs = null;
        Individual individual = null;
        try{
            stat= conn.prepareStatement(GETONE);
            stat.setDate(1, (java.sql.Date) birthDate);
            rs = stat.executeQuery();
            if (rs.next()){
                individual = casting(rs);

            }else {
                throw new DAOException("record not found");
            }
        }catch (SQLException ex) {
            throw new DAOException( "ERROR in SQL", ex);

        }finally {
            if(rs!=null){
                try {
                    rs.close();
                }catch (SQLException ex){
                    new DAOException("ERROR in SQL",ex);
                }
                if(stat!=null){
                    try {
                        stat.close();
                    }catch (SQLException ex){
                        new DAOException("ERROR in SQL",ex);
                    }


                }
            }
        }
        return individual;
    }
    }
