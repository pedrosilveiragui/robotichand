/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.Setor;
import java.util.ArrayList;

/**
 *
 * @author CLIENTE
 */
public interface SetorInterface {
    public boolean insert(Setor setor) throws Exception;
    public boolean delete(int idsetor) throws Exception;
    
    public ArrayList<Setor> RetrieveAll() throws Exception;
    public ArrayList<Setor> RetrieveByIdSetor(int idsetor) throws Exception;
    
}
