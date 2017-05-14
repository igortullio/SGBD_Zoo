
package model.dao;

import conexao.ConexaoMySQL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import model.bean.Visitante;


public class VisitanteDAO {
    
    public void salvar(Visitante visitante){
        Connection conexao = ConexaoMySQL.conectar();
        PreparedStatement stmt = null;
        
        try {
            stmt = conexao.prepareStatement("INSERT INTO visitante (Cpf_Visitante, Nome_Visitante, Telefone_Visitante) VALUES (?, ?, ?)");
            
            stmt.setInt(1, visitante.getCpf());
            stmt.setString(2, visitante.getNome());
            stmt.setInt(3, visitante.getTelefone());
            
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Visitante salvo com sucesso!");
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro: " +ex);
        } finally {
            ConexaoMySQL.desconectar(conexao, stmt);
        }
        
    }

    public boolean pesquisar(Visitante visitante) {        
        Connection conexao = ConexaoMySQL.conectar();
        PreparedStatement stmt = null;
        
        ResultSet rs = null;
        
        boolean existe = false;
        
        try {
            stmt = conexao.prepareStatement("SELECT Cpf_Visitante FROM visitante WHERE Cpf_Visitante = ?");
            
            stmt.setInt(1, visitante.getCpf());                       
            
            rs = stmt.executeQuery();
            
            if (rs.next()) {
                existe = true;
            }                        
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro: " +ex);
        } finally {
            ConexaoMySQL.desconectar(conexao, stmt);
        }
        
        return existe;
    }
    
}
