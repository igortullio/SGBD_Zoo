
package model.dao;

import conexao.ConexaoMySQL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import model.bean.FichaMedica;

/**
 * 
 * @author Pedro Paul
 */
public class FichaMedicaDAO {
    
    public static void inserir(FichaMedica ficha){
        Connection conexao = ConexaoMySQL.conectar();
        PreparedStatement stmt = null;
        
        try {
            stmt = conexao.prepareStatement("INSERT INTO fichamedica (Codigo_Animal, DataNascimento_FichaMedica, DataEntradaZoo_FichaMedica, EstadoSaude_FichaMedica, Peso_FichaMedica, Altura_FichaMedica) values (?, ?, ?, ?, ?, ?)");
            stmt.setInt(1, ficha.getCodigo_Animal());
            stmt.setString(2, ficha.getDataNascimento_FichaMedica());
            stmt.setString(3, ficha.getDataEntradaZoo_FichaMedica());
            stmt.setString(4, ficha.getEstadoSaude_FichaMedica());
            stmt.setFloat(5, ficha.getPeso_FichaMedica());
            stmt.setFloat(6, ficha.getAltura_FichaMedica());
            
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Criado!", null, JOptionPane.PLAIN_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e, e.getMessage(), JOptionPane.ERROR_MESSAGE);
        }//fim try catch
    }//fim metodo
    
    public static List<FichaMedica> ler(){//este precisa retornar algo
        Connection conexao = ConexaoMySQL.conectar();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<FichaMedica> fichasLista = new ArrayList<>();
        try {
            stmt = conexao.prepareStatement("SELECT * FROM fichamedica");
            rs = stmt.executeQuery();
            while (rs.next()) {                
                FichaMedica ficha = new FichaMedica(
                        rs.getInt("Codigo_FichaMedica"), 
                        rs.getInt("Codigo_Animal"), 
                        rs.getString("DataNascimento_FichaMedica"), 
                        rs.getString("DataEntradaZoo_FichaMedica"), 
                        rs.getString("EstadoSaude_FichaMedica"), 
                        rs.getFloat("Peso_FichaMedica"), 
                        rs.getFloat("Altura_FichaMedica")
                );
                fichasLista.add(ficha);
            }//fim while
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro: " +e);
        } finally {
            ConexaoMySQL.desconectar(conexao, stmt, rs);
        }//fim try catch
        return fichasLista;
    }//fim metodo
    
    public void atualizar(){
        Connection conexao = ConexaoMySQL.conectar();
        PreparedStatement stmt = null;
        
        try {
            
        } catch (Exception e) {
        }//fim try catch
    }//fim metodo
    
    public void excluir(){
        Connection conexao = ConexaoMySQL.conectar();
        PreparedStatement stmt = null;
        
        try {
            
        } catch (Exception e) {
        }//fim try catch
    }//fim metodo
    
    public void prepararStmt(){
        
    }

}//fim classe
