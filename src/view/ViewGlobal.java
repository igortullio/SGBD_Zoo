
package view;

public class ViewGlobal extends javax.swing.JFrame {

    public ViewGlobal() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jpItemServico = new javax.swing.JPanel();
        tfDescricao = new javax.swing.JTextField();
        tfValor = new javax.swing.JTextField();
        lbDescricao = new javax.swing.JLabel();
        lbValor = new javax.swing.JLabel();
        btSalvar = new javax.swing.JButton();
        btExcluir = new javax.swing.JButton();
        btAlterar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtItemServico = new javax.swing.JTable();
        jpComanda = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtComanda = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        btPesquisar1 = new javax.swing.JButton();
        tfCpf1 = new javax.swing.JTextField();
        lbCpf1 = new javax.swing.JLabel();
        tfCpf2 = new javax.swing.JTextField();
        btPesquisar2 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jpVisitante = new javax.swing.JPanel();
        tfCpf = new javax.swing.JTextField();
        tfNome = new javax.swing.JTextField();
        lbCpf = new javax.swing.JLabel();
        lbNome = new javax.swing.JLabel();
        btSalvar1 = new javax.swing.JButton();
        tfTelefone = new javax.swing.JTextField();
        lbTelefone = new javax.swing.JLabel();
        btCancelar = new javax.swing.JButton();
        btPesquisar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImages(null);

        jTabbedPane1.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N

        lbDescricao.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbDescricao.setText("Descrição:");

        lbValor.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbValor.setText("Valor:");

        btSalvar.setText("Salvar");
        btSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSalvarActionPerformed(evt);
            }
        });

        btExcluir.setText("Excluir");
        btExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btExcluirActionPerformed(evt);
            }
        });

        btAlterar.setText("Alterar");
        btAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAlterarActionPerformed(evt);
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
                                .addComponent(btSalvar))
                            .addGroup(jpItemServicoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(btAlterar, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(btExcluir, javax.swing.GroupLayout.Alignment.TRAILING))))
                    .addGroup(jpItemServicoLayout.createSequentialGroup()
                        .addGroup(jpItemServicoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tfDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbDescricao))
                        .addGap(18, 18, 18)
                        .addGroup(jpItemServicoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbValor)
                            .addComponent(tfValor, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jpItemServicoLayout.setVerticalGroup(
            jpItemServicoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpItemServicoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpItemServicoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpItemServicoLayout.createSequentialGroup()
                        .addComponent(lbDescricao)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jpItemServicoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tfDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfValor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jpItemServicoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jpItemServicoLayout.createSequentialGroup()
                                .addComponent(btSalvar)
                                .addGap(18, 18, 18)
                                .addComponent(btAlterar)
                                .addGap(18, 18, 18)
                                .addComponent(btExcluir))))
                    .addComponent(lbValor))
                .addContainerGap(35, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Cadastro de Itens/Serviços", jpItemServico);

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

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Nome:");

        btPesquisar1.setText("Pesquisar");
        btPesquisar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btPesquisar1ActionPerformed(evt);
            }
        });

        lbCpf1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbCpf1.setText("CPF:");

        btPesquisar2.setText("Pesquisar");
        btPesquisar2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btPesquisar2ActionPerformed(evt);
            }
        });

        jButton1.setText("Abrir Comanda");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
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
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(tfCpf2, javax.swing.GroupLayout.DEFAULT_SIZE, 237, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btPesquisar2, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jpComandaLayout.createSequentialGroup()
                        .addComponent(lbCpf1)
                        .addGap(30, 30, 30)
                        .addComponent(tfCpf1, javax.swing.GroupLayout.DEFAULT_SIZE, 237, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btPesquisar1, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(jpComandaLayout.createSequentialGroup()
                .addGap(164, 164, 164)
                .addComponent(jButton1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jpComandaLayout.setVerticalGroup(
            jpComandaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpComandaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpComandaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbCpf1)
                    .addComponent(tfCpf1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btPesquisar1))
                .addGap(18, 18, 18)
                .addGroup(jpComandaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(tfCpf2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btPesquisar2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Abrir Comanda", jpComanda);

        lbCpf.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbCpf.setText("CPF:");

        lbNome.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbNome.setText("Nome:");

        btSalvar1.setText("Salvar");
        btSalvar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSalvar1ActionPerformed(evt);
            }
        });

        lbTelefone.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbTelefone.setText("Telefone:");

        btCancelar.setText("Cancelar");
        btCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCancelarActionPerformed(evt);
            }
        });

        btPesquisar.setText("Pesquisar");
        btPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btPesquisarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jpVisitanteLayout = new javax.swing.GroupLayout(jpVisitante);
        jpVisitante.setLayout(jpVisitanteLayout);
        jpVisitanteLayout.setHorizontalGroup(
            jpVisitanteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpVisitanteLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpVisitanteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbNome)
                    .addComponent(lbTelefone)
                    .addComponent(lbCpf))
                .addGap(18, 18, 18)
                .addGroup(jpVisitanteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpVisitanteLayout.createSequentialGroup()
                        .addComponent(tfCpf)
                        .addGap(18, 18, 18)
                        .addComponent(btPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(tfNome)
                    .addComponent(tfTelefone))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpVisitanteLayout.createSequentialGroup()
                .addContainerGap(115, Short.MAX_VALUE)
                .addComponent(btSalvar1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(102, 102, 102))
        );
        jpVisitanteLayout.setVerticalGroup(
            jpVisitanteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpVisitanteLayout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(jpVisitanteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbCpf)
                    .addComponent(tfCpf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btPesquisar))
                .addGap(18, 18, 18)
                .addGroup(jpVisitanteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbNome))
                .addGap(18, 18, 18)
                .addGroup(jpVisitanteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbTelefone))
                .addGap(34, 34, 34)
                .addGroup(jpVisitanteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btSalvar1)
                    .addComponent(btCancelar))
                .addContainerGap(53, Short.MAX_VALUE))
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

    private void btSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSalvarActionPerformed

        ItemServico item = new ItemServico();
        ItemServicoDAO itemDAO = new ItemServicoDAO();

        item.setDescricao(tfDescricao.getText());
        item.setValor(Double.parseDouble(tfValor.getText()));

        itemDAO.salvar(item);

        tfDescricao.setText("");
        tfValor.setText("");

        leTabela();

    }//GEN-LAST:event_btSalvarActionPerformed

    private void btExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btExcluirActionPerformed
        // TODO add your handling code here:

        if (jtItemServico.getSelectedRow() != -1) {
            ItemServico item = new ItemServico();
            ItemServicoDAO itemDAO = new ItemServicoDAO();

            item.setCodigo((int)jtItemServico.getValueAt(jtItemServico.getSelectedRow(), 0));
            itemDAO.excluir(item);

            tfDescricao.setText("");
            tfValor.setText("");

            leTabela();
        } else {
            JOptionPane.showMessageDialog(null, "Selecione um produto");
        }

    }//GEN-LAST:event_btExcluirActionPerformed

    private void btAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAlterarActionPerformed
        // TODO add your handling code here:

        if (jtItemServico.getSelectedRow() != -1) {
            ItemServico item = new ItemServico();
            ItemServicoDAO itemDAO = new ItemServicoDAO();

            item.setDescricao(tfDescricao.getText());
            item.setValor(Double.parseDouble(tfValor.getText()));
            item.setCodigo((int)jtItemServico.getValueAt(jtItemServico.getSelectedRow(), 0));
            itemDAO.alterar(item);

            tfDescricao.setText("");
            tfValor.setText("");

            leTabela();
        } else {
            JOptionPane.showMessageDialog(null, "Selecione um produto");
        }

    }//GEN-LAST:event_btAlterarActionPerformed

    private void jtItemServicoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtItemServicoMouseClicked
        // TODO add your handling code here:

        if (jtItemServico.getSelectedRow() != -1) {
            tfDescricao.setText(jtItemServico.getValueAt(jtItemServico.getSelectedRow(), 1).toString());
            tfValor.setText(jtItemServico.getValueAt(jtItemServico.getSelectedRow(), 2).toString());
        }

    }//GEN-LAST:event_jtItemServicoMouseClicked

    private void jtItemServicoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtItemServicoKeyReleased
        // TODO add your handling code here:

        if (jtItemServico.getSelectedRow() != -1) {
            tfDescricao.setText(jtItemServico.getValueAt(jtItemServico.getSelectedRow(), 1).toString());
            tfValor.setText(jtItemServico.getValueAt(jtItemServico.getSelectedRow(), 2).toString());
        }

    }//GEN-LAST:event_jtItemServicoKeyReleased

    private void btSalvar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSalvar1ActionPerformed

        Visitante visitante = new Visitante();
        VisitanteDAO visitanteDAO = new VisitanteDAO();

        visitante.setCpf(Integer.parseInt(tfCpf.getText()));
        visitante.setNome(tfNome.getText());
        visitante.setTelefone(Integer.parseInt(tfTelefone.getText()));

        visitanteDAO.salvar(visitante);

        tfCpf.setText("");
        tfNome.setText("");
        tfTelefone.setText("");
    }//GEN-LAST:event_btSalvar1ActionPerformed

    private void btCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCancelarActionPerformed
        // TODO add your handling code here:

        tfCpf.setText("");
        tfNome.setText("");
        tfTelefone.setText("");
    }//GEN-LAST:event_btCancelarActionPerformed

    private void btPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btPesquisarActionPerformed
        // TODO add your handling code here:

        Visitante visitante = new Visitante();
        VisitanteDAO visitanteDAO = new VisitanteDAO();

        visitante.setCpf(Integer.parseInt(tfCpf.getText()));

        if (visitanteDAO.pesquisar(visitante)){
            JOptionPane.showMessageDialog(null, "CPF existente!");
        } else {
            JOptionPane.showMessageDialog(null, "Não existe resgistro com esse CPF.");
        }
    }//GEN-LAST:event_btPesquisarActionPerformed

    private void jtComandaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtComandaMouseClicked
        // TODO add your handling code here:

        if (jtComanda.getSelectedRow() != -1) {
            tfBuscaCpf.setText(jtComanda.getValueAt(jtComanda.getSelectedRow(), 0).toString());
            tfBuscaNome.setText(jtComanda.getValueAt(jtComanda.getSelectedRow(), 1).toString());
        }

    }//GEN-LAST:event_jtComandaMouseClicked

    private void jtComandaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtComandaKeyReleased
        // TODO add your handling code here:

        if (jtComanda.getSelectedRow() != -1) {
            tfBuscaCpf.setText(jtComanda.getValueAt(jtComanda.getSelectedRow(), 0).toString());
            tfBuscaNome.setText(jtComanda.getValueAt(jtComanda.getSelectedRow(), 1).toString());
        }

    }//GEN-LAST:event_jtComandaKeyReleased

    private void btPesquisar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btPesquisar1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btPesquisar1ActionPerformed

    private void btPesquisar2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btPesquisar2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btPesquisar2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

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
    private javax.swing.JButton btAlterar;
    private javax.swing.JButton btCancelar;
    private javax.swing.JButton btExcluir;
    private javax.swing.JButton btPesquisar;
    private javax.swing.JButton btPesquisar1;
    private javax.swing.JButton btPesquisar2;
    private javax.swing.JButton btSalvar;
    private javax.swing.JButton btSalvar1;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JPanel jpComanda;
    private javax.swing.JPanel jpItemServico;
    private javax.swing.JPanel jpVisitante;
    private javax.swing.JTable jtComanda;
    private javax.swing.JTable jtItemServico;
    private javax.swing.JLabel lbCpf;
    private javax.swing.JLabel lbCpf1;
    private javax.swing.JLabel lbDescricao;
    private javax.swing.JLabel lbNome;
    private javax.swing.JLabel lbTelefone;
    private javax.swing.JLabel lbValor;
    private javax.swing.JTextField tfCpf;
    private javax.swing.JTextField tfCpf1;
    private javax.swing.JTextField tfCpf2;
    private javax.swing.JTextField tfDescricao;
    private javax.swing.JTextField tfNome;
    private javax.swing.JTextField tfTelefone;
    private javax.swing.JTextField tfValor;
    // End of variables declaration//GEN-END:variables
}
