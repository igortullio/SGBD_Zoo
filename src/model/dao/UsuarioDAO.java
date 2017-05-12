package model.dao;

import conexao.ConexaoMySQL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.bean.Usuario;


public class UsuarioDAO {

    public void criar(Usuario usuario) {
        
        Connection conexao = ConexaoMySQL.conectar();
        PreparedStatement stmt = null;
        
        try {
            stmt = conexao.prepareStatement("INSERT INTO usuario (Usuario_Usuario, Senha_Usuario) VALUES (?,?) ");
            stmt.setString(1, usuario.getUsuario());
            stmt.setString(2, usuario.getSenha());
            
            stmt.executeUpdate();                        
            
            JOptionPane.showMessageDialog(null, "Salvo com sucesso!");
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar: "+ex);
        } finally {
            ConexaoMySQL.desconectar(conexao, stmt);
        }
        
    }
    
    public boolean ler(String login, String senha){
        
        Connection conexao = ConexaoMySQL.conectar();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        boolean possuiLogin = false;
        
        try {
            stmt = conexao.prepareStatement("SELECT Usuario_Usuario, Senha_Usuario FROM usuario WHERE Usuario_Usuario = ? AND Senha_Usuario = ?");
            
            stmt.setString(1, login);
            stmt.setString(2, senha);
            
            rs = stmt.executeQuery();
            
            if (rs.next()) {
                possuiLogin = true;
            }

        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConexaoMySQL.desconectar(conexao, stmt, rs);
        }
        
        return possuiLogin;
    }
    
}
