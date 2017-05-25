
package view;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import model.bean.Comanda;
import model.bean.Comanda_ItemServico;
import model.bean.ItemServico;
import model.bean.Visitante;
import model.bean.JoinValorTotal;
import model.dao.ComandaDAO;
import model.dao.Comanda_ItemServicoDAO;
import model.dao.ItemServicoDAO;
import model.dao.VisitanteDAO;

public class ViewGlobal extends javax.swing.JFrame {

    public ViewGlobal() {
        initComponents();
        
        DefaultTableModel modeloItemServico = (DefaultTableModel) jtItemServico.getModel();
        jtItemServico.setRowSorter(new TableRowSorter(modeloItemServico));
        
        DefaultTableModel modeloComanda = (DefaultTableModel) jtVistantes.getModel();
        jtVistantes.setRowSorter(new TableRowSorter(modeloComanda));
        
        DefaultTableModel modeloFechaComanda = (DefaultTableModel) jtFechaComanda_ComandasAbertas.getModel();
        jtFechaComanda_ComandasAbertas.setRowSorter(new TableRowSorter(modeloFechaComanda));
        
        DefaultTableModel modeloJoin = (DefaultTableModel) jtFechaComanda_ComandasAbertas.getModel();
        jtFechaComanda_ComandasAbertas.setRowSorter(new TableRowSorter(modeloJoin));
        
        leTabelaVisitante();
        leTabelaItemServico();
        leTabelaComandasAbertas();
        leJoin();
    }
    
    public void leJoin(){
        DefaultTableModel modelo = (DefaultTableModel) jtTotalComandas.getModel();
        modelo.setNumRows(0);
        ComandaDAO comandaDAO = new ComandaDAO();
        
        for (JoinValorTotal c: comandaDAO.lerJoin()) {
            modelo.addRow(new Object[]{
               c.getNome(),
               c.getValor()
            });                        
        }       
    }
    
    public void leTabelaComandasAbertas(){
        DefaultTableModel modelo = (DefaultTableModel) jtFechaComanda_ComandasAbertas.getModel();
        modelo.setNumRows(0);
        ComandaDAO comandaDAO = new ComandaDAO();
        
        for (Comanda c: comandaDAO.ler()) {
            modelo.addRow(new Object[]{
               c.getCodigoComanda(),
               c.getCpf_visitante(),
               c.getDataEntrada(),
               c.getValor()
            });                        
        }           
    }
    
    public void leTabelaItemServico(){
        DefaultTableModel modelo = (DefaultTableModel) jtItemServico.getModel();
        modelo.setNumRows(0);
        ItemServicoDAO itemDAO = new ItemServicoDAO();
        
        for (ItemServico p: itemDAO.ler()) {
            modelo.addRow(new Object[]{
               p.getCodigoItemServico(),
               p.getDescricao(),
               p.getValor()
            });                        
        }        
    }
    
    public void leTabelaVisitante(){
        DefaultTableModel modelo = (DefaultTableModel) jtVistantes.getModel();
        modelo.setNumRows(0);
        VisitanteDAO visitanteDAO = new VisitanteDAO();
        
        for (Visitante v: visitanteDAO.ler()) {
            modelo.addRow(new Object[]{
               v.getCpf(),
               v.getNome(),
               v.getTelefone()
            });                        
        }
        
    }
    
    public void leTabelaComandaPorNome(String nomeVisitante){
        DefaultTableModel modelo = (DefaultTableModel) jtVistantes.getModel();
        modelo.setNumRows(0);
        ComandaDAO comandaDAO = new ComandaDAO();
        
        for (Visitante v: comandaDAO.lerPorNome(nomeVisitante)) {
            modelo.addRow(new Object[]{
               v.getCpf(),
               v.getNome(),
               v.getTelefone()
            });                        
        }        
    }   

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jpComanda_ItemServico = new javax.swing.JPanel();
        lbComanda_ItemServico_CodComanda = new javax.swing.JLabel();
        lbComanda_ItemServico_CodItemServico = new javax.swing.JLabel();
        lbComanda_ItemServico_Quantidade = new javax.swing.JLabel();
        tfComanda_ItemServico_CodComanda = new javax.swing.JTextField();
        tfComanda_ItemServico_CodItemServico = new javax.swing.JTextField();
        tfComanda_ItemServico_Quantidade = new javax.swing.JTextField();
        btComanda_ItemServico_Adicionar = new javax.swing.JButton();
        btComanda_ItemServico_Cancelar = new javax.swing.JButton();
        jpAbrirComanda = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtVistantes = new javax.swing.JTable();
        lbAbrirComanda_Nome = new javax.swing.JLabel();
        btAbrirComanda_PesquisaCPF = new javax.swing.JButton();
        tfAbrirComanda_Cpf = new javax.swing.JTextField();
        lbAbrirComanda_Cpf = new javax.swing.JLabel();
        tfAbrirComanda_Nome = new javax.swing.JTextField();
        btAbrirComanda_PesquisarNome = new javax.swing.JButton();
        btAbrirComanda_Abrir = new javax.swing.JButton();
        lbAbrirComanda_Tabela = new javax.swing.JLabel();
        jpFecharComanda = new javax.swing.JPanel();
        lbFechaComanda_Tabela = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jtFechaComanda_ComandasAbertas = new javax.swing.JTable();
        lbFechaComanda_NumeroComanda = new javax.swing.JLabel();
        tfFechaComanda_NumeroComanda = new javax.swing.JTextField();
        btFechaComanda_Fechar = new javax.swing.JButton();
        jpItemServico = new javax.swing.JPanel();
        lbItemServico_Tabela = new javax.swing.JLabel();
        tfItemServico_Descricao = new javax.swing.JTextField();
        tfItemServico_Valor = new javax.swing.JTextField();
        lbItemServico_Descricao = new javax.swing.JLabel();
        lbItemServico_Valor = new javax.swing.JLabel();
        btItemServico_Salvar = new javax.swing.JButton();
        btItemServico_Excluir = new javax.swing.JButton();
        btItemServico_Alterar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtItemServico = new javax.swing.JTable();
        jpVisitante = new javax.swing.JPanel();
        tfVisitante_Cpf = new javax.swing.JTextField();
        tfVisitante_Nome = new javax.swing.JTextField();
        lbVisitante_Cpf = new javax.swing.JLabel();
        lbVisitante_Nome = new javax.swing.JLabel();
        btVisitante_Salvar = new javax.swing.JButton();
        tfVisitante_Telefone = new javax.swing.JTextField();
        lbVisitante_Telefone = new javax.swing.JLabel();
        btVisitante_Cancelar = new javax.swing.JButton();
        btVisitante_PesquisarCPF = new javax.swing.JButton();
        jpJoin = new javax.swing.JPanel();
        lbJoin_ValorTotal = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jtTotalComandas = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Sistema de Comanda");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setIconImages(null);
        setLocation(new java.awt.Point(0, 0));
        setLocationByPlatform(true);
        setResizable(false);

        jTabbedPane1.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N

        lbComanda_ItemServico_CodComanda.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbComanda_ItemServico_CodComanda.setText("Código da Comanda:");

        lbComanda_ItemServico_CodItemServico.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbComanda_ItemServico_CodItemServico.setText("Código do Item/Serviço:");

        lbComanda_ItemServico_Quantidade.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbComanda_ItemServico_Quantidade.setText("Quantidade:");

        btComanda_ItemServico_Adicionar.setText("Adicionar");
        btComanda_ItemServico_Adicionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btComanda_ItemServico_AdicionarActionPerformed(evt);
            }
        });

        btComanda_ItemServico_Cancelar.setText("Cancelar");
        btComanda_ItemServico_Cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btComanda_ItemServico_CancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jpComanda_ItemServicoLayout = new javax.swing.GroupLayout(jpComanda_ItemServico);
        jpComanda_ItemServico.setLayout(jpComanda_ItemServicoLayout);
        jpComanda_ItemServicoLayout.setHorizontalGroup(
            jpComanda_ItemServicoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpComanda_ItemServicoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpComanda_ItemServicoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbComanda_ItemServico_CodItemServico)
                    .addComponent(lbComanda_ItemServico_Quantidade, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lbComanda_ItemServico_CodComanda, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(25, 25, 25)
                .addGroup(jpComanda_ItemServicoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tfComanda_ItemServico_Quantidade, javax.swing.GroupLayout.DEFAULT_SIZE, 457, Short.MAX_VALUE)
                    .addComponent(tfComanda_ItemServico_CodItemServico)
                    .addComponent(tfComanda_ItemServico_CodComanda)
                    .addGroup(jpComanda_ItemServicoLayout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(btComanda_ItemServico_Adicionar)
                        .addGap(35, 35, 35)
                        .addComponent(btComanda_ItemServico_Cancelar)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jpComanda_ItemServicoLayout.setVerticalGroup(
            jpComanda_ItemServicoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpComanda_ItemServicoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpComanda_ItemServicoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbComanda_ItemServico_CodComanda)
                    .addComponent(tfComanda_ItemServico_CodComanda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jpComanda_ItemServicoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbComanda_ItemServico_CodItemServico)
                    .addComponent(tfComanda_ItemServico_CodItemServico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jpComanda_ItemServicoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbComanda_ItemServico_Quantidade)
                    .addComponent(tfComanda_ItemServico_Quantidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addGroup(jpComanda_ItemServicoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btComanda_ItemServico_Adicionar)
                    .addComponent(btComanda_ItemServico_Cancelar))
                .addContainerGap(128, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Adicionar Itens", jpComanda_ItemServico);

        jtVistantes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "CPF", "Nome", "Telefone"
            }
        ));
        jtVistantes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtVistantesMouseClicked(evt);
            }
        });
        jtVistantes.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtVistantesKeyReleased(evt);
            }
        });
        jScrollPane2.setViewportView(jtVistantes);

        lbAbrirComanda_Nome.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbAbrirComanda_Nome.setText("Nome:");

        btAbrirComanda_PesquisaCPF.setText("Pesquisar");
        btAbrirComanda_PesquisaCPF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAbrirComanda_PesquisaCPFActionPerformed(evt);
            }
        });

        lbAbrirComanda_Cpf.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbAbrirComanda_Cpf.setText("CPF:");

        btAbrirComanda_PesquisarNome.setText("Pesquisar");
        btAbrirComanda_PesquisarNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAbrirComanda_PesquisarNomeActionPerformed(evt);
            }
        });

        btAbrirComanda_Abrir.setText("Abrir Comanda");
        btAbrirComanda_Abrir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAbrirComanda_AbrirActionPerformed(evt);
            }
        });

        lbAbrirComanda_Tabela.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbAbrirComanda_Tabela.setText("Tabela dos Visitantes:");

        javax.swing.GroupLayout jpAbrirComandaLayout = new javax.swing.GroupLayout(jpAbrirComanda);
        jpAbrirComanda.setLayout(jpAbrirComandaLayout);
        jpAbrirComandaLayout.setHorizontalGroup(
            jpAbrirComandaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpAbrirComandaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpAbrirComandaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpAbrirComandaLayout.createSequentialGroup()
                        .addComponent(lbAbrirComanda_Nome)
                        .addGap(18, 18, 18)
                        .addComponent(tfAbrirComanda_Nome, javax.swing.GroupLayout.DEFAULT_SIZE, 454, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btAbrirComanda_PesquisarNome, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jpAbrirComandaLayout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(lbAbrirComanda_Cpf)
                        .addGap(18, 18, 18)
                        .addComponent(tfAbrirComanda_Cpf, javax.swing.GroupLayout.DEFAULT_SIZE, 454, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btAbrirComanda_PesquisaCPF, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(jpAbrirComandaLayout.createSequentialGroup()
                        .addComponent(lbAbrirComanda_Tabela)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpAbrirComandaLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btAbrirComanda_Abrir)
                .addGap(232, 232, 232))
        );
        jpAbrirComandaLayout.setVerticalGroup(
            jpAbrirComandaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpAbrirComandaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpAbrirComandaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbAbrirComanda_Cpf)
                    .addComponent(tfAbrirComanda_Cpf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btAbrirComanda_PesquisaCPF))
                .addGap(18, 18, 18)
                .addGroup(jpAbrirComandaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbAbrirComanda_Nome)
                    .addComponent(tfAbrirComanda_Nome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btAbrirComanda_PesquisarNome))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbAbrirComanda_Tabela)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 123, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(btAbrirComanda_Abrir)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Abrir Comanda", jpAbrirComanda);

        lbFechaComanda_Tabela.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbFechaComanda_Tabela.setText("Tabela de Comandas Abertas:");

        jtFechaComanda_ComandasAbertas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Código", "CPF do Visitante", "Data de Entrada", "Valor Total"
            }
        ));
        jtFechaComanda_ComandasAbertas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtFechaComanda_ComandasAbertasMouseClicked(evt);
            }
        });
        jtFechaComanda_ComandasAbertas.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtFechaComanda_ComandasAbertasKeyReleased(evt);
            }
        });
        jScrollPane3.setViewportView(jtFechaComanda_ComandasAbertas);

        lbFechaComanda_NumeroComanda.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbFechaComanda_NumeroComanda.setText("Número da Comanda:");

        btFechaComanda_Fechar.setText("Fechar Comanda");
        btFechaComanda_Fechar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btFechaComanda_FecharActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jpFecharComandaLayout = new javax.swing.GroupLayout(jpFecharComanda);
        jpFecharComanda.setLayout(jpFecharComandaLayout);
        jpFecharComandaLayout.setHorizontalGroup(
            jpFecharComandaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpFecharComandaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpFecharComandaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpFecharComandaLayout.createSequentialGroup()
                        .addGroup(jpFecharComandaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 632, Short.MAX_VALUE)
                            .addGroup(jpFecharComandaLayout.createSequentialGroup()
                                .addComponent(lbFechaComanda_Tabela)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())
                    .addGroup(jpFecharComandaLayout.createSequentialGroup()
                        .addComponent(lbFechaComanda_NumeroComanda)
                        .addGap(18, 18, 18)
                        .addComponent(tfFechaComanda_NumeroComanda, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btFechaComanda_Fechar)
                        .addGap(112, 112, 112))))
        );
        jpFecharComandaLayout.setVerticalGroup(
            jpFecharComandaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpFecharComandaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbFechaComanda_Tabela)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 187, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(jpFecharComandaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbFechaComanda_NumeroComanda)
                    .addComponent(tfFechaComanda_NumeroComanda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btFechaComanda_Fechar))
                .addGap(27, 27, 27))
        );

        jTabbedPane1.addTab("Fechar Comanda", jpFecharComanda);

        lbItemServico_Tabela.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbItemServico_Tabela.setText("Tabela dos Itens/Serviços:");

        lbItemServico_Descricao.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbItemServico_Descricao.setText("Descrição:");

        lbItemServico_Valor.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbItemServico_Valor.setText("Valor:");

        btItemServico_Salvar.setText("Salvar");
        btItemServico_Salvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btItemServico_SalvarActionPerformed(evt);
            }
        });

        btItemServico_Excluir.setText("Excluir");
        btItemServico_Excluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btItemServico_ExcluirActionPerformed(evt);
            }
        });

        btItemServico_Alterar.setText("Alterar");
        btItemServico_Alterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btItemServico_AlterarActionPerformed(evt);
            }
        });

        jtItemServico.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Código", "Descrição", "Valor"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtItemServico.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtItemServicoMouseClicked(evt);
            }
        });
        jtItemServico.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtItemServicoKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(jtItemServico);

        javax.swing.GroupLayout jpItemServicoLayout = new javax.swing.GroupLayout(jpItemServico);
        jpItemServico.setLayout(jpItemServicoLayout);
        jpItemServicoLayout.setHorizontalGroup(
            jpItemServicoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpItemServicoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpItemServicoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpItemServicoLayout.createSequentialGroup()
                        .addComponent(lbItemServico_Tabela, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jpItemServicoLayout.createSequentialGroup()
                        .addGroup(jpItemServicoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jpItemServicoLayout.createSequentialGroup()
                                .addGroup(jpItemServicoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jpItemServicoLayout.createSequentialGroup()
                                        .addComponent(lbItemServico_Descricao)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addComponent(tfItemServico_Descricao))
                                .addGap(18, 18, 18)
                                .addGroup(jpItemServicoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbItemServico_Valor)
                                    .addComponent(tfItemServico_Valor, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 565, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jpItemServicoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jpItemServicoLayout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addComponent(btItemServico_Salvar))
                            .addGroup(jpItemServicoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(btItemServico_Alterar, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(btItemServico_Excluir, javax.swing.GroupLayout.Alignment.TRAILING)))
                        .addGap(6, 6, 6))))
        );
        jpItemServicoLayout.setVerticalGroup(
            jpItemServicoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpItemServicoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpItemServicoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpItemServicoLayout.createSequentialGroup()
                        .addComponent(lbItemServico_Descricao)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfItemServico_Descricao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lbItemServico_Valor)
                    .addComponent(tfItemServico_Valor, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbItemServico_Tabela)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jpItemServicoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpItemServicoLayout.createSequentialGroup()
                        .addComponent(btItemServico_Salvar)
                        .addGap(18, 18, 18)
                        .addComponent(btItemServico_Alterar)
                        .addGap(18, 18, 18)
                        .addComponent(btItemServico_Excluir))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(26, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Cadastro de Itens/Serviços", jpItemServico);

        lbVisitante_Cpf.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbVisitante_Cpf.setText("CPF:");

        lbVisitante_Nome.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbVisitante_Nome.setText("Nome:");

        btVisitante_Salvar.setText("Salvar");
        btVisitante_Salvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btVisitante_SalvarActionPerformed(evt);
            }
        });

        lbVisitante_Telefone.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbVisitante_Telefone.setText("Telefone:");

        btVisitante_Cancelar.setText("Cancelar");
        btVisitante_Cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btVisitante_CancelarActionPerformed(evt);
            }
        });

        btVisitante_PesquisarCPF.setText("Pesquisar");
        btVisitante_PesquisarCPF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btVisitante_PesquisarCPFActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jpVisitanteLayout = new javax.swing.GroupLayout(jpVisitante);
        jpVisitante.setLayout(jpVisitanteLayout);
        jpVisitanteLayout.setHorizontalGroup(
            jpVisitanteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpVisitanteLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpVisitanteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbVisitante_Telefone)
                    .addComponent(lbVisitante_Nome, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lbVisitante_Cpf, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(18, 18, 18)
                .addGroup(jpVisitanteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpVisitanteLayout.createSequentialGroup()
                        .addComponent(tfVisitante_Cpf, javax.swing.GroupLayout.DEFAULT_SIZE, 427, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(btVisitante_PesquisarCPF, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(tfVisitante_Nome)
                    .addComponent(tfVisitante_Telefone))
                .addContainerGap())
            .addGroup(jpVisitanteLayout.createSequentialGroup()
                .addGap(217, 217, 217)
                .addComponent(btVisitante_Salvar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btVisitante_Cancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jpVisitanteLayout.setVerticalGroup(
            jpVisitanteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpVisitanteLayout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(jpVisitanteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbVisitante_Cpf)
                    .addComponent(tfVisitante_Cpf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btVisitante_PesquisarCPF))
                .addGap(18, 18, 18)
                .addGroup(jpVisitanteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfVisitante_Nome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbVisitante_Nome))
                .addGap(18, 18, 18)
                .addGroup(jpVisitanteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfVisitante_Telefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbVisitante_Telefone))
                .addGap(30, 30, 30)
                .addGroup(jpVisitanteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btVisitante_Salvar)
                    .addComponent(btVisitante_Cancelar))
                .addContainerGap(104, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Cadastro de Visitantes", jpVisitante);

        lbJoin_ValorTotal.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbJoin_ValorTotal.setText("Valor Total das Comandas:");

        jtTotalComandas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Nome do Visitante", "Valor Total"
            }
        ));
        jScrollPane4.setViewportView(jtTotalComandas);

        javax.swing.GroupLayout jpJoinLayout = new javax.swing.GroupLayout(jpJoin);
        jpJoin.setLayout(jpJoinLayout);
        jpJoinLayout.setHorizontalGroup(
            jpJoinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpJoinLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpJoinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpJoinLayout.createSequentialGroup()
                        .addComponent(lbJoin_ValorTotal)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 632, Short.MAX_VALUE))
                .addContainerGap())
        );
        jpJoinLayout.setVerticalGroup(
            jpJoinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpJoinLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbJoin_ValorTotal)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 244, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Valor das Comandas", jpJoin);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btItemServico_SalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btItemServico_SalvarActionPerformed

        ItemServico item = new ItemServico();
        ItemServicoDAO itemDAO = new ItemServicoDAO();

        item.setDescricao(tfItemServico_Descricao.getText());
        item.setValor(Double.parseDouble(tfItemServico_Valor.getText()));

        itemDAO.salvar(item);

        tfItemServico_Descricao.setText("");
        tfItemServico_Valor.setText("");

        leTabelaItemServico();

    }//GEN-LAST:event_btItemServico_SalvarActionPerformed

    private void btItemServico_ExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btItemServico_ExcluirActionPerformed
        // TODO add your handling code here:

        if (jtItemServico.getSelectedRow() != -1) {
            ItemServico item = new ItemServico();
            ItemServicoDAO itemDAO = new ItemServicoDAO();

            item.setCodigoItemServico((int)jtItemServico.getValueAt(jtItemServico.getSelectedRow(), 0));
            itemDAO.excluir(item);

            tfItemServico_Descricao.setText("");
            tfItemServico_Valor.setText("");

            leTabelaItemServico();
        } else {
            JOptionPane.showMessageDialog(null, "Selecione um produto");
        }

    }//GEN-LAST:event_btItemServico_ExcluirActionPerformed

    private void btItemServico_AlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btItemServico_AlterarActionPerformed
        // TODO add your handling code here:

        if (jtItemServico.getSelectedRow() != -1) {
            ItemServico item = new ItemServico();
            ItemServicoDAO itemDAO = new ItemServicoDAO();

            item.setDescricao(tfItemServico_Descricao.getText());
            item.setValor(Double.parseDouble(tfItemServico_Valor.getText()));
            item.setCodigoItemServico((int)jtItemServico.getValueAt(jtItemServico.getSelectedRow(), 0));
            itemDAO.alterar(item);

            tfItemServico_Descricao.setText("");
            tfItemServico_Valor.setText("");

            leTabelaItemServico();
        } else {
            JOptionPane.showMessageDialog(null, "Selecione um produto");
        }

    }//GEN-LAST:event_btItemServico_AlterarActionPerformed

    private void jtItemServicoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtItemServicoMouseClicked
        // TODO add your handling code here:

        if (jtItemServico.getSelectedRow() != -1) {
            tfItemServico_Descricao.setText(jtItemServico.getValueAt(jtItemServico.getSelectedRow(), 1).toString());
            tfItemServico_Valor.setText(jtItemServico.getValueAt(jtItemServico.getSelectedRow(), 2).toString());
        }

    }//GEN-LAST:event_jtItemServicoMouseClicked

    private void jtItemServicoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtItemServicoKeyReleased
        // TODO add your handling code here:

        if (jtItemServico.getSelectedRow() != -1) {
            tfItemServico_Descricao.setText(jtItemServico.getValueAt(jtItemServico.getSelectedRow(), 1).toString());
            tfItemServico_Valor.setText(jtItemServico.getValueAt(jtItemServico.getSelectedRow(), 2).toString());
        }

    }//GEN-LAST:event_jtItemServicoKeyReleased

    private void btVisitante_SalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btVisitante_SalvarActionPerformed

        Visitante visitante = new Visitante();
        VisitanteDAO visitanteDAO = new VisitanteDAO();

        visitante.setCpf(Integer.parseInt(tfVisitante_Cpf.getText()));
        visitante.setNome(tfVisitante_Nome.getText());
        visitante.setTelefone(Integer.parseInt(tfVisitante_Telefone.getText()));

        visitanteDAO.salvar(visitante);

        tfVisitante_Cpf.setText("");
        tfVisitante_Nome.setText("");
        tfVisitante_Telefone.setText("");
        
        leTabelaVisitante();
    }//GEN-LAST:event_btVisitante_SalvarActionPerformed

    private void btVisitante_CancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btVisitante_CancelarActionPerformed
        // TODO add your handling code here:

        tfVisitante_Cpf.setText("");
        tfVisitante_Nome.setText("");
        tfVisitante_Telefone.setText("");
    }//GEN-LAST:event_btVisitante_CancelarActionPerformed

    private void btVisitante_PesquisarCPFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btVisitante_PesquisarCPFActionPerformed
        // TODO add your handling code here:

        Visitante visitante = new Visitante();
        VisitanteDAO visitanteDAO = new VisitanteDAO();

        visitante.setCpf(Integer.parseInt(tfVisitante_Cpf.getText()));

        if (visitanteDAO.pesquisar(visitante)){
            JOptionPane.showMessageDialog(null, "CPF existente!");
        } else {
            JOptionPane.showMessageDialog(null, "Não existe registro com esse CPF.");
        }
    }//GEN-LAST:event_btVisitante_PesquisarCPFActionPerformed

    private void jtVistantesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtVistantesMouseClicked
        // TODO add your handling code here:

        if (jtVistantes.getSelectedRow() != -1) {
            tfAbrirComanda_Cpf.setText(jtVistantes.getValueAt(jtVistantes.getSelectedRow(), 0).toString());
            tfAbrirComanda_Nome.setText(jtVistantes.getValueAt(jtVistantes.getSelectedRow(), 1).toString());
        }

    }//GEN-LAST:event_jtVistantesMouseClicked

    private void jtVistantesKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtVistantesKeyReleased
        // TODO add your handling code here:

        if (jtVistantes.getSelectedRow() != -1) {
            tfAbrirComanda_Cpf.setText(jtVistantes.getValueAt(jtVistantes.getSelectedRow(), 0).toString());
            tfAbrirComanda_Nome.setText(jtVistantes.getValueAt(jtVistantes.getSelectedRow(), 1).toString());
        }

    }//GEN-LAST:event_jtVistantesKeyReleased

    private void btAbrirComanda_PesquisaCPFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAbrirComanda_PesquisaCPFActionPerformed
        // TODO add your handling code here:
        ComandaDAO comandaDAO = new ComandaDAO();
        
        String retorno = comandaDAO.verificaCPF(Double.parseDouble(tfAbrirComanda_Cpf.getText()));
        if (retorno != null) {
            JOptionPane.showMessageDialog(null, "Visitante existente!");
            tfAbrirComanda_Nome.setText(retorno);
        } else {
            JOptionPane.showMessageDialog(null, "Visitante não encontrado!");
        }
    }//GEN-LAST:event_btAbrirComanda_PesquisaCPFActionPerformed

    private void btAbrirComanda_PesquisarNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAbrirComanda_PesquisarNomeActionPerformed
        // TODO add your handling code here:
        leTabelaComandaPorNome(tfAbrirComanda_Nome.getText());
        tfAbrirComanda_Cpf.setText("");
        
    }//GEN-LAST:event_btAbrirComanda_PesquisarNomeActionPerformed

    private void btAbrirComanda_AbrirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAbrirComanda_AbrirActionPerformed
        // TODO add your handling code here:
        if (!tfAbrirComanda_Nome.getText().equals("")) {                    
            Comanda comanda = new Comanda();
            ComandaDAO comandaDAO = new ComandaDAO();

            comanda.setCpf_visitante(Double.parseDouble(tfAbrirComanda_Cpf.getText()));

            comandaDAO.abre(comanda);
            
            leTabelaComandasAbertas();
        } else {
            JOptionPane.showMessageDialog(null, "Selecione um CPF.");
        }
        
    }//GEN-LAST:event_btAbrirComanda_AbrirActionPerformed

    private void jtFechaComanda_ComandasAbertasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtFechaComanda_ComandasAbertasMouseClicked
        
        if (jtFechaComanda_ComandasAbertas.getSelectedRow() != -1) {
            tfFechaComanda_NumeroComanda.setText(jtFechaComanda_ComandasAbertas.getValueAt(jtFechaComanda_ComandasAbertas.getSelectedRow(), 0).toString());            
        }
        
    }//GEN-LAST:event_jtFechaComanda_ComandasAbertasMouseClicked

    private void jtFechaComanda_ComandasAbertasKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtFechaComanda_ComandasAbertasKeyReleased
        
        if (jtFechaComanda_ComandasAbertas.getSelectedRow() != -1) {
            tfFechaComanda_NumeroComanda.setText(jtFechaComanda_ComandasAbertas.getValueAt(jtFechaComanda_ComandasAbertas.getSelectedRow(), 0).toString());            
        }
        
    }//GEN-LAST:event_jtFechaComanda_ComandasAbertasKeyReleased

    private void btFechaComanda_FecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btFechaComanda_FecharActionPerformed
        
        if (!tfFechaComanda_NumeroComanda.getText().equals("")) {                    
            Comanda comanda = new Comanda();
            ComandaDAO comandaDAO = new ComandaDAO();   
            
            comanda.setCodigoComanda(Integer.parseInt(tfFechaComanda_NumeroComanda.getText()));
            
            comandaDAO.fecha(comanda);
            
            tfFechaComanda_NumeroComanda.setText("");
            
            leTabelaComandasAbertas();
            leJoin();
        
        } else {
            JOptionPane.showMessageDialog(null, "Selecione uma comanda.");
        }
        
        
    }//GEN-LAST:event_btFechaComanda_FecharActionPerformed

    private void btComanda_ItemServico_AdicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btComanda_ItemServico_AdicionarActionPerformed
        
        if (!tfComanda_ItemServico_CodComanda.getText().equals("") && !tfComanda_ItemServico_CodItemServico.getText().equals("") && !tfComanda_ItemServico_Quantidade.getText().equals("")) {            
            Comanda_ItemServico comandaItemServico = new Comanda_ItemServico();
            Comanda_ItemServicoDAO comandaItemServicoDAO = new Comanda_ItemServicoDAO();

            comandaItemServico.setCodigo_Comanda(Integer.parseInt(tfComanda_ItemServico_CodComanda.getText()));
            comandaItemServico.setCodigo_ItemServico(Integer.parseInt(tfComanda_ItemServico_CodItemServico.getText()));
            comandaItemServico.setQuantidade(Integer.parseInt(tfComanda_ItemServico_Quantidade.getText()));

            comandaItemServicoDAO.insere(comandaItemServico);
            
            tfComanda_ItemServico_CodComanda.setText("");
            tfComanda_ItemServico_CodItemServico.setText("");
            tfComanda_ItemServico_Quantidade.setText("");
        } else {
            JOptionPane.showMessageDialog(null, "Preencha os campos.");
        }
        
    }//GEN-LAST:event_btComanda_ItemServico_AdicionarActionPerformed

    private void btComanda_ItemServico_CancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btComanda_ItemServico_CancelarActionPerformed
        
        tfComanda_ItemServico_CodComanda.setText("");
        tfComanda_ItemServico_CodItemServico.setText("");
        tfComanda_ItemServico_Quantidade.setText("");
        
    }//GEN-LAST:event_btComanda_ItemServico_CancelarActionPerformed

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
            java.util.logging.Logger.getLogger(ViewGlobal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewGlobal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewGlobal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewGlobal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ViewGlobal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btAbrirComanda_Abrir;
    private javax.swing.JButton btAbrirComanda_PesquisaCPF;
    private javax.swing.JButton btAbrirComanda_PesquisarNome;
    private javax.swing.JButton btComanda_ItemServico_Adicionar;
    private javax.swing.JButton btComanda_ItemServico_Cancelar;
    private javax.swing.JButton btFechaComanda_Fechar;
    private javax.swing.JButton btItemServico_Alterar;
    private javax.swing.JButton btItemServico_Excluir;
    private javax.swing.JButton btItemServico_Salvar;
    private javax.swing.JButton btVisitante_Cancelar;
    private javax.swing.JButton btVisitante_PesquisarCPF;
    private javax.swing.JButton btVisitante_Salvar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JPanel jpAbrirComanda;
    private javax.swing.JPanel jpComanda_ItemServico;
    private javax.swing.JPanel jpFecharComanda;
    private javax.swing.JPanel jpItemServico;
    private javax.swing.JPanel jpJoin;
    private javax.swing.JPanel jpVisitante;
    private javax.swing.JTable jtFechaComanda_ComandasAbertas;
    private javax.swing.JTable jtItemServico;
    private javax.swing.JTable jtTotalComandas;
    private javax.swing.JTable jtVistantes;
    private javax.swing.JLabel lbAbrirComanda_Cpf;
    private javax.swing.JLabel lbAbrirComanda_Nome;
    private javax.swing.JLabel lbAbrirComanda_Tabela;
    private javax.swing.JLabel lbComanda_ItemServico_CodComanda;
    private javax.swing.JLabel lbComanda_ItemServico_CodItemServico;
    private javax.swing.JLabel lbComanda_ItemServico_Quantidade;
    private javax.swing.JLabel lbFechaComanda_NumeroComanda;
    private javax.swing.JLabel lbFechaComanda_Tabela;
    private javax.swing.JLabel lbItemServico_Descricao;
    private javax.swing.JLabel lbItemServico_Tabela;
    private javax.swing.JLabel lbItemServico_Valor;
    private javax.swing.JLabel lbJoin_ValorTotal;
    private javax.swing.JLabel lbVisitante_Cpf;
    private javax.swing.JLabel lbVisitante_Nome;
    private javax.swing.JLabel lbVisitante_Telefone;
    private javax.swing.JTextField tfAbrirComanda_Cpf;
    private javax.swing.JTextField tfAbrirComanda_Nome;
    private javax.swing.JTextField tfComanda_ItemServico_CodComanda;
    private javax.swing.JTextField tfComanda_ItemServico_CodItemServico;
    private javax.swing.JTextField tfComanda_ItemServico_Quantidade;
    private javax.swing.JTextField tfFechaComanda_NumeroComanda;
    private javax.swing.JTextField tfItemServico_Descricao;
    private javax.swing.JTextField tfItemServico_Valor;
    private javax.swing.JTextField tfVisitante_Cpf;
    private javax.swing.JTextField tfVisitante_Nome;
    private javax.swing.JTextField tfVisitante_Telefone;
    // End of variables declaration//GEN-END:variables
}
