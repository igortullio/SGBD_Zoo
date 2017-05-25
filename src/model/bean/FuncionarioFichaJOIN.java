/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.bean;

/**
 *
 * @author Shirley
 */
public class FuncionarioFichaJOIN {

  
    public FuncionarioFichaJOIN(){
        
    }
    
    public String getNomeFuncionario() {
        return nomeFuncionario;
    }

    /**
     * @param nomeFuncionario the nomeFuncionario to set
     */
    public void setNomeFuncionario(String nomeFuncionario) {
        this.nomeFuncionario = nomeFuncionario;
    }

    /**
     * @return the codigoFicha
     */
    public int getCodigoFicha() {
        return codigoFicha;
    }

    /**
     * @param codigoFicha the codigoFicha to set
     */
    public void setCodigoFicha(int codigoFicha) {
        this.codigoFicha = codigoFicha;
    }
    
   private String nomeFuncionario;
   private int codigoFicha;
}
