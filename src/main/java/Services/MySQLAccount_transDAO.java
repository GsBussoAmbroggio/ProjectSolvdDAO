package Services;

import dao.DAOException;
import dao.IAccount_transDAO;
import models.Account_trans;
import models.Customer;
import models.Employee;

import java.sql.*;

import java.util.ArrayList;
import java.util.List;

public class MySQLAccount_transDAO implements IAccount_transDAO {



    //--------------------------------------------------CRUD------------------------------------------------------------
    final String INSERT = "INSERT INTO account_trans (AMOUNT,FUNDS_AVAIL_DATE,TXN_DATE,TXN_TYPE_CD,ACCOUNT_ID,EXECUTION_BRANCH_ID,TELLER_EMP_ID) VALUES (?,?,?,?,?,?)";
    final String UPDATE = "UPDATE account_trans SET TXN_ID,AMOUNT=?,FUNDS_AVAIL_DATE=?,TXN_DATE=?,TXN_TYPE_CD=?,ACCOUNT_ID=?,EXECUTION_BRANCH_ID=?,TELLER_EMP_ID=?";
    final String DELETE = "DELETE FROM account_trans WHERE INCORP_DATE=?";
    final String GETALL = "SELECT TXN_ID,AMOUNT,FUNDS_AVAIL_DATE,TXN_DATE,TXN_TYPE_CD,ACCOUNT_ID,EXECUTION_BRANCH_ID,TELLER_EMP_ID FROM account_trans";
    final String GETONE = "SELECT TXN_ID,AMOUNT,FUNDS_AVAIL_DATE,TXN_DATE,TXN_TYPE_CD,ACCOUNT_ID," +
                          "EXECUTION_BRANCH_ID,TELLER_EMP_ID FROM account_trans WHERE TXN_ID=?";

    /* ATTRIBUTES */ private Connection conn;
    /* CASTING */ private Account_trans casting(ResultSet rs)throws SQLException {
        Long TXN_ID = rs.getLong("TXN_ID");
        Double AMOUNT = rs.getDouble("AMOUNT");
        Date FUNDS_AVAIL_DATE = rs.getDate("FUNDS_AVAIL_DATE");
        Date TXN_DATE = rs.getDate ("TXN_DATE");
        String TXN_TYPE_CD = rs.getString("TXN_TYPE_CD");
        Long ACCOUNT_ID = rs.getLong("ACCOUNT_ID");
        Long EXECUTION_BRANCH_ID = rs.getLong("EXECUTION_BRANCH_ID");
        Long TELLER_EMP_ID = rs.getLong("TELLER_EMP_ID");

        Account_trans at = new Account_trans(TXN_ID,AMOUNT,FUNDS_AVAIL_DATE,TXN_DATE,TXN_TYPE_CD,ACCOUNT_ID,EXECUTION_BRANCH_ID,TELLER_EMP_ID);
        at.setTxnID(rs.getLong("TXN_ID"));
        return at;


    }

    /* CONNECTION */public MySQLAccount_transDAO(Connection conn){
        this.conn = conn;
    }

    // INTERFACE METHODS CRUD
    //TODO check insert method
    @Override
    public void insert(Account_trans at) throws DAOException {
        PreparedStatement stat =null;
        ResultSet rs = null;
        try{
            stat = conn.prepareStatement(INSERT);
            stat = conn.prepareStatement(DELETE);
            stat.setDouble(1,at.getAmount());
            stat.setDate(2, new Date(at.getFundsAvailDate().getTime()));
            stat.setDate(3,new Date(at.getTxnDate().getTime()));
            stat.setString(4,at.getTxnTypeCD());
            stat.setLong(5,at.getAccountID());
            stat.setLong(6,at.getExecutionBranchID());
            stat.setLong(7,at.getTellerEmpID());
            if (stat.executeUpdate()==0){
                throw new DAOException("-if possible that you may not have saved successfully");
            }
            rs = stat.getGeneratedKeys();
            if (rs.next()){
                at.setTxnID(rs.getLong(1));

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
    public void modify(Account_trans at) throws DAOException {
        PreparedStatement stat =null;
        ResultSet rs = null;
        try{
            stat = conn.prepareStatement(UPDATE);
            stat = conn.prepareStatement(DELETE);
            stat.setDouble(1,at.getAmount());
            stat.setDate(2, new Date(at.getFundsAvailDate().getTime()));
            stat.setDate(3,new Date(at.getTxnDate().getTime()));
            stat.setString(4,at.getTxnTypeCD());
            stat.setLong(5,at.getAccountID());
            stat.setLong(6,at.getExecutionBranchID());
            stat.setLong(7,at.getTellerEmpID());
            if (stat.executeUpdate()==0){
                throw new DAOException("-if possible that you may not have saved successfully");
            }
            if (rs.next()){
                at.setTxnID(rs.getLong(1));

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
    public void delete(Account_trans at) throws DAOException {
        PreparedStatement stat =null;
        ResultSet rs = null;
        try{
            stat = conn.prepareStatement(DELETE);
            stat.setDouble(1,at.getAmount());
            stat.setDate(2, new Date(at.getFundsAvailDate().getTime()));
            stat.setDate(3,new Date(at.getTxnDate().getTime()));
            stat.setString(4,at.getTxnTypeCD());
            stat.setLong(5,at.getAccountID());
            stat.setLong(6,at.getExecutionBranchID());
            stat.setLong(7,at.getTellerEmpID());

            if (stat.executeUpdate()==0){
                throw new DAOException("-if possible that you may not have saved successfully");
            }
            rs = stat.getGeneratedKeys();
            if (rs.next()){
                at.setTxnID(rs.getLong(1));

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
    public List<Account_trans> GetAll() throws DAOException {
        PreparedStatement stat = null;
        ResultSet rs = null;
        List<Account_trans> atList = new ArrayList<>();
        try{
            stat= conn.prepareStatement(GETALL);
            rs = stat.executeQuery();
            while (rs.next()){
                atList.add(casting(rs));
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
        return atList;

    }

    @Override
    public Account_trans GetBy(Long  txnID) throws DAOException {
        PreparedStatement stat = null;
        ResultSet rs = null;
        Account_trans at = null;
        try{
            stat= conn.prepareStatement(GETONE);
            stat.setLong(1,txnID);
            rs = stat.executeQuery();
            if (rs.next()){
                at = casting(rs);

            }else {
                throw new DAOException("record not found");
            }
            rs = stat.getGeneratedKeys();
            if (rs.next()){
                at.setTxnID(rs.getLong(1));

            }else{
                throw new DAOException("could not assign an id.");
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
        return at;
    }
}

