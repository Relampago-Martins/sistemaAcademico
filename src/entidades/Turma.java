package entidades;
import java.util.ArrayList;

public class Turma {
	int vagas, numeroMatriculados;
	private String codigo, nome, local, horario;
	private ArrayList<Aluno> matriculados;
	private Professor professor;
	
	
	public Turma(String codigo, int vagas) {
		this.codigo = codigo;
		this.vagas = vagas;
		this.matriculados = new ArrayList<>();
	}
	
	public void matricular(Aluno aluno) {
		if (this.numeroMatriculados < this.vagas && aluno != null) {
			this.matriculados.add(aluno);
			this.numeroMatriculados++;
		}
	}
	
	public void cancelarMatricula(Aluno aluno) {
		int indexAluno = this.matriculados.indexOf(aluno);
		if (indexAluno != -1) {
			this.matriculados.get(indexAluno);
		}
	}
	
	public Aluno getAluno(int indice){
		if (indice >= 0 && indice <= this.numeroMatriculados)
			return this.matriculados.get(indice);
		
		return null;
	}
	
	public Aluno getAluno(String nomeAluno) {
		for (Aluno aluno: this.matriculados) {
			if (aluno.getNome().equals(nomeAluno)) {
				return aluno;
			}
		}
		return null;
	}
	
	public boolean estahMatriculado(String nomeAluno) {
		for (Aluno aluno: this.matriculados) {
			if (aluno.getNome().equals(nomeAluno)) {
				return true;
			}
		}
		return false;
	}
	
	public int getNumeroMatriculados() {
		return this.numeroMatriculados;
	}
	
	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public int getvagas() {
		return vagas;
	}
}
