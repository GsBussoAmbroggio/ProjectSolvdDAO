package Services;

import dao.DAOException;
import dao.IEmployeeDAO;
import models.Account_trans;
import models.Employee;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MySQLEmployeeDAO implements IEmployeeDAO {
    //--------------------------------------------------CRUD------------------------------------------------------------
    final String INSERT = "INSERT INTO employee (EMP_ID,FIRST_NAME,LAST_NAME,START_DATE,END_DATE,TITLE,ASSIGNED_BRANCH_ID,DEPT_ID,SUPERIOR_EMP_ID) VALUES (?,?,?,?,?,?,?,?,?)";
    final String UPDATE = "UPDATE employee SET EMP_ID=?,FIRST_NAME=?,LAST_NAME=?,START_DATE=?,END_DATE=?,TITLE=?,ASSIGNED_BRANCH_ID=?,DEPT_ID=?,SUPERIOR_EMP_ID=?";
    final String DELETE = "DELETE FROM employee WHERE EMP_ID=?";
    final String GETALL = "SELECT EMP_ID,FIRST_NAME,LAST_NAME,START_DATE,END_DATE,TITLE,ASSIGNED_BRANCH_ID,DEPT_ID,SUPERIOR_EMP_ID FROM employee";
    final String GETONE = "SELECT EMP_ID,FIRST_NAME,LAST_NAME,START_DATE,END_DATE,TITLE,ASSIGNED_BRANCH_ID,DEPT_ID,SUPERIOR_EMP_ID FROM employee WHERE EMP_ID=?";

    /* ATTRIBUTES */ private Connection conn;
    /* CASTING */ private Employee casting(ResultSet rs)throws SQLException {
        Long EMP_ID = rs.getLong("EMP_ID=?");
        String FIRST_NAME = rs.getString("FIRST_NAME");
        String LAST_NAME = rs.getString("LAST_NAME");
        Date START_DATE = rs.getDate ("START_DATE");
        Date END_DATE = rs.getDate("END_DATE");
        String TITLE = rs.getString("TITLE");
        Long ASSIGNED_BRANCH_ID = rs.getLong("ASSIGNED_BRANCH_ID");
        Long DEPT_ID = rs.getLong("DEPT_ID");
        Long SUPERIOR_EMP_ID = rs.getLong("SUPERIOR_EMP_ID");

        Employee emp = new Employee(EMP_ID,FIRST_NAME,LAST_NAME,START_DATE,END_DATE,TITLE,ASSIGNED_BRANCH_ID,DEPT_ID,SUPERIOR_EMP_ID);
        emp.setID(rs.getLong("EMP_ID=?"));
        return emp;
    }

    /* CONNECTION */public MySQLEmployeeDAO(Connection conn){
        this.conn = conn;
    }

    // INTERFACE METHODS CRUD
    //TODO check insert method
    @Override
    public void insert(Employee emp) throws DAOException {
        PreparedStatement stat =null;
        try{
            stat = conn.prepareStatement(INSERT);
            stat = conn.prepareStatement(DELETE);
            stat.setLong(1,emp.getID());
            stat.setString(2,emp.getFirstName());
            stat.setString(3,emp.getLastName());
            stat.setDate(4, new Date(emp.getStartDate().getTime()));
            stat.setDate(5,new Date(emp.getEndDate().getTime()));
            stat.setString(6,emp.getTitle());
            stat.setLong(7,emp.getAssignedBranchID());
            stat.setLong(8, emp.getDeptID());
            stat.setLong(9, emp.getSuperiorEmpID());
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
    public void modify(Employee emp) throws DAOException {
        PreparedStatement stat =null;
        try{
            stat = conn.prepareStatement(UPDATE);
            stat = conn.prepareStatement(DELETE);
            stat.setLong(1,emp.getID());
            stat.setString(2,emp.getFirstName());
            stat.setString(3,emp.getLastName());
            stat.setDate(4, new Date(emp.getStartDate().getTime()));
            stat.setDate(5,new Date(emp.getEndDate().getTime()));
            stat.setString(6,emp.getTitle());
            stat.setLong(7,emp.getAssignedBranchID());
            stat.setLong(8, emp.getDeptID());
            stat.setLong(9, emp.getSuperiorEmpID());
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
    public void delete(Employee emp) throws DAOException {
        PreparedStatement stat =null;
        try{
            stat = conn.prepareStatement(DELETE);
            stat.setLong(1,emp.getID());
            stat.setString(2,emp.getFirstName());
            stat.setString(3,emp.getLastName());
            stat.setDate(4, new Date(emp.getStartDate().getTime()));
            stat.setDate(5,new Date(emp.getEndDate().getTime()));
            stat.setString(6,emp.getTitle());
            stat.setLong(7,emp.getAssignedBranchID());
            stat.setLong(8, emp.getDeptID());
            stat.setLong(9, emp.getSuperiorEmpID());

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
    public List<Employee> GetAll() throws DAOException {
        PreparedStatement stat = null;
        ResultSet rs = null;
        List<Employee> employeeList = new ArrayList<>();
        try{
            stat= conn.prepareStatement(GETALL);
            rs = stat.executeQuery();
            while (rs.next()){
                employeeList.add(casting(rs));
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
        return employeeList;

    }

    @Override
    public Employee GetBy(Long  txnID) throws DAOException {
        PreparedStatement stat = null;
        ResultSet rs = null;
        Employee emp = null;
        try{
            stat= conn.prepareStatement(GETONE);
            stat.setLong(1,txnID);
            rs = stat.executeQuery();
            if (rs.next()){
                emp = casting(rs);

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
        return emp;
    }
}

