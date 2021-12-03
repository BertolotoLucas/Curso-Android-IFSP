/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Banco;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Lucas Bertoloto dos Santos
 */
//Início da classe de conexão//
public class ConexaoMySQL {
    //classe dada pelo professor, estou a utilizando
    private static ConexaoMySQL instance = null;
    private Connection connection = null;  

    public ConexaoMySQL() {
        try {
            //tive que mudar o driver por causa da versao..
            String driverName = "com.mysql.cj.jdbc.Driver";
            Class.forName(driverName);           
            String serverName = "127.0.0.1";               
            //nesta linha estar� o nome do seu banco de dados. Olhe no workbench
            //o nome do banco. Caso voce tenha criado o modelo no workbench e n�o
            //tenha modificado o nome do banco, o nome padr�o � "mydb". 
            String dbName = "db" ;        
            String url = "jdbc:mysql://" + 
                    serverName + "/" + 
                    dbName+"?useTimezone=true&serverTimezone=UTC";   //colocado isso por que o banco de dados mysql apresentou erros de regiao, fazendo isso solucionei o problema         
            //ajuste o username e password de acordo com o que voce utiliza para 
            //acessar o banco
            String username = "root";             
            String password = "vermelho";      
            
            try {
                connection = DriverManager.getConnection(url,username, password);
            } catch (SQLException ex) {
                Logger.getLogger(ConexaoMySQL.class.getName()).log(Level.SEVERE, null, ex);
            }
              
            if (connection != null) {
                System.out.println("STATUS--->Conectado "
                        + "com sucesso!");
            } else {
                System.err.println("STATUS--->Não foi "
                        + "possivel realizar conexão");
            }
            connection.setAutoCommit(true);
        } catch (ClassNotFoundException e) {  
            
            System.out.println("O driver expecificado"
                    + " nao foi encontrado.");
        } catch (SQLException e) {
            
            System.out.println("Nao foi possivel"
                    + " conectar ao Banco de Dados.");
            e.printStackTrace();
        }
    }

    public static ConexaoMySQL getInstance() {
        if (instance == null) {
            instance = new ConexaoMySQL();
        }
        return instance;
    }

    public java.sql.Connection getConnection() {
        return connection;
    }
}
