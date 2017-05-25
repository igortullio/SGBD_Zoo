

package model.bean;

/**
 * Classe de definição de uma ficha médica
 * 
 * @author Pedro Paul
 */
public class Responsavel {
    String 
            Nome_Funcionario,
            Especie_Animal;
    int Codigo_Animal;

    public Responsavel(String Nome_Funcionario, String Especie_Animal, int Codigo_Animal) {
        this.Nome_Funcionario = Nome_Funcionario;
        this.Especie_Animal = Especie_Animal;
        this.Codigo_Animal = Codigo_Animal;
    }

    public String getNome_Funcionario() {
        return Nome_Funcionario;
    }

    public String getEspecie_Animal() {
        return Especie_Animal;
    }

    public int getCodigo_Animal() {
        return Codigo_Animal;
    }
    
}
