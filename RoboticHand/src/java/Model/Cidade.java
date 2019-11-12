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
public class Cidade {
    public int ID, FK_ID_ESTADO;
    public String Nome, NomeEstado/*campo para relacionar com a tabela estados*/;
    
    public Cidade(){
        ID = -1;
        Nome = "";
        FK_ID_ESTADO = -1;
    }
    
    public Cidade(int idCidade, String nomeCidade, int fk_id_estado){
        ID = idCidade;
        Nome = nomeCidade;
        FK_ID_ESTADO = fk_id_estado;
    }
    
    public Cidade(int idCidade, String nomeCidade, int fk_id_estado, String nomeestado){
        ID = idCidade;
        Nome = nomeCidade;
        FK_ID_ESTADO = fk_id_estado;
        NomeEstado = nomeestado;
    }
}
