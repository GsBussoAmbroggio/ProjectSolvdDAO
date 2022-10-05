package Services;

import dao.DAOException;
import dao.IProductTypeDAO;
import models.Employee;
import models.Product;
import models.ProductType;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MySQLProductTypeDAO implements IProductTypeDAO {
    //--------------------------------------------------CRUD------------------------------------------------------------
    final String INSERT = "INSERT INTO product_type (NAME) VALUES (?)";
    final String UPDATE = "UPDATE product_type SET PRODUCT_TYPE_CD=?,NAME=?";
    final String DELETE = "DELETE FROM product_type WHERE PRODUCT_TYPE_CD=?";
    final String GETALL = "SELECT PRODUCT_TYPE_CD,NAME FROM product_type";
    final String GETONE = "SELECT PRODUCT_TYPE_CD,NAME FROM product_type WHERE PRODUCT_TYPE_CD=?";

    /* ATTRIBUTES */ private Connection conn;
    /* CASTING */ private ProductType casting(ResultSet rs)throws SQLException {
        String PRODUCT_TYPE_CD = rs.getString("PRODUCT_TYPE_CD");
        String NAME = rs.getString("NAME");
        ProductType pt = new ProductType(PRODUCT_TYPE_CD,NAME);
        pt.setProductType(rs.getString("PRODUCT_TYPE_CD"));
        return pt;
    }

    /* CONNECTION */public MySQLProductTypeDAO(Connection conn){
        this.conn = conn;
    }

    // INTERFACE METHODS CRUD
    //TODO check insert method
    @Override
    public void insert(ProductType pt) throws DAOException {
        PreparedStatement stat =null;
        ResultSet rs = null;
        try{
            stat = conn.prepareStatement(INSERT);
            stat = conn.prepareStatement(DELETE);
            stat.setString(1, pt.getProductType());
            stat.setString(4, pt.getName());
             if (stat.executeUpdate()==0){
                throw new DAOException("-if possible that you may not have saved successfully");
            }
            if (rs.next()){
                pt.setProductType(rs.getString(1));

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
    public void modify(ProductType pt) throws DAOException {
        PreparedStatement stat =null;
        ResultSet rs = null;
        try{
            stat = conn.prepareStatement(UPDATE);
            stat = conn.prepareStatement(DELETE);
            stat.setString(1, pt.getProductType());
            stat.setString(4, pt.getName());
            if (stat.executeUpdate()==0){
                throw new DAOException("-if possible that you may not have saved successfully");
            }
            if (rs.next()){
                pt.setProductType(rs.getString(1));

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
    public void delete(ProductType pt) throws DAOException {
        PreparedStatement stat =null;
        ResultSet rs = null;
        try{
            stat = conn.prepareStatement(DELETE);
            stat.setString(1, pt.getProductType());
            stat.setString(4, pt.getName());
            if (stat.executeUpdate()==0){
                throw new DAOException("-if possible that you may not have saved successfully");
            }
            if (rs.next()){
                pt.setProductType(rs.getString(1));

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
    public List<ProductType> GetAll() throws DAOException {
        PreparedStatement stat = null;
        ResultSet rs = null;
        List<ProductType> productTypeList = new ArrayList<>();
        try{
            stat= conn.prepareStatement(GETALL);
            rs = stat.executeQuery();
            while (rs.next()){
                productTypeList.add(casting(rs));
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
        return productTypeList;

    }

    @Override
    public ProductType GetBy(String productType) throws DAOException {
        PreparedStatement stat = null;
        ResultSet rs = null;
        ProductType pt = null;
        try{
            stat= conn.prepareStatement(GETONE);
            stat.setString(1, pt.getProductType());
            rs = stat.executeQuery();
            if (rs.next()){
                pt = casting(rs);

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
        return pt;
    }
}