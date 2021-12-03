package br.com.lucas.projetofinal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

//******************************************************

//Instituto Federal de São Paulo - Campus Sertãozinho

//Disciplina......: M4DADM

//Programação de Computadores e Dispositivos Móveis

//Aluno...........: Lucas Bertoloto dos Santos

//******************************************************

public class MainActivity extends AppCompatActivity {
    //activity apenas para fazer a apresentacao do aplicativo, com um botao para ir à tela de inserir pessoa
    Button botaoInserirPessoa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        botaoInserirPessoa = findViewById(R.id.btInserirPessoa);

        botaoInserirPessoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(MainActivity.this, ActivityInserirPessoa.class);
                startActivity(intent);
                finish();
            }
        });

    }
}
