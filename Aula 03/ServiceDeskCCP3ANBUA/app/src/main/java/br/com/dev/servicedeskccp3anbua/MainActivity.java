package br.com.dev.servicedeskccp3anbua;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText buscaFilaEditText;
    public static final String NOME_FILA = "nome_fila";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        buscaFilaEditText = (EditText) findViewById(R.id.buscaFilaEditText); //buscando elemento apos a arvore ser construida
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);

        // Configurando um observer onclick para o fab (FloatingActionButton)
        /*fab.setOnClickListener(new View.OnClickListener() { //classe interna anonima, começando em {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });*/

        //Expressao lambda em Java para fazer exatamente o que o codigo da linha 23-29 esta fazendo
        //Expressão lambda em Java somente a partir da versão 8
        fab.setOnClickListener((v) -> {
            //Ações a serem executadas apos o event onClick ser disparado
            Intent intent = new Intent(this, ListaChamadosActivity.class);
            String texto = buscaFilaEditText.getEditableText().toString();
            intent.putExtra(NOME_FILA, texto);
            startActivity(intent);
        });
    }
}
