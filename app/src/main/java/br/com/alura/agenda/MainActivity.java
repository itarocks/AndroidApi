package br.com.alura.agenda;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       // Toast.makeText(this, "Itamar Rocha", Toast.LENGTH_LONG).show();
        TextView aluno = new TextView(this);
        aluno.setText("Itamar Rocha");
        //Classe R faz o mapeamento de todos os recursos do projeto
        setContentView(R.layout.activity_main);
        List<String> alunos = listAluno();
//        TextView primeiroAluno = findViewById(R.id.textView);
//        TextView segundoAluno = findViewById(R.id.textView2);
//        TextView terceiroAluno = findViewById(R.id.textView3);
//        primeiroAluno.setText(alunos.get(0));
//        segundoAluno.setText(alunos.get(1));
//        terceiroAluno.setText(alunos.get(2));

        ListView listaDeAlunos = findViewById(R.id.activity_main_list_Alunos);
        //Adapter faz o vinculo entre o dado e uma view
        //ArrayApater implementa o Adapter
        listaDeAlunos.setAdapter(new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,alunos));

        //ViewGroup
        //DSL
        //Domain Specifc Language
        //dp
        //densidade por pixel
        //
    }

    public static List<String> listAluno(){
        List<String> alunos = new ArrayList<>();
        alunos.add("Henrique");
        alunos.add("Pedro");
        alunos.add("Jose");
        return alunos;
    }
}
