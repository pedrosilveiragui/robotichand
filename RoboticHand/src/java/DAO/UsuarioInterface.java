/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.Usuario;

/**
 *
 * @author CLIENTE
 */
public interface UsuarioInterface {
    public boolean insert(Usuario usuario) throws Exception;
    public boolean delete(int id) throws Exception;    
    public Usuario retrieveByLogin(String login, String senha) throws Exception;
}
