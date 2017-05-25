package model.bean;


public class Funcao {

  private int codigo_funcao;
  private String descricao_funcao;
  private double salario_funcao;

    public Funcao(int codigo_funcao, String descricao_funcao, double salario_funcao) {
        this.codigo_funcao = codigo_funcao;
        this.descricao_funcao = descricao_funcao;
        this.salario_funcao = salario_funcao;
    }
    
    public Funcao(){
        
    }
    
     public Funcao(String descricao_funcao, double salario_funcao) {
        this.descricao_funcao = descricao_funcao;
        this.salario_funcao = salario_funcao;
     }
    
    public int getCodigo_funcao() {
        return codigo_funcao;
    }

    /**
     * @param codigo_funcao the codigo_funcao to set
     */
    public void setCodigo_funcao(int codigo_funcao) {
        this.codigo_funcao = codigo_funcao;
    }

    /**
     * @return the descricao_funcao
     */
    public String getDescricao_funcao() {
        return descricao_funcao;
    }

    /**
     * @param descricao_funcao the descricao_funcao to set
     */
    public void setDescricao_funcao(String descricao_funcao) {
        this.descricao_funcao = descricao_funcao;
    }

    /**
     * @return the salario_funcao
     */
    public double getSalario_funcao() {
        return salario_funcao;
    }

    /**
     * @param salario_funcao the salario_funcao to set
     */
    public void setSalario_funcao(double salario_funcao) {
        this.salario_funcao = salario_funcao;
    }
   
  
   
   
}
