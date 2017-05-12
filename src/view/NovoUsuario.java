package view;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import model.bean.Usuario;
import model.dao.UsuarioDAO;


public class NovoUsuario extends JFrame{
    
    private JLabel lbUsuario, lbSenha;
    private JTextField tfNomeNovoUsuario;    
    private JPasswordField tfSenhaNovoUsuario;
    private JButton btCadastrar, btCancelar;    

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
        
        btCadastrar = new JButton("Cadastrar");
        btCadastrar.setToolTipText("Salvar cadastro");
        add(btCadastrar);

        btCancelar = new JButton("Cancelar");
        btCancelar.setToolTipText("Cancelar cadastro");
        add(btCancelar);
        
        // Cria o objeto da classe interna ButtonHandler e o registra para tratamento de evento de botão.
        ButtonHandler handler = new ButtonHandler();
        // Registra o objeto criado para tratar os ActionEvents dos dois botões.
        //btCopiar.addActionListener(handler);
        btCadastrar.addActionListener(handler);
        btCancelar.addActionListener(handler);
        tfSenhaNovoUsuario.addActionListener(handler);
    }

    private class ButtonHandler implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent evento) {
            
            if (evento.getSource() == btCadastrar || evento.getSource() == tfSenhaNovoUsuario) {
                if (tfNomeNovoUsuario.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Usuário obrigatório");
                } else {
                    if (tfSenhaNovoUsuario.getText().equals("")) {
                        JOptionPane.showMessageDialog(null, "Senha obrigatória");
                    } else {
                        Usuario usuario = new Usuario();
                        UsuarioDAO usuarioDAO = new UsuarioDAO();
                        
                        usuario.setUsuario(tfNomeNovoUsuario.getText());
                        usuario.setSenha(tfSenhaNovoUsuario.getText());
                        
                        usuarioDAO.criar(usuario);
                        
                        tfNomeNovoUsuario.setText("");
                        tfSenhaNovoUsuario.setText("");  
                        dispose();
                    }
                }
            } else if (evento.getSource() == btCancelar) {
                dispose();                
            }
            
        }
    }
    
    
    
}
