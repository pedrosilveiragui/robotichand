/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.Cidade;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author CLIENTE
 */
public class CidadeDAO implements CidadeInterface{

    @Override
    public boolean insert(Cidade cidade) throws Exception {
        boolean bRet = false;
        try {
            ConnectionFactory.openConnection();
        //Statement stm = ConnectionFactory.Con.createStatement();
        //stm.execute("insert into cidades (nomeCidade, estado) values ('" + cidade.Nome + "', '" + cidade.FK_ID_ESTADO + "'");
        
        PreparedStatement pstm = ConnectionFactory.Con.prepareStatement("insert into tb_cidades (Nome, FK_ID_ESTADO) values (?, ?)");
        pstm.setString(1, cidade.Nome);
        pstm.setInt(2, cidade.FK_ID_ESTADO);
        pstm.execute();
        bRet = true;
        
        ConnectionFactory.closeConnection();
                
        }catch(Exception e){
        throw new Exception("Erro em CidadeDAO.insert: " + e.getMessage()); //To change body of generated methods, choose Tools | Templates.
        }
        return bRet;
    }

    @Override
    public boolean delete(int idCidade) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Cidade> RetrieveAll() throws Exception {
                ArrayList<Cidade> arRet = new ArrayList<Cidade>();
        try{
            ConnectionFactory.openConnection();
            PreparedStatement pstm = ConnectionFactory.Con.prepareStatement("select tb_cidades.id, tb_cidades.nome as nomecidade, tb_estados.id as idestado, tb_estados.nome as nomeestado from tb_cidades, tb_estados where tb_cidades.FK_ID_ESTADO = tb_estados.id");
            ResultSet rs = pstm.executeQuery();
            
            while(rs.next()){
                Cidade cidade = new Cidade(rs.getInt("ID"), rs.getString("nomecidade"), rs.getInt("idestado"), rs.getString("nomeestado"));
                arRet.add(cidade);
            }
            
            ConnectionFactory.closeConnection(pstm, rs);
        }catch(Exception e){
        
            throw new Exception("Erro em CidadeDAO.RetrieveAll(): " + e.getMessage()); //To change body of generated methods, choose Tools | Templates.
        }
        
        return arRet;
    }

    @Override
    public ArrayList<Cidade> RetriveByIdEstado(int idestado) throws Exception {
        ArrayList<Cidade> arRet = new ArrayList<Cidade>();
        try{
            ConnectionFactory.openConnection();
            PreparedStatement pstm = ConnectionFactory.Con.prepareStatement("select * from tb_cidades where FK_ID_ESTADO = ?");
            pstm.setInt(1, idestado);
            ResultSet rs = pstm.executeQuery();
            
            while(rs.next()){
                Cidade cidade = new Cidade(rs.getInt("ID"), rs.getString("nome"), rs.getInt("FK_ID_ESTADO"));
                arRet.add(cidade);
            }
            
            ConnectionFactory.closeConnection(pstm, rs);
        }catch(Exception e){
        
            throw new Exception("Erro em CidadeDAO.RetrieveByIdEstado(): " + e.getMessage()); //To change body of generated methods, choose Tools | Templates.
        }
        
        return arRet;
    }
    
}
