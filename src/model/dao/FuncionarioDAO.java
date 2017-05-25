package model.dao;

import conexao.ConexaoMySQL;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import static java.time.LocalDate.now;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.bean.Funcionario;

public class FuncionarioDAO {
    
    public static void salvar(Funcionario funcionario){
        Connection conexao = ConexaoMySQL.conectar();
        PreparedStatement stmt = null;
        
        try {
            stmt = conexao.prepareStatement("INSERT INTO funcionario (codigo_funcionario, codigo_funcao, nome_funcionario, cpf_funcionario, rg_funcionario, dataEntrada_funcionario, telefone_funcionario) VALUES (?, ?, ?, ?, ?, ?, ?)");
            
            stmt.setInt(1, funcionario.getCodigo_funcionario());
            stmt.setInt(2, funcionario.getCodigo_funcao());
            stmt.setString(3, funcionario.getNome_funcionario());
            stmt.setString(4, funcionario.getCpf_funcionario());
            stmt.setInt(5, funcionario.getRg_funcionario());
            stmt.setString(6, funcionario.getDataEntrada_funcionario());
            stmt.setString(7, funcionario.getTelefone_funcionario());
            
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Funcionário salvo com sucesso!");
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro: " +ex);
        } finally {
            ConexaoMySQL.desconectar(conexao, stmt);
        }
      
    }
    
    public static List<Funcionario> ler() {
        Connection conexao = ConexaoMySQL.conectar();
        PreparedStatement stmt = null;
        
        ResultSet rs = null;
        List<Funcionario> funcionarios = new ArrayList<>();
        
        
        try {
        stmt = conexao.prepareStatement("select codigo_funcionario, codigo_funcao, nome_funcionario, cpf_funcionario, rg_funcionario, dataEntrada_funcionario, telefone_funcionario from funcionario;");
        rs = stmt.executeQuery();
              
        while(rs.next()){
            
            Funcionario funcionario = new Funcionario(
                    
            rs.getInt("codigo_funcionario"),
            rs.getInt("codigo_funcao"),
            rs.getString("nome_funcionario"),
            rs.getString("cpf_funcionario"),
            rs.getInt("rg_funcionario"),
            rs.getString("dataEntrada_funcionario"),
            rs.getString("telefone_funcionario")
            
            );
            funcionarios.add(funcionario);
        }
        
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro: " +ex);
        } finally {
            ConexaoMySQL.desconectar(conexao, stmt);
        }     
        return funcionarios;
    }
    
     public static List<Funcionario> lerPorCodigoFuncionario(int codigo_funcionario){
        Connection conexao = ConexaoMySQL.conectar();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Funcionario> funcionarios = new ArrayList<>();
        try {
            stmt = conexao.prepareStatement("SELECT codigo_funcionario, codigo_funcao, nome_funcionario, cpf_funcionario, rg_funcionario, dataEntrada_funcionario, telefone_funcionario FROM funcionario WHERE codigo_funcionario = ?;");
            stmt.setInt(1, codigo_funcionario);
            rs = stmt.executeQuery();
            while(rs.next()){
            
            Funcionario funcionario = new Funcionario(
                    
            rs.getInt("codigo_funcionario"),
            rs.getInt("codigo_funcao"),
            rs.getString("nome_funcionario"),
            rs.getString("cpf_funcionario"),
            rs.getInt("rg_funcionario"),
            rs.getString("dataEntrada_funcionario"),
            rs.getString("telefone_funcionario")
            
            );
            funcionarios.add(funcionario);
        }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro: " +e);
        } finally {
            ConexaoMySQL.desconectar(conexao, stmt, rs);
        }//fim try catch
        return funcionarios;
    }
    
     public static void excluir(Funcionario funcionario) {
        Connection conexao = ConexaoMySQL.conectar();
        PreparedStatement stmt = null;
        
        try {
            int resposta = JOptionPane.showConfirmDialog(null, "Você irá excluir o funcionário do seguinte código: "+ funcionario.getCodigo_funcionario()+"\nTem certeza disto?", null, JOptionPane.YES_NO_OPTION);
            switch(resposta){
                case JOptionPane.YES_OPTION:
                    //cria o comando de DELETE
                    stmt = conexao.prepareStatement("DELETE FROM funcionario WHERE codigo_funcionario = ?");
                    //Pega o Código da ficha a ser excluida
                    stmt.setInt(1, funcionario.getCodigo_funcionario());
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
     
     public static void atualizar(Funcionario funcionario){
        Connection conexao = ConexaoMySQL.conectar();
        PreparedStatement stmt = null;
        
        try {
            stmt = conexao.prepareStatement("UPDATE funcionario SET codigo_funcao = ?, nome_funcionario = ?, cpf_funcionario = ?, rg_funcionario = ?, telefone_funcionario = ? WHERE codigo_funcionario = ?;");
            stmt.setInt(1, funcionario.getCodigo_funcao());
            stmt.setString(2, funcionario.getNome_funcionario());
            stmt.setString(3, funcionario.getCpf_funcionario());
            stmt.setInt(4, funcionario.getRg_funcionario());
            stmt.setString(5, funcionario.getTelefone_funcionario());
            stmt.setInt(6, funcionario.getCodigo_funcionario());
            
            stmt.executeUpdate();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }//fim try catch
    }
}
