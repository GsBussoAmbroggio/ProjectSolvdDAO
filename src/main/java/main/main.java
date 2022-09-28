package main;

import Services.MySQLAccountDAO;
import Services.MySQLIndividualDAO;
import dao.DAO;
import dao.DAOException;
import dao.IAccountDAO;
import dao.IIndividualDAO;
import models.Account;
import models.Individual;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

public class main {
    public static void main (String [] args) throws SQLException,DAOException{
        Connection conn = null;
        try {//Database logical
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank","root","Solvd2022");
            IIndividualDAO dao = new MySQLIndividualDAO(conn);

            List<Individual> individualList = dao.GetAll();
            for (Individual a : individualList  ){
                System.out.println(a.toString());

            }
            System.out.println("i`m in");

            /*Except*/  } finally {
            if (conn!=null);{
                conn.close();
            }
        }

    }
}
