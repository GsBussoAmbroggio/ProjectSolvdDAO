package Services;

import dao.DAOException;
import dao.IDepartmentDAO;
import models.Customer;
import models.Department;
import models.Employee;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MySQLDepartmentDAO implements IDepartmentDAO {
    //--------------------------------------------------CRUD------------------------------------------------------------
    final String INSERT = "INSERT INTO departament (NAME) VALUES (?,?)";
    final String UPDATE = "UPDATE departament SET DEPT_ID=?,NAME=?";
    final String DELETE = "DELETE FROM departament WHERE DEPT_ID=?";
    final String GETALL = "SELECT DEPT_ID,NAME FROM departament";
    final String GETONE = "SELECT DEPT_ID,NAME FROM departament WHERE DEPT_ID=?";

    /* ATTRIBUTES */ private Connection conn;
    /* CASTING */ private Department casting(ResultSet rs)throws SQLException {
        Long DEPT_ID = rs.getLong("DEPT_ID");
        String NAME = rs.getString("NAME");
        Department d = new Department(DEPT_ID,NAME);
        d.setID(rs.getLong("DEPT_ID"));
        return d;
    }

    /* CONNECTION */public MySQLDepartmentDAO(Connection conn){
        this.conn = conn;
    }

    // INTERFACE METHODS CRUD
    //TODO check insert method
    @Override
    public void insert(Department d) throws DAOException {
        PreparedStatement stat =null;
        ResultSet rs = null;
        try{
            stat = conn.prepareStatement(INSERT);
            stat = conn.prepareStatement(DELETE);
            stat.setString(1,d.getName());

            if (stat.executeUpdate()==0){
                throw new DAOException("-if possible that you may not have saved successfully");
            }
            if (rs.next()){
                d.setID(rs.getLong(1));

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
    public void modify(Department d) throws DAOException {
        PreparedStatement stat =null;
        ResultSet rs = null;
        try{
            stat = conn.prepareStatement(UPDATE);
            stat = conn.prepareStatement(DELETE);
            stat.setLong(1, d.getID());
            stat.setString(2,d.getName());
            if (stat.executeUpdate()==0){
                throw new DAOException("-if possible that you may not have saved successfully");
            }
            if (rs.next()){
                d.setID(rs.getLong(1));

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
    public void delete(Department d) throws DAOException {
        PreparedStatement stat =null;
        ResultSet rs = null;
        try{
            stat = conn.prepareStatement(DELETE);
            stat.setLong(1, d.getID());
            stat.setString(2,d.getName());
            if (stat.executeUpdate()==0){
                throw new DAOException("-if possible that you may not have saved successfully");
            }
            if (rs.next()){
                d.setID(rs.getLong(1));

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
    public List<Department> GetAll() throws DAOException {
        PreparedStatement stat = null;
        ResultSet rs = null;
        List<Department> departmentList = new ArrayList<>();
        try{
            stat= conn.prepareStatement(GETALL);
            rs = stat.executeQuery();
            while (rs.next()){
                departmentList.add(casting(rs));
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
        return departmentList;

    }

    @Override
    public Department GetBy(Long ID) throws DAOException {
        PreparedStatement stat = null;
        ResultSet rs = null;
        Department department = null;
        try{
            stat= conn.prepareStatement(GETONE);
            stat.setLong(1,ID);
            rs = stat.executeQuery();
            if (rs.next()){
                 department = casting(rs);

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
        return department;
    }
}
