
package model.bean;

public class Comanda_ItemServico {

    private int sequencia;
    private int codigo_comanda;
    private int codigo_itemservico;
    private double valor;
    private int quantidade;

    public int getSequencia() {
        return sequencia;
    }

    public void setSequencia(int sequencia) {
        this.sequencia = sequencia;
    }

    public int getCodigo_comanda() {
        return codigo_comanda;
    }

    public void setCodigo_comanda(int codigo_comanda) {
        this.codigo_comanda = codigo_comanda;
    }

    public int getCodigo_itemservico() {
        return codigo_itemservico;
    }

    public void setCodigo_itemservico(int codigo_itemservico) {
        this.codigo_itemservico = codigo_itemservico;
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
