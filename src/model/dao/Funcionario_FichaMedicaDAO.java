/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import conexao.ConexaoMySQL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import model.bean.FuncionarioFichaJOIN;
import model.bean.FuncionarioSalarioJOIN;
import model.bean.Funcionario_FichaMedica;


public class Funcionario_FichaMedicaDAO {
    
   
    
    public static void gravar(Funcionario_FichaMedica fm){
        
        Connection conexao = ConexaoMySQL.conectar();
        PreparedStatement stmt = null;
        
        
        try {
            stmt = conexao.prepareStatement("INSERT INTO funcionario_fichamedica(codigo_funcionario, codigo_fichamedica) VALUES (?, ?)");
            
            
            stmt.setInt(1, fm.getCodigo_funcionario());
            stmt.setInt(2, fm.getCodigo_fichaMedica());
            
            
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null, " Tabela de 2 salva com sucesso!");
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro: " +ex);
        } finally {
            ConexaoMySQL.desconectar(conexao, stmt);
        }
        
        
    }
     public List<FuncionarioFichaJOIN> lerJoin(){        
        Connection conexao = ConexaoMySQL.conectar();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<FuncionarioFichaJOIN> listaJoin = new ArrayList<>();
        
        try {
            stmt = conexao.prepareStatement("SELECT * FROM zooFuncionarioFicha");
            
            rs = stmt.executeQuery();
            
            while (rs.next()) {
                FuncionarioFichaJOIN join = new FuncionarioFichaJOIN();
                
             join.setNomeFuncionario(rs.getString("nome_funcionario"));
             join.setCodigoFicha(rs.getInt("codigo_fichamedica"));
                
             listaJoin.add(join);
                                
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro: " +ex);
        } finally {
            ConexaoMySQL.desconectar(conexao, stmt, rs);
        }
        
        return listaJoin;
    }
    
}
