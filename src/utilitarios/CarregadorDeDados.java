package utilitarios;

import java.util.ArrayList;

import entidades.Aluno;
import entidades.Turma;


public class CarregadorDeDados {

	private static void carregarAlunos(ArrayList<Aluno> alunos) {
		alunos.add(new Aluno("Bruno"));
		alunos.add(new Aluno("Frederico"));
		alunos.add(new Aluno("Carlos"));
		alunos.add(new Aluno("Carol"));
	}
	
	
	private static void carregarTurmas(ArrayList<Turma> turmas) {
		turmas.add(new Turma("GRA058AB", 12));
		turmas.add(new Turma("GRA096C", 23));
		turmas.add(new Turma("GRA022B", 21));
		turmas.add(new Turma("GRA744AA", 22));
		turmas.add(new Turma("POS065A", 6));
	}
	
	public static void charge(ArrayList<Turma> turmas, ArrayList<Aluno> alunos) {
		CarregadorDeDados.carregarAlunos(alunos);
		CarregadorDeDados.carregarTurmas(turmas);
		turmas.get(0).matricular(alunos.get(3));
		turmas.get(1).matricular(alunos.get(3));
		turmas.get(2).matricular(alunos.get(2));
		turmas.get(3).matricular(alunos.get(1));
		turmas.get(4).matricular(alunos.get(0));
		
	}
	
	
	
}
