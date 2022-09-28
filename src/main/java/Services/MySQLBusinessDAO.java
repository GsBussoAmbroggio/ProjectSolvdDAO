package Services;

import dao.DAO;
import dao.DAOException;
import dao.IBusinessDAO;
import models.Branch;
import models.Business;
import models.Employee;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MySQLBusinessDAO implements IBusinessDAO {
    //--------------------------------------------------CRUD------------------------------------------------------------
    final String INSERT = "INSERT INTO business (INCORP_DATE,NAME,STATE_ID,customer_CUST_ID) VALUES (?,?,?,?)";
    final String UPDATE = "UPDATE business SET INCORP_DATE=?,NAME=?,STATE_ID=?,customer_CUST_ID=?";
    final String DELETE = "DELETE FROM business WHERE INCORP_DATE=?";
    final String GETALL = "SELECT INCORP_DATE,NAME,STATE_ID,customer_CUST_ID FROM business";
    final String GETONE = "SELECT INCORP_DATE,NAME,STATE_ID,customer_CUST_ID FROM business WHERE INCORP_DATE=?";

    /* ATTRIBUTES */ private Connection conn;
    /* CASTING */ private Business casting(ResultSet rs)throws SQLException {
        Date INCORP_DATE = rs.getDate("INCORP_DATE");
        String NAME = rs.getString("NAME");
        String STATE_ID = rs.getString("STATE_ID");
        Long customer_CUST_ID = rs.getLong("customer_CUST_ID");
        Business b = new Business(INCORP_DATE,NAME,STATE_ID,customer_CUST_ID);
        b.setIncorpDate((rs.getDate("INCORP_DATE")));
        return b;
    }

    /* CONNECTION */public MySQLBusinessDAO(Connection conn){
        this.conn = conn;
    }

    // INTERFACE METHODS CRUD
    //TODO check insert method
    @Override
    public void insert(Business b) throws DAOException {
        PreparedStatement stat =null;
        try{
            stat = conn.prepareStatement(INSERT);
            stat = conn.prepareStatement(DELETE);
            stat.setDate(1, (Date) b.getIncorpDate());
            stat.setString(2,b.getName());
            stat.setString(3,b.getState());
            stat.setLong(4,b.getCustID());
            if (stat.executeUpdate()==0){
                throw new DAOException("-if possible that you may not have saved successfully");
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
    public void modify(Business b) throws DAOException {
        PreparedStatement stat =null;
        try{
            stat = conn.prepareStatement(UPDATE);
            stat = conn.prepareStatement(DELETE);
            stat.setDate(1, (Date) b.getIncorpDate());
            stat.setString(2,b.getName());
            stat.setString(3,b.getState());
            stat.setLong(4,b.getCustID());
            if (stat.executeUpdate()==0){
                throw new DAOException("-if possible that you may not have saved successfully");
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
    public void delete(Business b) throws DAOException {
        PreparedStatement stat =null;
        try{
            stat = conn.prepareStatement(DELETE);
            stat.setDate(1, (Date) b.getIncorpDate());
            stat.setString(2,b.getName());
            stat.setString(3,b.getState());
            stat.setLong(4,b.getCustID());

            if (stat.executeUpdate()==0){
                throw new DAOException("-if possible that you may not have saved successfully");
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
    public List<Business> GetAll() throws DAOException {
        PreparedStatement stat = null;
        ResultSet rs = null;
        List<Business> businessList = new ArrayList<>();
        try{
            stat= conn.prepareStatement(GETALL);
            rs = stat.executeQuery();
            while (rs.next()){
                businessList.add(casting(rs));
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
        return businessList;

    }

    @Override
    public Business GetBy(Long accountID) throws DAOException {
        PreparedStatement stat = null;
        ResultSet rs = null;
        Business business = null;
        try{
            stat= conn.prepareStatement(GETONE);
            stat.setLong(1,accountID);
            rs = stat.executeQuery();
            if (rs.next()){
                business = casting(rs);

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
        return business;
    }
}
