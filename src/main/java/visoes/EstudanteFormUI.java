package visoes;

import controles.EstudanteControle;
import javax.swing.JPanel;
import modelos.Estudante;
import visoescomponentes.FormularioUI;

public class EstudanteFormUI extends FormularioUI {
    private Estudante estudanteEmEdicao = null;
    
    public EstudanteFormUI(Estudante estudante) {
        super();
        initComponents();
        super.iniciarComponentes();
        
        if (estudante == null) {
            this.estudanteEmEdicao = new Estudante();
            return;
        }
        
        this.inputNome.setText(estudante.getNome());
        this.inputRA.setText(estudante.getRa());
        this.inputEmail.setText(estudante.getEmail());
        this.inputTelefone.setText(estudante.getTelefone());
        this.estudanteEmEdicao = estudante;
    }
        

    @Override
    protected JPanel getPanelForm() {
        return this.panelForm;
    }
    
     @Override
    protected void salvar() {
        Estudante estudante = this.estudanteEmEdicao;
            
        estudante.setNome(this.inputNome.getText());
        estudante.setRa(this.inputRA.getText());
        estudante.setEmail(this.inputEmail.getText());
        estudante.setSenha(new String(this.inputSenha.getPassword()));
        estudante.setTelefone(this.inputTelefone.getText());
        
        if (estudante.getId() != null) {
            EstudanteControle.atualizar(estudante);
        } else {
            EstudanteControle.criar(estudante);
        }
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelForm = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        lbNome = new javax.swing.JLabel();
        inputNome = new javax.swing.JTextField();
        lbEmail = new javax.swing.JLabel();
        inputEmail = new javax.swing.JTextField();
        lbRA = new javax.swing.JLabel();
        inputRA = new javax.swing.JTextField();
        lbSenha = new javax.swing.JLabel();
        inputSenha = new javax.swing.JPasswordField();
        lbTelefone = new javax.swing.JLabel();
        inputTelefone = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        lbNome1 = new javax.swing.JLabel();
        inputNome1 = new javax.swing.JTextField();
        lbEmail1 = new javax.swing.JLabel();
        inputEmail1 = new javax.swing.JTextField();
        lbRA1 = new javax.swing.JLabel();
        inputRA1 = new javax.swing.JTextField();
        lbSenha1 = new javax.swing.JLabel();
        inputSenha1 = new javax.swing.JPasswordField();
        lbTelefone1 = new javax.swing.JLabel();
        inputTelefone1 = new javax.swing.JTextField();

        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        lbNome.setText("Nome:");

        lbEmail.setText("Email:");

        lbRA.setText("R.A.:");

        lbSenha.setText("Senha:");

        lbTelefone.setText("Telefone");

        lbNome1.setText("Nome:");

        lbEmail1.setText("Email:");

        lbRA1.setText("R.A.:");

        lbSenha1.setText("Senha:");

        lbTelefone1.setText("Telefone");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lbNome1)
                    .addComponent(lbSenha1)
                    .addComponent(lbTelefone1)
                    .addComponent(inputNome1)
                    .addComponent(inputTelefone1)
                    .addComponent(lbRA1)
                    .addComponent(inputRA1)
                    .addComponent(lbEmail1)
                    .addComponent(inputEmail1)
                    .addComponent(inputSenha1, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE))
                .addContainerGap(177, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbNome1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(inputNome1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lbRA1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(inputRA1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lbEmail1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(inputEmail1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lbSenha1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(inputSenha1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lbTelefone1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(inputTelefone1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lbNome)
                    .addComponent(lbSenha)
                    .addComponent(lbTelefone)
                    .addComponent(inputNome)
                    .addComponent(inputTelefone)
                    .addComponent(lbRA)
                    .addComponent(inputRA)
                    .addComponent(lbEmail)
                    .addComponent(inputEmail)
                    .addComponent(inputSenha, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE))
                .addContainerGap(177, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbNome)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(inputNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lbRA)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(inputRA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lbEmail)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(inputEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lbSenha)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(inputSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lbTelefone)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(inputTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        jScrollPane1.setViewportView(jPanel1);

        javax.swing.GroupLayout panelFormLayout = new javax.swing.GroupLayout(panelForm);
        panelForm.setLayout(panelFormLayout);
        panelFormLayout.setHorizontalGroup(
            panelFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
        );
        panelFormLayout.setVerticalGroup(
            panelFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 291, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelForm, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelForm, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField inputEmail;
    private javax.swing.JTextField inputEmail1;
    private javax.swing.JTextField inputNome;
    private javax.swing.JTextField inputNome1;
    private javax.swing.JTextField inputRA;
    private javax.swing.JTextField inputRA1;
    private javax.swing.JPasswordField inputSenha;
    private javax.swing.JPasswordField inputSenha1;
    private javax.swing.JTextField inputTelefone;
    private javax.swing.JTextField inputTelefone1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbEmail;
    private javax.swing.JLabel lbEmail1;
    private javax.swing.JLabel lbNome;
    private javax.swing.JLabel lbNome1;
    private javax.swing.JLabel lbRA;
    private javax.swing.JLabel lbRA1;
    private javax.swing.JLabel lbSenha;
    private javax.swing.JLabel lbSenha1;
    private javax.swing.JLabel lbTelefone;
    private javax.swing.JLabel lbTelefone1;
    private javax.swing.JPanel panelForm;
    // End of variables declaration//GEN-END:variables

}
