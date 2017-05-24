

package model.bean;

/**
 * Classe de definição de uma ficha médica
 * 
 * @author Pedro Paul
 */
public class Animal {
    int Codigo_Animal;
    String  
            Reino_Animal, 
            Filo_Animal, 
            SubFilo_Animal, 
            Classe_Animal, 
            Ordem_Animal, 
            Familia_Animal,
            Genero_Animal, 
            Especie_Animal; 
    
    /**
     * Construtor vazio
     */
    public Animal() {
    }
    
    /**
     * Construtor da classe Animal
     * 
     * @param Codigo_Animal
     * @param Reino_Animal
     * @param Filo_Animal
     * @param SubFilo_Animal
     * @param Classe_Animal
     * @param Ordem_Animal
     * @param Familia_Animal
     * @param Genero_Animal
     * @param Especie_Animal 
     */
    public Animal(int Codigo_Animal, String Reino_Animal, String Filo_Animal, String SubFilo_Animal, String Classe_Animal, String Ordem_Animal, String Familia_Animal, String Genero_Animal, String Especie_Animal) {
        this.Codigo_Animal = Codigo_Animal;
        this.Reino_Animal = Reino_Animal;
        this.Filo_Animal = Filo_Animal;
        this.SubFilo_Animal = SubFilo_Animal;
        this.Classe_Animal = Classe_Animal;
        this.Ordem_Animal = Ordem_Animal;
        this.Familia_Animal = Familia_Animal;
        this.Genero_Animal = Genero_Animal;
        this.Especie_Animal = Especie_Animal;
    }
    
    /**
     * Construtor da Classe Animal sem o Codigo_Animal
     * 
     * @param Reino_Animal
     * @param Filo_Animal
     * @param SubFilo_Animal
     * @param Classe_Animal
     * @param Ordem_Animal
     * @param Familia_Animal
     * @param Genero_Animal
     * @param Especie_Animal 
     */
    public Animal(String Reino_Animal, String Filo_Animal, String SubFilo_Animal, String Classe_Animal, String Ordem_Animal, String Familia_Animal, String Genero_Animal, String Especie_Animal) {
        this.Reino_Animal = Reino_Animal;
        this.Filo_Animal = Filo_Animal;
        this.SubFilo_Animal = SubFilo_Animal;
        this.Classe_Animal = Classe_Animal;
        this.Ordem_Animal = Ordem_Animal;
        this.Familia_Animal = Familia_Animal;
        this.Genero_Animal = Genero_Animal;
        this.Especie_Animal = Especie_Animal;
    }

    public int getCodigo_Animal() {
        return Codigo_Animal;
    }

    public void setCodigo_Animal(int Codigo_Animal) {
        this.Codigo_Animal = Codigo_Animal;
    }

    public String getReino_Animal() {
        return Reino_Animal;
    }

    public void setReino_Animal(String Reino_Animal) {
        this.Reino_Animal = Reino_Animal;
    }

    public String getFilo_Animal() {
        return Filo_Animal;
    }

    public void setFilo_Animal(String Filo_Animal) {
        this.Filo_Animal = Filo_Animal;
    }

    public String getSubFilo_Animal() {
        return SubFilo_Animal;
    }

    public void setSubFilo_Animal(String SubFilo_Animal) {
        this.SubFilo_Animal = SubFilo_Animal;
    }

    public String getClasse_Animal() {
        return Classe_Animal;
    }

    public void setClasse_Animal(String Classe_Animal) {
        this.Classe_Animal = Classe_Animal;
    }

    public String getOrdem_Animal() {
        return Ordem_Animal;
    }

    public void setOrdem_Animal(String Ordem_Animal) {
        this.Ordem_Animal = Ordem_Animal;
    }

    public String getFamilia_Animal() {
        return Familia_Animal;
    }

    public void setFamilia_Animal(String Familia_Animal) {
        this.Familia_Animal = Familia_Animal;
    }

    public String getGenero_Animal() {
        return Genero_Animal;
    }

    public void setGenero_Animal(String Genero_Animal) {
        this.Genero_Animal = Genero_Animal;
    }

    public String getEspecie_Animal() {
        return Especie_Animal;
    }

    public void setEspecie_Animal(String Especie_Animal) {
        this.Especie_Animal = Especie_Animal;
    }
    
    
}
