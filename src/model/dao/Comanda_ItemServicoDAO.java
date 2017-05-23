
package model.dao;

import conexao.ConexaoMySQL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import model.bean.Comanda;
import model.bean.Visitante;

public class Comanda_ItemServicoDAO {
    
    public List<Comanda> ler(){
        Connection conexao = ConexaoMySQL.conectar();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<Comanda> comandas = new ArrayList<>();        
        
        try {
            stmt = conexao.prepareStatement("SELECT * FROM comanda");
            
            rs = stmt.executeQuery();
            
            while (rs.next()) {
                Comanda comanda = new Comanda();
                
                comanda.setCodigo(rs.getInt("Codigo_Comanda"));
                comanda.setCpf_visitante(rs.getDouble("Cpf_Visitante"));
                comanda.setDataEntrada(rs.getString("DataEntrada_Comanda"));
                comanda.setValor(rs.getDouble("Valor_Comanda"));                
                
                comandas.add(comanda);
                                
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro: " +ex);
        } finally {
            ConexaoMySQL.desconectar(conexao, stmt, rs);
        }
        
        return comandas;
        
    }
    
}
