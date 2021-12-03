package br.com.lucas.projetofinal;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import br.com.lucas.projetofinal.dao.PessoaDAO;
import br.com.lucas.projetofinal.modelo.Pessoa;

//******************************************************

//Instituto Federal de São Paulo - Campus Sertãozinho

//Disciplina......: M4DADM

//Programação de Computadores e Dispositivos Móveis

//Aluno...........: Lucas Bertoloto dos Santos

//******************************************************

public class ActivityListaRegistro extends AppCompatActivity {
    //tela para listar todos os registros que se encontram no banco de dados
    //List view, componente que ira listar todos os registros, colocando como atributo da classe facilita nosso trabalho
    private ListView listaPessoas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_registro);

        //pegando os componentes de maneira padrao
        listaPessoas = findViewById(R.id.lvPessoas);
        Button novaPessoa = findViewById(R.id.btNovaPessoa);

        //caso algum item (pessoa) seja clicado
        listaPessoas.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> Lista, View item, int position, long id) {
                //pegara a pessoa clicada
                Pessoa pessoa = (Pessoa) listaPessoas.getItemAtPosition(position);
                //jogara essa pessoa como uma informacao numa intencao para ir para a tela de inserir pessoa, como a intencao tem informacao, a pessoa sera atualizada
                Intent intentFormulario = new Intent(ActivityListaRegistro.this, ActivityInserirPessoa.class);
                intentFormulario.putExtra("pessoa",pessoa);
                startActivity(intentFormulario);
                finish();
            }
        });

        //botao de adicionar uma pessoa nova à lista foi clicado, ira para a tela de inserir pessoa com a intencao sem informacao, ou seja ira fazer o processo de insercao normalmente
        novaPessoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentFormulario = new Intent(ActivityListaRegistro.this, ActivityInserirPessoa.class);
                startActivity(intentFormulario);
            }
        });
        registerForContextMenu(listaPessoas);
    }

    private void carregaLista(){
        //metodo para criar a lista no list view
        PessoaDAO dao = new PessoaDAO(this);
        List<Pessoa> pessoas = dao.pegarTodasPessoas();
        dao.close();

        //adapter para jogar a lista com um texto modificado para ficar um pouco elegante
        ArrayAdapter<Pessoa> adapter = new ArrayAdapter<Pessoa>(ActivityListaRegistro.this, android.R.layout.simple_list_item_1, pessoas){
            @Override
            public View getView(int position, View convertView,ViewGroup parent) {
                TextView item = (TextView) super.getView(position, convertView, parent);

                //texto em negrito
                item.setTypeface(item.getTypeface(), Typeface.BOLD);

                //cor verde pro texto
                item.setTextColor(Color.parseColor("#ff669900"));

                //texto um pouco grande
                item.setTextSize(TypedValue.COMPLEX_UNIT_SP,20);

                return item;
            }
        };
        listaPessoas.setAdapter(adapter);
    }

    @Override
    protected void onResume(){
        //no ciclo de vida da activity quando entrar em onResume a lista sera atualizada
        super.onResume();
        carregaLista();
    }


    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, final ContextMenu.ContextMenuInfo menuInfo) {
        //context menu eh aquele menu que e aberto quando algo eh pressionado por um certo tmepo
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) menuInfo;
        final Pessoa pessoa = (Pessoa) listaPessoas.getItemAtPosition(info.position);

        //adicionando um item desse menu, sera o deletar para o usuario deletar um registro do banco
        MenuItem deletar = menu.add("Deletar");

        deletar.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {
                //usuario clicou em deletar, registro sera deletado
                PessoaDAO dao = new PessoaDAO(ActivityListaRegistro.this);
                dao.deletarPessoa(pessoa);
                dao.close();
                carregaLista();

                Toast.makeText(ActivityListaRegistro.this, "O " + pessoa.getNome() + " foi deletado do banco com sucesso!", Toast.LENGTH_SHORT).show();
                return false;
            }
        });
    }
}
