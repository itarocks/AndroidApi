package br.com.alura.agenda.dao;

import android.support.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

import br.com.alura.agenda.model.Aluno;

public class AlunoDAO {


    private final static List<Aluno> alunos = new ArrayList<>();

    private static int contadorDeIds = 1;

    public void salva(Aluno aluno) {
        aluno.setId(contadorDeIds);
        alunos.add(aluno);
        atualizaIds();
    }

    private void atualizaIds() {
        contadorDeIds++;
    }

    public void edita(Aluno aluno) {

        Aluno alunoEncontrado = buscaAlunoPorId(aluno);

        if (alunoEncontrado != null) {

            int posicao = alunos.indexOf(alunoEncontrado);
            alunos.set(posicao, aluno);

        }

    }

    @Nullable
    private Aluno buscaAlunoPorId(Aluno aluno) {
        Aluno alunoEncontrado = null;

        for (Aluno a : alunos) {

            if (a.getId() == aluno.getId()) {

                alunoEncontrado = a;
            }
        }
        return alunoEncontrado;
    }

    public List<Aluno> todos() {

        return new ArrayList<>(alunos);

    }
}
