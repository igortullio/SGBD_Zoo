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
import model.dao.UsuarioDAO;

public class Login extends JFrame {

    private JLabel lbUsuario, lbSenha;
    private JTextField tfUsuario;
    private JPasswordField pfSenha;
    private JButton btEntrar, btNovoUsua, btSair;

    public Login(String titulo) {
        super(titulo);
        setLayout(new FlowLayout());

        lbUsuario = new JLabel("Usuário:");
        add(lbUsuario);

        tfUsuario = new JTextField(15);
        add(tfUsuario);

        lbSenha = new JLabel("Senha:  ");
        add(lbSenha);

        pfSenha = new JPasswordField(15);
        add(pfSenha);

        btEntrar = new JButton("Entrar");
        btEntrar.setToolTipText("Entrar na aplicação");
        add(btEntrar);

        btNovoUsua = new JButton("Novo Usuário");
        btNovoUsua.setToolTipText("Cadastrar novo usuário");
        add(btNovoUsua);

        btSair = new JButton("Sair");
        btSair.setToolTipText("Fechar aplicação");
        add(btSair);

        // Cria o objeto da classe interna ButtonHandler e o registra para tratamento de evento de botão.
        ButtonHandler handler = new ButtonHandler();
        // Registra o objeto criado para tratar os ActionEvents dos dois botões.
        btEntrar.addActionListener(handler);
        btNovoUsua.addActionListener(handler);
        btSair.addActionListener(handler);
        pfSenha.addActionListener(handler);

    }

    private class ButtonHandler implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent evento) {
            try {
                if (evento.getSource() == btEntrar || evento.getSource() == pfSenha) {
                    if (tfUsuario.getText().equals("")) {
                        JOptionPane.showMessageDialog(null, "Usuário obrigatório");
                    } else if (pfSenha.getText().equals("")) {
                        JOptionPane.showMessageDialog(null, "Senha obrigatória");
                    } else {
                        UsuarioDAO usuarioDAO = new UsuarioDAO();
                        if (usuarioDAO.ler(tfUsuario.getText(), pfSenha.getText())) {

                            // resposta == 0 para Comanda, 1 para Ficha Médica, -1 ou 2 para Escape/Cancelar.
                            String[] opcoes = new String[]{"Comanda", "Ficha Médica", "Cancelar"}; // vetor com 4 posições
                            int resposta
                                    = JOptionPane.showOptionDialog(
                                            null, //frame
                                            "Selecione o sistema.",
                                            "ZOO - Login",
                                            JOptionPane.DEFAULT_OPTION,
                                            JOptionPane.DEFAULT_OPTION,
                                            null, //icone
                                            opcoes,
                                            opcoes[0]
                                    );
                            switch (resposta) {
                                case 0: //Sistema de Comanda
                                    new ViewComanda().setVisible(true);
                                    break;
                                case 1: //Sistema de Ficha Médica
                                    new ViewFichaMedica().setVisible(true);
                                    break;
                                case 2:
                                    //Faz nada!
                                    break;
                            }
                        } else {
                            JOptionPane.showMessageDialog(null, "Usuário e/ou senha incorreta(s)!");
                        }
                    }
                } else if (evento.getSource() == btNovoUsua) {
                    NovoUsuario objNovoUsuario = new NovoUsuario();
                    objNovoUsuario.setSize(268, 115);
                    objNovoUsuario.setLocationRelativeTo(null);
                    objNovoUsuario.setResizable(false);
                    //objNovoUsuario.setIconImage(new ImageIcon(getClass().getResource("Imagens/icone_cadastro.png")).getImage());
                    objNovoUsuario.setVisible(true);
                    objNovoUsuario.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                } else if (evento.getSource() == btSair) {
                    dispose();
                }
            } catch (RuntimeException e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "Sem conexão com o Banco de Dados\n"+e.getCause().toString(), e.getMessage(), JOptionPane.ERROR_MESSAGE);
            }
        }
    }

}
