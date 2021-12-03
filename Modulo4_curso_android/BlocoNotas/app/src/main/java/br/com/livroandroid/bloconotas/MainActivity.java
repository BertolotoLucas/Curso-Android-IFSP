package br.com.livroandroid.bloconotas;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText etTexto;
    Button btCriar;
    ListView listView;
    private ArrayList<String> notas = new ArrayList<String>();
    ArrayAdapter<String> adapter = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etTexto = findViewById(R.id.etTexto);
        btCriar = findViewById(R.id.btCriar);
        listView = findViewById(R.id.listView);

        adapter = new ArrayAdapter<String>(MainActivity.this,android.R.layout.simple_list_item_1, notas);
        listView.setAdapter(adapter);

        btCriar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String textoNota = etTexto.getText().toString();
                if(textoNota.length() > 0){
                    etTexto.setText("");
                    etTexto.findFocus();
                    notas.add(textoNota);
                    adapter.notifyDataSetChanged();
                }
            }
        });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(final AdapterView<?> adapterView, View view, int i, long l) {
                AlertDialog.Builder alert = new AlertDialog.Builder(MainActivity.this);
                alert.setTitle("Nota");
                alert.setMessage("Voce deseja apagar essa nota ? ");
                final int positionToRemove = i;
                alert.setNegativeButton("Não",null);
                alert.setPositiveButton("Sim", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        notas.remove(positionToRemove);
                        adapter.notifyDataSetChanged();
                    }
                });
                alert.show();
            }
        });

    }
}
