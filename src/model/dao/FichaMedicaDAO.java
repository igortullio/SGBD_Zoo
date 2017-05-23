
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
            stmt = conexao.prepareStatement("INSERT INTO fichamedica (Codigo_Animal, DataNascimento_FichaMedica, DataEntradaZoo_FichaMedica, EstadoSaude_FichaMedica, Peso_FichaMedica, Altura_FichaMedica) values (?, str_to_date(?, '%d/%m/%Y'), str_to_date(?, '%d/%m/%Y'), ?, ?, ?)");
            stmt.setInt(1, ficha.getCodigo_Animal());
            stmt.setString(2, ficha.getDataNascimento_FichaMedica());
            stmt.setString(3, ficha.getDataEntradaZoo_FichaMedica());
            stmt.setString(4, ficha.getEstadoSaude_FichaMedica());
            stmt.setFloat(5, ficha.getPeso_FichaMedica());
            stmt.setFloat(6, ficha.getAltura_FichaMedica());
            
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Criado!", null, JOptionPane.PLAIN_MESSAGE);
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e, e.getMessage(), JOptionPane.ERROR_MESSAGE);
        }//fim try catch
    }//fim metodo
    
    public static List<FichaMedica> ler(){//este precisa retornar algo
        Connection conexao = ConexaoMySQL.conectar();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<FichaMedica> fichasLista = new ArrayList<>();
        try {
            stmt = conexao.prepareStatement("select Codigo_FichaMedica, Codigo_Animal, date_format(DataNascimento_FichaMedica, '%d/%m/%Y') 'DataNascimento_FichaMedica', date_format(DataEntradaZoo_FichaMedica, '%d/%m/%Y') 'DataEntradaZoo_FichaMedica', EstadoSaude_FichaMedica, Peso_FichaMedica, Altura_FichaMedica from fichamedica;");
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
    
    public static List<FichaMedica> lerPorCodigo(int codigo_FichaMedica){
        Connection conexao = ConexaoMySQL.conectar();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<FichaMedica> fichasLista = new ArrayList<>();
        try {
            stmt = conexao.prepareStatement("SELECT Codigo_FichaMedica, Codigo_Animal, date_format(DataNascimento_FichaMedica, '%d/%m/%Y') 'DataNascimento_FichaMedica', date_format(DataEntradaZoo_FichaMedica, '%d/%m/%Y') 'DataEntradaZoo_FichaMedica', EstadoSaude_FichaMedica, Peso_FichaMedica, Altura_FichaMedica FROM fichamedica WHERE Codigo_FichaMedica = ?;");
            stmt.setInt(1, codigo_FichaMedica);
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
    }
    
    public static void atualizar(FichaMedica ficha){
        Connection conexao = ConexaoMySQL.conectar();
        PreparedStatement stmt = null;
        
        try {
            stmt = conexao.prepareStatement("UPDATE fichamedica SET Codigo_Animal = ?, DataNascimento_FichaMedica = str_to_date(?, '%d/%m/%Y'), DataEntradaZoo_FichaMedica = str_to_date(?, '%d/%m/%Y'), EstadoSaude_FichaMedica = ?, Peso_FichaMedica = ?, Altura_FichaMedica = ? WHERE Codigo_FichaMedica = ?;");
            stmt.setInt(1, ficha.getCodigo_Animal());
            stmt.setString(2, ficha.getDataNascimento_FichaMedica());
            stmt.setString(3, ficha.getDataEntradaZoo_FichaMedica());
            stmt.setString(4, ficha.getEstadoSaude_FichaMedica());
            stmt.setFloat(5, ficha.getPeso_FichaMedica());
            stmt.setFloat(6, ficha.getAltura_FichaMedica());
            stmt.setInt(7, ficha.getCodigo_FichaMedica());
            
            stmt.executeUpdate();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }//fim try catch
    }//fim metodo

    public static void excluir(FichaMedica ficha) {
        Connection conexao = ConexaoMySQL.conectar();
        PreparedStatement stmt = null;
        
        try {
            int resposta = JOptionPane.showConfirmDialog(null, "Você ira excluir a ficha de código "+ficha.getCodigo_FichaMedica()+"\nTem certeza disto?", null, JOptionPane.YES_NO_OPTION);
            switch(resposta){
                case JOptionPane.YES_OPTION:
                    //cria o comando de DELETE
                    stmt = conexao.prepareStatement("DELETE FROM fichamedica WHERE Codigo_FichaMedica = ?");
                    //Pega o Código da ficha a ser excluida
                    stmt.setInt(1, ficha.getCodigo_FichaMedica());
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
