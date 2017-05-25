/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.bean;

/**
 *
 * @author Elton Machado
 */
public class Procedimentos {
    
    private int Codigo_Procedimentos;
    private int Codigo_TipoProcedimentos;
    private String Descricao;
    private int Quantidade;
    private String Data_Vencimento;
    private double Valor;
    
    public int getCodigo_Procedimentos() {
        return Codigo_Procedimentos;
    }

    public void setCodigo_Procedimentos(int Codigo_FichaMedica) {
        this.Codigo_Procedimentos = Codigo_Procedimentos;
    }

    public int getCodigo_TipoProcedimentos() {
        return Codigo_TipoProcedimentos;
    }

    public void setCodigo_TipoProcedimentos(int Codigo_TipoProcedimentos) {
        this.Codigo_TipoProcedimentos = Codigo_TipoProcedimentos;
    }

    public String getDescricao() {
        return Descricao;
    }

    public void setDescricao(String Descricao) {
        this.Descricao = Descricao;
    }

    public int getQuantidade() {
        return Quantidade;
    }

    public void setQuantidade(int Quantidade) {
        this.Quantidade = Quantidade;
    }

    public String getData_Vencimento() {
        return Data_Vencimento;
    }

    public void setData_Vencimento(String Data_Vencimento) {
        this.Data_Vencimento = Data_Vencimento;
    }

    public double getValor() {
        return Valor;
    }

    public void setValor(double Valor) {
        this.Valor = Valor;
    }
}
