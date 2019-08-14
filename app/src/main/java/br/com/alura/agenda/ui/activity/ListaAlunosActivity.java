 package br.com.alura.agenda.ui.activity;

 import android.content.Intent;
 import android.os.Bundle;
 import android.support.annotation.Nullable;
 import android.support.design.widget.FloatingActionButton;
 import android.support.v7.app.AppCompatActivity;
 import android.view.View;
 import android.widget.AdapterView;
 import android.widget.ArrayAdapter;
 import android.widget.ListView;

 import java.util.ArrayList;
 import java.util.List;

 import br.com.alura.agenda.R;
 import br.com.alura.agenda.dao.AlunoDAO;
 import br.com.alura.agenda.model.Aluno;

 import static br.com.alura.agenda.ui.activity.ConstantesAcitivities.CHAVE_ALUNO;

 //AppCompatActivity é uma boa pratica dentro do Androidfor
public class ListaAlunosActivity extends AppCompatActivity {

    public static final String TITULO_APPBAR = "Lista de Alunos";

     private final AlunoDAO dao = new AlunoDAO();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_alunos);
        setTitle(TITULO_APPBAR);
        configuraFabNovoAluno();
        dao.salva(new Aluno("Itamar","11993379121","itamarrochaa@yahoo.com"));
        dao.salva(new Aluno("Pedro","11993379121","itamarrochaa@yahoo.com"));

    }

    private void configuraFabNovoAluno() {
        FloatingActionButton botaoNovoAluno = findViewById(R.id.activity_lista_alunos_fab_novo_aluno);
        botaoNovoAluno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                abreFormularioModoInsereAluno();
            }
        });
    }

    private void abreFormularioModoInsereAluno() {
        startActivity(new Intent(this,formularioAlunoActivity.class));
    }

    @Override
    protected void onResume() {
        super.onResume();
        configuraLista();
    }

    private void configuraLista() {
        ListView listaDeAlunos = findViewById(R.id.activity_lista_alunos_listview);
        final List<Aluno> alunos = dao.todos();
        configuraAdapter(listaDeAlunos, alunos);
        configuraListenerDeCliquePorItem(listaDeAlunos);
    }

     private void configuraListenerDeCliquePorItem(ListView listaDeAlunos) {
         listaDeAlunos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
             @Override
             public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                 Aluno alunoEscolhido = (Aluno) parent.getItemAtPosition(position);
                 abreFormularioEditarAluno(alunoEscolhido);
             }
         });
     }

     private void abreFormularioEditarAluno(Aluno alunoEscolhido) {
         Intent vaiParaFormularioActivity = new Intent(this, formularioAlunoActivity.class);
         vaiParaFormularioActivity.putExtra(CHAVE_ALUNO,alunoEscolhido);
         startActivity(vaiParaFormularioActivity);
     }

     private void configuraAdapter(ListView listaDeAlunos, List<Aluno> alunos) {
         listaDeAlunos.setAdapter(new ArrayAdapter<>(this,android.R.layout.simple_list_item_1, alunos));
     }

     public static List<String> listAluno(){
        List<String> alunos = new ArrayList<>();
        alunos.add("Henrique");
        alunos.add("Pedro");
        alunos.add("Jose");
        return alunos;
    }
}
