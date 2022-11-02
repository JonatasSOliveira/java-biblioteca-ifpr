package visoescomponentes;

import java.util.List;
import javax.swing.event.InternalFrameAdapter;
import javax.swing.event.InternalFrameEvent;
import javax.swing.table.DefaultTableModel;

public abstract class ListagemUI<T> extends javax.swing.JInternalFrame {

    private final DefaultTableModel tableModel = new DefaultTableModel();

    public ListagemUI() {
        this.montaCabecalhos();
        initComponents();
        this.carregaDados(null);
    }

    private void montaCabecalhos() {
        for (String cabecalhoColuna : this.getCabecalhosColunas()) {
            this.tableModel.addColumn(cabecalhoColuna);
        }
    }

    private void carregaDados(String filtro) {
        int rowCount = this.tableModel.getRowCount();
        for (int i = rowCount - 1; i >= 0; i--) {
            this.tableModel.removeRow(i);
        }
        List<T> listaDados = this.buscarDados(filtro);

        if (listaDados != null) {
            for (T entidade : listaDados) {
                this.tableModel.addRow(this.getLinha(entidade));
            }
        }
    }

    protected abstract String[] getCabecalhosColunas();

    protected abstract List<T> buscarDados(String filtro);

    protected abstract String[] getLinha(T entidade);

    protected abstract FormularioUI getTelaFormulario();

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        painelFiltros = new javax.swing.JPanel();
        btnBuscar = new javax.swing.JButton();
        inputFiltro = new javax.swing.JTextField();
        btnNovo = new javax.swing.JButton();
        painelTabela = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setClosable(true);
        setMaximizable(true);

        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        btnNovo.setText("Novo");
        btnNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNovoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout painelFiltrosLayout = new javax.swing.GroupLayout(painelFiltros);
        painelFiltros.setLayout(painelFiltrosLayout);
        painelFiltrosLayout.setHorizontalGroup(
            painelFiltrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelFiltrosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painelFiltrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelFiltrosLayout.createSequentialGroup()
                        .addComponent(inputFiltro, javax.swing.GroupLayout.DEFAULT_SIZE, 302, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnBuscar))
                    .addGroup(painelFiltrosLayout.createSequentialGroup()
                        .addComponent(btnNovo)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        painelFiltrosLayout.setVerticalGroup(
            painelFiltrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelFiltrosLayout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(painelFiltrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnBuscar)
                    .addComponent(inputFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnNovo)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(painelFiltros, java.awt.BorderLayout.PAGE_START);

        jTable1.setModel(tableModel);
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout painelTabelaLayout = new javax.swing.GroupLayout(painelTabela);
        painelTabela.setLayout(painelTabelaLayout);
        painelTabelaLayout.setHorizontalGroup(
            painelTabelaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelTabelaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 381, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        painelTabelaLayout.setVerticalGroup(
            painelTabelaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 243, Short.MAX_VALUE)
        );

        getContentPane().add(painelTabela, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents


    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        this.carregaDados(this.inputFiltro.getText());
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovoActionPerformed
        FormularioUI formUI = this.getTelaFormulario();
        this.getParent().add(formUI);

        ListagemUI listageUI = this;
        formUI.addInternalFrameListener(new InternalFrameAdapter() {
            @Override
            public void internalFrameClosing(InternalFrameEvent e) {
                listageUI.carregaDados(null);
            }
        });
        formUI.setVisible(true);
    }//GEN-LAST:event_btnNovoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnNovo;
    private javax.swing.JTextField inputFiltro;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JPanel painelFiltros;
    private javax.swing.JPanel painelTabela;
    // End of variables declaration//GEN-END:variables
}
