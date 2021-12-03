package br.com.livroandroid.lojadelivros;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;

public class MainActivity extends AppCompatActivity {
    CheckBox cbCSharp, cbAndroid, cbJava;
    Button btComprar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btComprar = findViewById(R.id.btComprar);
        cbCSharp = findViewById(R.id.cbCSharp);
        cbAndroid = findViewById(R.id.cbAndroid);
        cbJava = findViewById(R.id.cbJava);

        btComprar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String mensagem;
                if(!cbJava.isChecked() && !cbCSharp.isChecked() && !cbAndroid.isChecked()){
                    mensagem = "Você nao comprou livro algum!";
                    AlertDialog.Builder alertDialog = new AlertDialog.Builder(MainActivity.this);
                    alertDialog.setMessage(mensagem);
                    alertDialog.show();

                } else {
                    mensagem = "Você comprou os seguintes livros : \n\n";

                    if(cbCSharp.isChecked()){
                        mensagem += cbCSharp.getText()+"\n";
                    }

                    if(cbAndroid.isChecked()){
                        mensagem += cbAndroid.getText()+"\n";
                    }

                    if(cbJava.isChecked()){
                        mensagem += cbJava.getText()+"\n";
                    }

                    AlertDialog.Builder alertDialog = new AlertDialog.Builder(MainActivity.this);
                    alertDialog.setMessage(mensagem);
                    alertDialog.show();
                }

            }
        });
    }
}
