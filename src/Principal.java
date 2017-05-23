
import view.Login;
import javax.swing.JFrame;

public class Principal {
    
    static Login obj;

    public static void main(String[] args) {
        obj = new Login("ZOO - Login");
        obj.setSize(280, 115);                       // Configura o tamanho do frame
        obj.setLocationRelativeTo(null);             // Posiciona no centro da tela
        obj.setResizable(false);                     // Não é possível redimensionar
        obj.setVisible(true);                        // Torna o frame visível
        obj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
}
