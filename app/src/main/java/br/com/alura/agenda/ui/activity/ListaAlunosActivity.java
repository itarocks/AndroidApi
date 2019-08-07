 package br.com.alura.agenda.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import br.com.alura.agenda.R;
import br.com.alura.agenda.dao.AlunoDAO;

//AppCompatActivity é uma boa pratica dentro do Android
public class ListaAlunosActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        TextView aluno = new TextView(this);
        aluno.setText("Itamar Rocha");
        //Classe R faz o mapeamento de todos os recursos do projeto
        setContentView(R.layout.activity_lista_alunos);
        setTitle("Lista de Alunos");
        FloatingActionButton botaoNovoAluno = findViewById(R.id.activity_lista_alunos_fab_novo_aluno);
        botaoNovoAluno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ListaAlunosActivity.this,formularioAlunoActivity.class));
            }
        });


    }

    @Override
    protected void onResume() {
        super.onResume();
        AlunoDAO dao = new AlunoDAO();
        ListView listaDeAlunos = findViewById(R.id.activity_lista_alunos_listview);
        listaDeAlunos.setAdapter(new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,dao.todos()));
    }

    public static List<String> listAluno(){
        List<String> alunos = new ArrayList<>();
        alunos.add("Henrique");
        alunos.add("Pedro");
        alunos.add("Jose");
        return alunos;
    }
}
