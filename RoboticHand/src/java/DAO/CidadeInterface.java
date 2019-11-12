/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.Cidade;
import java.util.ArrayList;

/**
 *
 * @author CLIENTE
 */
public interface CidadeInterface {
    public boolean insert(Cidade cidade) throws Exception;
    public boolean delete(int idCidade) throws Exception;
    
    public ArrayList<Cidade> RetrieveAll() throws Exception;
    public ArrayList<Cidade> RetriveByIdEstado(int idestado) throws Exception;
    
}
