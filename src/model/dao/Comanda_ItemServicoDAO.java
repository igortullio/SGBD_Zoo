
package model.dao;

import conexao.ConexaoMySQL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import model.bean.Comanda_ItemServico;

public class Comanda_ItemServicoDAO {

    public void insere(Comanda_ItemServico comandaItemServico){
        
        Connection conexao = ConexaoMySQL.conectar();
        PreparedStatement stmt = null;
        
        try {
            stmt = conexao.prepareStatement("INSERT INTO comanda_itemservico (Codigo_Comanda, Codigo_ItemServico, Valor_ItemServico, Quantidade_ItemServico) VALUES (?,?,(SELECT `Valor_ItemServico` FROM itemservico WHERE `Codigo_ItemServico` = ?),?) ");
            stmt.setInt(1, comandaItemServico.getCodigo_Comanda());
            stmt.setInt(2, comandaItemServico.getCodigo_ItemServico());
            stmt.setInt(3, comandaItemServico.getCodigo_ItemServico());
            stmt.setInt(4, comandaItemServico.getQuantidade());
            
            stmt.executeUpdate();                        
            
            JOptionPane.showMessageDialog(null, "Produto adicionado na comanda!");
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao abrir: "+ex);
        } finally {
            ConexaoMySQL.desconectar(conexao, stmt);
        }
        
    }
    
}
