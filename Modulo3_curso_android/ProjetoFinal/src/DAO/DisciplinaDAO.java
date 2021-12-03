/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Banco.ConexaoMySQL;
import Modelo.Disciplina;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Lucas Bertoloto dos Santos
 */
public class DisciplinaDAO {
    //essa classe foi criada para a classe modelo Disciplina ser manejada sem dificuldades, nela faremos as atividades escenciais no banco (INSERT, DELETE, UPDATE e SELECT)
    //O unico atributo da classe, com ele sera possivel reconectar ao banco de dados
    private Connection conexao;
    
    public DisciplinaDAO(){
        //metodo de construcao da classe padrao, utilizando a classe ConexaoMySQL do professor, podemos armazenar a conexao no atributo desta classe
        this.conexao = new ConexaoMySQL().getConnection();   
    }
    
    public void desconecta(){
        try {
            //caso seja necessario desconectar do banco
            this.conexao.close();
            this.conexao = null;
        } catch (SQLException ex) {
            Logger.getLogger(DisciplinaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }    
    }
    
    public void conecta(){
        //caso precise conectar novamente ao banco
        this.conexao = new ConexaoMySQL().getConnection();  
    }
    
    public void atualizaConexao(){
        //reinicia a atualizacao da conexao com o banco, desconectando e conectando novamente
       desconecta();
       conecta();
    }
    
    public Disciplina buscaDisciplina(String n){
        try {
            //metodo que faz a busca no banco pelo nome da disciplina dada no parametro
            //verificacao se existe conexao com o banco
            if(!(this.conexao.isClosed()) && !(this.conexao.equals(null))){
                //comando sql que fara a busca pelo mysql
                String sql = "SELECT * FROM disciplinas WHERE nome = '"+n+"';";
                //procedimento padrao para realizar a busca
                PreparedStatement prepareStatement = this.conexao.prepareStatement(sql);
                ResultSet executeQuery = prepareStatement.executeQuery();
                
                //verificar se existe um resultado
                if(executeQuery.next()){
                    
                    //existe um resultado, pegaremos todos os valores da disciplina no banco:
                    int id = executeQuery.getInt("idDisciplinas");
                    String nome = executeQuery.getString("nome");
                    int cargaHoraria = executeQuery.getInt("cargaHoraria");
                    String curso = executeQuery.getString("curso");
                    int vagas = executeQuery.getInt("vagas");
                    String periodo = executeQuery.getString("periodo");
                    
                    //criaremos uma instancia de disciplina com esses dados e retornaremos o mesmo
                    Disciplina disciplinaEncontrada = new Disciplina(id,nome,cargaHoraria,curso,vagas,periodo);                    
                    return disciplinaEncontrada;

                }
                //procedimento padrao
                prepareStatement.close();
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(DisciplinaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public List<Disciplina> buscaTodasDisciplinas(){
        //metodo importantissimo para a tabela da tela de remocao de disciplinas, retorna uma lista com todas das disciplinas encontradas no banco
        //inicializa uma lista de Disciplina
        List<Disciplina> disciplinas = new ArrayList<>();
        try {
            //verificacao se existe conexao com o banco
            if(!(this.conexao.isClosed()) && !(this.conexao.equals(null))){
                //comando sql que seleciona todas as informacoes de disciplinas no banco de dados
                String sql = "SELECT * FROM disciplinas;";
                //procedimento padrao 
                PreparedStatement prepareStatement = this.conexao.prepareStatement(sql);
                ResultSet executeQuery = prepareStatement.executeQuery();
                
                //realizando um loop que percorrerá cada registo de disciplina encontrada 
                while(executeQuery.next()){
                
                    //existe um resultado, pegaremos todos os valores da disciplina no banco
                    int id = executeQuery.getInt("idDisciplinas");
                    String nome = executeQuery.getString("nome");
                    int cargaHoraria = executeQuery.getInt("cargaHoraria");
                    String curso = executeQuery.getString("curso");
                    int vagas = executeQuery.getInt("vagas");
                    String periodo = executeQuery.getString("periodo");
                    //criaremos uma instancia de disciplina com esses dados e a adicionaremos na nossa lista de disciplina
                    Disciplina novaDisciplina = new Disciplina(id,nome,cargaHoraria,curso,vagas,periodo);
                    disciplinas.add(novaDisciplina);
                    
                }
                //procedimento padrao
                prepareStatement.close();
                //retornar a lista encontrada, repare que ela pode ser uma Lista nula!
                return disciplinas;
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(DisciplinaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return disciplinas;
    }
    
    public void insereDisciplina(Disciplina disciplina){       
        //metodo para inserir uma nova disciplina no banco de dados
        try {
            //verificacao se existe conexao com o banco
            if(!(this.conexao.isClosed()) && !(this.conexao.equals(null))){
                //pegando os dados da disciplina dada no parametro
                String nome = disciplina.getNome();
                int cargaHoraria = disciplina.getCargaHoraria();
                String curso = disciplina.getCurso();
                int vagas = disciplina.getVagas();
                String periodo = disciplina.getPeriodo();
                
                //sql que vai inserir uma nova tupla no banco de dados
                String sql = "INSERT INTO disciplinas(nome,cargaHoraria,curso,vagas,periodo)"
                        + "   VALUES ('"+nome+"', "+cargaHoraria+", '"+curso+"', "+vagas+", '"+periodo+"') ;";
                //procedimento padrao
                PreparedStatement prepareStatement = this.conexao.prepareStatement(sql);
                prepareStatement.executeUpdate(sql);
                prepareStatement.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(DisciplinaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void deletaDisciplina(Disciplina disciplina){ 
        //metodo para deletar uma disciplina do banco, tendo como parametro uma instancia de Disciplina
        try {
            //verificacao se existe conexao com o banco
            if(!(this.conexao.isClosed()) && !(this.conexao.equals(null))){
                //pega o nome da disciplina para o sql
                String nome = disciplina.getNome();
                
                //sql para deletar uma tupla que contenha o nome da disciplina dada, nao fiz a verificacao se existe uma disciplina com esse nome
                //pois o programa foi feito para apenas deletar uma disciplina selecionada!!
                String sql = "DELETE FROM disciplinas WHERE nome = '"+nome+"' ;";
                //procedimento padrao
                PreparedStatement prepareStatement = this.conexao.prepareStatement(sql);
                prepareStatement.executeUpdate(sql);
                prepareStatement.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(DisciplinaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void deletaDisciplina(String nome){
        //metodo para deletar uma disciplina do banco, tendo como parametro o nome da disciplina, outro metodo com outro parametro so para auxiliar o desenvolvedor <3
        try {
            //verificacao se existe conexao com o banco
            if(!(this.conexao.isClosed()) && !(this.conexao.equals(null))){
                //sql para deletar uma tupla que contenha o nome da disciplina dada, nao fiz a verificacao se existe uma disciplina com esse nome
                //pois o programa foi feito para apenas deletar uma disciplina selecionada!!
                String sql = "DELETE FROM disciplinas WHERE nome = '"+nome+"' ;";
                //procedimento padrao
                PreparedStatement prepareStatement = this.conexao.prepareStatement(sql);
                prepareStatement.executeUpdate(sql);
                prepareStatement.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(DisciplinaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void atualizaDisciplina(Disciplina disciplina) {
        //metodo para atualizar uma disciplina do banco, tendo como parametro uma disciplina
        try {
            //verificacao se existe conexao com o banco
            if(!(this.conexao.isClosed()) && !(this.conexao.equals(null))){
                //pegando os dados da disciplina dada
                int id = disciplina.getIdDisciplina();
                String nome = disciplina.getNome();
                int cargaHoraria = disciplina.getCargaHoraria();
                String curso = disciplina.getCurso();
                int vagas = disciplina.getVagas();
                String periodo = disciplina.getPeriodo();
                
                //sql para fazer a atualizacao da disciplina no banco
                //nao fiz a verificacao se existe uma disciplina com esse nome pelo mesmo motivo do metodo acima
                String sql = "UPDATE disciplinas SET nome = '"+nome+"', cargaHoraria = "+cargaHoraria+", curso = '"+curso+"',"
                        + " vagas = "+vagas+", periodo = '"+periodo+"' WHERE idDisciplinas ="+id+";";
                //procedimento padrao
                PreparedStatement prepareStatement = this.conexao.prepareStatement(sql);
                prepareStatement.executeUpdate(sql);
                prepareStatement.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(DisciplinaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
