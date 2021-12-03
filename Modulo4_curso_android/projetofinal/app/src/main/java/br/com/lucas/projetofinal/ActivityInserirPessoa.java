package br.com.lucas.projetofinal;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import br.com.lucas.projetofinal.dao.PessoaDAO;
import br.com.lucas.projetofinal.modelo.Pessoa;
//******************************************************

//Instituto Federal de São Paulo - Campus Sertãozinho

//Disciplina......: M4DADM

//Programação de Computadores e Dispositivos Móveis

//Aluno...........: Lucas Bertoloto dos Santos

//******************************************************

public class ActivityInserirPessoa extends AppCompatActivity {
    //activity para inserir pessoas no banco, basta apenas inserir as informações corretamente nos EditTexts
    private Pessoa pessoaDeFora; //atributo importante para poder fazer a alteração de uma Pessoa no banco, a pessoa de fora vira da ActivityListaRegistro, motivo pelo qual a classe Pessoa implementou o Serializable

    //todos os campos da nossa Activity
    EditText etNome;
    EditText etCPF;
    EditText etIdade;
    EditText etTelefone;
    EditText etEmail;

    Button btInserir;
    Button btListar;
    Button btVoltar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inserir_pessoa);

        //padrao, pegar todos os campos pelo findViewById()
        etNome = findViewById(R.id.etNome);
        etCPF = findViewById(R.id.etCPF);
        etIdade = findViewById(R.id.etIdade);
        etTelefone = findViewById(R.id.etTelefone);
        etEmail = findViewById(R.id.etEmail);

        btInserir = findViewById(R.id.btInserirDados);
        btListar = findViewById(R.id.btListarRegistros);
        btVoltar = findViewById(R.id.btVoltar);

        //Pegar a intencao que fez abrir essa activity, caso a intencao tenha alguma informação significa que é para alterar um registro e nao adicionar um novo
        final Intent intent = getIntent();
        pessoaDeFora = (Pessoa) intent.getSerializableExtra("pessoa");

        if(pessoaDeFora!=null){
            //intencao veio com a pessoa a ser alterada, as informações dela sera colocada nos campos corretamente
            preecherFormulario(pessoaDeFora);
        }

        btInserir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //colocando todas as informacoes em variaveis para facilitar o processo
                String nome = etNome.getText().toString();
                String CPF = etCPF.getText().toString();
                String idade = etIdade.getText().toString();
                String telefone = etTelefone.getText().toString();
                String email = etEmail.getText().toString();

                //primeiro faco verificacoes se algum campo esta vazio, nenhum campo pode estar vazio
                if(nome.isEmpty()){
                    Toast.makeText(ActivityInserirPessoa.this, "O campo nome precisa ser preenchido!",Toast.LENGTH_SHORT).show();
                } else {
                        if(CPF.isEmpty()){
                            Toast.makeText(ActivityInserirPessoa.this, "O campo CPF precisa ser preenchido!",Toast.LENGTH_SHORT).show();
                        } else {
                              if(idade.isEmpty()){
                                  Toast.makeText(ActivityInserirPessoa.this, "O campo idade precisa ser preenchido!",Toast.LENGTH_SHORT).show();
                              }  else {
                                     if(telefone.isEmpty()){
                                         Toast.makeText(ActivityInserirPessoa.this, "O campo telefone precisa ser preenchido!",Toast.LENGTH_SHORT).show();
                                     } else{
                                           if(email.isEmpty()){
                                               Toast.makeText(ActivityInserirPessoa.this, "O campo email precisa ser preenchido!",Toast.LENGTH_SHORT).show();
                                           }  else{
                                                  //todos os campos estao Ok, agora faremos a validacao dos campos CPF, telefone e Email, se todos estiverem corretos seguiremos
                                                  if(validaCPF(CPF,ActivityInserirPessoa.this) && validaTelefone(telefone,ActivityInserirPessoa.this)
                                                          && validaEmail(email,ActivityInserirPessoa.this)) {

                                                      //PessoaDAO é uma classe que se comunica com o banco de dados que possui a tabela Pessoas
                                                      PessoaDAO dao = new PessoaDAO(ActivityInserirPessoa.this);
                                                      Pessoa pessoa = new Pessoa(nome, CPF, Integer.valueOf(idade), telefone, email);

                                                      //como a intencao nao teve informacao, adicionaremos um novo registro de pessoa na tabela Pessoas
                                                      if(pessoaDeFora==null){
                                                          dao.inserirPessoa(pessoa);
                                                          dao.close();
                                                          limparCampos();
                                                          etNome.setFocusable(true);
                                                          Toast.makeText(ActivityInserirPessoa.this, "Pessoa salva no banco com sucesso!",Toast.LENGTH_SHORT).show();

                                                      }  else{
                                                              //veio informacao na intencao, entao iremos atualizar um registro da tabela Pessoas
                                                              //a intencao vem com a id da pessoa, o que facilita bastante
                                                              pessoa.setId(pessoaDeFora.getId());
                                                              dao.alterarPessoa(pessoa);
                                                              pessoaDeFora = null;

                                                              dao.close();
                                                              Toast.makeText(ActivityInserirPessoa.this, "Pessoa alterada no banco com sucesso!",Toast.LENGTH_SHORT).show();

                                                              //voltar para a lista de registro
                                                              Intent intentLista = new Intent();
                                                              intentLista.setClass(ActivityInserirPessoa.this,ActivityListaRegistro.class);
                                                              startActivity(intentLista);
                                                              finish();
                                                      }
                                                  }
                                              }
                                       }
                                 }
                          }
                  }

            }
        });

        btListar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //botao ao ser clicado ira para Lista de registros
                Intent intent = new Intent();
                intent.setClass(ActivityInserirPessoa.this, ActivityListaRegistro.class);
                startActivity(intent);
            }
        });

        btVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //botao ao ser clicado ira para a tela principal novamente
                Intent intent = new Intent();
                intent.setClass(ActivityInserirPessoa.this,MainActivity.class);

                startActivity(intent);
                finish();
            }
        });

    }

    private void preecherFormulario(Pessoa pessoa) {
        //preenche o formulario com os dados da pessoa no parametro
        etNome.setText(pessoa.getNome());
        etCPF.setText(pessoa.getCPF());
        etIdade.setText(Integer.toString(pessoa.getIdade()));
        etTelefone.setText(pessoa.getTelefone());
        etEmail.setText(pessoa.getEmail());
    }

    private void limparCampos() {
        //deixa todos os campos do formulario como vazio
        etNome.setText("");
        etCPF.setText("");
        etEmail.setText("");
        etIdade.setText("");
        etTelefone.setText("");
    }

    private boolean validaCPF(String CPF, Context context) {
        //baseado na explicacao desse site https://laennder.com/como-e-feito-o-calculo-de-validacao-cpf/
        //para saber como validar

        //cpf tem que ter exatamente 11 digitos
        if(CPF.length() != 11){
            AlertDialog.Builder alertDialog = new AlertDialog.Builder(context);
            alertDialog.setMessage("CPF inválido, não há 11 digitos!");
            alertDialog.show();
            return false;
        }

        //cpf nao pode ter todos os digitos iguais
        if (CPF.equals("00000000000") || CPF.equals("11111111111") || CPF.equals("22222222222") || CPF.equals("33333333333")
                || CPF.equals("44444444444") || CPF.equals("55555555555") || CPF.equals("66666666666")
                || CPF.equals("77777777777") || CPF.equals("88888888888") || CPF.equals("99999999999")){

            AlertDialog.Builder alertDialog = new AlertDialog.Builder(context);
            alertDialog.setMessage("CPF inválido, todos os digitos são iguais!");
            alertDialog.show();
            return false;
        }
        //criando um array de inteiros para o cpf:
        int CPFINT[] = new int[11];
        for(int x=0; x<=10; x++){
            CPFINT[x] = Character.getNumericValue(CPF.charAt(x));
        }

        //validando o primeiro digito verificador, deve-se multiplicar os nove primeiros numeros por um peso, o peso é reduzido em um para cada digito, com o peso tendo valor inicial 10
        //apos a multiplicacao deve-se somar o valor de todos, o resultado dessa soma sera dividido por 11, o resto desta divisao (quociente) sera utilizado para subtrair de 11
        //11-x, se o valor for maior que 9 o digito deve ser 0, se nao o resultado deve ser o valor do primeiro digito de verificacao

        int soma = 0;
        int pos = 0;

        for(int peso = 10; peso>=2; peso--){
            soma += CPFINT[pos] * peso;
            pos++;
        }

        int quociente = soma % 11;
        int digDesejado = 11 - quociente;

        if(digDesejado > 9){
            digDesejado = 0;
        }

        if(CPFINT[9] != digDesejado){
            AlertDialog.Builder alertDialog = new AlertDialog.Builder(context);
            alertDialog.setMessage("CPF inválido!");
            alertDialog.show();
            return false;
        }

        //primeiro digito foi verificado, vamos verificar o segundo digito verificador
        //eh parecido, apenas deve ser adicionado o numero do primeiro digito verificador

        soma = 0;
        pos = 0;

        for(int peso = 11; peso>=2; peso--){
            soma += CPFINT[pos] * peso;
            pos++;
        }

        quociente = soma % 11;
        digDesejado = 11 - quociente;

        if(digDesejado > 9){
            digDesejado = 0;
        }

        if(CPFINT[10] != digDesejado){
            AlertDialog.Builder alertDialog = new AlertDialog.Builder(context);
            alertDialog.setMessage("CPF inválido!");
            alertDialog.show();
            return false;
        }

        //CPF VALIDO
        return true;
    }

    private boolean validaTelefone(String telefone, Context context) {
        //usando regex coloquei o padrao de telefone ou celular com o ddd na frente: 021xxxxxxxxx
        if(telefone.matches("[0]{1}[1-9]{2}[0-9]{8,9}")){
            return true;
        }

        AlertDialog.Builder alertDialog = new AlertDialog.Builder(context);
        alertDialog.setMessage("Telefone inválido!");
        alertDialog.show();
        return false;
    }

    private boolean validaEmail(String email, Context context) {
        //usando regex novamente para validar o email, um possivel email para essa validacao : email@email.com
        String EMAIL_PATTERN ="^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
        Pattern pattern = Pattern.compile(EMAIL_PATTERN, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(email);

        if(matcher.matches()){
            return true;
        }

        AlertDialog.Builder alertDialog = new AlertDialog.Builder(context);
        alertDialog.setMessage("E-mail inválido!");
        alertDialog.show();
        return false;
    }
}
