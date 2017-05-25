
package model.bean;

public class Comanda_ItemServico {
    
    private int sequecia;
    private int codigo_Comanda;
    private int codigo_ItemServico;
    private String data;
    private double valor;
    private int quantidade;

    public int getSequecia() {
        return sequecia;
    }

    public void setSequecia(int sequecia) {
        this.sequecia = sequecia;
    }

    public int getCodigo_Comanda() {
        return codigo_Comanda;
    }

    public void setCodigo_Comanda(int codigo_Comanda) {
        this.codigo_Comanda = codigo_Comanda;
    }

    public int getCodigo_ItemServico() {
        return codigo_ItemServico;
    }

    public void setCodigo_ItemServico(int codigo_ItemServico) {
        this.codigo_ItemServico = codigo_ItemServico;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
    
    
    
}
