package br.com.alura.agenda;

import android.app.Application;

import br.com.alura.agenda.dao.AlunoDAO;
import br.com.alura.agenda.model.Aluno;

@SuppressWarnings("WeakerAccess")
public class AgendaApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        AlunoDAO dao = new AlunoDAO();
        criaAlunosTeste(dao);

    }

    private void criaAlunosTeste(AlunoDAO dao) {
        dao.salva(new Aluno("Itamar", "11993379121", "itamarrochaa@yahoo.com"));
        dao.salva(new Aluno("Pedro", "11993379121", "itamarrochaa@yahoo.com"));
    }
}
