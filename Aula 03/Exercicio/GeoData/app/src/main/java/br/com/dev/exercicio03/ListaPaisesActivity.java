package br.com.dev.exercicio03;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import android.app.Activity;
import android.view.View;
import java.util.ArrayList;
import java.util.List;

public class ListaPaisesActivity extends AppCompatActivity {
    Activity atividade;
    private ListView listView;
    private ArrayList<Pais> paises;
    private ArrayList<String> nomes;
    private ArrayAdapter<String> adapter;
    public static final String PAIS = "pais";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_paises);
        atividade = this;

        Intent intent = getIntent();
        String continente = intent.getStringExtra(MainActivity.CONTINENTE);
        paises = Data.listarPaises(continente);
        nomes = Data.listarNomes(paises);

        ListView listView = (ListView) findViewById(R.id.listView);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, nomes);
        listView.setAdapter(adapter);
        adapter.notifyDataSetChanged();

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {

                // manda para a tela de detalhe
                Intent intent = new Intent(atividade, DetalhePaisActivity.class);
                intent.putExtra(PAIS, paises.get(position));

                startActivity(intent);

            }
        });
    }
}