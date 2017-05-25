
package model.dao;

import conexao.ConexaoMySQL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import model.bean.Responsavel;

/**
 * 
 * @author Pedro Paul
 */
public class ResponsavelDAO {
    
    public static List<Responsavel> ler(){//este precisa retornar algo
        Connection conexao = ConexaoMySQL.conectar();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Responsavel> responsaveisLista = new ArrayList<>();
        try {
            stmt = conexao.prepareStatement("SELECT * FROM responsavelanimal;");
            rs = stmt.executeQuery();
            while (rs.next()) {                
                Responsavel responsavel = new Responsavel(
                        rs.getString("Nome_Funcionario"),//Nome_Funcionario
                        rs.getString("Especie_Animal"),//Especie_Animal
                        rs.getInt("Codigo_Animal")//Codigo_Animal
                );
                responsaveisLista.add(responsavel);
            }//fim while
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro: " +e);
        } finally {
            ConexaoMySQL.desconectar(conexao, stmt, rs);
        }//fim try catch
        return responsaveisLista;
    }//fim metodo
}//fim classe
