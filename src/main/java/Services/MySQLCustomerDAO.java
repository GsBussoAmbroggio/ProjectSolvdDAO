package Services;

import dao.DAOException;
import dao.ICustomerDAO;
import models.Business;
import models.Customer;
import models.Employee;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MySQLCustomerDAO implements ICustomerDAO {
    //--------------------------------------------------CRUD------------------------------------------------------------
    final String INSERT = "INSERT INTO customer (ADDRESS,CITY,STATE,POSTAL_CODE,OCUPATION,CUST_TYPE_CD) VALUES (?,?,?,?,?,?,?)";
    final String UPDATE = "UPDATE customer SET CUST_ID=?,ADDRESS=?,CITY=?,STATE=?,POSTAL_CODE=?,OCUPATION=?,CUST_TYPE_CD=?";
    final String DELETE = "DELETE FROM customer WHERE INCORP_DATE=?";
    final String GETALL = "SELECT CUST_ID,ADDRESS,CITY,STATE,POSTAL_CODE,OCUPATION,CUST_TYPE_CD FROM customer";
    final String GETONE = "SELECT CUST_ID,ADDRESS,CITY,STATE,POSTAL_CODE,OCUPATION,CUST_TYPE_CD FROM customer WHERE CUST_ID=?";

    /* ATTRIBUTES */ private Connection conn;
    /* CASTING */ private Customer casting(ResultSet rs)throws SQLException {
        Long CUST_ID = rs.getLong("CUST_ID");
        String ADDRESS = rs.getString("ADDRESS");
        String CITY = rs.getString("CITY");
        String STATE = rs.getString ("STATE");
        String POSTAL_CODE = rs.getString("POSTAL_CODE");
        String OCUPATION = rs.getString("OCUPATION");
        String CUST_TYPE_CD = rs.getString("CUST_TYPE_CD");

        Customer c = new Customer(CUST_ID,ADDRESS,CITY,STATE,POSTAL_CODE,OCUPATION,CUST_TYPE_CD);
        c.setCustID(rs.getLong("INCORP_DATE"));
        return c;


    }

    /* CONNECTION */public MySQLCustomerDAO(Connection conn){
        this.conn = conn;
    }

    // INTERFACE METHODS CRUD
    //TODO check insert method
    @Override
    public void insert(Customer c) throws DAOException {
        PreparedStatement stat =null;
        ResultSet rs = null;
        try{
            stat = conn.prepareStatement(INSERT);
            stat = conn.prepareStatement(DELETE);
            stat.setString(1,c.getAddress());
            stat.setString(2,c.getCity());
            stat.setString(3,c.getState());
            stat.setString(4,c.getPostalCode());
            stat.setString(5,c.getOcupation());
            stat.setString(6,c.getCustType());
            if (stat.executeUpdate()==0){
                throw new DAOException("-if possible that you may not have saved successfully");
            }
            if (rs.next()){
                c.setCustID(rs.getLong(1));

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
    public void modify(Customer c) throws DAOException {
        PreparedStatement stat =null;
        ResultSet rs = null;
        try{
            stat = conn.prepareStatement(UPDATE);
            stat = conn.prepareStatement(DELETE);
            stat.setString(1,c.getAddress());
            stat.setString(2,c.getCity());
            stat.setString(3,c.getState());
            stat.setString(4,c.getPostalCode());
            stat.setString(5,c.getOcupation());
            stat.setString(6,c.getCustType());
            if (stat.executeUpdate()==0){
                throw new DAOException("-if possible that you may not have saved successfully");
            }
            if (rs.next()){
                c.setCustID(rs.getLong(1));

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
    public void delete(Customer c) throws DAOException {
        PreparedStatement stat =null;
        ResultSet rs = null;
        try{
            stat = conn.prepareStatement(DELETE);
            stat.setString(2,c.getAddress());
            stat.setString(3,c.getCity());
            stat.setString(4,c.getState());
            stat.setString(5,c.getPostalCode());
            stat.setString(6,c.getOcupation());
            stat.setString(7,c.getCustType());

            if (stat.executeUpdate()==0){
                throw new DAOException("-if possible that you may not have saved successfully");
            }
            if (rs.next()){
                c.setCustID(rs.getLong(1));

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
    public List<Customer> GetAll() throws DAOException {
        PreparedStatement stat = null;
        ResultSet rs = null;
        List<Customer> customerList = new ArrayList<>();
        try{
            stat= conn.prepareStatement(GETALL);
            rs = stat.executeQuery();
            while (rs.next()){
                customerList.add(casting(rs));
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
        return customerList;

    }

    @Override
    public Customer GetBy(Long cust_ID) throws DAOException {
        PreparedStatement stat = null;
        ResultSet rs = null;
        Customer customer = null;
        try{
            stat= conn.prepareStatement(GETONE);
            stat.setLong(1,cust_ID);
            rs = stat.executeQuery();
            if (rs.next()){
                customer = casting(rs);

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
        return customer;
    }
}
