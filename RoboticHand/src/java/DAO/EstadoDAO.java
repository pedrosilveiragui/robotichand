/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.Estado;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author CLIENTE
 */
public class EstadoDAO implements EstadoInterface{

    @Override
    public boolean insert(Estado estado) throws Exception {
        boolean bRet = false;
        try {
            ConnectionFactory.openConnection();
        //Statement stm = ConnectionFactory.Con.createStatement();
        //stm.execute("insert into estados (nome, uf) values ('" + estado.Nome + "', '" + estado.UF + "'");
        
        PreparedStatement pstm = ConnectionFactory.Con.prepareStatement("insert into tb_estados (nome, uf) values (?, ?)");
        pstm.setString(1, estado.Nome);
        pstm.setString(2, estado.UF);
        pstm.execute();
        bRet = true;
        
        ConnectionFactory.closeConnection();
        
        }catch(Exception e){
        throw new Exception("Erro em EstadoDAO.insert: " + e.getMessage()); //To change body of generated methods, choose Tools | Templates.
        }
        return bRet;
    }

    @Override
    public boolean delete(int id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Estado> RetrieveAll() throws Exception {
        ArrayList<Estado> arRet = new ArrayList<Estado>();
        try{
            ConnectionFactory.openConnection();
            PreparedStatement pstm = ConnectionFactory.Con.prepareStatement("select * from tb_estados");
            ResultSet rs = pstm.executeQuery();
            
            while(rs.next()){
                Estado estado = new Estado(rs.getInt("ID"), rs.getString("Nome"), rs.getString("UF"));
                arRet.add(estado);
            }
            
            ConnectionFactory.closeConnection(pstm, rs);
        }catch(Exception e){
        
            throw new Exception("Erro em EstadoDAO.RetrieveAll(): " + e.getMessage()); //To change body of generated methods, choose Tools | Templates.
        }
        
        return arRet;
    }

    @Override
    public ArrayList<Estado> RetrieveByNomeLike(String data) throws Exception {
        ArrayList<Estado> arRet = new ArrayList<Estado>();
        try{
            ConnectionFactory.openConnection();
            PreparedStatement pstm = ConnectionFactory.Con.prepareStatement("select * from tb_estados where nome like ?");
            pstm.setString(1, data);
            ResultSet rs = pstm.executeQuery();
            
            while(rs.next()){
                Estado estado = new Estado(rs.getInt("ID"), rs.getString("Nome"), rs.getString("UF"));
                arRet.add(estado);
            }
            
            ConnectionFactory.closeConnection(pstm, rs);
        }catch(Exception e){
        
            throw new Exception("Erro em EstadoDAO.RetrieveByNomeLike(): " + e.getMessage()); //To change body of generated methods, choose Tools | Templates.
        }
        
        return arRet;
    }
    
}
