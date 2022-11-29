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
import util.DialogUtil;

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
        boolean bibliotecarioEstaLogado = sessaoBibliotecario != null;
        this.menuBar.setVisible(bibliotecarioEstaLogado);
        this.btnLogin.setVisible(!bibliotecarioEstaLogado);
        
        if (sessaoBibliotecario != null) {
            this.lbNomeUsuario.setText("Usuário: " + sessaoBibliotecario.getNome());
        } else {
            this.lbNomeUsuario.setText("");
        }
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
        btnDevolver = new javax.swing.JButton();
        btnEmprestar = new javax.swing.JButton();
        btnLogin = new javax.swing.JButton();
        lbNomeUsuario = new javax.swing.JLabel();
        menuBar = new javax.swing.JMenuBar();
        menuCadastros = new javax.swing.JMenu();
        menuItemEstudantes = new javax.swing.JMenuItem();
        menuItemReservas = new javax.swing.JMenuItem();
        menuItemBibliotecarios = new javax.swing.JMenuItem();
        menuItemArmarios = new javax.swing.JMenuItem();
        menuOpcoes = new javax.swing.JMenu();
        menuItemSairConta = new javax.swing.JMenuItem();
        menuItemSairSistema = new javax.swing.JMenuItem();

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

        btnDevolver.setText("DEVOLVER");
        btnDevolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDevolverActionPerformed(evt);
            }
        });

        btnEmprestar.setText("EMPRESTAR");
        btnEmprestar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEmprestarActionPerformed(evt);
            }
        });

        btnLogin.setText("LOGIN");
        btnLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginActionPerformed(evt);
            }
        });

        lbNomeUsuario.setText("Usuário: NomeUsuario");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnLogin, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnDevolver, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnEmprestar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 127, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lbNomeUsuario)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(btnEmprestar, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41)
                .addComponent(btnDevolver, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbNomeUsuario)
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

        menuItemArmarios.setText("Armarios");
        menuItemArmarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemArmariosActionPerformed(evt);
            }
        });
        menuCadastros.add(menuItemArmarios);

        menuBar.add(menuCadastros);

        menuOpcoes.setText("Opções");

        menuItemSairConta.setText("Sair da Conta");
        menuItemSairConta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemSairContaActionPerformed(evt);
            }
        });
        menuOpcoes.add(menuItemSairConta);

        menuItemSairSistema.setText("Encerrar Sistema");
        menuItemSairSistema.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemSairSistemaActionPerformed(evt);
            }
        });
        menuOpcoes.add(menuItemSairSistema);

        menuBar.add(menuOpcoes);

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

    private void btnDevolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDevolverActionPerformed
        this.iniciarInternalFrame(new DevolucaoUI());
    }//GEN-LAST:event_btnDevolverActionPerformed

    private void btnEmprestarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEmprestarActionPerformed
        this.iniciarInternalFrame(new EmprestimoUI());
    }//GEN-LAST:event_btnEmprestarActionPerformed

    private void btnLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginActionPerformed
        this.iniciarInternalFrame(new LoginUI());
    }//GEN-LAST:event_btnLoginActionPerformed

    private void menuItemEstudantesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemEstudantesActionPerformed
        this.iniciarInternalFrame(new EstudantesUI());
    }//GEN-LAST:event_menuItemEstudantesActionPerformed

    private void menuItemReservasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemReservasActionPerformed
        this.iniciarInternalFrame(new ReservasUI());
    }//GEN-LAST:event_menuItemReservasActionPerformed

    private void menuItemBibliotecariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemBibliotecariosActionPerformed
        this.iniciarInternalFrame(new BibliotecariosUI());
    }//GEN-LAST:event_menuItemBibliotecariosActionPerformed

    private void menuItemArmariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemArmariosActionPerformed
        this.iniciarInternalFrame(new ArmariosUI());
    }//GEN-LAST:event_menuItemArmariosActionPerformed

    private void menuItemSairContaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemSairContaActionPerformed
         boolean saidaConfirmada = DialogUtil.abrirModalConfirmacaoPadrao(
            this,
            "Realmente deseja sair da conta?"
        );
         
        if (saidaConfirmada){
            SessaoBibliotecario.setBibliotecarioLogado(null);            
            this.verificarSessao();
        }
    }//GEN-LAST:event_menuItemSairContaActionPerformed

    private void menuItemSairSistemaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemSairSistemaActionPerformed
        boolean encerramentoConfirmado = DialogUtil.abrirModalConfirmacaoPadrao(
            this,
            "Realmente deseja encerrar o sistema?"
        );
        
        if (encerramentoConfirmado) {
            System.exit(0);
        }
    }//GEN-LAST:event_menuItemSairSistemaActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDevolver;
    private javax.swing.JButton btnEmprestar;
    private javax.swing.JButton btnLogin;
    private javax.swing.JDesktopPane desktopPane;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lbNomeUsuario;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JMenu menuCadastros;
    private javax.swing.JMenuItem menuItemArmarios;
    private javax.swing.JMenuItem menuItemBibliotecarios;
    private javax.swing.JMenuItem menuItemEstudantes;
    private javax.swing.JMenuItem menuItemReservas;
    private javax.swing.JMenuItem menuItemSairConta;
    private javax.swing.JMenuItem menuItemSairSistema;
    private javax.swing.JMenu menuOpcoes;
    // End of variables declaration//GEN-END:variables
}
