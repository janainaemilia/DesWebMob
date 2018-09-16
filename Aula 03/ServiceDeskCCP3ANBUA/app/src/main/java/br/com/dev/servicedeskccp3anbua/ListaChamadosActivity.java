package br.com.dev.servicedeskccp3anbua;

import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class ListaChamadosActivity extends AppCompatActivity {

    private ListView listView;
    private List<String> chamados;
    private ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_chamados);

        listView = (ListView) findViewById(R.id.listView);
        chamados = new ArrayList<>();

        //vinculo entre o view a model, no caso a ListView com o ArrayList
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, chamados);

        //Setando na listView quem ta provendo os dados
        listView.setAdapter(adapter);
        Intent intent = getIntent();
        String valor = intent.getStringExtra(MainActivity.NOME_FILA); //constante de classe MainActivity.NOME_FILA

        chamados.addAll(buscaChamados(valor));
        adapter.notifyDataSetChanged();

        //Registrando ouvinte em cada item da lista
        ListView.OnItemClickListener itemClickListener =
                (adapterView, view, position, id) -> {
                    String touchedItem = chamados.get(position);
                    Toast.makeText(ListaChamadosActivity.this, touchedItem, Toast.LENGTH_LONG).show();
                };

        //List view ira reagir ao evento com o setOnItemClickListener
        listView.setOnItemClickListener(itemClickListener);
    }

    public ArrayList<String> geraListaChamados(){
        ArrayList<String> lista = new ArrayList<>();
        lista.add("Desktops: Computador da secretária quebrado.");
        lista.add("Telefonia: Telefone não funciona.");
        lista.add("Redes: Manutenção no proxy.");
        lista.add("Servidores: Lentidão generalizada.");
        lista.add("Novos Projetos: CRM");
        lista.add("Manutenção Sistema ERP: atualizar versão.");
        lista.add("Novos Projetos: Rede MPLS");
        lista.add("Manutenção Sistema de Vendas: incluir pipeline.");
        lista.add("Manutenção Sistema ERP: erro contábil");
        lista.add("Novos Projetos: Gestão de Orçamento");
        lista.add("Novos Projetos: Big Data");
        lista.add("Manoel de Barros");
        lista.add("Redes: Internet com lentidão");
        lista.add("Novos Projetos: Chatbot");
        lista.add("Desktops: troca de senha");
        lista.add("Desktops: falha no Windows");
        lista.add("Novos Projetos: ITIL V3");
        lista.add("Telefonia: liberar celular");
        lista.add("Telefonia: mover ramal");
        lista.add("Redes: ponto com defeito");
        lista.add("Novos Projetos: ferramenta EMM");
        return lista;
    }

    public ArrayList<String> buscaChamados(String chave){
        ArrayList<String> lista = geraListaChamados();
        if (chave == null || chave.length() == 0){
            return lista;
        }

        ArrayList<String> subLista = new ArrayList<>();
        for(String nome:lista){
            if(nome.toUpperCase().contains(chave.toUpperCase())){
                subLista.add(nome);
            }
        }
        return subLista;
    }
}
