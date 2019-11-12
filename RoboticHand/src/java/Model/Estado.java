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
public class Estado {
    public int ID;
    public String Nome, UF;
    
    public Estado(){
        ID = -1;
        Nome = "";
        UF = "";
    }
    
    public Estado(int id, String nome, String uf){
        ID = id;
        Nome = nome;
        UF = uf;
    }
}
