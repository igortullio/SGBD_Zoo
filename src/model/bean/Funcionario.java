package model.bean;

import java.sql.Date;

public class Funcionario {

    private int codigo_funcionario;
    private int codigo_funcao;
    private String nome_funcionario;
    private String cpf_funcionario;
    private int rg_funcionario;
    private String dataEntrada_funcionario;
    private String telefone_funcionario;

    public Funcionario() {

    }

    public Funcionario(int codigo_funcionario, int codigo_funcao,String nome_funcionario, String cpf_funcionario,int rg_funcionario,String telefone_funcionario) {
        this.codigo_funcionario = codigo_funcionario;
        this.codigo_funcao = codigo_funcao;
        this.cpf_funcionario = cpf_funcionario;
        this.rg_funcionario = rg_funcionario;
        this.telefone_funcionario = telefone_funcionario;

    }

    public Funcionario(int codigo_funcionario, int codigo_funcao, String nome_funcionario, String cpf_funcionario,  int rg_funcionario,  String dataEntrada_funcionario, String telefone_funcionario) {
        this.codigo_funcionario = codigo_funcionario;       
        this.codigo_funcao = codigo_funcao;
        this.nome_funcionario = nome_funcionario;
        this.cpf_funcionario = cpf_funcionario;
        this.rg_funcionario = rg_funcionario;
        this.dataEntrada_funcionario = dataEntrada_funcionario;   
        this.telefone_funcionario = telefone_funcionario;

    }

    public Funcionario(int codigo_funcionario, String nome_funcionario, String cpf_funcionario, int rg_funcionario, int codigo_funcao, String telefone_funcionario){
        this.codigo_funcionario = codigo_funcionario;
        this.nome_funcionario = nome_funcionario;
        this.cpf_funcionario = cpf_funcionario;
        this.rg_funcionario = rg_funcionario;
        this.codigo_funcao = codigo_funcao;        
        this.telefone_funcionario = telefone_funcionario;
    }
    

    /**
     *
     *
     * @param codigo_funcionario
     * @param codigo_funcao
     * @param nome_funcionario
     * @param cpf_funcionario
     * @param rg_funcionario
     * @param dataEntrada_funcionario
     * @param telefone_funcionario
     */
    public int getCodigo_funcionario() {
        return codigo_funcionario;
    }

    public void setCodigo_funcionario(int codigo_funcionario) {
        this.codigo_funcionario = codigo_funcionario;
    }

    public int getCodigo_funcao() {
        return codigo_funcao;
    }

    public void setCodigo_funcao(int codigo_funcao) {
        this.codigo_funcao = codigo_funcao;
    }

    public String getNome_funcionario() {
        return nome_funcionario;
    }

    public void setNome_funcionario(String nome_funcionario) {
        this.nome_funcionario = nome_funcionario;
    }

    public String getCpf_funcionario() {
        return cpf_funcionario;
    }

    public void setCpf_funcionario(String cpf_funcionario) {
        this.cpf_funcionario = cpf_funcionario;
    }

    public int getRg_funcionario() {
        return rg_funcionario;
    }

    public void setRg_funcionario(int rg_funcionario) {
        this.rg_funcionario = rg_funcionario;
    }

    public String getDataEntrada_funcionario() {
        return dataEntrada_funcionario;
    }

    public void setDataEntrada_funcionario(String dataEntrada_funcionario) {
        this.dataEntrada_funcionario = dataEntrada_funcionario;
    }

    public String getTelefone_funcionario() {
        return telefone_funcionario;
    }

    public void setTelefone_funcionario(String telefone_funcionario) {
        this.telefone_funcionario = telefone_funcionario;
    }

}
