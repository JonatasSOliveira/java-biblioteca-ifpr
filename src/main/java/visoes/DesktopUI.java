package visoes;

import util.Coordenada;

import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.event.InternalFrameAdapter;
import javax.swing.event.InternalFrameEvent;
import modelos.Bibliotecario;
import sessao.SessaoBibliotecario;

public class DesktopUI extends JFrame {

    public DesktopUI() {
        setResizable(false);
        setUndecorated(true);
        initComponents();
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.menuBar.setVisible(false);
        this.verificarSessao();
    }

    private void verificarSessao() {
        Bibliotecario sessaoBibliotecario = SessaoBibliotecario.getBibliotecarioLogado();
        boolean bibliotecarioEstaLogado = true; //sessaoBibliotecario != null;
        this.menuBar.setVisible(bibliotecarioEstaLogado);
    }

    private static Coordenada getCentroTela(int larguraJanela, int alturaJanela) {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        return new Coordenada(
                (screenSize.width - larguraJanela) / 2,
                (screenSize.height - alturaJanela) / 2
        );

    }

    private void iniciarInternalFrame(JInternalFrame internalFrame) {
        this.desktopPane.removeAll();
        repaint();
        Dimension internalFrameSize = internalFrame.getSize();
        Coordenada coordenadaCentro = DesktopUI.getCentroTela(internalFrameSize.width, internalFrameSize.height);
        this.desktopPane.add(internalFrame);
        DesktopUI desktopUI = this;
        internalFrame.addInternalFrameListener(new InternalFrameAdapter() {
            @Override
            public void internalFrameClosing(InternalFrameEvent e) {
                desktopUI.verificarSessao();
            }
        });
        internalFrame.setLocation(coordenadaCentro.getPontoX(), coordenadaCentro.getPontoY());
        internalFrame.setVisible(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        desktopPane = new javax.swing.JDesktopPane();
        jPanel1 = new javax.swing.JPanel();
        devolverButton = new javax.swing.JButton();
        emprestarButton = new javax.swing.JButton();
        loginButton = new javax.swing.JButton();
        menuBar = new javax.swing.JMenuBar();
        menuCadastros = new javax.swing.JMenu();
        menuItemEstudantes = new javax.swing.JMenuItem();
        menuItemReservas = new javax.swing.JMenuItem();
        menuItemBibliotecarios = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        setSize(new java.awt.Dimension(1024, 768));

        javax.swing.GroupLayout desktopPaneLayout = new javax.swing.GroupLayout(desktopPane);
        desktopPane.setLayout(desktopPaneLayout);
        desktopPaneLayout.setHorizontalGroup(
            desktopPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1038, Short.MAX_VALUE)
        );
        desktopPaneLayout.setVerticalGroup(
            desktopPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 445, Short.MAX_VALUE)
        );

        devolverButton.setText("DEVOLVER");
        devolverButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                devolverButtonActionPerformed(evt);
            }
        });

        emprestarButton.setText("EMPRESTAR");
        emprestarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                emprestarButtonActionPerformed(evt);
            }
        });

        loginButton.setText("LOGIN");
        loginButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(loginButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(devolverButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(emprestarButton, javax.swing.GroupLayout.DEFAULT_SIZE, 127, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(emprestarButton, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41)
                .addComponent(devolverButton, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(loginButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        menuCadastros.setText("Cadastros");

        menuItemEstudantes.setText("Estudantes");
        menuItemEstudantes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemEstudantesActionPerformed(evt);
            }
        });
        menuCadastros.add(menuItemEstudantes);

        menuItemReservas.setText("Reservas");
        menuItemReservas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemReservasActionPerformed(evt);
            }
        });
        menuCadastros.add(menuItemReservas);

        menuItemBibliotecarios.setText("Bibliotecarios");
        menuItemBibliotecarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemBibliotecariosActionPerformed(evt);
            }
        });
        menuCadastros.add(menuItemBibliotecarios);

        menuBar.add(menuCadastros);

        setJMenuBar(menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(desktopPane))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(desktopPane)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void devolverButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_devolverButtonActionPerformed
        this.iniciarInternalFrame(new DevolucaoUI());
    }//GEN-LAST:event_devolverButtonActionPerformed

    private void emprestarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_emprestarButtonActionPerformed
        this.iniciarInternalFrame(new EmprestimoUI());
    }//GEN-LAST:event_emprestarButtonActionPerformed

    private void loginButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginButtonActionPerformed
        this.iniciarInternalFrame(new LoginUI());
    }//GEN-LAST:event_loginButtonActionPerformed

    private void menuItemEstudantesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemEstudantesActionPerformed
        this.iniciarInternalFrame(new EstudantesUI());
    }//GEN-LAST:event_menuItemEstudantesActionPerformed

    private void menuItemReservasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemReservasActionPerformed
        this.iniciarInternalFrame(new ReservasUI());
    }//GEN-LAST:event_menuItemReservasActionPerformed

    private void menuItemBibliotecariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemBibliotecariosActionPerformed
        this.iniciarInternalFrame(new BibliotecariosUI());
    }//GEN-LAST:event_menuItemBibliotecariosActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane desktopPane;
    private javax.swing.JButton devolverButton;
    private javax.swing.JButton emprestarButton;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton loginButton;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JMenu menuCadastros;
    private javax.swing.JMenuItem menuItemBibliotecarios;
    private javax.swing.JMenuItem menuItemEstudantes;
    private javax.swing.JMenuItem menuItemReservas;
    // End of variables declaration//GEN-END:variables
}
