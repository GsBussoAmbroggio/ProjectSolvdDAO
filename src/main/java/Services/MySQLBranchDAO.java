package Services;

import dao.DAOException;
import dao.IBranchDAO;
import models.Account;
import models.Branch;
import models.Employee;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MySQLBranchDAO implements IBranchDAO {
    //--------------------------------------------------CRUD------------------------------------------------------------
    final String INSERT = "INSERT INTO branch (BRANCH_ID,ADDRESS,NAME,CITY,STATE,ZIP_CODE) VALUES (?,?,?,?,?,?)";
    final String UPDATE = "UPDATE branch SET BRANCH_ID=?,ADDRESS=?,NAME=?,CITY=?,STATE=?,ZIP_CODE=?";
    final String DELETE = "DELETE FROM branch WHERE BRANCH_ID=?";
    final String GETALL = "SELECT BRANCH_ID,ADDRESS,NAME,CITY,STATE,ZIP_CODE FROM branch";
    final String GETONE = "SELECT BRANCH_ID,ADDRESS,NAME,CITY,STATE,ZIP_CODE FROM branch WHERE BRANCH_ID = ?";

    /* ATTRIBUTES */ private Connection conn;
    /* CASTING */ private Branch casting(ResultSet rs)throws SQLException{
        Long BRANCH_ID = rs.getLong("BRANCH_ID");
        String ADDRESS = rs.getString("ADDRESS");
        String NAME = rs.getString("NAME");
        String CITY = rs.getString("CITY");
        String STATE = rs.getString("STATE");
        String ZIP_CODE = rs.getString("ZIP_CODE");

        Branch branch = new Branch(BRANCH_ID,ADDRESS,NAME,CITY,STATE,ZIP_CODE);
        branch.setBranchID((rs.getLong("BRANCH_ID")));
        return branch;


    }

    /* CONNECTION */public MySQLBranchDAO(Connection conn){
        this.conn = conn;
    }

    // INTERFACE METHODS CRUD
    @Override
    public void insert(Branch e) throws DAOException{
        PreparedStatement stat =null;
        ResultSet rs = null;
        try{
            stat = conn.prepareStatement(INSERT);
            stat = conn.prepareStatement(DELETE);
            stat.setLong(1,e.getBranchID());
            stat.setString(2,e.getAddress());
            stat.setString(3,e.getName());
            stat.setString(4,e.getCity());
            stat.setString(5, e.getState());
            stat.setString(6,e.getZipCode());
            if (stat.executeUpdate()==0){
                throw new DAOException("-if possible that you may not have saved successfully");
            }
            if (rs.next()){
                e.setBranchID(rs.getLong(1));

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
    public void modify(Branch e) throws DAOException {
        PreparedStatement stat =null;
        ResultSet rs = null;
        try{
            stat = conn.prepareStatement(UPDATE);
            stat = conn.prepareStatement(DELETE);
            stat.setLong(1,e.getBranchID());
            stat.setString(2,e.getAddress());
            stat.setString(3,e.getName());
            stat.setString(4,e.getCity());
            stat.setString(5, e.getState());
            stat.setString(6,e.getZipCode());
            if (stat.executeUpdate()==0){
                throw new DAOException("-if possible that you may not have saved successfully");
            }
            if (rs.next()){
                e.setBranchID(rs.getLong(1));

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
    public void delete(Branch e) throws DAOException {
        PreparedStatement stat =null;
        ResultSet rs = null;
        try{
            stat = conn.prepareStatement(DELETE);
            stat.setLong(1,e.getBranchID());
            stat.setString(2,e.getAddress());
            stat.setString(3,e.getName());
            stat.setString(4,e.getCity());
            stat.setString(5, e.getState());
            stat.setString(6,e.getZipCode());

            if (stat.executeUpdate()==0){
                throw new DAOException("-if possible that you may not have saved successfully");
            }
            if (rs.next()){
                e.setBranchID(rs.getLong(1));

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
    public List<Branch> GetAll() throws DAOException {
        PreparedStatement stat = null;
        ResultSet rs = null;
        List<Branch> branches = new ArrayList<>();
        try{
            stat= conn.prepareStatement(GETALL);
            rs = stat.executeQuery();
            while (rs.next()){
                branches.add(casting(rs));
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
        return branches;

    }

    @Override
    public Branch GetBy(Long accountID) throws DAOException {
        PreparedStatement stat = null;
        ResultSet rs = null;
        Branch branch = null;
        try{
            stat= conn.prepareStatement(GETONE);
            stat.setLong(1,accountID);
            rs = stat.executeQuery();
            if (rs.next()){
                branch = casting(rs);

            }else {
                throw new DAOException("record not found");
            }
            if (rs.next()){
                branch.setBranchID(rs.getLong(1));

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
        return branch;
    }
}
