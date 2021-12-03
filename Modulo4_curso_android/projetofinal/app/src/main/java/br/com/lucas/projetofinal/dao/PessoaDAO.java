package br.com.lucas.projetofinal.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.Nullable;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import br.com.lucas.projetofinal.modelo.Pessoa;

//******************************************************

//Instituto Federal de São Paulo - Campus Sertãozinho

//Disciplina......: M4DADM

//Programação de Computadores e Dispositivos Móveis

//Aluno...........: Lucas Bertoloto dos Santos

//******************************************************

public class PessoaDAO extends SQLiteOpenHelper {
    //Classe que ira ser a intermediadora entre a classe Pessoa e o banco de dados, podemos dizer que sera a classe que ira manejar as pessoas no banco
    private Context context;

    public PessoaDAO(Context context) {
        super(context, "Registro", null, 1);
        this.context = context;
    }

    @Override
    //metodo que todo o celular ira fazer para criar o banco do zero
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String sql = "CREATE TABLE Pessoas(id INTEGER PRIMARY KEY ASC, nome TEXT NOT NULL, cpf TEXT NOT NULL UNIQUE, idade INTEGER, telefone TEXT NOT NULL UNIQUE, email TEXT NOT NULL UNIQUE);";
        sqLiteDatabase.execSQL(sql);
    }

    @Override
    //banco nao foi modificado durante todo o projeto
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        //nenhuma mudança para o banco no momento
    }

    public List<Pessoa> pegarTodasPessoas(){
        //metodo que ira pegar todas as pessoas que se encontram na tabela Pessoas e retornar como uma List<Pessoa>
        List<Pessoa> pessoas = new ArrayList<Pessoa>();

        SQLiteDatabase readableDatabase = getReadableDatabase();

        String sql = "SELECT * FROM Pessoas;";

        Cursor cursor = readableDatabase.rawQuery(sql,null);
        while (cursor.moveToNext()) {
            Pessoa pessoa = new Pessoa();

            Long id = cursor.getLong(cursor.getColumnIndex("id"));
            String nome = cursor.getString(cursor.getColumnIndex("nome"));
            String cpf = cursor.getString(cursor.getColumnIndex("cpf"));
            int idade = cursor.getInt(cursor.getColumnIndex("idade"));
            String telefone = cursor.getString(cursor.getColumnIndex("telefone"));
            String email = cursor.getString(cursor.getColumnIndex("email"));

            pessoa.setId(id);
            pessoa.setNome(nome);
            pessoa.setCPF(cpf);
            pessoa.setIdade(idade);
            pessoa.setTelefone(telefone);
            pessoa.setEmail(email);

            pessoas.add(pessoa);
        }

        cursor.close();


        return pessoas;
    }

    public Pessoa pegarPessoa(Long id){
        //pegar uma pessoa atraves do seu id, o metodo acabou por nao ser usado no projeto
        SQLiteDatabase readableDatabase = getReadableDatabase();
        Pessoa pessoa = null;

        String[] param = {Long.toString(id)};
        String sql = "SELECT * FROM Pessoas WHERE id = "+id+" LIMIT 1;";

        Cursor cursor = readableDatabase.rawQuery(sql, param);
        if(cursor.moveToNext()) {
            pessoa = retornaUmRegistroPessoa(cursor);
            pessoa.setId(id);
        }

        cursor.close();

        return pessoa;
    }

    public void deletarPessoa(Pessoa pessoa) {
        //deletar uma pessoa do banco
        SQLiteDatabase writableDatabase = getWritableDatabase();
        String[] params = {pessoa.getId().toString()};
        writableDatabase.delete("Pessoas", "id =?", params);
    }

    public void alterarPessoa(Pessoa pessoa) {
        //alterar uma pessoa do banco
        SQLiteDatabase writableDatabase = getWritableDatabase();
        ContentValues dados = pegaDadosDaPessoa(pessoa);

        String[] params = {pessoa.getId().toString()};
        writableDatabase.update("Pessoas", dados, "id = ?", params);
    }

    public void inserirPessoa(Pessoa pessoa){
        //adicionar um novo registro de pessoa no banco
        SQLiteDatabase writableDatabase = getWritableDatabase();
        ContentValues dados = pegaDadosDaPessoa(pessoa);

        writableDatabase.insert("Pessoas", null, dados);
    }

    private ContentValues pegaDadosDaPessoa(Pessoa pessoa) {
        //metodo que retorna ContentValues, necessario para usar os metodos insert e update da classe SQLiteDatabase
        ContentValues dados = new ContentValues();

        //o ContentValues possui os valores para a tabela ser removida ou atualizada
        dados.put("nome",pessoa.getNome());
        dados.put("cpf",pessoa.getCPF());
        dados.put("idade",pessoa.getIdade());
        dados.put("telefone",pessoa.getTelefone());
        dados.put("email",pessoa.getEmail());

        return dados;
    }

    private Pessoa retornaUmRegistroPessoa(Cursor cursor) {
        //metodo para reduzir as linhas do metodo pegar uma pessoa, nao foi utilizado.
        String nome = cursor.getString(cursor.getColumnIndex("nome"));
        String cpf = cursor.getString(cursor.getColumnIndex("cpf"));
        int idade = cursor.getInt(cursor.getColumnIndex("idade"));
        String telefone = cursor.getString(cursor.getColumnIndex("telefone"));
        String email = cursor.getString(cursor.getColumnIndex("email"));

        return new Pessoa(nome,cpf,idade,telefone,email);
    }
}
