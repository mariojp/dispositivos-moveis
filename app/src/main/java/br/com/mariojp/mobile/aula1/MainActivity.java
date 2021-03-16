package br.com.mariojp.mobile.aula1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Usando o Log para exibir no Logcat o ciclo de vida da Activity
 *
 *
 *
 */
public class MainActivity extends AppCompatActivity {

    /**
     * onCreate()
     * Sua implementação é obrigatoria
     * É chamado pelo sistema para criar a Activity
     * A Activity é criada atravez dele e para ele é passado o estado (Bundle).
     * No método onCreate(), você executa a lógica básica de inicialização da Activity.
     * Isso deve acontecer somente uma vez durante todo o período que a Activity durar.
     * Boas praticas para sua implementação:
     * - vincular dados a listas
     * - associar a atividade a um ViewModel
     * - instanciar algumas variáveis com escopo de classe
     * Esse método recebe um parâmetro do tipo Bundle que contém o estado anteriormente salvo da Activity.
     * - Se a atividade nunca existiu, o valor do objeto Bundle será nulo.
     *
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("Tarefas");
        Log.d("Ciclo de Vida","Ciclo de Vida - onCreate");

        //List<String> tarefas = new ArrayList<>(Arrays.asList("DEVER DE CASA", "ASSITIR AULA", "TOMAR BANHO",
        //        "LER UM LIVRO"));
        // ListAdapter adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1 , tarefas);

        List<Tarefa> tarefas = new ArrayList<Tarefa>(
                Arrays.asList(
                        new Tarefa("DEVER DE CASA","DESCRICAO !", 1),
                        new Tarefa("ASSITIR AULA", "DESCRICAO !", 2),
                        new Tarefa( "TOMAR BANHO","DESCRICAO !",1),
                        new Tarefa("LER UM LIVRO", "DESCRICAO !", 3)
                )
                );

        ListView lista = findViewById(R.id.main_list_tarefas);
        ListAdapter adapter = new TarefaAdapter(this, tarefas);

        lista.setAdapter(adapter);


    }

    public void formulario(View view){
        Toast.makeText(this,"Vai para o form", Toast.LENGTH_SHORT).show();
    }

}