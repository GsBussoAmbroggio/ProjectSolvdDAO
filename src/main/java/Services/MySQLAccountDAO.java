package Services;

import dao.DAOException;
import dao.IAccountDAO;
import models.Account;
import models.Employee;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MySQLAccountDAO implements IAccountDAO {

    //--------------------------------------------------CRUD------------------------------------------------------------
    final String INSERT = "INSERT INTO account (AVAIL_BALANCE,PENDING_BALANCE,STATUS,OPEN_DATE," +
            "LAST_ACTIVITY_DATE,CLOSE_DATE,customer_CUST_ID,branch_BRANCH_ID,employee_EMP_ID,product_PRODUCT_CD) VALUES(?,?,?,?,?,?,?,?,?,?)";
    final String UPDATE = "UPDATE account SET ACCOUNT_ID=?,AVAIL_BALANCE=?,PENDING_BALANCE=?,STATUS=?,OPEN_DATE=?" +
            ",LAST_ACTIVITY_DATE=?,CLOSE_DATE=?,customer_CUST_ID=?,branch_BRANCH_ID=?,employee_EMP_ID=?,product_PRODUCT_CD=?";
    final String DELETE = "DELETE FROM account WHERE ACCOUNT_ID=?";
    final String GETALL = "SELECT ACCOUNT_ID,AVAIL_BALANCE,PENDING_BALANCE,STATUS,OPEN_DATE,LAST_ACTIVITY_DATE," +
            "CLOSE_DATE,customer_CUST_ID,branch_BRANCH_ID,employee_EMP_ID,product_PRODUCT_CD FROM account";
    final String GETONE = "SELECT ACCOUNT_ID,AVAIL_BALANCE,PENDING_BALANCE,STATUS,OPEN_DATE,LAST_ACTIVITY_DATE," +
            "CLOSE_DATE,customer_CUST_ID,branch_BRANCH_ID,employee_EMP_ID,product_PRODUCT_CD FROM account WHERE ACCOUNT_ID = ?";

    /* ATTRIBUTES */ private Connection conn;
    /* CASTING */ private Account casting(ResultSet rs)throws SQLException{
        Long ACCOUNT_ID = rs.getLong("ACCOUNT_ID");
        Double AVAIL_BALANCE = rs.getDouble("AVAIL_BALANCE");
        Double PENDING_BALANCE = rs.getDouble("PENDING_BALANCE");
        String STATUS = rs.getString("STATUS");
        Date OPEN_DATE = rs.getDate("OPEN_DATE");
        Date LAST_ACTIVITY = rs.getDate("LAST_ACTIVITY");
        Date CLOSE_DATE = rs.getDate("CLOSE_DATE");
        Long CUST_ID = rs.getLong("CUST_ID");
        Long BRANCH_ID = rs.getLong("BRANCH_ID");
        Long EMP_ID = rs.getLong("EMP_ID");
        String PRODUCT_CD = rs.getString("PRODUCT_CD");
        Account account = new Account(ACCOUNT_ID,AVAIL_BALANCE,PENDING_BALANCE,STATUS,OPEN_DATE,LAST_ACTIVITY,CLOSE_DATE,CUST_ID,BRANCH_ID,EMP_ID,PRODUCT_CD);
        account.setAccountID(rs.getLong("ACCOUNT_ID"));
        return account;



    }

    /* CONNECTION */public MySQLAccountDAO(Connection conn){
        this.conn = conn;
    }

    // INTERFACE METHODS CRUD
    @Override
    public void insert(Account e) throws DAOException{
        PreparedStatement stat =null;
        ResultSet rs = null;
        try{
            stat = conn.prepareStatement(INSERT);

            stat.setDouble(1,e.getAvailBalance());
            stat.setDouble(2,e.getPendingBalance());
            stat.setString(3,e.getStatus());
            stat.setDate(4, new Date(e.getOpenDate().getTime()));
            stat.setDate(5,new Date(e.getLastActivity().getTime()));
            stat.setDate(6,new Date(e.getCloseDate().getTime()));
            stat.setLong(7,e.getCustID());
            stat.setLong(8,e.getBranchID());
            stat.setLong(9,e.getEmpID());
            stat.setString(10,e.getProductCD());
            if (stat.executeUpdate()==0){
                throw new DAOException("-if possible that you may not have saved successfully");
            }
            if (rs.next()){
                e.setAccountID(rs.getLong(1));

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
    public void modify(Account e) throws DAOException {
        PreparedStatement stat =null;
        ResultSet rs = null;
        try{
            stat = conn.prepareStatement(UPDATE);
            stat.setDouble(1,e.getAvailBalance());
            stat.setDouble(2,e.getPendingBalance());
            stat.setString(3,e.getStatus());
            stat.setDate(4, new Date(e.getOpenDate().getTime()));
            stat.setDate(5,new Date(e.getLastActivity().getTime()));
            stat.setDate(6,new Date(e.getCloseDate().getTime()));
            stat.setLong(7,e.getCustID());
            stat.setLong(8,e.getBranchID());
            stat.setLong(9,e.getEmpID());
            stat.setString(10,e.getProductCD());
            if (stat.executeUpdate()==0){
                throw new DAOException("-if possible that you may not have saved successfully");
            }
            if (rs.next()){
                e.setAccountID(rs.getLong(1));

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
    public void delete(Account e) throws DAOException {
        PreparedStatement stat =null;
        ResultSet rs = null;
        try{
            stat = conn.prepareStatement(DELETE);
            stat.setDouble(1,e.getAvailBalance());
            stat.setDouble(2,e.getPendingBalance());
            stat.setString(3,e.getStatus());
            stat.setDate(4, new Date(e.getOpenDate().getTime()));
            stat.setDate(5,new Date(e.getLastActivity().getTime()));
            stat.setDate(6,new Date(e.getCloseDate().getTime()));
            stat.setLong(7,e.getCustID());
            stat.setLong(8,e.getBranchID());
            stat.setLong(9,e.getEmpID());
            stat.setString(10,e.getProductCD());
            if (stat.executeUpdate()==0){
                throw new DAOException("-if possible that you may not have saved successfully");

            }
            if (rs.next()){
                e.setAccountID(rs.getLong(1));

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
    public List<Account> GetAll() throws DAOException {
        PreparedStatement stat = null;
        ResultSet rs = null;
        List<Account> a = new ArrayList<>();
        try{
            stat= conn.prepareStatement(GETALL);
            rs = stat.executeQuery();
            while (rs.next()){
                a.add(casting(rs));
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
        return a;

    }

    @Override
    public Account GetBy(Long accountID) throws DAOException {
    PreparedStatement stat = null;
    ResultSet rs = null;
    Account a = null;
    try{
        stat= conn.prepareStatement(GETONE);
        stat.setLong(1,accountID);
        rs = stat.executeQuery();
        if (rs.next()){
            a = casting(rs);

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
        return a;
    }
}

