import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;


public class NovoUsuario extends JFrame{
    
    private JLabel lbUsuario, lbSenha;
    private JTextField tfNomeNovoUsuario;    
    private JPasswordField tfSenhaNovoUsuario;
    private JButton btGravar, btCancelar, btSair;    

    public NovoUsuario() {
        super("ZOO - Cadastro");
        setLayout(new FlowLayout());
        
        lbUsuario = new JLabel("Usuário:");
        add(lbUsuario);

        tfNomeNovoUsuario = new JTextField(15);
        add(tfNomeNovoUsuario);

        lbSenha = new JLabel("Senha:  ");
        add(lbSenha);

        tfSenhaNovoUsuario = new JPasswordField(15);
        add(tfSenhaNovoUsuario);
        
        btGravar = new JButton("Gravar");
        btGravar.setToolTipText("Salvar cadastro");
        add(btGravar);

        btCancelar = new JButton("Cancelar");
        btCancelar.setToolTipText("Cancelar cadastro");
        add(btCancelar);

        btSair = new JButton("Sair");
        btSair.setToolTipText("Fechar tela de cadastro");
        add(btSair);
        
        // Cria o objeto da classe interna ButtonHandler e o registra para tratamento de evento de botão.
        ButtonHandler handler = new ButtonHandler();
        // Registra o objeto criado para tratar os ActionEvents dos dois botões.
        //btCopiar.addActionListener(handler);
        btGravar.addActionListener(handler);
        btCancelar.addActionListener(handler);
        btSair.addActionListener(handler);
    }

    private class ButtonHandler implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent evento) {
            
            if (evento.getSource() == btGravar) {
                if (tfNomeNovoUsuario.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Usuário obrigatório");
                } else {
                    if (tfSenhaNovoUsuario.getText().equals("")) {
                        JOptionPane.showMessageDialog(null, "Senha obrigatória");
                    } else {
                        ConexaoMySQL conexao = new ConexaoMySQL();
                        conexao.conectar();
                        
                        
                    }
                }
            } else if (evento.getSource() == btCancelar) {
                JOptionPane.showMessageDialog(null, "Usuário não cadastrado");
                tfNomeNovoUsuario.setText("");
                tfSenhaNovoUsuario.setText("");                
            } else if (evento.getSource() == btSair) {
                dispose();
            }
            
        }
    }
    
    
    
}
