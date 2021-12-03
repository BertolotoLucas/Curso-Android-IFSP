/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import DAO.DisciplinaDAO;
import Modelo.Disciplina;
import java.awt.Toolkit;
import javax.swing.JOptionPane;

/**
 *
 * @author Lucas Bertoloto dos Santos
 */
public class frmCadastro extends javax.swing.JFrame {
    //atributo da classe que se envolve com o banco 
    private DisciplinaDAO disciplinaDAO;
    /**
     * Creates new form frmCadastro
     */
    
    //novo construtor da classe, utilizado para atribuir valor ao unico atributo da classe que faz a comunicacao com o banco
    public frmCadastro(DisciplinaDAO dao) {
        initComponents();
        this.disciplinaDAO = dao;
        //colocar um icone da imagem do nosso querido instituto federal <3
        this.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagens/LogoIFSP.jpg")));
    }

    public frmCadastro() {
        initComponents();
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        spnNumVagas = new javax.swing.JSpinner();
        txtNomeDisciplina = new javax.swing.JTextField();
        spnNumCarga = new javax.swing.JSpinner();
        txtNomeCurso = new javax.swing.JTextField();
        cboPeriodos = new javax.swing.JComboBox<>();
        btnRemover = new javax.swing.JButton();
        btnCadastrar = new javax.swing.JButton();
        btnLimpar = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Adicionar Disciplina");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jLabel1.setText("Nome da disciplina:");

        jLabel2.setText("Carga horária:");

        jLabel3.setText("Nome do Curso:");

        jLabel4.setText("Número de vagas:");

        jLabel5.setText("Período:");

        spnNumVagas.setToolTipText("Número de vagas disponibilizadas para cursar esta disciplinas");
        spnNumVagas.setValue(1);
        spnNumVagas.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                spnNumVagasStateChanged(evt);
            }
        });

        txtNomeDisciplina.setToolTipText("Área para digitar o nome desejado para a nova disciplina");
        txtNomeDisciplina.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtNomeDisciplinaKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNomeDisciplinaKeyTyped(evt);
            }
        });

        spnNumCarga.setToolTipText("Carga horária total da disciplina");
        spnNumCarga.setValue(1);
        spnNumCarga.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                spnNumCargaStateChanged(evt);
            }
        });

        txtNomeCurso.setToolTipText("Nome do curso que a disciplina pertence");
        txtNomeCurso.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtNomeCursoKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNomeCursoKeyTyped(evt);
            }
        });

        cboPeriodos.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Integral", "Diurno", "Matutino", "Noturno", "Vespertino" }));
        cboPeriodos.setToolTipText("Período que a disciplina será cursada");

        btnRemover.setText("Remover diciplina");
        btnRemover.setToolTipText("Ir para tela de remoção de disciplinas");
        btnRemover.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoverActionPerformed(evt);
            }
        });

        btnCadastrar.setText("Cadastrar");
        btnCadastrar.setToolTipText("Cadastrar a disciplina no banco de dados");
        btnCadastrar.setEnabled(false);
        btnCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastrarActionPerformed(evt);
            }
        });

        btnLimpar.setText("Limpar");
        btnLimpar.setToolTipText("Limpar o formulario para recomeçar o preenchimento");
        btnLimpar.setEnabled(false);
        btnLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimparActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Formulario para adicionar disciplinas");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtNomeDisciplina))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnRemover)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnLimpar, javax.swing.GroupLayout.DEFAULT_SIZE, 88, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnCadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(txtNomeCurso))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(spnNumCarga, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(spnNumVagas, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(58, 58, 58)
                        .addComponent(cboPeriodos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtNomeDisciplina, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(spnNumCarga, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(spnNumVagas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtNomeCurso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel5)
                    .addComponent(cboPeriodos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRemover)
                    .addComponent(btnCadastrar)
                    .addComponent(btnLimpar))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void spnNumVagasStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_spnNumVagasStateChanged
        //Verificação para impedir vagas nula ou negativa
        int valor = (int) this.spnNumVagas.getValue();
        if(valor<=0){
            //caso seja, colocar o valor como 1. 
            this.spnNumVagas.setValue(1);
        }
    }//GEN-LAST:event_spnNumVagasStateChanged

    private void txtNomeDisciplinaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNomeDisciplinaKeyTyped
        //Verificacao do total de caracteres, ja que o banco armazena ate 45 caracteres
        int totalCaracteres = this.txtNomeDisciplina.getText().length();
        if(totalCaracteres > 45){
            //caso seja, colocar até o caractere 44
            String texto = this.txtNomeDisciplina.getText();
            String textoLimitado = texto.substring(0, 44);
            this.txtNomeDisciplina.setText(textoLimitado);
        }
    }//GEN-LAST:event_txtNomeDisciplinaKeyTyped

    private void spnNumCargaStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_spnNumCargaStateChanged
        //Verificação para impedir carga horaria nula ou negativa
        int valor = (int) this.spnNumCarga.getValue();
        if(valor<=0){
            //caso seja, colocar o valor como 1. 
            this.spnNumCarga.setValue(1);
        }
    }//GEN-LAST:event_spnNumCargaStateChanged

    private void txtNomeCursoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNomeCursoKeyTyped
        //Verificacao do total de caracteres, ja que o banco armazena ate 45 caracteres
        int totalCaracteres = this.txtNomeCurso.getText().length();
        if(totalCaracteres > 45){
            //caso seja, colocar até o caractere 44
            String texto = this.txtNomeCurso.getText();
            String textoLimitado = texto.substring(0, 44);
            this.txtNomeCurso.setText(textoLimitado);
        }
    }//GEN-LAST:event_txtNomeCursoKeyTyped

    private void btnRemoverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoverActionPerformed
        //ir para a janela de remoção de disciplinas
        //fechar esta janela primeiro
        this.dispose();
        //criar a nova instancia da classe que contem a tabela de todas as disciplinas armazenadas no banco de dados
        //jogando o valor do atributo para o contrutor da classe abaixo
        frmRemocao janelaRemocao = new frmRemocao(this.disciplinaDAO);
        //tornar visível a tela de remocao de disciplinas para o usuario
        janelaRemocao.setVisible(true);
    }//GEN-LAST:event_btnRemoverActionPerformed

    private void btnLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimparActionPerformed
        //limpar o formulario, acredito que esteja bem intuitivo
        limparFormulario();
    }//GEN-LAST:event_btnLimparActionPerformed

    private void btnCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastrarActionPerformed
        //pegar o nome que o usuario digitou no formulario para fazer verificacoes
        String nome = this.txtNomeDisciplina.getText();
        //abrir uma janela para confirmar a acao do usuario
        if (JOptionPane.showConfirmDialog(rootPane, "Você tem certeza que deseja armazenar a disciplina "+nome+" no banco de dados ?", "Cuidado",
            JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
            //apos o usuario confirmar a acao, faremos uma busca rapida pelo banco, para ver se o nome desta disciplina ja se encontra no banco
            //fazendo isso a gente evita de haver registros com o mesmo nome de disciplina
            if(this.disciplinaDAO.buscaDisciplina(nome)!=null){
                //encontrado uma disciplina com esse nome, nao armazenaremos isso no banco
                //mostrar a mensagem de que ja existe esta disciplina no banco para o usuario
                JOptionPane.showConfirmDialog(rootPane, "Disciplina ja existe no banco!","Error",JOptionPane.WARNING_MESSAGE);
            } else{
                  //opa, nao existe esta disciplina no banco, sera armazenada
                  //metodo que faz o armazenamento da disciplina, so precisa do nome, detalhes se encontram explicados no metodo..
                  cadastrarDiscNoBanco(nome); 
                  //avisar para o usuario que a disciplina foi cadastrada com sucesso
                  JOptionPane.showMessageDialog(rootPane, "Disciplina cadastrada no banco!","Sucesso",JOptionPane.INFORMATION_MESSAGE);
                  //limpar o formulario para que o usuario possa adicionar outras disciplinas
                  limparFormulario();
              }          
        } else {
            //usuario nao quis completar a acao
            //mostrar aviso do por que nao foi feita a acao
            JOptionPane.showMessageDialog(rootPane, "Operação cancelada pelo usuário!","Error",JOptionPane.ERROR_MESSAGE);
         }
    }//GEN-LAST:event_btnCadastrarActionPerformed

    private void txtNomeDisciplinaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNomeDisciplinaKeyReleased
        //verificar os campos apos digitar algo neste componente 
        verificarCampos();
    }//GEN-LAST:event_txtNomeDisciplinaKeyReleased

    private void txtNomeCursoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNomeCursoKeyReleased
        //verificar os campos apos digitar algo neste componente 
        verificarCampos();
    }//GEN-LAST:event_txtNomeCursoKeyReleased

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        //perguntar para o usuario se quer realmente sair
        int reply = JOptionPane.showConfirmDialog(rootPane, "Quer realmente sair?", "Cuidado", JOptionPane.YES_NO_OPTION);
        if (reply == JOptionPane.YES_OPTION){
            //caso esta janela seja fechada, faremos a desconexao do banco
            //o metodo desconecta da classe DisciplinaDAO desconecta nosso programa do baco de dados 
            this.disciplinaDAO.desconecta();
            //para evitar algum problema inesperado anularemos o atributo
            this.disciplinaDAO = null;
            this.dispose();
        }
    }//GEN-LAST:event_formWindowClosing

    //ABAIXO SE ENCONTRAM OS METODOS UTILIZADOS ACIMA...
    
    private void limparFormulario() {
        //acredito estar bem intuitivo
        this.txtNomeCurso.setText("");
        this.txtNomeDisciplina.setText("");
        this.spnNumCarga.setValue(1);
        this.spnNumVagas.setValue(1);
        this.cboPeriodos.setSelectedItem(0);
        this.btnCadastrar.setEnabled(false);
        this.btnLimpar.setEnabled(false);
        this.btnRemover.setEnabled(true);
    }
    
    private void cadastrarDiscNoBanco(String nome) {
        //faremos uma varredura nos componentes, pegando todos os valores necessarios.
        int cargaHoraria = (int) this.spnNumCarga.getValue();
        String curso = this.txtNomeCurso.getText();
        int vagas = (int) this.spnNumVagas.getValue();
        String periodo = (String) this.cboPeriodos.getSelectedItem();
        //cria-se uma nova instancia da Classe de disciplina
        Disciplina novaDisciplina = new Disciplina(nome,cargaHoraria,curso,vagas,periodo);
        //utiliza essa instancia para ser armazenada no banco de dados
        //nosso atributo e' da classe DisciplinaDAO, essa classe e responsavel para fazer todas as operacoes em nosso banco
        //um dos metodos da classe DisciplinaDAO e' o insereDisciplina, que fara a insercao da disciplina no banco, esse metodo esta explicado na Classe
        this.disciplinaDAO.insereDisciplina(novaDisciplina);
    }


    private void verificarCampos(){
        //caso os dois campos de entrada de texto do formulario estejam vazios, os botoes serao impedidos de funcionar 
        if(!(this.txtNomeCurso.getText().isEmpty()) && !(this.txtNomeDisciplina.getText().isEmpty())){
            this.btnCadastrar.setEnabled(true);
            this.btnLimpar.setEnabled(true);
        } else{
              //caso contrario, serao disponibilizados para o usuario
              this.btnCadastrar.setEnabled(false);
              this.btnLimpar.setEnabled(false);
          }
    
    }
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
            java.util.logging.Logger.getLogger(frmCadastro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmCadastro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmCadastro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmCadastro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmCadastro().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCadastrar;
    private javax.swing.JButton btnLimpar;
    private javax.swing.JButton btnRemover;
    private javax.swing.JComboBox<String> cboPeriodos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JSpinner spnNumCarga;
    private javax.swing.JSpinner spnNumVagas;
    private javax.swing.JTextField txtNomeCurso;
    private javax.swing.JTextField txtNomeDisciplina;
    // End of variables declaration//GEN-END:variables
}
