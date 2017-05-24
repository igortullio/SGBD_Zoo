
package model.dao;

import conexao.ConexaoMySQL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import model.bean.Animal;

/**
 * 
 * @author Pedro Paul
 */
public class AnimalDAO {
    
    public static void inserir(Animal animal){
        Connection conexao = ConexaoMySQL.conectar();
        PreparedStatement stmt = null;
        
        try {
            stmt = conexao.prepareStatement("INSERT INTO animal (Reino_Animal, Filo_Animal, SubFilo_Animal, Classe_Animal, Ordem_Animal, Familia_Animal, Genero_Animal, Especie_Animal) VALUES (?, ?, ?, ?, ?, ?, ?, ?);");
            stmt.setString(1, animal.getReino_Animal());
            stmt.setString(2, animal.getFilo_Animal());
            stmt.setString(3, animal.getSubFilo_Animal());
            stmt.setString(4, animal.getClasse_Animal());
            stmt.setString(5, animal.getOrdem_Animal());
            stmt.setString(6, animal.getFamilia_Animal());
            stmt.setString(7, animal.getGenero_Animal());
            stmt.setString(8, animal.getEspecie_Animal());
            
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Inserido!", null, JOptionPane.PLAIN_MESSAGE);
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e, e.getMessage(), JOptionPane.ERROR_MESSAGE);
        }//fim try catch
    }//fim metodo
    
    public static List<Animal> ler(){//este precisa retornar algo
        Connection conexao = ConexaoMySQL.conectar();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Animal> animaisLista = new ArrayList<>();
        try {
            stmt = conexao.prepareStatement("SELECT Codigo_Animal, Reino_Animal, Filo_Animal, SubFilo_Animal, Classe_Animal, Ordem_Animal, Familia_Animal, Genero_Animal, Especie_Animal FROM animal;");
            rs = stmt.executeQuery();
            while (rs.next()) {                
                Animal animal = new Animal(
                        rs.getInt("Codigo_Animal"),//Codigo_Animal 
                        rs.getString("Reino_Animal"),//Reino_Animal 
                        rs.getString("Filo_Animal"),//Filo_Animal 
                        rs.getString("SubFilo_Animal"),//SubFilo_Animal 
                        rs.getString("Classe_Animal"),//Classe_Animal 
                        rs.getString("Ordem_Animal"),//Ordem_Animal 
                        rs.getString("Familia_Animal"),//Familia_Animal 
                        rs.getString("Genero_Animal"),//Genero_Animal 
                        rs.getString("Especie_Animal")//Especie_Animal
                );
                animaisLista.add(animal);
            }//fim while
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro: " +e);
        } finally {
            ConexaoMySQL.desconectar(conexao, stmt, rs);
        }//fim try catch
        return animaisLista;
    }//fim metodo
    
    public static List<Animal> lerPorCodigo(int Codigo_Animal){
        Connection conexao = ConexaoMySQL.conectar();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Animal> animalsLista = new ArrayList<>();
        try {
            stmt = conexao.prepareStatement("SELECT Codigo_Animal, Reino_Animal, Filo_Animal, SubFilo_Animal, Classe_Animal, Ordem_Animal, Familia_Animal, Genero_Animal, Especie_Animal FROM animal WHERE Codigo_Animal = ?;");
            stmt.setInt(1, Codigo_Animal);
            rs = stmt.executeQuery();
            while (rs.next()) {                
                Animal animal = new Animal(
                        rs.getInt("Codigo_Animal"),//Codigo_Animal 
                        rs.getString("Reino_Animal"),//Reino_Animal 
                        rs.getString("Filo_Animal"),//Filo_Animal 
                        rs.getString("SubFilo_Animal"),//SubFilo_Animal 
                        rs.getString("Classe_Animal"),//Classe_Animal 
                        rs.getString("Ordem_Animal"),//Ordem_Animal 
                        rs.getString("Familia_Animal"),//Familia_Animal 
                        rs.getString("Genero_Animal"),//Genero_Animal 
                        rs.getString("Especie_Animal")//Especie_Animal
                );
                animalsLista.add(animal);
            }//fim while
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro: " +e);
        } finally {
            ConexaoMySQL.desconectar(conexao, stmt, rs);
        }//fim try catch
        return animalsLista;
    }
    
    public static void atualizar(Animal animal){
        Connection conexao = ConexaoMySQL.conectar();
        PreparedStatement stmt = null;
        
        try {
            stmt = conexao.prepareStatement("UPDATE animal SET Reino_Animal = ?, Filo_Animal = ?, SubFilo_Animal = ?, Classe_Animal = ?, Ordem_Animal = ?, Familia_Animal = ?, Genero_Animal = ?, Especie_Animal = ? WHERE Codigo_Animal = ?;");
            stmt.setString(1, animal.getReino_Animal());
            stmt.setString(2, animal.getFilo_Animal());
            stmt.setString(3, animal.getSubFilo_Animal());
            stmt.setString(4, animal.getClasse_Animal());
            stmt.setString(5, animal.getOrdem_Animal());
            stmt.setString(6, animal.getFamilia_Animal());
            stmt.setString(7, animal.getGenero_Animal());
            stmt.setString(8, animal.getEspecie_Animal());
            stmt.setInt(9, animal.getCodigo_Animal());
            
            stmt.executeUpdate();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }//fim try catch
    }//fim metodo

    public static void excluir(Animal animal) {
        Connection conexao = ConexaoMySQL.conectar();
        PreparedStatement stmt = null;
        
        try {
            int resposta = JOptionPane.showConfirmDialog(null, "Você ira excluir o animal de código "+animal.getCodigo_Animal()+"\nTem certeza disto?", null, JOptionPane.YES_NO_OPTION);
            switch(resposta){
                case JOptionPane.YES_OPTION:
                    //cria o comando de DELETE
                    stmt = conexao.prepareStatement("DELETE FROM animal WHERE Codigo_Animal = ?");
                    //Pega o Código da animal a ser excluida
                    stmt.setInt(1, animal.getCodigo_Animal());
                    //Executa o comando no Banco
                    stmt.executeUpdate();
                    
                    JOptionPane.showMessageDialog(null, "Excluido!", null, JOptionPane.PLAIN_MESSAGE);
                    break;
                case JOptionPane.NO_OPTION:
                    //sei lá
                    break;
            }//fim switch case
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e, e.getMessage(), JOptionPane.ERROR_MESSAGE);
        }//fim try catch
    }

}//fim classe
