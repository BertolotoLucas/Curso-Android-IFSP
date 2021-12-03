/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author Lucas Bertoloto dos Santos
 */

//Nesta classe nao houve tanto misterio, aqui apenas fiz ficar praticamente igual a como se encontra a entidade no banco de dados
//e a entidade foi feita a partir do enunciado da questao
public class Disciplina {
    private int idDisciplina;
    private String nome;
    private int cargaHoraria;
    private String curso;
    private int vagas;
    private String periodo;

    //metodo de construcao da classe sem o id, foi muito usado no projeto
    public Disciplina(String nome, int cargaHoraria, String curso, int vagas, String periodo) {
        this.nome = nome;
        this.cargaHoraria = cargaHoraria;
        this.curso = curso;
        this.vagas = vagas;
        this.periodo = periodo;
    }

    //metodo de construcao da classe com o id, foi usado quando pegava disciplina do banco de dados
    public Disciplina(int idDisciplinas, String nome, int cargaHoraria, String curso, int vagas, String periodo) {
        this.idDisciplina = idDisciplinas;
        this.nome = nome;
        this.cargaHoraria = cargaHoraria;
        this.curso = curso;
        this.vagas = vagas;
        this.periodo = periodo;    }
    
    //getters e setters de todos os atributos
    public int getIdDisciplina() {
        return idDisciplina;
    }

    public void setIdDisciplina(int idDisciplina) {
        this.idDisciplina = idDisciplina;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getCargaHoraria() {
        return cargaHoraria;
    }

    public void setCargaHoraria(int cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public int getVagas() {
        return vagas;
    }

    public void setVagas(int vagas) {
        this.vagas = vagas;
    }

    public String getPeriodo() {
        return periodo;
    }

    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }
    
    //metodo toString da classe, apenas retornar o nome da disciplina esta otimo
    public String toString(){
       return this.nome;
    }
    
}
