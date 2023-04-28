package interacoes;

import java.util.Scanner;
import java.util.ArrayList;

import entidades.Aluno;
import entidades.Turma;
import utilitarios.CarregadorDeDados;


public class InterfaceDeUsuario {
	Scanner leitor = new Scanner(System.in);
	enum Menu{
		CRIAR_ALUNO, CRIAR_TURMA, MATRICULAR, CANCELAR_MATRICULA,
		LIS_ALUNO, LIS_TURMA, LIS_ALUNO_POR_TURMA, LIS_TURMA_POR_ALUNO,
		DEFAULT
	}
	private ArrayList<Aluno> alunos = new ArrayList<>();
	private ArrayList<Turma> turmas  = new ArrayList<>();
	
	public void rodarMenu(){
		Aluno alunoFind;
		Turma turmaFind;
		CarregadorDeDados.charge(
				this.turmas, this.alunos);
		
		boolean continuar =  true;
		while(continuar) {
			switch(this.getMenu()) {
			case CRIAR_ALUNO:
				System.out.print("Nome do aluno: ");
				String nome = this.leitor.nextLine();
				this.alunos.add(new Aluno(nome));
				break;
			case CRIAR_TURMA:
				System.out.print("Codigo da turma: ");
				String codigo = this.leitor.next();
				this.leitor.nextLine();
				System.out.print("Numero de vagas: ");
				int vagas = this.leitor.nextInt();
				this.leitor.nextLine();
				this.turmas.add(new Turma(codigo, vagas));
				break;
			case MATRICULAR:
				alunoFind = this.getInputAluno();
				turmaFind = this.getInputTurma();
				

				if (turmaFind != null && alunoFind != null) {
					turmaFind.matricular(alunoFind);
				}else {
					System.out.println("Aluno ou turma não encontrado");
				}

				break;
			case CANCELAR_MATRICULA:
				alunoFind = this.getInputAluno();
				turmaFind = this.getInputTurma();

				if (turmaFind != null && alunoFind != null) {
					turmaFind.cancelarMatricula(alunoFind);
				}else {
					System.out.println("Aluno ou turma não encontrado");
				}
				break;
			case LIS_ALUNO:
				break;
			case LIS_TURMA:
				break;
			case LIS_ALUNO_POR_TURMA:
				turmaFind = this.getInputTurma();
				
				if (turmaFind != null) {
					System.out.printf("Alunos da turma %s:\n", turmaFind.getCodigo());

					for(int i=0; i<turmaFind.getNumeroMatriculados(); i++) {
						System.out.printf("-> %s\n",
								turmaFind.getAluno(i).getNome());
					}
				}else {
					System.out.println("Turma não encontrada\n");
				}
				
				break;
			case LIS_TURMA_POR_ALUNO:
				System.out.print("Nome do aluno: ");
				String nomeSearch = this.leitor.nextLine();

				System.out.printf("Turmas do aluno: %s\n", nomeSearch);

				for (Turma turma: this.turmas) {
					if(turma.estahMatriculado(nomeSearch)) {
						System.out.printf("-> %s\n", turma.getCodigo());
					}
				}
				break;
			default:
				continuar = false;
				break;
			}
		}		
	}
	
	public Menu getMenu() {
		System.out.println("Menu de opcoes:\n"+
		"1 - Criar aluno\n"+
		"2 - Criar turma\n"+
		"3 - Matricular aluno\n"+
		"4 - Cancelar matricula aluno\n"+
		"7 - Listar os alunos de uma determinada turma\n"+
		"8 - Listar as turmas de um determinado aluno");
		
		int option = this.leitor.nextInt();
		this.leitor.nextLine();
		
		try{
			return Menu.values()[option -1];
		}catch (Exception e) {
			return Menu.DEFAULT;
		} 
	}
	
	public Aluno getInputAluno() {
		Aluno alunoFind = null; 
		String nomeSearch;

		System.out.print("Nome do aluno: ");
		nomeSearch = this.leitor.nextLine();
		
		for (Aluno aluno: this.alunos) {
			if (nomeSearch.equals(aluno.getNome())) {
				alunoFind = aluno;
			}
		}
		return alunoFind;
	}
	
	public Turma getInputTurma() {
		Turma turmaFind = null;
		String codigoSearch;
		
		System.out.print("Codigo da turma: ");
		codigoSearch = this.leitor.next();
		this.leitor.nextLine();

		for (Turma turma: this.turmas) {
			if (codigoSearch.equals(turma.getCodigo())) {
				turmaFind = turma;
			}
		}
		
		return turmaFind;
	}
	
}
