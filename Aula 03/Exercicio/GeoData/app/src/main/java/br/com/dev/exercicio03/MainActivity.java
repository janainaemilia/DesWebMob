package br.com.dev.exercicio03;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {

    private Spinner continentes_spinner;
    public static final String CONTINENTE = "continente";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        continentes_spinner = (Spinner) findViewById(R.id.continentes_spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.continentes, android.R.layout.simple_spinner_item);

        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // Apply the adapter to the spinner
        continentes_spinner.setAdapter(adapter);

        //buscaFilaEditText = (EditText) findViewById(R.id.buscaFilaEditText); //buscando elemento apos a arvore ser construida
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);

        //Expressão lambda em Java somente a partir da versão 8
        fab.setOnClickListener((v) -> {
            //Ações a serem executadas apos o event onClick ser disparado
            Intent intent = new Intent(this, ListaPaisesActivity.class);
            String texto = continentes_spinner.getDisplay().toString();
            intent.putExtra(CONTINENTE, texto);
            startActivity(intent);
        });
    }
}