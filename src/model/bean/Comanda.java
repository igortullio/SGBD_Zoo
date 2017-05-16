
package model.bean;


public class Comanda {
    
    private int codigo;
    private double cpf_visitante;
    private String dataEntrada;
    private double valor;

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public double getCpf_visitante() {
        return cpf_visitante;
    }

    public void setCpf_visitante(double cpf_visitante) {
        this.cpf_visitante = cpf_visitante;
    }

    public String getDataEntrada() {
        return dataEntrada;
    }

    public void setDataEntrada(String dataEntrada) {
        this.dataEntrada = dataEntrada;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }
    
    
    
    
}
