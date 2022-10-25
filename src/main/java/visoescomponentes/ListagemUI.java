package visoescomponentes;

import java.util.List;
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

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        painelFiltros = new javax.swing.JPanel();
        btnBuscar = new javax.swing.JButton();
        inputFiltro = new javax.swing.JTextField();
        painelTabela = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout painelFiltrosLayout = new javax.swing.GroupLayout(painelFiltros);
        painelFiltros.setLayout(painelFiltrosLayout);
        painelFiltrosLayout.setHorizontalGroup(
            painelFiltrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelFiltrosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(inputFiltro, javax.swing.GroupLayout.DEFAULT_SIZE, 298, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnBuscar)
                .addContainerGap())
        );
        painelFiltrosLayout.setVerticalGroup(
            painelFiltrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelFiltrosLayout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(painelFiltrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnBuscar)
                    .addComponent(inputFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(44, Short.MAX_VALUE))
        );

        getContentPane().add(painelFiltros, java.awt.BorderLayout.PAGE_START);

        jTable1.setModel(tableModel);
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout painelTabelaLayout = new javax.swing.GroupLayout(painelTabela);
        painelTabela.setLayout(painelTabelaLayout);
        painelTabelaLayout.setHorizontalGroup(
            painelTabelaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelTabelaLayout.createSequentialGroup()
                .addContainerGap(7, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 381, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        painelTabelaLayout.setVerticalGroup(
            painelTabelaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 247, Short.MAX_VALUE)
        );

        getContentPane().add(painelTabela, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>                        

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {                                          
        this.carregaDados(this.inputFiltro.getText());
    }                                         


    // Variables declaration - do not modify                     
    private javax.swing.JButton btnBuscar;
    private javax.swing.JTextField inputFiltro;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JPanel painelFiltros;
    private javax.swing.JPanel painelTabela;
    // End of variables declaration                   
}
