
package model.dao;

import conexao.ConexaoMySQL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import model.bean.Funcao;
import model.bean.Funcionario;
import model.bean.FuncionarioSalarioJOIN;


public class FuncaoDAO {
    
    
        
  public void salvar(Funcao funcao){
        Connection conexao = ConexaoMySQL.conectar();
        PreparedStatement stmt = null;
        
        try {
            stmt = conexao.prepareStatement("INSERT INTO funcao (codigo_funcao, descricao_funcao, salario_funcao) VALUES (?, ?, ?)");
            
            stmt.setInt(1, funcao.getCodigo_funcao());
            stmt.setString(2, funcao.getDescricao_funcao());
            stmt.setDouble(3, funcao.getSalario_funcao());
          
            
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Função salva com sucesso!");
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro: " +ex);
        } finally {
            ConexaoMySQL.desconectar(conexao, stmt);
        }
      
    }
    
  public static List<Funcao> lerFuncao() {
        Connection conexao = ConexaoMySQL.conectar();
        PreparedStatement stmt = null;
        
        ResultSet rs = null;
        List<Funcao> funcaos = new ArrayList<>();
        
        
        try {
        stmt = conexao.prepareStatement("SELECT * FROM funcao");
        rs = stmt.executeQuery();
              
        while(rs.next()){
            
            Funcao funcao = new Funcao();
            
            funcao.setCodigo_funcao(rs.getInt("codigo_funcao"));
            funcao.setDescricao_funcao(rs.getString("descricao_funcao"));
            funcao.setSalario_funcao(rs.getDouble("salario_funcao"));
          
            funcaos.add(funcao); 
            
            
        }
        
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro: " +ex);
        } finally {
            ConexaoMySQL.desconectar(conexao, stmt);
        }
        
        return funcaos;
    }

  public static void excluirFuncao(Funcao funcao) {
        Connection conexao = ConexaoMySQL.conectar();
        PreparedStatement stmt = null;
        
        try {
            int resposta = JOptionPane.showConfirmDialog(null, "Você irá excluir a função do seguinte código: "+ funcao.getCodigo_funcao()+"\nTem certeza disto?", null, JOptionPane.YES_NO_OPTION);
            switch(resposta){
                case JOptionPane.YES_OPTION:
                    //cria o comando de DELETE
                    stmt = conexao.prepareStatement("DELETE FROM funcao WHERE codigo_funcao = ?");
                    //Pega o Código da ficha a ser excluida
                    stmt.setInt(1, funcao.getCodigo_funcao());
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
    
  public static void atualizar(Funcao funcao){
        Connection conexao = ConexaoMySQL.conectar();
        PreparedStatement stmt = null;
        
        try {
            stmt = conexao.prepareStatement("UPDATE funcao SET Descricao_Funcao = ?, Salario_Funcao = ? WHERE Codigo_Funcao = ?;");
            
            stmt.setString(1, funcao.getDescricao_funcao());
            stmt.setDouble(2, funcao.getSalario_funcao());
            stmt.setInt(3, funcao.getCodigo_funcao());
       
            stmt.executeUpdate();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }//fim try catch
    }//fim metodo
    
    public List<FuncionarioSalarioJOIN> lerJoin(){        
        Connection conexao = ConexaoMySQL.conectar();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<FuncionarioSalarioJOIN> listaJoin = new ArrayList<>();
        
        try {
            stmt = conexao.prepareStatement("SELECT * FROM zooFuncionarioSalario");
            
            rs = stmt.executeQuery();
            
            while (rs.next()) {
                FuncionarioSalarioJOIN join = new FuncionarioSalarioJOIN();
                
                join.setNome(rs.getString("Nome do Funcionário"));
                join.setValor(rs.getDouble("Salário"));
                
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

