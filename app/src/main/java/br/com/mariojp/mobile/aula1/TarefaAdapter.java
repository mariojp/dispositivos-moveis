package br.com.mariojp.mobile.aula1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class TarefaAdapter extends BaseAdapter {

    private List<Tarefa> lista;
    private Context contexto;

    public TarefaAdapter(Context contexto, List<Tarefa> tarefas){
        this.contexto = contexto;
        this.lista = tarefas;
    }

    @Override
    public int getCount() {
        return lista.size();
    }

    @Override
    public Tarefa getItem(int posicao) {
        return lista.get(posicao);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int posicao, View view, ViewGroup parent) {

        if(view == null ) {
            view = LayoutInflater.from(contexto).inflate(R.layout.tarefa_list_item, parent, false);
        }
        TextView titulo = view.findViewById(R.id.list_tarefa_titulo);
        TextView descricao = view.findViewById(R.id.list_tarefa_descricao);
        TextView prioridade = view.findViewById(R.id.list_tarefa_prioridade);

        Tarefa tarefa = getItem(posicao);
        titulo.setText(tarefa.getTitulo());
        descricao.setText(tarefa.getDescricao());
        prioridade.setText(tarefa.getPrioridade()+"");

        return view;
    }
}
