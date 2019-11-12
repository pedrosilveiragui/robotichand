/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author CLIENTE
 */
public class ConnectionFactory {
    
    public static Connection Con;

    public static boolean openConnection() throws Exception {
        boolean bRet = false;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Con = DriverManager.getConnection("jdbc:mysql://localhost/robotichand", "root", "gotrtvdptsg");
            bRet = true;
        } catch (Exception e) {
            throw new Exception("Erro no metodo ConnectionFactory.openConnection: " + e.getMessage());
        }
        return bRet;
    }
    
    public static boolean closeConnection() throws Exception{
        boolean bRet = false;
        try{
            Con.close();
            bRet = true;
        }catch(Exception e){
            throw new Exception("Erro no metodo ConnectionFactory.closeConnection: " + e.getMessage());
        }
        return bRet;
    }
    
    public static boolean closeConnection(PreparedStatement pstm) throws Exception{
        boolean bRet = false;
        try{
            pstm.close();
            Con.close();
            bRet = true;
        }catch(Exception e){
            throw new Exception("Erro no metodo ConnectionFactory.closeConnection: " + e.getMessage());
        }
        return bRet;
    }
    
        public static boolean closeConnection(PreparedStatement pstm, ResultSet rs) throws Exception{
        boolean bRet = false;
        try{
            rs.close();
            pstm.close();
            Con.close();
            bRet = true;
        }catch(Exception e){
            throw new Exception("Erro no metodo ConnectionFactory.closeConnection: " + e.getMessage());
        }
        return bRet;
    }
}
