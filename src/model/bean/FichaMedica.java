

package model.bean;

/**
 * Classe de definição de uma ficha médica
 * 
 * @author Pedro Paul
 */
public class FichaMedica {
    int Codigo_FichaMedica;
    int Codigo_Animal;
    String DataNascimento_FichaMedica;
    String DataEntradaZoo_FichaMedica;
    String EstadoSaude_FichaMedica;
    float Peso_FichaMedica;
    float Altura_FichaMedica;

    /**
     * Constutor da Ficha Médica
     * 
     * @param Codigo_FichaMedica
     * @param Codigo_Animal
     * @param DataNascimento_FichaMedica
     * @param DataEntradaZoo_FichaMedica
     * @param EstadoSaude_FichaMedica
     * @param Peso_FichaMedica
     * @param Altura_FichaMedica 
     */
    public FichaMedica(int Codigo_FichaMedica, int Codigo_Animal, String DataNascimento_FichaMedica, String DataEntradaZoo_FichaMedica, String EstadoSaude_FichaMedica, float Peso_FichaMedica, float Altura_FichaMedica) {
        this.Codigo_FichaMedica = Codigo_FichaMedica;
        this.Codigo_Animal = Codigo_Animal;
        this.DataNascimento_FichaMedica = DataNascimento_FichaMedica;
        this.DataEntradaZoo_FichaMedica = DataEntradaZoo_FichaMedica;
        this.EstadoSaude_FichaMedica = EstadoSaude_FichaMedica;
        this.Peso_FichaMedica = Peso_FichaMedica;
        this.Altura_FichaMedica = Altura_FichaMedica;
    }
    
    /**
     * 
     * @param Codigo_Animal
     * @param DataNascimento_FichaMedica
     * @param DataEntradaZoo_FichaMedica
     * @param EstadoSaude_FichaMedica
     * @param Peso_FichaMedica
     * @param Altura_FichaMedica 
     */
    public FichaMedica(int Codigo_Animal, String DataNascimento_FichaMedica, String DataEntradaZoo_FichaMedica, String EstadoSaude_FichaMedica, float Peso_FichaMedica, float Altura_FichaMedica) {
        this.Codigo_Animal = Codigo_Animal;
        this.DataNascimento_FichaMedica = DataNascimento_FichaMedica;
        this.DataEntradaZoo_FichaMedica = DataEntradaZoo_FichaMedica;
        this.EstadoSaude_FichaMedica = EstadoSaude_FichaMedica;
        this.Peso_FichaMedica = Peso_FichaMedica;
        this.Altura_FichaMedica = Altura_FichaMedica;
    }
    
    

    public int getCodigo_FichaMedica() {
        return Codigo_FichaMedica;
    }

    public void setCodigo_FichaMedica(int Codigo_FichaMedica) {
        this.Codigo_FichaMedica = Codigo_FichaMedica;
    }

    public int getCodigo_Animal() {
        return Codigo_Animal;
    }

    public void setCodigo_Animal(int Codigo_Animal) {
        this.Codigo_Animal = Codigo_Animal;
    }

    public String getDataNascimento_FichaMedica() {
        return DataNascimento_FichaMedica;
    }

    public void setDataNascimento_FichaMedica(String DataNascimento_FichaMedica) {
        this.DataNascimento_FichaMedica = DataNascimento_FichaMedica;
    }

    public String getDataEntradaZoo_FichaMedica() {
        return DataEntradaZoo_FichaMedica;
    }

    public void setDataEntradaZoo_FichaMedica(String DataEntradaZoo_FichaMedica) {
        this.DataEntradaZoo_FichaMedica = DataEntradaZoo_FichaMedica;
    }

    public String getEstadoSaude_FichaMedica() {
        return EstadoSaude_FichaMedica;
    }

    public void setEstadoSaude_FichaMedica(String EstadoSaude_FichaMedica) {
        this.EstadoSaude_FichaMedica = EstadoSaude_FichaMedica;
    }

    public float getPeso_FichaMedica() {
        return Peso_FichaMedica;
    }

    public void setPeso_FichaMedica(float Peso_FichaMedica) {
        this.Peso_FichaMedica = Peso_FichaMedica;
    }

    public float getAltura_FichaMedica() {
        return Altura_FichaMedica;
    }

    public void setAltura_FichaMedica(float Altura_FichaMedica) {
        this.Altura_FichaMedica = Altura_FichaMedica;
    }
    

}
