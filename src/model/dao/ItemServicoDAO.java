
package model.dao;

import conexao.ConexaoMySQL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import model.bean.ItemServico;

public class ItemServicoDAO {
    
    public void salvar(ItemServico item) {
        Connection conexao = ConexaoMySQL.conectar();
        PreparedStatement stmt = null;
        
        try {
            stmt = conexao.prepareStatement("INSERT INTO itemservico (Descricao_ItemServico, Valor_ItemServico) VALUES (?, ?)");
            
            stmt.setString(1, item.getDescricao());
            stmt.setDouble(2, item.getValor());
            
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Salvo!");
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro: " +ex);
        } finally {
            ConexaoMySQL.desconectar(conexao, stmt);
        }
        
    }
    
    public List<ItemServico> ler(){
        Connection conexao = ConexaoMySQL.conectar();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<ItemServico> itens = new ArrayList<>();        
        
        try {
            stmt = conexao.prepareStatement("SELECT * FROM itemservico");
            
            rs = stmt.executeQuery();
            
            while (rs.next()) {
                ItemServico item = new ItemServico();
                
                item.setCodigoItemServico(rs.getInt("Codigo_ItemServico"));
                item.setDescricao(rs.getString("Descricao_ItemServico"));
                item.setValor(rs.getDouble("Valor_ItemServico"));
                
                itens.add(item);
                                
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro: " +ex);
        } finally {
            ConexaoMySQL.desconectar(conexao, stmt, rs);
        }
        
        return itens;
        
    }
    
    public void alterar(ItemServico item) {
        Connection conexao = ConexaoMySQL.conectar();
        PreparedStatement stmt = null;
        
        try {
            stmt = conexao.prepareStatement("UPDATE itemservico SET Descricao_ItemServico = ?, Valor_ItemServico = ? WHERE Codigo_ItemServico = ?");
            
            stmt.setString(1, item.getDescricao());
            stmt.setDouble(2, item.getValor());
            stmt.setDouble(3, item.getCodigoItemServico());
            
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Atualizado com sucesso!");
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro: " +ex);
        } finally {
            ConexaoMySQL.desconectar(conexao, stmt);
        }
        
    }
    
    public void excluir(ItemServico item) {
        Connection conexao = ConexaoMySQL.conectar();
        PreparedStatement stmt = null;
        
        try {
            stmt = conexao.prepareStatement("DELETE FROM itemservico WHERE Codigo_ItemServico = ?");
                        
            stmt.setDouble(1, item.getCodigoItemServico());
            
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Excluido com sucesso!");
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro: " +ex);
        } finally {
            ConexaoMySQL.desconectar(conexao, stmt);
        }
        
    }
    
}
