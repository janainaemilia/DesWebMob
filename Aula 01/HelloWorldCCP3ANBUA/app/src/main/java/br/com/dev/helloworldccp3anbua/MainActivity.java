package br.com.dev.helloworldccp3anbua;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

/**
* @author Janaina Emilia RA 816114781
*/
public class MainActivity extends AppCompatActivity { //AppCompatActivity relacionado a retrocompatibilidade, para utilizar componentes destinado à tablet em versões anteriores a 3 do android studio

	/**
	* @author Janaina Emilia RA 816114781
	*/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // metodo  responsavel por "inflar a view", gerar a arvore a ser construida para o render da view
        setContentView(R.layout.activity_main); // R: classe publica gerada por padrão, que contem classes aninhadas (no caso, layout) e gera uma constante
    }
}
