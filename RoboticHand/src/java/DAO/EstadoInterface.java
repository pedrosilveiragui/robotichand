/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.Estado;
import java.util.ArrayList;

/**
 *
 * @author CLIENTE
 */
public interface EstadoInterface {
    public boolean insert(Estado estado) throws Exception;
    public boolean delete(int id) throws Exception;
    
    public ArrayList<Estado> RetrieveAll() throws Exception;
    public ArrayList<Estado> RetrieveByNomeLike(String data) throws Exception;
}
