
package model.bean;

public class ItemServico {
    
    private int codigoItemServico;
    private String descricao;
    private double valor;

    public int getCodigoItemServico() {
        return codigoItemServico;
    }

    public void setCodigoItemServico(int codigo) {
        this.codigoItemServico = codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }        
    
}
