import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConexaoMySQL {    

    public static Connection conexao = null;
    private static final String usuario = "root";
    private static final String senha = "";
    private static final String url = "jdbc:mysql://127.0.0.1/zoo";
    private static final String driver = "com.mysql.jdbc.Driver";
    
    public ConexaoMySQL() {
        
    }       

    public static Connection conectar() {
        try {
            Class.forName(driver);
            conexao = DriverManager.getConnection(url, usuario, senha);
            System.out.println("Conectado.");
    
        } catch (ClassNotFoundException ex) {
            System.out.println("Classe não encontrada, adicione o driver nas bibliotecas.");
            Logger.getLogger(ConexaoMySQL.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException e) {
            System.out.println(e);
            throw new RuntimeException(e);
        }
        
        return conexao;
    }
    
    public static void desconectar(){
        try{
            if(conexao!=null && !conexao.isClosed()){
                conexao.close();
                System.out.println(">>Conexao encerrada com sucesso");
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}

