package view;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import model.bean.Animal;
import model.dao.FichaMedicaDAO;
import model.bean.FichaMedica;
import model.bean.Funcao;
import model.bean.Funcionario;
import model.bean.FuncionarioSalarioJOIN;
import model.bean.Procedimentos;
import model.bean.Responsavel;
import model.dao.AnimalDAO;
import model.dao.FuncaoDAO;
import model.dao.FuncionarioDAO;
import model.dao.ProcedimentosDAO;
import model.dao.ResponsavelDAO;

/**
 * Tela do sistema de ficha médica do animal
 * 
 * @author Pedro Paul
 */
public class ViewFichaMedica extends javax.swing.JFrame {

    /**
     * Construtor da classe. Creates new form NewJFrame
     */
    public ViewFichaMedica() {
        initComponents();
        setLocationRelativeTo(null); // Deixa o Frame Centralizado
        setResizable(false); // Não deixa mudar o tamanho da tela

        DefaultTableModel modeloFichaMedica = (DefaultTableModel) jtFichaMedica.getModel();
        jtFichaMedica.setRowSorter(new TableRowSorter(modeloFichaMedica));
        
        DefaultTableModel modeloAnimal = (DefaultTableModel) jtAnimal.getModel();
        jtAnimal.setRowSorter(new TableRowSorter(modeloAnimal));
        
        DefaultTableModel modeloResponsavel = (DefaultTableModel) jtResponsavel.getModel();
        jtResponsavel.setRowSorter(new TableRowSorter(modeloResponsavel));
        
        //Parte do Caio
        DefaultTableModel modeloCadastroFuncionario = (DefaultTableModel) jtFuncionario.getModel();
        jtFuncionario.setRowSorter(new TableRowSorter(modeloCadastroFuncionario));

        DefaultTableModel modeloCadastroFuncao = (DefaultTableModel) jtFuncao.getModel();
        jtFuncao.setRowSorter(new TableRowSorter(modeloCadastroFuncao));

        DefaultTableModel modeloJOIN = (DefaultTableModel) jtJOIN_Funcao.getModel();
        jtJOIN_Funcao.setRowSorter(new TableRowSorter(modeloJOIN));
        
        //Parte do Elton
        DefaultTableModel modeloProcedimento = (DefaultTableModel) jtProcedimento.getModel();
        jtProcedimento.setRowSorter(new TableRowSorter(modeloProcedimento));
        
        lerTabelaFichaMedica();
        lerTabelaAnimal();
        lerTabelaResponsavel();
        lerTabelaFuncionario();//Parte do Caio
        lerTabelaFuncao();//Parte do Caio
        lerTabelaProcedimento();//Parte do Elton
        
    }
    
    private void lerTabelaFichaMedica(){
        DefaultTableModel modelFichaMedica = (DefaultTableModel)jtFichaMedica.getModel();
        modelFichaMedica.setRowCount(0);
        FichaMedicaDAO fichaDAO = new FichaMedicaDAO();
        for (FichaMedica f : fichaDAO.ler()) {
            modelFichaMedica.addRow(new Object[]{
                f.getCodigo_FichaMedica(),
                f.getCodigo_Animal(),
                f.getDataNascimento_FichaMedica(),
                f.getDataEntradaZoo_FichaMedica(),
                f.getEstadoSaude_FichaMedica(),
                f.getPeso_FichaMedica(),
                f.getAltura_FichaMedica()
            });
        }//fim for
    }//fim 
    
    private void lerTabelaAnimal(){
        DefaultTableModel modelAnimal = (DefaultTableModel)jtAnimal.getModel();
        modelAnimal.setRowCount(0);
        AnimalDAO animalDAO = new AnimalDAO();
        for (Animal a : animalDAO.ler()) {
            modelAnimal.addRow(new Object[]{
                a.getCodigo_Animal(),
                a.getReino_Animal(),
                a.getFilo_Animal(),
                a.getSubFilo_Animal(),
                a.getClasse_Animal(),
                a.getOrdem_Animal(),
                a.getFamilia_Animal(),
                a.getGenero_Animal(),
                a.getEspecie_Animal()
            });
        }//fim for
    }//fim metodo
    
    private void lerTabelaResponsavel(){
        DefaultTableModel modelResponsavel = (DefaultTableModel)jtResponsavel.getModel();
        modelResponsavel.setRowCount(0);
        ResponsavelDAO responsavel = new ResponsavelDAO();
        for (Responsavel r : ResponsavelDAO.ler()) {
            modelResponsavel.addRow(new Object[]{
                r.getNome_Funcionario(),
                r.getEspecie_Animal(),
                r.getCodigo_Animal()
            });
        }//fim for
    }
    
    private void lerTabelaFuncionario() {
        DefaultTableModel modelCadastroFuncionario = (DefaultTableModel) jtFuncionario.getModel();
        modelCadastroFuncionario.setRowCount(0);
        FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
        for (Funcionario f : funcionarioDAO.ler()) {
            modelCadastroFuncionario.addRow(new Object[]{
                f.getCodigo_funcionario(),
                f.getNome_funcionario(),
                f.getCpf_funcionario(),
                f.getRg_funcionario(),
                f.getCodigo_funcao(),
                f.getDataEntrada_funcionario(),
                f.getTelefone_funcionario(),});
        }//fim for
    }//fim metodo
    
    private void lerTabelaFuncao() {
        DefaultTableModel modelCadastroFuncao = (DefaultTableModel) jtFuncao.getModel();
        modelCadastroFuncao.setRowCount(0);
        FuncaoDAO funcaoDAO = new FuncaoDAO();
        for (Funcao f : funcaoDAO.lerFuncao()) {
            modelCadastroFuncao.addRow(new Object[]{
                f.getCodigo_funcao(),
                f.getDescricao_funcao(),
                f.getSalario_funcao(),});
        }//fim for
    }
    
    private void lerTabelaJOIN() {
        DefaultTableModel modelJOIN = (DefaultTableModel) jtJOIN_Funcao.getModel();
        modelJOIN.setRowCount(0);
        FuncaoDAO funcaoDAO = new FuncaoDAO();
        for (FuncionarioSalarioJOIN f : funcaoDAO.lerJoin()) {
            modelJOIN.addRow(new Object[]{
                f.getNome(),
                f.getValor()});
        }//fim for
    }
    
    public void lerTabelaProcedimento(){
        DefaultTableModel modelProcedimetos = (DefaultTableModel)jtProcedimento.getModel();
        modelProcedimetos.setRowCount(0);
        ProcedimentosDAO procedimentosDAO = new ProcedimentosDAO();
        
        for (Procedimentos p : procedimentosDAO.ler()) {
            modelProcedimetos.addRow(new Object[]{
                p.getCodigo_Procedimentos(),
                p.getCodigo_TipoProcedimentos(),
                p.getDescricao(),
                p.getQuantidade(),
                p.getData_Vencimento(),
                p.getValor()
            });
        }//fim for
        
    }
    
    private void lerTabelaFichaMedicaPeloCodigo(int codigo_FichaMedica) {
        DefaultTableModel modelFichaMedica = (DefaultTableModel) jtFichaMedica.getModel();
        modelFichaMedica.setNumRows(0);
        FichaMedicaDAO fichaDAO = new FichaMedicaDAO();
        for (FichaMedica f : fichaDAO.lerPorCodigo(codigo_FichaMedica)) {
            modelFichaMedica.addRow(new Object[]{
                f.getCodigo_FichaMedica(),
                f.getCodigo_Animal(),
                f.getDataNascimento_FichaMedica(),
                f.getDataEntradaZoo_FichaMedica(),
                f.getEstadoSaude_FichaMedica(),
                f.getPeso_FichaMedica(),
                f.getAltura_FichaMedica()
            });                        
        }
    }
    
    private void lerTabelaAnimalPeloCodigo(int codigo_Animal) {
        DefaultTableModel modelAnimal = (DefaultTableModel) jtAnimal.getModel();
        modelAnimal.setNumRows(0);
        AnimalDAO fichaDAO = new AnimalDAO();
        for (Animal a : AnimalDAO.lerPorCodigo(codigo_Animal)) {
            modelAnimal.addRow(new Object[]{
                a.getCodigo_Animal(),
                a.getReino_Animal(),
                a.getFilo_Animal(),
                a.getSubFilo_Animal(),
                a.getClasse_Animal(),
                a.getOrdem_Animal(),
                a.getFamilia_Animal(),
                a.getGenero_Animal(),
                a.getEspecie_Animal()
            });                        
        }
    }
    
    private void lerTabelaFuncionarioPeloCodigo(int codigo_funcionario) {
        DefaultTableModel modelFuncionario = (DefaultTableModel) jtFuncionario.getModel();
        modelFuncionario.setNumRows(0);
        FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
        for (Funcionario f : funcionarioDAO.lerPorCodigoFuncionario(codigo_funcionario)) {
            modelFuncionario.addRow(new Object[]{
                f.getCodigo_funcionario(),
                f.getNome_funcionario(),
                f.getCpf_funcionario(),
                f.getRg_funcionario(),
                f.getCodigo_funcao(),
                f.getDataEntrada_funcionario(),
                f.getTelefone_funcionario()
            });
        }
    }
    
    private void limparCamposTabelaFichaMedica(){
        tfCodAnimalFicha.setText("");
        tfNascimento.setText("");
        tfEntrada.setText("");
        cbEstadoSaude.setSelectedItem(null);
        tfPeso.setText("");
        tfAltura.setText("");
    }
    
    private void limparCamposTabelaAnimal(){
        tfReino.setText("");
        tfFilo.setText("");
        tfSubFilo.setText("");
        tfClasse.setText("");
        tfOrdem.setText("");
        tfFamilia.setText("");
        tfGenero.setText("");
        tfEspecie.setText("");
    }
    
    private void limparCamposTabelaFuncionario() {
        tfFuncaoFuncionario.setText("");
        tfNome.setText("");
        tfCpfFuncionario.setText("");
        tfRGFuncionario.setText("");
        tfTelefoneFuncionario.setText("");
    }
    
    private void limparCamposTabelaFuncao() {
        tfDescricaoFuncao.setText("");
        tfSalarioFuncao.setText("");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tpSistemaFichaMedica = new javax.swing.JTabbedPane();
        jpFichaMedica = new javax.swing.JPanel();
        spFichaMedica = new javax.swing.JScrollPane();
        jtFichaMedica = new javax.swing.JTable();
        jlCodAnimalFicha = new javax.swing.JLabel();
        tfCodAnimalFicha = new javax.swing.JTextField();
        jlNascimento = new javax.swing.JLabel();
        tfNascimento = new javax.swing.JTextField();
        jlEntrada = new javax.swing.JLabel();
        tfEntrada = new javax.swing.JTextField();
        jlEstadoSaude = new javax.swing.JLabel();
        cbEstadoSaude = new javax.swing.JComboBox();
        jlPeso = new javax.swing.JLabel();
        tfPeso = new javax.swing.JTextField();
        jlAltura = new javax.swing.JLabel();
        tfAltura = new javax.swing.JTextField();
        jbInserirFicha = new javax.swing.JButton();
        jbAtualizarFicha = new javax.swing.JButton();
        jbPesquisarFicha = new javax.swing.JButton();
        jbExcluirFicha = new javax.swing.JButton();
        jlCodFicha = new javax.swing.JLabel();
        tfCodFicha = new javax.swing.JTextField();
        jpAnimais = new javax.swing.JPanel();
        spAnimal = new javax.swing.JScrollPane();
        jtAnimal = new javax.swing.JTable();
        jlFilo = new javax.swing.JLabel();
        tfFilo = new javax.swing.JTextField();
        jlReino = new javax.swing.JLabel();
        tfReino = new javax.swing.JTextField();
        jlClasse = new javax.swing.JLabel();
        tfClasse = new javax.swing.JTextField();
        jlGenero = new javax.swing.JLabel();
        tfGenero = new javax.swing.JTextField();
        jlEspecie = new javax.swing.JLabel();
        tfEspecie = new javax.swing.JTextField();
        jlOrdem = new javax.swing.JLabel();
        tfOrdem = new javax.swing.JTextField();
        jlSubFilo = new javax.swing.JLabel();
        tfSubFilo = new javax.swing.JTextField();
        jlFamilia = new javax.swing.JLabel();
        tfFamilia = new javax.swing.JTextField();
        jbInserirAnimal = new javax.swing.JButton();
        jbAtualizarAnimal = new javax.swing.JButton();
        jbPesquisarAnimal = new javax.swing.JButton();
        jbExcluirAnimal = new javax.swing.JButton();
        jlCodAnimal = new javax.swing.JLabel();
        tfCodAnimal = new javax.swing.JTextField();
        jsResponsavel = new javax.swing.JScrollPane();
        jtResponsavel = new javax.swing.JTable();
        jbAtualizarResponsavel = new javax.swing.JButton();
        jpFuncionarios = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtFuncionario = new javax.swing.JTable();
        tfNome = new javax.swing.JTextField();
        jlNome = new javax.swing.JLabel();
        jlCPF = new javax.swing.JLabel();
        jlRG = new javax.swing.JLabel();
        jlFuncao = new javax.swing.JLabel();
        jlTelefone = new javax.swing.JLabel();
        tfFuncaoFuncionario = new javax.swing.JTextField();
        tfRGFuncionario = new javax.swing.JTextField();
        tfCpfFuncionario = new javax.swing.JTextField();
        jbInserirFuncionario = new javax.swing.JButton();
        jbExcluirFuncionario = new javax.swing.JButton();
        jlCodigoFuncionario = new javax.swing.JLabel();
        tfCodigoFuncionario = new javax.swing.JTextField();
        jbPesquisarFuncionario = new javax.swing.JButton();
        jbAtualizarFuncionario = new javax.swing.JButton();
        tfTelefoneFuncionario = new javax.swing.JTextField();
        jpProcedimentos = new javax.swing.JPanel();
        jtProcedimentos = new javax.swing.JScrollPane();
        jtProcedimento = new javax.swing.JTable();
        jlTipoProcedimentos = new javax.swing.JLabel();
        jlQuantidade = new javax.swing.JLabel();
        jlDataVencimento = new javax.swing.JLabel();
        jlValorProcedimento = new javax.swing.JLabel();
        tfProcedimentos_tipoProcedimentos = new javax.swing.JTextField();
        tfProcedimentos_Quantidade = new javax.swing.JTextField();
        tfProcedimentos_DataVencimento = new javax.swing.JTextField();
        tfProcedimentos_Valor = new javax.swing.JTextField();
        InserirProcedimentos = new javax.swing.JButton();
        ExcluirProcedimentos = new javax.swing.JButton();
        PesquisarProcedimentos = new javax.swing.JButton();
        AtualizarProcedimentos = new javax.swing.JButton();
        tfProcedimentos_Descricao = new javax.swing.JTextField();
        jlDescricaoProcedimento = new javax.swing.JLabel();
        jpFornecedores = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtFuncao = new javax.swing.JTable();
        jlDescricaoFuncao = new javax.swing.JLabel();
        jlSalarioFuncao = new javax.swing.JLabel();
        tfSalarioFuncao = new javax.swing.JTextField();
        tfDescricaoFuncao = new javax.swing.JTextField();
        jbInserirFuncao = new javax.swing.JButton();
        jbAtualiza_Funcao = new javax.swing.JButton();
        jbExcluir_Funcao = new javax.swing.JButton();
        jbVerifica = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        jtJOIN_Funcao = new javax.swing.JTable();
        btVoltar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Sistema Ficha Médica");
        setPreferredSize(new java.awt.Dimension(1024, 500));

        jtFichaMedica.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Cód Ficha", "Cód Animal", "Nascimento", "Entrada", "Estado Saúde", "Peso", "Altura"
            }
        ));
        jtFichaMedica.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtFichaMedicaMouseClicked(evt);
            }
        });
        spFichaMedica.setViewportView(jtFichaMedica);

        jlCodAnimalFicha.setText("Código do Animal");

        jlNascimento.setText("Data de Nascimento");

        jlEntrada.setText("Data de Entrada");

        jlEstadoSaude.setText("Estado de Saúde");

        cbEstadoSaude.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Normal", "Atenção", "Grave" }));
        cbEstadoSaude.setSelectedItem(null);

        jlPeso.setText("Peso");

        jlAltura.setText("Altura");

        jbInserirFicha.setText("Inserir");
        jbInserirFicha.setToolTipText("Digite dos dados nescessários e clique para inserir no banco");
        jbInserirFicha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbInserirFichaActionPerformed(evt);
            }
        });

        jbAtualizarFicha.setText("Atualizar");
        jbAtualizarFicha.setToolTipText("Selecione uma ficha na tabela e clique para atualizar");
        jbAtualizarFicha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbAtualizarFichaActionPerformed(evt);
            }
        });

        jbPesquisarFicha.setText("Pesquisar");
        jbPesquisarFicha.setToolTipText("Pesquisa a ficha pelo código digitado");
        jbPesquisarFicha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbPesquisarFichaActionPerformed(evt);
            }
        });

        jbExcluirFicha.setText("Excluir");
        jbExcluirFicha.setToolTipText("Selecione uma ficha na tabela e clique para excluir");
        jbExcluirFicha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbExcluirFichaActionPerformed(evt);
            }
        });

        jlCodFicha.setText("Código da Ficha");

        javax.swing.GroupLayout jpFichaMedicaLayout = new javax.swing.GroupLayout(jpFichaMedica);
        jpFichaMedica.setLayout(jpFichaMedicaLayout);
        jpFichaMedicaLayout.setHorizontalGroup(
            jpFichaMedicaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpFichaMedicaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpFichaMedicaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpFichaMedicaLayout.createSequentialGroup()
                        .addGroup(jpFichaMedicaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jpFichaMedicaLayout.createSequentialGroup()
                                .addGroup(jpFichaMedicaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jlAltura)
                                    .addComponent(jlPeso)
                                    .addComponent(jlEstadoSaude))
                                .addGap(36, 36, 36)
                                .addGroup(jpFichaMedicaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(tfPeso)
                                    .addComponent(tfAltura)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jpFichaMedicaLayout.createSequentialGroup()
                                        .addComponent(cbEstadoSaude, 0, 92, Short.MAX_VALUE)
                                        .addGap(3, 3, 3))))
                            .addGroup(jpFichaMedicaLayout.createSequentialGroup()
                                .addGroup(jpFichaMedicaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jlNascimento)
                                    .addComponent(jlCodAnimalFicha)
                                    .addComponent(jlEntrada))
                                .addGap(18, 18, 18)
                                .addGroup(jpFichaMedicaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(tfEntrada, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(tfCodAnimalFicha, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(tfNascimento, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(18, 18, 18)
                        .addGroup(jpFichaMedicaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jbExcluirFicha, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jbInserirFicha, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(36, 36, 36)
                        .addComponent(jlCodFicha)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfCodFicha, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jpFichaMedicaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jbPesquisarFicha, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jbAtualizarFicha, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(spFichaMedica, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 970, Short.MAX_VALUE))
                .addContainerGap())
        );
        jpFichaMedicaLayout.setVerticalGroup(
            jpFichaMedicaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpFichaMedicaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(spFichaMedica, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpFichaMedicaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpFichaMedicaLayout.createSequentialGroup()
                        .addGroup(jpFichaMedicaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jlCodAnimalFicha)
                            .addComponent(tfCodAnimalFicha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jpFichaMedicaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jlNascimento)
                            .addComponent(tfNascimento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jpFichaMedicaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tfEntrada, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jlEntrada))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jpFichaMedicaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jlEstadoSaude)
                            .addComponent(cbEstadoSaude, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jpFichaMedicaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jlPeso)
                            .addComponent(tfPeso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jpFichaMedicaLayout.createSequentialGroup()
                        .addGroup(jpFichaMedicaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jbInserirFicha)
                            .addComponent(jlCodFicha)
                            .addComponent(tfCodFicha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jbPesquisarFicha))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jpFichaMedicaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jbAtualizarFicha)
                            .addComponent(jbExcluirFicha))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpFichaMedicaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlAltura)
                    .addComponent(tfAltura, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(55, Short.MAX_VALUE))
        );

        jpFichaMedicaLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {tfAltura, tfPeso});

        tpSistemaFichaMedica.addTab("Ficha Médica", jpFichaMedica);

        jtAnimal.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Cód Animal", "Reino", "Filo", "Sub Filo", "Classe", "Ordem", "Família", "Gênero", "Espécie"
            }
        ));
        jtAnimal.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtAnimalMouseClicked(evt);
            }
        });
        spAnimal.setViewportView(jtAnimal);

        jlFilo.setText("Filo");

        jlReino.setText("Reino");

        jlClasse.setText("Classe");

        jlGenero.setText("Gênero");

        jlEspecie.setText("Espécie");

        jlOrdem.setText("Ordem");

        jlSubFilo.setText("Sub Filo");

        jlFamilia.setText("Familia");

        jbInserirAnimal.setText("Inserir");
        jbInserirAnimal.setToolTipText("Digite todos dados nescessários e clique para inserir no banco");
        jbInserirAnimal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbInserirAnimalActionPerformed(evt);
            }
        });

        jbAtualizarAnimal.setText("Atualizar");
        jbAtualizarAnimal.setToolTipText("Selecione um animal na tabela e clique para atualizar");
        jbAtualizarAnimal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbAtualizarAnimalActionPerformed(evt);
            }
        });

        jbPesquisarAnimal.setText("Pesquisar");
        jbPesquisarAnimal.setToolTipText("Pesquisa o animal pelo código digitado");
        jbPesquisarAnimal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbPesquisarAnimalActionPerformed(evt);
            }
        });

        jbExcluirAnimal.setText("Excluir");
        jbExcluirAnimal.setToolTipText("Selecione um animal na tabela e clique para excluir");
        jbExcluirAnimal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbExcluirAnimalActionPerformed(evt);
            }
        });

        jlCodAnimal.setText("Código do Animal");

        jtResponsavel.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Responsável", "Animal", "Cód Animal"
            }
        ));
        jsResponsavel.setViewportView(jtResponsavel);

        jbAtualizarResponsavel.setText("Atualizar");
        jbAtualizarResponsavel.setToolTipText("Atualiza a tabela de Responsáveis por animais acima");
        jbAtualizarResponsavel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbAtualizarResponsavelActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jpAnimaisLayout = new javax.swing.GroupLayout(jpAnimais);
        jpAnimais.setLayout(jpAnimaisLayout);
        jpAnimaisLayout.setHorizontalGroup(
            jpAnimaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpAnimaisLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpAnimaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(spAnimal, javax.swing.GroupLayout.DEFAULT_SIZE, 970, Short.MAX_VALUE)
                    .addGroup(jpAnimaisLayout.createSequentialGroup()
                        .addGroup(jpAnimaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jpAnimaisLayout.createSequentialGroup()
                                .addGroup(jpAnimaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jpAnimaisLayout.createSequentialGroup()
                                        .addGroup(jpAnimaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jlFamilia, javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jlOrdem))
                                        .addGap(22, 22, 22)
                                        .addComponent(tfFamilia, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jpAnimaisLayout.createSequentialGroup()
                                        .addGroup(jpAnimaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jlSubFilo, javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jlClasse, javax.swing.GroupLayout.Alignment.LEADING))
                                        .addGap(18, 18, 18)
                                        .addGroup(jpAnimaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(tfOrdem, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 94, Short.MAX_VALUE)
                                            .addComponent(tfClasse, javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(tfSubFilo, javax.swing.GroupLayout.Alignment.TRAILING))))
                                .addGap(18, 18, 18)
                                .addGroup(jpAnimaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jbExcluirAnimal)
                                    .addComponent(jbInserirAnimal)
                                    .addComponent(jbAtualizarAnimal, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jpAnimaisLayout.createSequentialGroup()
                                .addGroup(jpAnimaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jlReino)
                                    .addComponent(jlFilo))
                                .addGap(27, 27, 27)
                                .addGroup(jpAnimaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(tfReino)
                                    .addComponent(tfFilo, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jpAnimaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jlEspecie)
                                    .addComponent(jlGenero))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jpAnimaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(tfGenero, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(tfEspecie, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jpAnimaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jpAnimaisLayout.createSequentialGroup()
                                        .addComponent(jlCodAnimal)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(tfCodAnimal, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jpAnimaisLayout.createSequentialGroup()
                                        .addGap(10, 10, 10)
                                        .addComponent(jbPesquisarAnimal, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(61, 61, 61)
                        .addGroup(jpAnimaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jsResponsavel, javax.swing.GroupLayout.PREFERRED_SIZE, 318, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jpAnimaisLayout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jbAtualizarResponsavel)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jpAnimaisLayout.setVerticalGroup(
            jpAnimaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpAnimaisLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(spAnimal, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jpAnimaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jpAnimaisLayout.createSequentialGroup()
                        .addGroup(jpAnimaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jpAnimaisLayout.createSequentialGroup()
                                .addComponent(jlGenero)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 62, Short.MAX_VALUE)
                                .addComponent(jbInserirAnimal)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jbExcluirAnimal))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpAnimaisLayout.createSequentialGroup()
                                .addGroup(jpAnimaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(tfGenero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jlCodAnimal)
                                    .addComponent(tfCodAnimal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jpAnimaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(tfEspecie, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jlEspecie)
                                    .addComponent(jbPesquisarAnimal))
                                .addGap(73, 73, 73)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jbAtualizarAnimal)
                        .addGap(25, 25, 25))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jpAnimaisLayout.createSequentialGroup()
                        .addGroup(jpAnimaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jpAnimaisLayout.createSequentialGroup()
                                .addGroup(jpAnimaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jlReino)
                                    .addComponent(tfReino, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jpAnimaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jlFilo)
                                    .addComponent(tfFilo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(7, 7, 7)
                                .addGroup(jpAnimaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jlSubFilo)
                                    .addComponent(tfSubFilo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(9, 9, 9)
                                .addGroup(jpAnimaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(tfClasse, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jlClasse))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jpAnimaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jlOrdem)
                                    .addComponent(tfOrdem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(4, 4, 4)
                                .addGroup(jpAnimaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jlFamilia)
                                    .addComponent(tfFamilia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jpAnimaisLayout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addComponent(jsResponsavel, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jbAtualizarResponsavel)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        tpSistemaFichaMedica.addTab("Cadastro de Animais", jpAnimais);

        jtFuncionario.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Nome", "CPF", "RG", "Função", "Data de Entrada", "Telefone"
            }
        ));
        jtFuncionario.setCellSelectionEnabled(true);
        jtFuncionario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtFuncionarioMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jtFuncionario);

        jlNome.setText("Nome");

        jlCPF.setText("CPF");

        jlRG.setText("RG");

        jlFuncao.setText("Função");

        jlTelefone.setText("Telefone");

        jbInserirFuncionario.setText("Inserir");
        jbInserirFuncionario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbInserirFuncionarioActionPerformed(evt);
            }
        });

        jbExcluirFuncionario.setText("Excluir");
        jbExcluirFuncionario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbExcluirFuncionarioActionPerformed(evt);
            }
        });

        jlCodigoFuncionario.setText("Código do Funcionário");

        jbPesquisarFuncionario.setText("Pesquisar");
        jbPesquisarFuncionario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbPesquisarFuncionarioActionPerformed(evt);
            }
        });

        jbAtualizarFuncionario.setText("Atualizar");
        jbAtualizarFuncionario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbAtualizarFuncionarioActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jpFuncionariosLayout = new javax.swing.GroupLayout(jpFuncionarios);
        jpFuncionarios.setLayout(jpFuncionariosLayout);
        jpFuncionariosLayout.setHorizontalGroup(
            jpFuncionariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpFuncionariosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpFuncionariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpFuncionariosLayout.createSequentialGroup()
                        .addGroup(jpFuncionariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jpFuncionariosLayout.createSequentialGroup()
                                .addComponent(jlFuncao)
                                .addGap(11, 11, 11))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpFuncionariosLayout.createSequentialGroup()
                                .addComponent(jlTelefone)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                        .addGroup(jpFuncionariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tfFuncaoFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfTelefoneFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jpFuncionariosLayout.createSequentialGroup()
                        .addGroup(jpFuncionariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(jpFuncionariosLayout.createSequentialGroup()
                                .addComponent(jlCPF)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(tfCpfFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(79, 79, 79))
                            .addGroup(jpFuncionariosLayout.createSequentialGroup()
                                .addGroup(jpFuncionariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jpFuncionariosLayout.createSequentialGroup()
                                        .addComponent(jlNome)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(tfNome, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jpFuncionariosLayout.createSequentialGroup()
                                        .addComponent(jlRG)
                                        .addGap(18, 18, 18)
                                        .addComponent(tfRGFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(18, 18, 18)
                                .addComponent(jbInserirFuncionario)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jbExcluirFuncionario)
                        .addGap(52, 52, 52)
                        .addComponent(jlCodigoFuncionario)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(tfCodigoFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jbPesquisarFuncionario)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jbAtualizarFuncionario)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jpFuncionariosLayout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 989, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 1, Short.MAX_VALUE))
        );
        jpFuncionariosLayout.setVerticalGroup(
            jpFuncionariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpFuncionariosLayout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 220, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpFuncionariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlNome)
                    .addComponent(tfNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbInserirFuncionario)
                    .addComponent(jbExcluirFuncionario)
                    .addComponent(jlCodigoFuncionario)
                    .addComponent(tfCodigoFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbPesquisarFuncionario)
                    .addComponent(jbAtualizarFuncionario))
                .addGap(2, 2, 2)
                .addGroup(jpFuncionariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfCpfFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlCPF))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpFuncionariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlRG)
                    .addComponent(tfRGFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpFuncionariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfFuncaoFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlFuncao))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpFuncionariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlTelefone)
                    .addComponent(tfTelefoneFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(38, 38, 38))
        );

        tpSistemaFichaMedica.addTab("Cadastro de Funcionários", jpFuncionarios);

        jtProcedimento.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Tipo", "Descrição", "Quantidade", "Data de Vencimento", "Valor"
            }
        ));
        jtProcedimento.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtProcedimentoMouseClicked(evt);
            }
        });
        jtProcedimento.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtProcedimentoKeyReleased(evt);
            }
        });
        jtProcedimentos.setViewportView(jtProcedimento);

        jlTipoProcedimentos.setText("Tipo de Procedimento:");

        jlQuantidade.setText("Quantidade:");

        jlDataVencimento.setText("Data de Vencimento:");

        jlValorProcedimento.setText("Valor:");

        tfProcedimentos_Quantidade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfProcedimentos_QuantidadeActionPerformed(evt);
            }
        });

        InserirProcedimentos.setText("Inserir");
        InserirProcedimentos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                InserirProcedimentosActionPerformed(evt);
            }
        });

        ExcluirProcedimentos.setText("Excluir");
        ExcluirProcedimentos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ExcluirProcedimentosActionPerformed(evt);
            }
        });

        PesquisarProcedimentos.setText("Pesquisar");
        PesquisarProcedimentos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PesquisarProcedimentosActionPerformed(evt);
            }
        });

        AtualizarProcedimentos.setText("Atualizar");

        tfProcedimentos_Descricao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfProcedimentos_DescricaoActionPerformed(evt);
            }
        });

        jlDescricaoProcedimento.setText("Descrição:");

        javax.swing.GroupLayout jpProcedimentosLayout = new javax.swing.GroupLayout(jpProcedimentos);
        jpProcedimentos.setLayout(jpProcedimentosLayout);
        jpProcedimentosLayout.setHorizontalGroup(
            jpProcedimentosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jtProcedimentos)
            .addGroup(jpProcedimentosLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jpProcedimentosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jlTipoProcedimentos)
                    .addComponent(jlQuantidade)
                    .addComponent(jlValorProcedimento)
                    .addComponent(jlDataVencimento))
                .addGap(18, 18, 18)
                .addGroup(jpProcedimentosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(tfProcedimentos_tipoProcedimentos)
                    .addComponent(tfProcedimentos_Quantidade)
                    .addComponent(tfProcedimentos_Valor)
                    .addComponent(tfProcedimentos_DataVencimento, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jpProcedimentosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpProcedimentosLayout.createSequentialGroup()
                        .addComponent(InserirProcedimentos)
                        .addGap(18, 18, 18)
                        .addComponent(ExcluirProcedimentos)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(PesquisarProcedimentos)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(AtualizarProcedimentos))
                    .addComponent(jlDescricaoProcedimento)
                    .addComponent(tfProcedimentos_Descricao, javax.swing.GroupLayout.PREFERRED_SIZE, 325, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(364, Short.MAX_VALUE))
        );
        jpProcedimentosLayout.setVerticalGroup(
            jpProcedimentosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpProcedimentosLayout.createSequentialGroup()
                .addComponent(jtProcedimentos, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jlDescricaoProcedimento)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jpProcedimentosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jpProcedimentosLayout.createSequentialGroup()
                        .addGroup(jpProcedimentosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jlTipoProcedimentos)
                            .addComponent(tfProcedimentos_tipoProcedimentos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jpProcedimentosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jlQuantidade)
                            .addComponent(tfProcedimentos_Quantidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jpProcedimentosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jlDataVencimento)
                            .addComponent(tfProcedimentos_DataVencimento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(13, 13, 13)
                        .addGroup(jpProcedimentosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tfProcedimentos_Valor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jlValorProcedimento)))
                    .addComponent(tfProcedimentos_Descricao))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpProcedimentosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ExcluirProcedimentos)
                    .addComponent(InserirProcedimentos)
                    .addComponent(PesquisarProcedimentos)
                    .addComponent(AtualizarProcedimentos))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        tpSistemaFichaMedica.addTab("Procedimentos", jpProcedimentos);

        jtFuncao.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código da Função", "Nome da Função", "Salário da Função"
            }
        ));
        jtFuncao.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtFuncaoMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jtFuncao);

        jlDescricaoFuncao.setText("Função");

        jlSalarioFuncao.setText("Salário");

        jbInserirFuncao.setText("Inserir");
        jbInserirFuncao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbInserirFuncaoActionPerformed(evt);
            }
        });

        jbAtualiza_Funcao.setText("Atualizar");
        jbAtualiza_Funcao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbAtualiza_FuncaoActionPerformed(evt);
            }
        });

        jbExcluir_Funcao.setText("Excluir");
        jbExcluir_Funcao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbExcluir_FuncaoActionPerformed(evt);
            }
        });

        jbVerifica.setText("Verifica");
        jbVerifica.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbVerificaActionPerformed(evt);
            }
        });

        jtJOIN_Funcao.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Funcionário", "Salário"
            }
        ));
        jScrollPane3.setViewportView(jtJOIN_Funcao);

        javax.swing.GroupLayout jpFornecedoresLayout = new javax.swing.GroupLayout(jpFornecedores);
        jpFornecedores.setLayout(jpFornecedoresLayout);
        jpFornecedoresLayout.setHorizontalGroup(
            jpFornecedoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2)
            .addGroup(jpFornecedoresLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpFornecedoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jpFornecedoresLayout.createSequentialGroup()
                        .addComponent(jlDescricaoFuncao)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(tfDescricaoFuncao, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jpFornecedoresLayout.createSequentialGroup()
                        .addComponent(jlSalarioFuncao)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(tfSalarioFuncao)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jpFornecedoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpFornecedoresLayout.createSequentialGroup()
                        .addComponent(jbExcluir_Funcao)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(145, 145, 145))
                    .addGroup(jpFornecedoresLayout.createSequentialGroup()
                        .addComponent(jbInserirFuncao)
                        .addGap(18, 18, 18)
                        .addComponent(jbAtualiza_Funcao, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 328, Short.MAX_VALUE)
                        .addComponent(jbVerifica)
                        .addGap(261, 261, 261))))
        );
        jpFornecedoresLayout.setVerticalGroup(
            jpFornecedoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpFornecedoresLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jpFornecedoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpFornecedoresLayout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addGroup(jpFornecedoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jlDescricaoFuncao)
                            .addComponent(tfDescricaoFuncao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jbInserirFuncao)
                            .addComponent(jbAtualiza_Funcao)))
                    .addGroup(jpFornecedoresLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jbVerifica)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jpFornecedoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpFornecedoresLayout.createSequentialGroup()
                        .addGroup(jpFornecedoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jlSalarioFuncao)
                            .addComponent(tfSalarioFuncao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jbExcluir_Funcao))
                        .addGap(0, 91, Short.MAX_VALUE))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
        );

        tpSistemaFichaMedica.addTab("Função", jpFornecedores);

        btVoltar.setText("Voltar");
        btVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btVoltarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tpSistemaFichaMedica)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btVoltar)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(tpSistemaFichaMedica, javax.swing.GroupLayout.PREFERRED_SIZE, 420, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btVoltar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
   
    private void btVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btVoltarActionPerformed
        dispose();
    }//GEN-LAST:event_btVoltarActionPerformed

    private void jbInserirFichaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbInserirFichaActionPerformed
        try {
            //criar o objeto da classe FichaMedica
            FichaMedica ficha = new FichaMedica(
                Integer.parseInt(tfCodAnimalFicha.getText()),
                tfNascimento.getText(),
                tfEntrada.getText(),
                cbEstadoSaude.getSelectedItem().toString(),
                Float.parseFloat(tfPeso.getText()),
                Float.parseFloat(tfAltura.getText())
            );
            //Pegar os textos e mandar pro banco
            FichaMedicaDAO.inserir(ficha);
            //Limpeza dos Campos
            limparCamposTabelaFichaMedica();
            //atualiza a tabela FichaMedica
            lerTabelaFichaMedica();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }//fim try catch
    }//GEN-LAST:event_jbInserirFichaActionPerformed

    private void jbExcluirFichaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbExcluirFichaActionPerformed
        try {
            FichaMedica ficha = new FichaMedica();
            FichaMedicaDAO fichaDAO = new FichaMedicaDAO();

            ficha.setCodigo_FichaMedica(
                    (int)jtFichaMedica.getValueAt(
                            jtFichaMedica.getSelectedRow(), 0
                    )
            );
            
            fichaDAO.excluir(ficha);

            limparCamposTabelaFichaMedica();

            lerTabelaFichaMedica();
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_jbExcluirFichaActionPerformed

    private void jbPesquisarFichaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbPesquisarFichaActionPerformed
        try {
            //Cria os objetos da ficha a ser buscada
            FichaMedica ficha = new FichaMedica();
            //Pega o código digitado para busca
            ficha.setCodigo_FichaMedica(Integer.parseInt(tfCodFicha.getText()));
            lerTabelaFichaMedicaPeloCodigo(ficha.getCodigo_FichaMedica());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_jbPesquisarFichaActionPerformed

    private void jtFichaMedicaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtFichaMedicaMouseClicked
        try {
            tfCodAnimalFicha.setText(jtFichaMedica.getValueAt(jtFichaMedica.getSelectedRow(), 1).toString());
            tfEntrada.setText(jtFichaMedica.getValueAt(jtFichaMedica.getSelectedRow(), 2).toString());
            tfNascimento.setText(jtFichaMedica.getValueAt(jtFichaMedica.getSelectedRow(), 3).toString());
            cbEstadoSaude.setSelectedItem(jtFichaMedica.getValueAt(jtFichaMedica.getSelectedRow(), 4).toString());
            tfPeso.setText(jtFichaMedica.getValueAt(jtFichaMedica.getSelectedRow(), 5).toString());
            tfAltura.setText(jtFichaMedica.getValueAt(jtFichaMedica.getSelectedRow(), 6).toString());
        } catch (Exception e) {
        }
        
    }//GEN-LAST:event_jtFichaMedicaMouseClicked

    private void jbAtualizarFichaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbAtualizarFichaActionPerformed
        try {
            //selecionar ficha com modificações
            FichaMedica ficha = new FichaMedica(
                    Integer.parseInt(jtFichaMedica.getValueAt(jtFichaMedica.getSelectedRow(), 0).toString()),//Codigo_FichaMedica 
                    Integer.parseInt(tfCodAnimalFicha.getText()),//Codigo_Animal 
                    tfNascimento.getText(),//DataNascimento_FichaMedica 
                    tfEntrada.getText(),//DataEntradaZoo_FichaMedica 
                    cbEstadoSaude.getSelectedItem().toString(),//EstadoSaude_FichaMedica 
                    Float.parseFloat(tfPeso.getText()),//Peso_FichaMedica 
                    Float.parseFloat(tfAltura.getText())//Altura_FichaMedica
            );
            //alterar no banco
            FichaMedicaDAO.atualizar(ficha);
            //Mensagensinha
            JOptionPane.showMessageDialog(null, "Atualizado.");
            //atualiza a tabela no frame
            lerTabelaFichaMedica();
        } catch (IndexOutOfBoundsException e){
            JOptionPane.showMessageDialog(null, "Selecione uma ficha na tabela", null, JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_jbAtualizarFichaActionPerformed

    private void jtAnimalMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtAnimalMouseClicked
        try {
            tfReino.setText(jtAnimal.getValueAt(jtAnimal.getSelectedRow(), 1).toString());
            tfFilo.setText(jtAnimal.getValueAt(jtAnimal.getSelectedRow(), 2).toString());
            tfSubFilo.setText(jtAnimal.getValueAt(jtAnimal.getSelectedRow(), 3).toString());
            tfClasse.setText(jtAnimal.getValueAt(jtAnimal.getSelectedRow(), 4).toString());
            tfOrdem.setText(jtAnimal.getValueAt(jtAnimal.getSelectedRow(), 5).toString());
            tfFamilia.setText(jtAnimal.getValueAt(jtAnimal.getSelectedRow(), 6).toString());
            tfGenero.setText(jtAnimal.getValueAt(jtAnimal.getSelectedRow(), 7).toString());
            tfEspecie.setText(jtAnimal.getValueAt(jtAnimal.getSelectedRow(), 8).toString());
        } catch (Exception e) {
        }
    }//GEN-LAST:event_jtAnimalMouseClicked

    private void jbInserirAnimalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbInserirAnimalActionPerformed
        try {
            //criar o objeto da classe Animal
            Animal animal = new Animal(
                tfReino.getText(),//Reino_Animal 
                tfFilo.getText(),//Filo_Animal 
                tfSubFilo.getText(),//SubFilo_Animal 
                tfClasse.getText(),//Classe_Animal 
                tfOrdem.getText(),//Ordem_Animal 
                tfFamilia.getText(),//Familia_Animal 
                tfGenero.getText(),//Genero_Animal 
                tfEspecie.getText()//Especie_Animal
            );
            //Pegar os textos e mandar pro banco
            AnimalDAO.inserir(animal);
            //Limpeza dos Campos
            limparCamposTabelaAnimal();
            //atualiza a tabela Animal
            lerTabelaAnimal();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }//fim try catch
    }//GEN-LAST:event_jbInserirAnimalActionPerformed

    private void jbAtualizarAnimalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbAtualizarAnimalActionPerformed
        try {
            //selecionar animal com modificações
            Animal animal = new Animal(
                    Integer.parseInt(jtAnimal.getValueAt(jtAnimal.getSelectedRow(), 0).toString()),//Codigo_Animal 
                    tfReino.getText(),//Reino_Animal 
                    tfFilo.getText(),//Filo_Animal 
                    tfSubFilo.getText(),//SubFilo_Animal 
                    tfClasse.getText(),//Classe_Animal 
                    tfOrdem.getText(),//Ordem_Animal 
                    tfFamilia.getText(),//Familia_Animal 
                    tfGenero.getText(),//Genero_Animal 
                    tfEspecie.getText()//Especie_Animal
            );
            //alterar no banco
            AnimalDAO.atualizar(animal);
            //Mensagensinha
            JOptionPane.showMessageDialog(null, "Atualizado.");
            //atualiza a tabela no frame
            lerTabelaAnimal();
        } catch (IndexOutOfBoundsException e){
            JOptionPane.showMessageDialog(null, "Selecione um animal na tabela", null, JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_jbAtualizarAnimalActionPerformed

    private void jbPesquisarAnimalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbPesquisarAnimalActionPerformed
        try {
            //Cria os objetos do animal a ser buscada
            Animal animal = new Animal();
            //Pega o código digitado para busca
            animal.setCodigo_Animal(Integer.parseInt(tfCodAnimal.getText()));
            lerTabelaAnimalPeloCodigo(animal.getCodigo_Animal());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_jbPesquisarAnimalActionPerformed

    private void jbExcluirAnimalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbExcluirAnimalActionPerformed
        try {
            Animal animal = new Animal();
            AnimalDAO animalDAO = new AnimalDAO();

            animal.setCodigo_Animal(
                    (int)jtAnimal.getValueAt(
                            jtAnimal.getSelectedRow(), 0
                    )
            );
            
            animalDAO.excluir(animal);

            limparCamposTabelaAnimal();

            lerTabelaAnimal();
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_jbExcluirAnimalActionPerformed

    private void jbAtualizarResponsavelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbAtualizarResponsavelActionPerformed
        lerTabelaResponsavel();
    }//GEN-LAST:event_jbAtualizarResponsavelActionPerformed

    private void jtFuncionarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtFuncionarioMouseClicked
        try {

            tfNome.setText(jtFuncionario.getValueAt(jtFuncionario.getSelectedRow(), 1).toString());
            tfCpfFuncionario.setText(jtFuncionario.getValueAt(jtFuncionario.getSelectedRow(), 2).toString());
            tfRGFuncionario.setText(jtFuncionario.getValueAt(jtFuncionario.getSelectedRow(), 3).toString());
            tfFuncaoFuncionario.setText(jtFuncionario.getValueAt(jtFuncionario.getSelectedRow(), 4).toString());
            tfTelefoneFuncionario.setText(jtFuncionario.getValueAt(jtFuncionario.getSelectedRow(), 6).toString());
        } catch (Exception e) {
        }
    }//GEN-LAST:event_jtFuncionarioMouseClicked

    private void jbInserirFuncionarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbInserirFuncionarioActionPerformed
        if (evt.getSource() == jbInserirFuncionario) {
            Funcionario funcionario = new Funcionario();
            FuncionarioDAO funcionarioDAO = new FuncionarioDAO();

            int cf = Integer.parseInt(tfFuncaoFuncionario.getText());
            funcionario.setCodigo_funcao(cf);
            funcionario.setNome_funcionario(tfNome.getText());
            funcionario.setCpf_funcionario(tfCpfFuncionario.getText());
            int rg = Integer.parseInt(tfRGFuncionario.getText());
            funcionario.setRg_funcionario(rg);
            funcionario.setTelefone_funcionario(tfTelefoneFuncionario.getText());

            java.util.Date dt = new java.util.Date();
            java.text.SimpleDateFormat sdf
            = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String currentTime = sdf.format(dt);

            funcionario.setDataEntrada_funcionario(currentTime);

            funcionarioDAO.salvar(funcionario);

        }
    }//GEN-LAST:event_jbInserirFuncionarioActionPerformed

    private void jbExcluirFuncionarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbExcluirFuncionarioActionPerformed
        try {
            Funcionario funcionario = new Funcionario();
            FuncionarioDAO funcionarioDAO = new FuncionarioDAO();

            funcionario.setCodigo_funcionario(
                (int) jtFuncionario.getValueAt(
                    jtFuncionario.getSelectedRow(), 0
                )
            );
            funcionarioDAO.excluir(funcionario);

            limparCamposTabelaFuncionario();

            lerTabelaFuncionario();
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_jbExcluirFuncionarioActionPerformed

    private void jbPesquisarFuncionarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbPesquisarFuncionarioActionPerformed
        try {
            //Cria os objetos da ficha a ser buscada
            Funcionario funcionario = new Funcionario();
            //Pega o código digitado para busca
            funcionario.setCodigo_funcionario(Integer.parseInt(tfCodigoFuncionario.getText()));
            lerTabelaFuncionarioPeloCodigo(funcionario.getCodigo_funcionario());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_jbPesquisarFuncionarioActionPerformed

    private void jbAtualizarFuncionarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbAtualizarFuncionarioActionPerformed
        try {

            Funcionario funcionario = new Funcionario(
                Integer.parseInt(jtFuncionario.getValueAt(jtFuncionario.getSelectedRow(), 0).toString()),//Codigo_FichaMedica
                tfNome.getText(),
                tfCpfFuncionario.getText(),
                Integer.parseInt(tfRGFuncionario.getText()),
                Integer.parseInt(tfFuncaoFuncionario.getText()),
                tfTelefoneFuncionario.getText()
            );
            //alterar no banco
            FuncionarioDAO.atualizar(funcionario);
            //Mensagensinha
            JOptionPane.showMessageDialog(null, "Atualizado.");
            //atualiza a tabela no frame
            lerTabelaFuncionario();
        } catch (IndexOutOfBoundsException e) {
            JOptionPane.showMessageDialog(null, "Selecione uma ficha na tabela", null, JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_jbAtualizarFuncionarioActionPerformed

    private void jtFuncaoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtFuncaoMouseClicked
        try {
            tfDescricaoFuncao.setText(jtFuncao.getValueAt(jtFuncao.getSelectedRow(), 1).toString());
            tfSalarioFuncao.setText(jtFuncao.getValueAt(jtFuncao.getSelectedRow(), 2).toString());

        } catch (Exception e) {
        }

    }//GEN-LAST:event_jtFuncaoMouseClicked

    private void jbInserirFuncaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbInserirFuncaoActionPerformed
        if (evt.getSource() == jbInserirFuncao) {
            Funcao funcao = new Funcao();
            FuncaoDAO funcaoDAO = new FuncaoDAO();

            funcao.setDescricao_funcao(tfDescricaoFuncao.getText());
            double salario = Double.parseDouble(tfSalarioFuncao.getText());
            funcao.setSalario_funcao(salario);
            funcaoDAO.salvar(funcao);

        }
    }//GEN-LAST:event_jbInserirFuncaoActionPerformed

    private void jbAtualiza_FuncaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbAtualiza_FuncaoActionPerformed
        try {
            //selecionar ficha com modificações
            Funcao funcao = new Funcao(
                Integer.parseInt(jtFuncao.getValueAt(jtFuncao.getSelectedRow(), 0).toString()),//Codigo_Funcao
                tfDescricaoFuncao.getText(),
                Double.parseDouble(tfSalarioFuncao.getText())
            );

            //alterar no banco
            FuncaoDAO.atualizar(funcao);
            //Mensagensinha
            JOptionPane.showMessageDialog(null, "Atualizado.");
            //atualiza a tabela no frame
            lerTabelaFuncao();
        } catch (IndexOutOfBoundsException e) {
            JOptionPane.showMessageDialog(null, "Selecione uma ficha na tabela", null, JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_jbAtualiza_FuncaoActionPerformed

    private void jbExcluir_FuncaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbExcluir_FuncaoActionPerformed
        if (evt.getSource() == jbExcluir_Funcao) {
            try {
                Funcao funcao = new Funcao();
                FuncaoDAO funcaoDAO = new FuncaoDAO();

                funcao.setCodigo_funcao(
                    (int) jtFuncao.getValueAt(
                        jtFuncao.getSelectedRow(), 0
                    )
                );
                funcaoDAO.excluirFuncao(funcao);

                limparCamposTabelaFuncao();

                lerTabelaFuncao();
            } catch (Exception e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, e);
            }
        }
    }//GEN-LAST:event_jbExcluir_FuncaoActionPerformed

    private void jbVerificaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbVerificaActionPerformed

        lerTabelaJOIN();

    }//GEN-LAST:event_jbVerificaActionPerformed

    private void jtProcedimentoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtProcedimentoMouseClicked
        if(jtProcedimento.getSelectedRow() != -1){
            tfProcedimentos_tipoProcedimentos.setText(jtProcedimento.getValueAt(jtProcedimento.getSelectedRow(),1).toString());
            tfProcedimentos_Descricao.setText(jtProcedimento.getValueAt(jtProcedimento.getSelectedRow(),2).toString());
            tfProcedimentos_Quantidade.setText(jtProcedimento.getValueAt(jtProcedimento.getSelectedRow(),1).toString());
            tfProcedimentos_DataVencimento.setText(jtProcedimento.getValueAt(jtProcedimento.getSelectedRow(),1).toString());
            tfProcedimentos_Valor.setText(jtProcedimento.getValueAt(jtProcedimento.getSelectedRow(),1).toString());

        }
    }//GEN-LAST:event_jtProcedimentoMouseClicked

    private void jtProcedimentoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtProcedimentoKeyReleased
        if(jtProcedimento.getSelectedRow() != -1){
            tfProcedimentos_tipoProcedimentos.setText(jtProcedimento.getValueAt(jtProcedimento.getSelectedRow(),1).toString());
            tfProcedimentos_Descricao.setText(jtProcedimento.getValueAt(jtProcedimento.getSelectedRow(),2).toString());
            tfProcedimentos_Quantidade.setText(jtProcedimento.getValueAt(jtProcedimento.getSelectedRow(),1).toString());
            tfProcedimentos_DataVencimento.setText(jtProcedimento.getValueAt(jtProcedimento.getSelectedRow(),1).toString());
            tfProcedimentos_Valor.setText(jtProcedimento.getValueAt(jtProcedimento.getSelectedRow(),1).toString());
        }
    }//GEN-LAST:event_jtProcedimentoKeyReleased

    private void tfProcedimentos_QuantidadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfProcedimentos_QuantidadeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfProcedimentos_QuantidadeActionPerformed

    private void InserirProcedimentosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_InserirProcedimentosActionPerformed

        Procedimentos pro = new Procedimentos();
        ProcedimentosDAO proDAO = new ProcedimentosDAO();

        pro.setCodigo_TipoProcedimentos(Integer.parseInt(tfProcedimentos_tipoProcedimentos.getText()));
        pro.setDescricao(tfProcedimentos_Descricao.getText());
        pro.setQuantidade(Integer.parseInt(tfProcedimentos_Quantidade.getText()));
        pro.setData_Vencimento(tfProcedimentos_DataVencimento.getText());
        pro.setValor(Double.parseDouble(tfProcedimentos_Valor.getText()));

        proDAO.inserir(pro);

        lerTabelaProcedimento();
    }//GEN-LAST:event_InserirProcedimentosActionPerformed

    private void ExcluirProcedimentosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ExcluirProcedimentosActionPerformed
        if (jtProcedimento.getSelectedRow() != -1) {
            Procedimentos pro = new Procedimentos();
            ProcedimentosDAO proDAO = new ProcedimentosDAO();

            pro.setCodigo_Procedimentos((int)jtProcedimento.getValueAt(jtProcedimento.getSelectedRow(), 0));
            proDAO.excluir(pro);

            lerTabelaProcedimento();

        }else{
            JOptionPane.showMessageDialog(null, "Selecine um procedimento!");
        }
    }//GEN-LAST:event_ExcluirProcedimentosActionPerformed

    private void PesquisarProcedimentosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PesquisarProcedimentosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_PesquisarProcedimentosActionPerformed

    private void tfProcedimentos_DescricaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfProcedimentos_DescricaoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfProcedimentos_DescricaoActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ViewFichaMedica.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewFichaMedica.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewFichaMedica.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewFichaMedica.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ViewFichaMedica().setVisible(true); // Deixa o Frame visível
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AtualizarProcedimentos;
    private javax.swing.JButton ExcluirProcedimentos;
    private javax.swing.JButton InserirProcedimentos;
    private javax.swing.JButton PesquisarProcedimentos;
    private javax.swing.JButton btVoltar;
    private javax.swing.JComboBox cbEstadoSaude;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JButton jbAtualiza_Funcao;
    private javax.swing.JButton jbAtualizarAnimal;
    private javax.swing.JButton jbAtualizarFicha;
    private javax.swing.JButton jbAtualizarFuncionario;
    private javax.swing.JButton jbAtualizarResponsavel;
    private javax.swing.JButton jbExcluirAnimal;
    private javax.swing.JButton jbExcluirFicha;
    private javax.swing.JButton jbExcluirFuncionario;
    private javax.swing.JButton jbExcluir_Funcao;
    private javax.swing.JButton jbInserirAnimal;
    private javax.swing.JButton jbInserirFicha;
    private javax.swing.JButton jbInserirFuncao;
    private javax.swing.JButton jbInserirFuncionario;
    private javax.swing.JButton jbPesquisarAnimal;
    private javax.swing.JButton jbPesquisarFicha;
    private javax.swing.JButton jbPesquisarFuncionario;
    private javax.swing.JButton jbVerifica;
    private javax.swing.JLabel jlAltura;
    private javax.swing.JLabel jlCPF;
    private javax.swing.JLabel jlClasse;
    private javax.swing.JLabel jlCodAnimal;
    private javax.swing.JLabel jlCodAnimalFicha;
    private javax.swing.JLabel jlCodFicha;
    private javax.swing.JLabel jlCodigoFuncionario;
    private javax.swing.JLabel jlDataVencimento;
    private javax.swing.JLabel jlDescricaoFuncao;
    private javax.swing.JLabel jlDescricaoProcedimento;
    private javax.swing.JLabel jlEntrada;
    private javax.swing.JLabel jlEspecie;
    private javax.swing.JLabel jlEstadoSaude;
    private javax.swing.JLabel jlFamilia;
    private javax.swing.JLabel jlFilo;
    private javax.swing.JLabel jlFuncao;
    private javax.swing.JLabel jlGenero;
    private javax.swing.JLabel jlNascimento;
    private javax.swing.JLabel jlNome;
    private javax.swing.JLabel jlOrdem;
    private javax.swing.JLabel jlPeso;
    private javax.swing.JLabel jlQuantidade;
    private javax.swing.JLabel jlRG;
    private javax.swing.JLabel jlReino;
    private javax.swing.JLabel jlSalarioFuncao;
    private javax.swing.JLabel jlSubFilo;
    private javax.swing.JLabel jlTelefone;
    private javax.swing.JLabel jlTipoProcedimentos;
    private javax.swing.JLabel jlValorProcedimento;
    private javax.swing.JPanel jpAnimais;
    private javax.swing.JPanel jpFichaMedica;
    private javax.swing.JPanel jpFornecedores;
    private javax.swing.JPanel jpFuncionarios;
    private javax.swing.JPanel jpProcedimentos;
    private javax.swing.JScrollPane jsResponsavel;
    private javax.swing.JTable jtAnimal;
    private javax.swing.JTable jtFichaMedica;
    private javax.swing.JTable jtFuncao;
    private javax.swing.JTable jtFuncionario;
    private javax.swing.JTable jtJOIN_Funcao;
    private javax.swing.JTable jtProcedimento;
    private javax.swing.JScrollPane jtProcedimentos;
    private javax.swing.JTable jtResponsavel;
    private javax.swing.JScrollPane spAnimal;
    private javax.swing.JScrollPane spFichaMedica;
    private javax.swing.JTextField tfAltura;
    private javax.swing.JTextField tfClasse;
    private javax.swing.JTextField tfCodAnimal;
    private javax.swing.JTextField tfCodAnimalFicha;
    private javax.swing.JTextField tfCodFicha;
    private javax.swing.JTextField tfCodigoFuncionario;
    private javax.swing.JTextField tfCpfFuncionario;
    private javax.swing.JTextField tfDescricaoFuncao;
    private javax.swing.JTextField tfEntrada;
    private javax.swing.JTextField tfEspecie;
    private javax.swing.JTextField tfFamilia;
    private javax.swing.JTextField tfFilo;
    private javax.swing.JTextField tfFuncaoFuncionario;
    private javax.swing.JTextField tfGenero;
    private javax.swing.JTextField tfNascimento;
    private javax.swing.JTextField tfNome;
    private javax.swing.JTextField tfOrdem;
    private javax.swing.JTextField tfPeso;
    private javax.swing.JTextField tfProcedimentos_DataVencimento;
    private javax.swing.JTextField tfProcedimentos_Descricao;
    private javax.swing.JTextField tfProcedimentos_Quantidade;
    private javax.swing.JTextField tfProcedimentos_Valor;
    private javax.swing.JTextField tfProcedimentos_tipoProcedimentos;
    private javax.swing.JTextField tfRGFuncionario;
    private javax.swing.JTextField tfReino;
    private javax.swing.JTextField tfSalarioFuncao;
    private javax.swing.JTextField tfSubFilo;
    private javax.swing.JTextField tfTelefoneFuncionario;
    private javax.swing.JTabbedPane tpSistemaFichaMedica;
    // End of variables declaration//GEN-END:variables

}
