package com.example.lucas.appsomador;

import android.support.v7.app.AlertDialog;
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

        final EditText editNumero1 = findViewById(R.id.etNumero1);
        final EditText editNumero2 = findViewById(R.id.etNumero2);
        final EditText editResultado = findViewById(R.id.etResultado);

        Button btnSomar = findViewById(R.id.btSomar);
        btnSomar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Float soma = Float.parseFloat(editNumero1.getText().toString()) + Float.parseFloat(editNumero2.getText().toString());
                editResultado.setText(String.valueOf(soma));

                //AlertDialog.Builder alertDialog = new AlertDialog.Builder(MainActivity.this);
                //alertDialog.setMessage("Soma realizada com sucesso");
                //alertDialog.show();

                Toast.makeText(MainActivity.this,"Sucesso",Toast.LENGTH_LONG).show();
            }
        });
    }

}
