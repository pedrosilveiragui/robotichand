/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.Setor;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author CLIENTE
 */
public class SetorDAO implements SetorInterface{

    @Override
    public boolean insert(Setor setor) throws Exception {
        boolean bRet = false;
        try {
            ConnectionFactory.openConnection();
        //Statement stm = ConnectionFactory.Con.createStatement();
        //stm.execute("insert into estados (nome, uf) values ('" + estado.Nome + "', '" + estado.UF + "'");
        
        PreparedStatement pstm = ConnectionFactory.Con.prepareStatement("insert into setor (nomesetor) values (?)");
        pstm.setString(1, setor.Nome);
        pstm.execute();
        bRet = true;
        
        ConnectionFactory.closeConnection();
        
        }catch(Exception e){
        throw new Exception("Erro em SetorDAO.insert: " + e.getMessage()); //To change body of generated methods, choose Tools | Templates.
        }
        return bRet;
    }

    @Override
    public boolean delete(int idsetor) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public ArrayList<Setor> RetrieveAll() throws Exception {
        ArrayList<Setor> arRet = new ArrayList<Setor>();
        try{
            ConnectionFactory.openConnection();
            PreparedStatement pstm = ConnectionFactory.Con.prepareStatement("select * from setor");
            ResultSet rs = pstm.executeQuery();
            
            while(rs.next()){
                Setor setor = new Setor(rs.getInt("idsetor"), rs.getString("nomesetor"));
                arRet.add(setor);
            }
            
            ConnectionFactory.closeConnection(pstm, rs);
        }catch(Exception e){
        
            throw new Exception("Erro em SetorDAO.RetrieveAll(): " + e.getMessage()); //To change body of generated methods, choose Tools | Templates.
        }
        
        return arRet;
    }
    
    @Override
    public ArrayList<Setor> RetrieveByIdSetor(int idsetor) throws Exception {
        ArrayList<Setor> arRet = new ArrayList<Setor>();
        try{
            ConnectionFactory.openConnection();
            PreparedStatement pstm = ConnectionFactory.Con.prepareStatement("select * from setor where idsetor = ?");
            pstm.setInt(1, idsetor);
            ResultSet rs = pstm.executeQuery();
            
            while(rs.next()){
                Setor setor = new Setor(rs.getInt("idsetor"), rs.getString("nomesetor"));
                arRet.add(setor);
            }
            
            ConnectionFactory.closeConnection(pstm, rs);
        }catch(Exception e){
        
            throw new Exception("Erro em SetorDAO.RetrieveByIdSetor(): " + e.getMessage()); //To change body of generated methods, choose Tools | Templates.
        }
        
        return arRet;
    }
    
}
