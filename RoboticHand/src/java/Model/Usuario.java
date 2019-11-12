/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author CLIENTE
 */
public class Usuario {
    public int ID, FK_ID_SETOR, FK_ID_CIDADE, FK_ID_ESTADO;
    public String Nome, Email, Login, Senha;
    
    public Usuario(){
        ID = -1;
        Nome = "";
        Email = "";
        Login = "";
        Senha = "";
        FK_ID_SETOR = -1;
        FK_ID_CIDADE = -1;
        FK_ID_ESTADO = -1;
    }
    
    public Usuario(int id, String nome, String email, String login, String senha, int fk_id_setor, int fk_id_cidade, int fk_id_estado){
        ID = id;
        Nome = nome;
        Email = email;
        Login = login;
        Senha = senha;
        FK_ID_SETOR = fk_id_setor;
        FK_ID_CIDADE = fk_id_cidade;
        FK_ID_ESTADO = fk_id_estado;
    }

    /* public Usuario(int i, String parameter, String parameter0) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    } */
}
