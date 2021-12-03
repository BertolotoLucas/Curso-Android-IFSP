package br.com.livroandroid.helloandroidstudio;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText tvUsuario = findViewById(R.id.etLogin);
        final EditText tvSenha = findViewById(R.id.etSenha);
        Button btLogin = findViewById(R.id.btLogin);

        btLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String usuario = tvUsuario.getText().toString();
                String senha = tvSenha.getText().toString();

                if(usuario.equals("ricardo") && senha.equals("123")){
                    Toast.makeText(MainActivity.this,"Bem vindo, login realizado com sucesso",Toast.LENGTH_SHORT).show();
                }  else {
                        Toast.makeText(MainActivity.this,"Erro, login nao foi realizado com sucesso",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
