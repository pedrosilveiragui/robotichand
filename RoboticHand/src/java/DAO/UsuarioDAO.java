/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.Usuario;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author CLIENTE
 */
public class UsuarioDAO implements UsuarioInterface{

    @Override
    public boolean insert(Usuario usuario) throws Exception {
        boolean bRet = false;
        try {
            ConnectionFactory.openConnection();
        //Statement stm = ConnectionFactory.Con.createStatement();
        //stm.execute("insert into estados (nome, uf) values ('" + estado.Nome + "', '" + estado.UF + "'");
        
        PreparedStatement pstm = ConnectionFactory.Con.prepareStatement("insert into usuario (nome, email, login, senha, fk_id_setor, fk_id_cidade, fk_id_estado) values (?, ?, ?, ?, ?, ?, ?)");
        pstm.setString(1, usuario.Nome);
        pstm.setString(2, usuario.Email);
        pstm.setString(3, usuario.Login);
        pstm.setString(4, usuario.Senha);
        pstm.setInt(5, usuario.FK_ID_SETOR);
        pstm.setInt(6, usuario.FK_ID_CIDADE);
        pstm.setInt(7, usuario.FK_ID_ESTADO);

        pstm.execute();
        bRet = true;
        ConnectionFactory.closeConnection();
        }catch(Exception e){
        throw new Exception("Erro em UsuarioDAO.insert: " + e.getMessage()); //To change body of generated methods, choose Tools | Templates.
        }
        return bRet;
    }

    @Override
    public boolean delete(int id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Usuario retrieveByLogin(String login, String senha) throws Exception {
        Usuario uRet = null;
        try{
            ConnectionFactory.openConnection();
            PreparedStatement pstm = ConnectionFactory.Con.prepareStatement("select * from usuario where login = ?  and senha = ?");
            pstm.setString(1, login);
            pstm.setString(2, senha);
            ResultSet rs = pstm.executeQuery();
            
            if(rs.next()){
                uRet = new Usuario(rs.getInt("id"), rs.getString("nome"), rs.getString("email"), rs.getString("login"), rs.getString("senha"), rs.getInt("FK_ID_SETOR"), rs.getInt("FK_ID_CIDADE"), rs.getInt("FK_ID_ESTADO"));
            }
        }catch(Exception e){
            throw new Exception("Erro em UsuarioDAO.login: " + e.getMessage());
        }
        return uRet;
    }
    
}
