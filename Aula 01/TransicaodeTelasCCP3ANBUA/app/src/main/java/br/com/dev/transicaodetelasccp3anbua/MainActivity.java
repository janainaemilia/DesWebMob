package br.com.dev.transicaodetelasccp3anbua;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText mensagemEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mensagemEditText = findViewById(R.id.mensagemEditText);
    }

    public void enviarMensagem(View view){
        String mensagem = mensagemEditText.getEditableText().toString();
        Toast.makeText(this, mensagem, Toast.LENGTH_LONG).show();
    }
}
