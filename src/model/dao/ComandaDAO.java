
package model.dao;

import conexao.ConexaoMySQL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.bean.Comanda;
import model.bean.Visitante;

public class ComandaDAO {
    
    public void abre(Comanda comanda) {
        
        Connection conexao = ConexaoMySQL.conectar();
        PreparedStatement stmt = null;
        
        try {
            stmt = conexao.prepareStatement("INSERT INTO comanda (Cpf_Visitante) VALUES (?) ");
            stmt.setDouble(1, comanda.getCpf_visitante());            
            
            stmt.executeUpdate();                        
            
            JOptionPane.showMessageDialog(null, "Comanda aberta!");
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao abrir: "+ex);
        } finally {
            ConexaoMySQL.desconectar(conexao, stmt);
        }
        
    }
    
    public void fecha() { //PARA FECHAR O VALOR_COMANDA TEM QUE SER DEFINIDO
        
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
    
    public List<Visitante> lerPorNome(String nomeVistante){
        Connection conexao = ConexaoMySQL.conectar();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<Visitante> visitantes = new ArrayList<>();        
        
        try {
            stmt = conexao.prepareStatement("SELECT * FROM visitante WHERE Nome_Visitante LIKE ?");
            stmt.setString(1, "%"+nomeVistante+"%");
            
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
    
    public String verificaCPF(double cpfVistante){
        Connection conexao = ConexaoMySQL.conectar();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        String nomeVisitante = null;
        
        try {
            stmt = conexao.prepareStatement("SELECT Cpf_Visitante, Nome_Visitante FROM visitante WHERE Cpf_Visitante = ?");
            
            stmt.setDouble(1, cpfVistante);            
            
            rs = stmt.executeQuery();
            
            if (rs.next()) {
                nomeVisitante = rs.getString("Nome_Visitante");
            }

        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConexaoMySQL.desconectar(conexao, stmt, rs);
        }
        
        return nomeVisitante;
        
    }
    
    
}
