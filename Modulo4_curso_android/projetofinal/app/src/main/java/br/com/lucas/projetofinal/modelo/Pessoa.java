package br.com.lucas.projetofinal.modelo;

import java.io.Serializable;

//******************************************************

//Instituto Federal de São Paulo - Campus Sertãozinho

//Disciplina......: M4DADM

//Programação de Computadores e Dispositivos Móveis

//Aluno...........: Lucas Bertoloto dos Santos

//******************************************************

public class Pessoa implements Serializable {
    //pessoa eh a classe chave da aplicacao, necessaria para o funcionamento adequado do programa, o toString eh muito importante para o Adapter para a ListView
    private Long id;
    private String nome;
    private String CPF;
    private int idade;
    private String telefone;
    private String email;

    public Pessoa(){

    }

    public Pessoa(String nome, String CPF, int idade, String telefone, String email) {
        this.nome = nome;
        this.CPF = CPF;
        this.idade = idade;
        this.telefone = telefone;
        this.email = email;
    }

    public Pessoa(Long id, String nome, String CPF, int idade, String telefone, String email) {
        this.id = id;
        this.nome = nome;
        this.CPF = CPF;
        this.idade = idade;
        this.telefone = telefone;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String imprimirCPFPadrao(String cpf){
        String cpfPadrao = "";

        for(int i=0;i<3;i++){
            cpfPadrao += cpf.charAt(i);
        }
        cpfPadrao+='.';
        for(int i=3; i<6;i++){
            cpfPadrao += cpf.charAt(i);
        }
        cpfPadrao+='.';
        for(int i=6; i<9;i++){
            cpfPadrao += cpf.charAt(i);
        }
        cpfPadrao+='-';
        for(int i=9; i<11;i++){
            cpfPadrao += cpf.charAt(i);
        }

        return cpfPadrao;
    }

    public String toString(){
        return "Pessoa id "+getId()+": \n"+getNome()+" \nCPF: "+imprimirCPFPadrao(getCPF())+"\nE-mail: "+ getEmail();
    }
}
