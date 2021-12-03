/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import DAO.DisciplinaDAO;
import Modelo.Disciplina;
import java.awt.Toolkit;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Betao
 */
public class frmRemocao extends javax.swing.JFrame {
    //atributo da classe que se envolve com o banco 
    private DisciplinaDAO disciplinaDAO;

    /**
     * Creates new form frmRemocao
     */
    
    //novo construtor da classe, utilizado para atribuir valor ao unico atributo da classe que faz a comunicacao com o banco
    public frmRemocao(DisciplinaDAO dao) {
        initComponents();
        this.disciplinaDAO = dao;
        //colocar um icone da imagem do nosso querido instituto federal <3
        this.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagens/LogoIFSP.jpg")));
        //colocando todas as celulas alinhadas a direita
        DefaultTableCellRenderer renderer = (DefaultTableCellRenderer) this.tblDisciplinas.getDefaultRenderer(Object.class);
        renderer.setHorizontalAlignment( JLabel.RIGHT );
        //popular a tabela
        popularTabela(this.tblDisciplinas);
    }
    
    public frmRemocao() {
        initComponents();
    }

    //metodo para pegar a tabela que se encontra neste formulario, importante para o formulario de atualizacao da disciplina
    public JTable getTbl() {
        return this.tblDisciplinas;
    }
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblDisciplinas = new javax.swing.JTable();
        btnDeletar = new javax.swing.JButton();
        btnCadastrar = new javax.swing.JButton();
        btnAttTabela = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        btnEditLinha = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Remover disciplinas");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        tblDisciplinas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "idDisciplinas", "nome", "cargaHoraria", "curso", "vagas", "periodo"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblDisciplinas.setToolTipText("Tabela das disciplinas cadastradas no banco");
        tblDisciplinas.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        tblDisciplinas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblDisciplinasMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblDisciplinas);

        btnDeletar.setText("Deletar Linhas");
        btnDeletar.setToolTipText("Deletar uma ou mais linhas selecionadas da tabela");
        btnDeletar.setEnabled(false);
        btnDeletar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeletarActionPerformed(evt);
            }
        });

        btnCadastrar.setText("Cadastrar disciplinas");
        btnCadastrar.setToolTipText("Voltar para tela de cadastro de disciplinas");
        btnCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastrarActionPerformed(evt);
            }
        });

        btnAttTabela.setText("Atualizar tabela");
        btnAttTabela.setToolTipText("Atualizar a tabela com as informações contidas no banco de dados");
        btnAttTabela.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAttTabelaActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Tabela com todas as disciplinas registradas");

        btnEditLinha.setText("Editar Linha");
        btnEditLinha.setToolTipText("Editar um registro que esteja armazenado no banco de dados");
        btnEditLinha.setEnabled(false);
        btnEditLinha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditLinhaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 836, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnCadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnAttTabela, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnEditLinha, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnDeletar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 375, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnDeletar)
                    .addComponent(btnCadastrar)
                    .addComponent(btnAttTabela)
                    .addComponent(btnEditLinha))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnAttTabelaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAttTabelaActionPerformed
        //caso o botao de atualizar a tabela seja apertado, o metodo para atualizar a tabela sera acionado, so precisa informar para o metodo a tabela que sera atualizada
        atualizarTabela(this.tblDisciplinas);
        this.btnDeletar.setEnabled(false);
        this.btnEditLinha.setEnabled(false);
    }//GEN-LAST:event_btnAttTabelaActionPerformed

    private void btnDeletarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeletarActionPerformed
        //confirmar acao do usuario, as vezes ele pode nao querer deletar algo
        if(JOptionPane.showConfirmDialog(rootPane, "Você tem certeza que deseja remover as disciplina selecionas do banco de dados ?", "Cuidado",
            JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION){
            //deletar uma ou mais linhas selecionadas pelo usuario
            //primeiro pegaremos um array que indica os indices das linhas selecionadas na tabela
            int[] linhasSelecionadas = this.tblDisciplinas.getSelectedRows();
            //caso o array possua mais de um elemento, faremos : 
            if(linhasSelecionadas.length > 0) {
                //pegaremos o DefaultTableModel da tabela, pelo metodo getModel e fazendo o casta para DefaultTableModel
                DefaultTableModel dm = (DefaultTableModel) this.tblDisciplinas.getModel();
                //aqui percorreremos as linhas selecionadas da tabela do maior indice para o menor, assim quando remover uma linha selecionada nao ocasionara erros de logica
                for(int i = linhasSelecionadas.length - 1; i >= 0; i--) {
                    //a cada loop faremos:
                    //primeiro pegaremos o nome da disciplina que foi selecionada na tabela
                    String nome = (String) dm.getValueAt(linhasSelecionadas[i], 1);
                    //depois usaremos o metodo deletaDisciplina apenas colocando o nome da disciplina, para remover a disciplina do banco
                    this.disciplinaDAO.deletaDisciplina(nome);
                    //apos a remocao do banco, remover da tabela tambem
                    dm.removeRow(linhasSelecionadas[i]);
                }
                //removendo as linhas selecionadas, a tabela estara atualizada e o banco tambem  
            }
            this.btnDeletar.setEnabled(false);
        } else {
            //usuario nao quis completar a acao
            //mostrar aviso do por que nao foi feita a acao
            JOptionPane.showMessageDialog(rootPane, "Operação cancelada pelo usuário!","Error",JOptionPane.ERROR_MESSAGE);
         }   
        
    }//GEN-LAST:event_btnDeletarActionPerformed

    private void btnCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastrarActionPerformed
        //metodo para voltar a tela de armazenar disciplinas
        this.dispose();
    }//GEN-LAST:event_btnCadastrarActionPerformed

    private void tblDisciplinasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDisciplinasMouseClicked
        //metodo para verificar se existem linhas selecionadas na tabela, dependendo da situação um ou dois botoes serao habilitados ou nao, ou somente um 
        verificarLinhasSelecionadas(this.tblDisciplinas);
    }//GEN-LAST:event_tblDisciplinasMouseClicked

    private void btnEditLinhaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditLinhaActionPerformed
        //abrindo uma nova tela para editar o registro selecionado
        //usando o metodo pegarDisciplinaLinhaSelecionada e colocando o parametro a nossa tabela, pegaremos a disciplina da linha e colocaremos numa variavel
        Disciplina disciplina = pegarDisciplinaLinhaSelecionada(this.tblDisciplinas);
        //metodo de construcao da classe nessecita da disciplina,DisciplinaDAO e o frmRemocao para criar uma instancia, todos são necessarios, na classe é explicado o motivo
        frmAtualizacao telaAtualizacao = new frmAtualizacao(disciplina, disciplinaDAO, this);
        //não iremos fechar a janela, apenas iremos tirar sua visibilidade do usuario
        this.setVisible(false);
        //abrindo a janela de atualizacao do registro do banco
        telaAtualizacao.setVisible(true);
    }//GEN-LAST:event_btnEditLinhaActionPerformed

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        //caso a tela seja minimizada ou escondida, iremos atualizar os botoes dependendo da situacao das linhas da tabela
        verificarLinhasSelecionadas(this.tblDisciplinas);
    }//GEN-LAST:event_formWindowActivated

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        fecharJanela();
    }//GEN-LAST:event_formWindowClosed
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
            java.util.logging.Logger.getLogger(frmRemocao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmRemocao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmRemocao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmRemocao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmRemocao().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAttTabela;
    private javax.swing.JButton btnCadastrar;
    private javax.swing.JButton btnDeletar;
    private javax.swing.JButton btnEditLinha;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblDisciplinas;
    // End of variables declaration//GEN-END:variables

    //ABAIXO SE ENCONTRAM OS METODOS UTILIZADAS ACIMA...
    
    //metodo para inserir todas das disciplinas armazenadas no banco para a tabela que se encontra nesta tela 
    private void popularTabela(JTable tbl) {
        //utilizacao da classe List da biblioteca java.util para pegar todas as disciplinas no banco para essa lista
        //metodo buscaTodasDisciplinas da classe DisciplinaDAO retorna uma Lista de todas as disciplinas armazenadas no banco
        List<Disciplina> disciplinas = disciplinaDAO.buscaTodasDisciplinas();
        //caso a Lista retornada nao seja vazia, faremos a varredura por ela para adicionar linhas para a nossa tabela 
        if(!(disciplinas.isEmpty()))
        for(Disciplina d:disciplinas){
            //para cada disciplina da lista, armazenaremos seus valores nas variaveis temporarias
            int id = d.getIdDisciplina();
            String nome = d.getNome();
            int cargaHoraria = d.getCargaHoraria();
            String curso = d.getCurso();
            int vagas = d.getVagas();
            String periodo = d.getPeriodo();
            
            //com os variaveis, criaremos um array de object para representar uma linha da tabela
            Object[] linha = {id,nome,cargaHoraria,curso,vagas,periodo}; 
            
            //usando esse array adicionaremos a nova linha na nossa tabela
            ((DefaultTableModel) tbl.getModel()).addRow(linha);
        }
    }
  
    public void atualizarTabela(JTable tbl) {
        //o metodo eh bem simples, apenas remover todas as linhas da tabela e popular ela novamente
        removerTodasLinhasDaTabela(tbl);
        popularTabela(tbl);
    }

    private void fecharJanela() {
        //metodo para recriar a janela de inicio, a tela de cadastro de disciplinas
        frmCadastro telaCadastro = new frmCadastro(this.disciplinaDAO);
        telaCadastro.setVisible(true);
        //fechando de vez a tela de remoção de disciplinas
        this.dispose();
    }
    
    
    private void verificarLinhasSelecionadas(JTable tbl) {
        //metodo que retorna true caso haja, de alguma forma, alguma linha selecionada na tabela. Ou false caso não
        if(temLinhasSelecionadas(tbl)){
            //habilitar o botao de deletar, ja que existem um ou mais linhas para deletar
            this.btnDeletar.setEnabled(true);
            
            //metodo que retorna true caso haja apenas UMA linha selecionada na tabela, retorna false caso nao
            if(temSomenteUmaLinhasSelecionada(tbl)){
                //como existe apenas uma linha selecionada, podemos editá-la, ativando o botao de editar linha 
                this.btnEditLinha.setEnabled(true);
            } else{
                //como existem mais de uma linha selecionada, não podemos editá-las todas de uma vez, desativando o botao de editar linha
                this.btnEditLinha.setEnabled(false);
            }
            
        } else{
            //como nao ha NENHUMA linha selecionada, desativaremos nossos botoes
            this.btnDeletar.setEnabled(false);
            this.btnEditLinha.setEnabled(false);
        }
    }

    private boolean temLinhasSelecionadas(JTable tbl) {
        //pegaremos a quantidade de linhas selecionadas pelo usuario
        int qntLinhasSel = tbl.getSelectedRowCount();
        //retornara se existe alguma selecionada
        if(qntLinhasSel==0){
            return false;
        } else{
            return true;
        }
    }
    
    private boolean temSomenteUmaLinhasSelecionada(JTable tbl) {
        //metodo parecido com a de cima, neste caso se ha apenas uma selecionada retornara true
        int qntLinhasSel = tbl.getSelectedRowCount();
        if(qntLinhasSel==1){
            return true;
        } else{
            return false;
        }
    }

    private void removerTodasLinhasDaTabela(JTable tbl) {
        //metodo que limpa toda a tabela, removendo todas as linhas, repare que o banco de dados nao e afetado
        DefaultTableModel dm = (DefaultTableModel) tbl.getModel();
        //pegaremos a quantidade total de linhas
        int totalLinhas = dm.getRowCount();
        //se tiver linhas na tabela faremos:
        if(totalLinhas>0)
            for(int i=0; i<totalLinhas;i++)
                dm.removeRow(0);
                //para cada loop remover a primeira linha da tabela, sera feito isso pela quantidade de linhas que a tabela possui, resultando assim, numa tabela sem linhas
    }

    private Disciplina pegarDisciplinaLinhaSelecionada(JTable tbl) {
        //metodo que retorna a disciplina que esta selecionada na tabela
        Disciplina disciplina;
        
        //pegando todos os dados da linha selecionada :
        int linhaSelecionada = tbl.getSelectedRow();
        DefaultTableModel dm =(DefaultTableModel) tbl.getModel();
        int id = (int) dm.getValueAt(linhaSelecionada, 0);
        String nome = (String) dm.getValueAt(linhaSelecionada, 1);
        int cargaHoraria = (int) dm.getValueAt(linhaSelecionada, 2);
        String curso = (String) dm.getValueAt(linhaSelecionada, 3);
        int vagas = (int) dm.getValueAt(linhaSelecionada, 4);
        String periodo = (String) dm.getValueAt(linhaSelecionada, 5);
        
        
        //criando uma instancia da classe Disciplina, utilizando os dados coletados
        disciplina = new Disciplina(id,nome,cargaHoraria,curso,vagas,periodo);
        
        //retorna a disciplina adiquirida
        return disciplina;
    }
}
