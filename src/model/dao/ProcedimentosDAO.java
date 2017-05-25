package model.dao;

import conexao.ConexaoMySQL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import model.bean.FichaMedica;
import model.bean.Procedimentos;

public class ProcedimentosDAO{
    
    public List <Procedimentos> ler(){
        Connection conexao = ConexaoMySQL.conectar();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Procedimentos> procedimentos = new ArrayList<>();
        try {
            stmt = conexao.prepareStatement("select * from procedimentos");
            rs = stmt.executeQuery();
            while (rs.next()) {                
                Procedimentos pro = new Procedimentos();
                pro.setCodigo_Procedimentos(rs.getInt("Codigo_Procedimentos")); 
                pro.setCodigo_TipoProcedimentos(rs.getInt("Codigo_TipoProcedimento")); 
                pro.setDescricao(rs.getString("Descricao_Procedimentos")); 
                pro.setQuantidade(rs.getInt("Quantidade_Procedimentos")); 
                pro.setData_Vencimento(rs.getString("DataVencimento_Procedimentos")); 
                pro.setValor(rs.getDouble("Valor_Procedimentos")); 
                procedimentos.add(pro);
            }//fim while
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro: " +e);
        } finally {
            ConexaoMySQL.desconectar(conexao, stmt, rs);
        }//fim try catch
        return procedimentos;
    }
    
    public void inserir(Procedimentos procedimentos){
         Connection conexao = ConexaoMySQL.conectar();
        PreparedStatement stmt = null;
        
        try {
            stmt = conexao.prepareStatement("INSERT INTO procedimentos (Codigo_TipoProcedimento, Descricao_Procedimentos, Quantidade_Procedimentos, DataVencimento_Procedimentos, Valor_Procedimentos) values (?, ?, ?, str_to_date(?, '%d/%m/%Y'), ?)");
            stmt.setInt(1, procedimentos.getCodigo_TipoProcedimentos());
            stmt.setString(2, procedimentos.getDescricao());
            stmt.setInt(3, procedimentos.getQuantidade());
            stmt.setString(4, procedimentos.getData_Vencimento());
            stmt.setDouble(5, procedimentos.getValor());
            
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Criado!", null, JOptionPane.PLAIN_MESSAGE);
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e, e.getMessage(), JOptionPane.ERROR_MESSAGE);
        }//fim try catch
    }
    
   public void excluir(Procedimentos procedimento){
       Connection conexao = ConexaoMySQL.conectar();
        PreparedStatement stmt = null;
        
        try {
            stmt = conexao.prepareStatement("delete from procedimentos where Codigo_Procedimentos = ?");
            stmt.setInt(1, procedimento.getCodigo_Procedimentos());
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Excluido com Sucesso!");
            
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e, e.getMessage(), JOptionPane.ERROR_MESSAGE);
        }//fim try catch
   } 
}