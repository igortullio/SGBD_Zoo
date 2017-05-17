
package view;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import model.bean.Comanda;
import model.bean.ItemServico;
import model.bean.Visitante;
import model.dao.ComandaDAO;
import model.dao.ItemServicoDAO;
import model.dao.VisitanteDAO;

public class ViewGlobal extends javax.swing.JFrame {

    public ViewGlobal() {
        initComponents();
        
        DefaultTableModel modeloItemServico = (DefaultTableModel) jtItemServico.getModel();
        jtItemServico.setRowSorter(new TableRowSorter(modeloItemServico));
        
        DefaultTableModel modeloComanda = (DefaultTableModel) jtComanda.getModel();
        jtComanda.setRowSorter(new TableRowSorter(modeloComanda));
        
        leTabelaComanda();
        leTabelaItemServico();
    }
    
    public void leTabelaItemServico(){
        DefaultTableModel modelo = (DefaultTableModel) jtItemServico.getModel();
        modelo.setNumRows(0);
        ItemServicoDAO itemDAO = new ItemServicoDAO();
        
        for (ItemServico p: itemDAO.ler()) {
            modelo.addRow(new Object[]{
               p.getCodigo(),
               p.getDescricao(),
               p.getValor()
            });                        
        }        
    }
    
    public void leTabelaComanda(){
        DefaultTableModel modelo = (DefaultTableModel) jtComanda.getModel();
        modelo.setNumRows(0);
        ComandaDAO comandaDAO = new ComandaDAO();
        
        for (Visitante v: comandaDAO.ler()) {
            modelo.addRow(new Object[]{
               v.getCpf(),
               v.getNome(),
               v.getTelefone()
            });                        
        }
        
    }
    
    public void leTabelaComandaPorNome(String nomeVisitante){
        DefaultTableModel modelo = (DefaultTableModel) jtComanda.getModel();
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
        lbComanda_ItemServico_Valor = new javax.swing.JLabel();
        tfComanda_ItemServico_CodComanda = new javax.swing.JTextField();
        tfComanda_ItemServico_CodItemServico = new javax.swing.JTextField();
        tfComanda_ItemServico_Quantidade = new javax.swing.JTextField();
        tfComanda_ItemServico_Valor = new javax.swing.JTextField();
        btComanda_ItemServico_Adicionar = new javax.swing.JButton();
        btComanda_ItemServico_Cancelar = new javax.swing.JButton();
        jpComanda = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtComanda = new javax.swing.JTable();
        lbComanda_Nome = new javax.swing.JLabel();
        btComanda_PesquisaCPF = new javax.swing.JButton();
        tfComanda_Cpf = new javax.swing.JTextField();
        lbComanda_Cpf = new javax.swing.JLabel();
        tfComanda_Nome = new javax.swing.JTextField();
        btComanda_PesquisarNome = new javax.swing.JButton();
        btComanda_Abrir = new javax.swing.JButton();
        jpItemServico = new javax.swing.JPanel();
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

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
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

        lbComanda_ItemServico_Valor.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbComanda_ItemServico_Valor.setText("Valor:");

        tfComanda_ItemServico_Valor.setEditable(false);

        btComanda_ItemServico_Adicionar.setText("Adicionar");

        btComanda_ItemServico_Cancelar.setText("Cancelar");

        javax.swing.GroupLayout jpComanda_ItemServicoLayout = new javax.swing.GroupLayout(jpComanda_ItemServico);
        jpComanda_ItemServico.setLayout(jpComanda_ItemServicoLayout);
        jpComanda_ItemServicoLayout.setHorizontalGroup(
            jpComanda_ItemServicoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpComanda_ItemServicoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpComanda_ItemServicoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbComanda_ItemServico_CodItemServico)
                    .addComponent(lbComanda_ItemServico_Valor, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lbComanda_ItemServico_Quantidade, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lbComanda_ItemServico_CodComanda, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(25, 25, 25)
                .addGroup(jpComanda_ItemServicoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tfComanda_ItemServico_Valor)
                    .addComponent(tfComanda_ItemServico_Quantidade)
                    .addComponent(tfComanda_ItemServico_CodItemServico)
                    .addComponent(tfComanda_ItemServico_CodComanda))
                .addContainerGap())
            .addGroup(jpComanda_ItemServicoLayout.createSequentialGroup()
                .addGap(113, 113, 113)
                .addComponent(btComanda_ItemServico_Adicionar, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btComanda_ItemServico_Cancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(114, Short.MAX_VALUE))
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
                .addGap(18, 18, 18)
                .addGroup(jpComanda_ItemServicoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbComanda_ItemServico_Valor)
                    .addComponent(tfComanda_ItemServico_Valor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addGroup(jpComanda_ItemServicoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btComanda_ItemServico_Adicionar, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btComanda_ItemServico_Cancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22))
        );

        jTabbedPane1.addTab("Adicionar Itens", jpComanda_ItemServico);

        jtComanda.setModel(new javax.swing.table.DefaultTableModel(
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
        jtComanda.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtComandaMouseClicked(evt);
            }
        });
        jtComanda.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtComandaKeyReleased(evt);
            }
        });
        jScrollPane2.setViewportView(jtComanda);

        lbComanda_Nome.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbComanda_Nome.setText("Nome:");

        btComanda_PesquisaCPF.setText("Pesquisar");
        btComanda_PesquisaCPF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btComanda_PesquisaCPFActionPerformed(evt);
            }
        });

        lbComanda_Cpf.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbComanda_Cpf.setText("CPF:");

        btComanda_PesquisarNome.setText("Pesquisar");
        btComanda_PesquisarNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btComanda_PesquisarNomeActionPerformed(evt);
            }
        });

        btComanda_Abrir.setText("Abrir Comanda");
        btComanda_Abrir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btComanda_AbrirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jpComandaLayout = new javax.swing.GroupLayout(jpComanda);
        jpComanda.setLayout(jpComandaLayout);
        jpComandaLayout.setHorizontalGroup(
            jpComandaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpComandaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpComandaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpComandaLayout.createSequentialGroup()
                        .addComponent(lbComanda_Nome)
                        .addGap(18, 18, 18)
                        .addComponent(tfComanda_Nome, javax.swing.GroupLayout.DEFAULT_SIZE, 237, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btComanda_PesquisarNome, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jpComandaLayout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(lbComanda_Cpf)
                        .addGap(18, 18, 18)
                        .addComponent(tfComanda_Cpf, javax.swing.GroupLayout.DEFAULT_SIZE, 237, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btComanda_PesquisaCPF, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(jpComandaLayout.createSequentialGroup()
                .addGap(164, 164, 164)
                .addComponent(btComanda_Abrir)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jpComandaLayout.setVerticalGroup(
            jpComandaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpComandaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpComandaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbComanda_Cpf)
                    .addComponent(tfComanda_Cpf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btComanda_PesquisaCPF))
                .addGap(18, 18, 18)
                .addGroup(jpComandaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbComanda_Nome)
                    .addComponent(tfComanda_Nome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btComanda_PesquisarNome))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btComanda_Abrir)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Abrir Comanda", jpComanda);

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
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 332, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                        .addGroup(jpItemServicoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jpItemServicoLayout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addComponent(btItemServico_Salvar))
                            .addGroup(jpItemServicoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(btItemServico_Alterar, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(btItemServico_Excluir, javax.swing.GroupLayout.Alignment.TRAILING))))
                    .addGroup(jpItemServicoLayout.createSequentialGroup()
                        .addGroup(jpItemServicoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tfItemServico_Descricao, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbItemServico_Descricao))
                        .addGap(18, 18, 18)
                        .addGroup(jpItemServicoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbItemServico_Valor)
                            .addComponent(tfItemServico_Valor, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jpItemServicoLayout.setVerticalGroup(
            jpItemServicoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpItemServicoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpItemServicoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpItemServicoLayout.createSequentialGroup()
                        .addComponent(lbItemServico_Descricao)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jpItemServicoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tfItemServico_Descricao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfItemServico_Valor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jpItemServicoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jpItemServicoLayout.createSequentialGroup()
                                .addComponent(btItemServico_Salvar)
                                .addGap(18, 18, 18)
                                .addComponent(btItemServico_Alterar)
                                .addGap(18, 18, 18)
                                .addComponent(btItemServico_Excluir))))
                    .addComponent(lbItemServico_Valor))
                .addContainerGap(36, Short.MAX_VALUE))
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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpVisitanteLayout.createSequentialGroup()
                .addContainerGap(115, Short.MAX_VALUE)
                .addComponent(btVisitante_Salvar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btVisitante_Cancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(102, 102, 102))
            .addGroup(jpVisitanteLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpVisitanteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbVisitante_Telefone)
                    .addComponent(lbVisitante_Nome, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lbVisitante_Cpf, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(18, 18, 18)
                .addGroup(jpVisitanteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpVisitanteLayout.createSequentialGroup()
                        .addComponent(tfVisitante_Cpf)
                        .addGap(18, 18, 18)
                        .addComponent(btVisitante_PesquisarCPF, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(tfVisitante_Nome)
                    .addComponent(tfVisitante_Telefone))
                .addContainerGap())
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
                .addGap(34, 34, 34)
                .addGroup(jpVisitanteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btVisitante_Salvar)
                    .addComponent(btVisitante_Cancelar))
                .addContainerGap(54, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Cadastro de Visitantes", jpVisitante);

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

            item.setCodigo((int)jtItemServico.getValueAt(jtItemServico.getSelectedRow(), 0));
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
            item.setCodigo((int)jtItemServico.getValueAt(jtItemServico.getSelectedRow(), 0));
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

    private void jtComandaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtComandaMouseClicked
        // TODO add your handling code here:

        if (jtComanda.getSelectedRow() != -1) {
            tfComanda_Cpf.setText(jtComanda.getValueAt(jtComanda.getSelectedRow(), 0).toString());
            tfComanda_Nome.setText(jtComanda.getValueAt(jtComanda.getSelectedRow(), 1).toString());
        }

    }//GEN-LAST:event_jtComandaMouseClicked

    private void jtComandaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtComandaKeyReleased
        // TODO add your handling code here:

        if (jtComanda.getSelectedRow() != -1) {
            tfComanda_Cpf.setText(jtComanda.getValueAt(jtComanda.getSelectedRow(), 0).toString());
            tfComanda_Nome.setText(jtComanda.getValueAt(jtComanda.getSelectedRow(), 1).toString());
        }

    }//GEN-LAST:event_jtComandaKeyReleased

    private void btComanda_PesquisaCPFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btComanda_PesquisaCPFActionPerformed
        // TODO add your handling code here:
        ComandaDAO comandaDAO = new ComandaDAO();
        
        String retorno = comandaDAO.verificaCPF(Double.parseDouble(tfComanda_Cpf.getText()));
        if (retorno != null) {
            JOptionPane.showMessageDialog(null, "Visitante existente!");
            tfComanda_Nome.setText(retorno);
        } else {
            JOptionPane.showMessageDialog(null, "Visitante não encontrado!");
        }
    }//GEN-LAST:event_btComanda_PesquisaCPFActionPerformed

    private void btComanda_PesquisarNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btComanda_PesquisarNomeActionPerformed
        // TODO add your handling code here:
        leTabelaComandaPorNome(tfComanda_Nome.getText());
        tfComanda_Cpf.setText("");
        
    }//GEN-LAST:event_btComanda_PesquisarNomeActionPerformed

    private void btComanda_AbrirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btComanda_AbrirActionPerformed
        // TODO add your handling code here:
        if (!tfComanda_Nome.getText().equals("")) {                    
            Comanda comanda = new Comanda();
            ComandaDAO comandaDAO = new ComandaDAO();

            comanda.setCpf_visitante(Double.parseDouble(tfComanda_Cpf.getText()));

            comandaDAO.abre(comanda);
        } else {
            JOptionPane.showMessageDialog(null, "Selecione um CPF.");
        }
        
    }//GEN-LAST:event_btComanda_AbrirActionPerformed

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
    private javax.swing.JButton btComanda_Abrir;
    private javax.swing.JButton btComanda_ItemServico_Adicionar;
    private javax.swing.JButton btComanda_ItemServico_Cancelar;
    private javax.swing.JButton btComanda_PesquisaCPF;
    private javax.swing.JButton btComanda_PesquisarNome;
    private javax.swing.JButton btItemServico_Alterar;
    private javax.swing.JButton btItemServico_Excluir;
    private javax.swing.JButton btItemServico_Salvar;
    private javax.swing.JButton btVisitante_Cancelar;
    private javax.swing.JButton btVisitante_PesquisarCPF;
    private javax.swing.JButton btVisitante_Salvar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JPanel jpComanda;
    private javax.swing.JPanel jpComanda_ItemServico;
    private javax.swing.JPanel jpItemServico;
    private javax.swing.JPanel jpVisitante;
    private javax.swing.JTable jtComanda;
    private javax.swing.JTable jtItemServico;
    private javax.swing.JLabel lbComanda_Cpf;
    private javax.swing.JLabel lbComanda_ItemServico_CodComanda;
    private javax.swing.JLabel lbComanda_ItemServico_CodItemServico;
    private javax.swing.JLabel lbComanda_ItemServico_Quantidade;
    private javax.swing.JLabel lbComanda_ItemServico_Valor;
    private javax.swing.JLabel lbComanda_Nome;
    private javax.swing.JLabel lbItemServico_Descricao;
    private javax.swing.JLabel lbItemServico_Valor;
    private javax.swing.JLabel lbVisitante_Cpf;
    private javax.swing.JLabel lbVisitante_Nome;
    private javax.swing.JLabel lbVisitante_Telefone;
    private javax.swing.JTextField tfComanda_Cpf;
    private javax.swing.JTextField tfComanda_ItemServico_CodComanda;
    private javax.swing.JTextField tfComanda_ItemServico_CodItemServico;
    private javax.swing.JTextField tfComanda_ItemServico_Quantidade;
    private javax.swing.JTextField tfComanda_ItemServico_Valor;
    private javax.swing.JTextField tfComanda_Nome;
    private javax.swing.JTextField tfItemServico_Descricao;
    private javax.swing.JTextField tfItemServico_Valor;
    private javax.swing.JTextField tfVisitante_Cpf;
    private javax.swing.JTextField tfVisitante_Nome;
    private javax.swing.JTextField tfVisitante_Telefone;
    // End of variables declaration//GEN-END:variables
}
