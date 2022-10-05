package Services;

import dao.DAOException;
import dao.IOfficerDAO;
import models.Employee;
import models.Officer;
import models.ProductType;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MySQLOfficerDAO implements IOfficerDAO {
    final String INSERT = "INSERT INTO officer (OFFICER_ID,END_DATE,FIRST_NAME,LAST_NAME,START_DATE,TITLE,CUST_ID) VALUES (?,?,?,?,?,?,?)";
    final String UPDATE = "UPDATE officer SET OFFICER_ID=?,END_DATE=?,FIRST_NAME=?LAST_NAME=?,START_DATE=?,TITLE=?,CUST_ID=?";
    final String DELETE = "DELETE FROM officer WHERE PRODUCT_TYPE_CD=?";
    final String GETALL = "SELECT OFFICER_ID,END_DATE,FIRST_NAME,LAST_NAME,START_DATE,TITLE,CUST_ID FROM officer";
    final String GETONE = "SELECT OFFICER_ID,END_DATE,FIRST_NAME,LAST_NAME,START_DATE,TITLE,CUST_ID FROM officer WHERE OFFICER_ID=?";

    /* ATTRIBUTES */ private Connection conn;
    /* CASTING */ private Officer casting(ResultSet rs)throws SQLException {
        Long OFFICER_ID = rs.getLong("OFFICER_ID");
        Date END_DATE = rs.getDate("END_DATE");
        String FIRST_NAME = rs.getString("FIRST_NAME");
        String LAST_NAME = rs.getString("LAST_NAME");
        Date START_DATE = rs.getDate("START_DATE");
        String TITLE = rs.getString("TITLE");
        Long CUST_ID = rs.getLong("CUST_ID");
        Officer o = new Officer (OFFICER_ID,END_DATE,FIRST_NAME,LAST_NAME,START_DATE,TITLE,CUST_ID);
        o.setOfficerID(rs.getLong("OFFICER_ID"));
        return o;
    }

    /* CONNECTION */public MySQLOfficerDAO(Connection conn){
        this.conn = conn;
    }

    // INTERFACE METHODS CRUD
    //TODO check insert method
    @Override
    public void insert(Officer o) throws DAOException {
        PreparedStatement stat =null;
        ResultSet rs = null;
        try{
            stat = conn.prepareStatement(INSERT);
            stat = conn.prepareStatement(DELETE);
            stat.setDate(1, (java.sql.Date) o.getEndDate());
            stat.setString(2,o.getFirstName());
            stat.setString(3,o.getLastName());
            stat.setDate(4, (java.sql.Date) o.getStartDate());
            stat.setString(5,o.getTitle());
            stat.setLong(6,o.getCustID());
            if (stat.executeUpdate()==0){
                throw new DAOException("-if possible that you may not have saved successfully");
            }
            if (rs.next()){
                o.setOfficerID(rs.getLong(1));

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
    //TODO data set
    @Override
    public void modify(Officer o) throws DAOException {
        PreparedStatement stat =null;
        ResultSet rs = null;
        try{
            stat = conn.prepareStatement(UPDATE);
            stat = conn.prepareStatement(DELETE);
            stat.setDate(1, (java.sql.Date) o.getEndDate());
            stat.setString(2,o.getFirstName());
            stat.setString(3,o.getLastName());
            stat.setDate(4, (java.sql.Date) o.getStartDate());
            stat.setString(5,o.getTitle());
            stat.setLong(6,o.getCustID());
            if (stat.executeUpdate()==0){
                throw new DAOException("-if possible that you may not have saved successfully");
            }
            if (rs.next()){
                o.setOfficerID(rs.getLong(1));

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
    //TODO data set
    @Override
    public void delete(Officer o) throws DAOException {
        PreparedStatement stat =null;
        ResultSet rs = null;
        try{
            stat = conn.prepareStatement(DELETE);
            stat.setDate(1, (java.sql.Date) o.getEndDate());
            stat.setString(2,o.getFirstName());
            stat.setString(3,o.getLastName());
            stat.setDate(4, (java.sql.Date) o.getStartDate());
            stat.setString(5,o.getTitle());
            stat.setLong(6,o.getCustID());
            if (stat.executeUpdate()==0){
                throw new DAOException("-if possible that you may not have saved successfully");
            }
            if (rs.next()){
                o.setOfficerID(rs.getLong(1));

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
    public List<Officer> GetAll() throws DAOException {
        PreparedStatement stat = null;
        ResultSet rs = null;
        List<Officer> officersList = new ArrayList<>();
        try{
            stat= conn.prepareStatement(GETALL);
            rs = stat.executeQuery();
            while (rs.next()){
                officersList.add(casting(rs));
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
        return officersList;

    }

    @Override
    public Officer GetBy(Long officerID) throws DAOException {
        PreparedStatement stat = null;
        ResultSet rs = null;
        Officer officer = null;
        try{
            stat= conn.prepareStatement(GETONE);
            stat.setLong(1, officer.getOfficerID());
            rs = stat.executeQuery();
            if (rs.next()){
                officer = casting(rs);

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
        return officer;
    }
}