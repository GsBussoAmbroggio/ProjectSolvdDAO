package Services;

import dao.DAOException;
import dao.IProductDAO;
import models.Department;
import models.Employee;
import models.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MySQLProductDAO implements IProductDAO {
    //--------------------------------------------------CRUD------------------------------------------------------------
    final String INSERT = "INSERT INTO product (PRODUCT_CD,DATE_OFFERED,DATE_RETIRED,NAME,product_type_PRODUCT_TYPE_CD) VALUES (?,?,?,?,?)";
    final String UPDATE = "UPDATE product SET PRODUCT_CD=?,DATE_OFFERED=?,DATE_RETIRED=?,NAME=?,product_type_PRODUCT_TYPE_CD=?";
    final String DELETE = "DELETE FROM product WHERE PRODUCT_CD=?";
    final String GETALL = "SELECT PRODUCT_CD,DATE_OFFERED,DATE_RETIRED,NAME,product_type_PRODUCT_TYPE_CD FROM product";
    final String GETONE = "SELECT PRODUCT_CD,DATE_OFFERED,DATE_RETIRED,NAME,product_type_PRODUCT_TYPE_CD FROM product WHERE PRODUCT_CD=?";

    /* ATTRIBUTES */ private Connection conn;
    /* CASTING */ private Product casting(ResultSet rs)throws SQLException {
        String PRODUCT_CD = rs.getString("PRODUCT_CD");
        Date DATE_OFFERED = rs.getDate("DATE_OFFERED");
        Date DATE_RETIRED = rs.getDate("DATE_RETIRED");
        String NAME = rs.getString("NAME");
        String product_type_PRODUCT_TYPE_CD = rs.getString("product_type_PRODUCT_TYPE_CD");
        Product p = new Product(PRODUCT_CD,DATE_OFFERED,DATE_RETIRED,NAME,product_type_PRODUCT_TYPE_CD);
        p.setProductCD(rs.getString("PRODUCT_CD=?"));
        return p;
    }
    /* CONNECTION */public MySQLProductDAO(Connection conn){
        this.conn = conn;
    }

    // INTERFACE METHODS CRUD
    //TODO check insert method
    @Override
    public void insert(Product p) throws DAOException {
        PreparedStatement stat =null;
        try{
            stat = conn.prepareStatement(INSERT);
            stat = conn.prepareStatement(DELETE);
            stat.setString(1, p.getProductCD());
            stat.setDate(2, (java.sql.Date) p.getDateOffered());
            stat.setDate(3, (java.sql.Date) p.getDateRetired());
            stat.setString(4, p.getName());
            stat.setString(5, p.getProductType());

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
    public void modify(Product p) throws DAOException {
        PreparedStatement stat =null;
        try{
            stat = conn.prepareStatement(UPDATE);
            stat = conn.prepareStatement(DELETE);
            stat.setString(1, p.getProductCD());
            stat.setDate(2, (java.sql.Date) p.getDateOffered());
            stat.setDate(3, (java.sql.Date) p.getDateRetired());
            stat.setString(4, p.getName());
            stat.setString(5, p.getProductType());
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
    public void delete(Product p) throws DAOException {
        PreparedStatement stat =null;
        try{
            stat = conn.prepareStatement(DELETE);
            stat.setString(1, p.getProductCD());
            stat.setDate(2, (java.sql.Date) p.getDateOffered());
            stat.setDate(3, (java.sql.Date) p.getDateRetired());
            stat.setString(4, p.getName());
            stat.setString(5, p.getProductType());
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
    public List<Product> GetAll() throws DAOException {
        PreparedStatement stat = null;
        ResultSet rs = null;
        List<Product> productList = new ArrayList<>();
        try{
            stat= conn.prepareStatement(GETALL);
            rs = stat.executeQuery();
            while (rs.next()){
                productList.add(casting(rs));
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
        return productList;

    }

    @Override
    public Product GetBy(String productCD) throws DAOException {
        PreparedStatement stat = null;
        ResultSet rs = null;
        Product product = null;
        try{
            stat= conn.prepareStatement(GETONE);
            stat.setString(1,productCD);
            rs = stat.executeQuery();
            if (rs.next()){
                product = casting(rs);

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
        return product;
    }
}
