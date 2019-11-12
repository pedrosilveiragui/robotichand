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
public class Setor {
    public int ID;
    public String Nome;
    
    public Setor(){
        ID = -1;
        Nome = "";
    }
    
    public Setor(int idsetor, String nomesetor){
        ID = idsetor;
        Nome = nomesetor;
    }
}
