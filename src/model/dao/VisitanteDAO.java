
package model.dao;

import conexao.ConexaoMySQL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import model.bean.Visitante;


public class VisitanteDAO {
    
    public void salvar(Visitante visitante){
        Connection conexao = ConexaoMySQL.conectar();
        PreparedStatement stmt = null;
        
        try {
            stmt = conexao.prepareStatement("INSERT INTO visitante (Cpf_Visitante, Nome_Visitante, Telefone_Visitante) VALUES (?, ?, ?)");
            
            stmt.setDouble(1, visitante.getCpf());
            stmt.setString(2, visitante.getNome());
            stmt.setDouble(3, visitante.getTelefone());
            
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
            
            stmt.setDouble(1, visitante.getCpf());                       
            
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
    
    public List<Visitante> ler(){
        Connection conexao = ConexaoMySQL.conectar();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<Visitante> visitantes = new ArrayList<>();        
        
        try {
            stmt = conexao.prepareStatement("SELECT * FROM visitante");
            
            rs = stmt.executeQuery();
            
            while (rs.next()) {
                Visitante item = new Visitante();
                
                item.setCpf(rs.getDouble("Cpf_Visitante"));
                item.setNome(rs.getString("Nome_Visitante"));
                item.setTelefone(rs.getDouble("Telefone_Visitante"));
                
                visitantes.add(item);
                                
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro: " +ex);
        } finally {
            ConexaoMySQL.desconectar(conexao, stmt, rs);
        }
        
        return visitantes;
        
    }
    
}
