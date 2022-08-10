/*
 * 
 * Sistema de Turmas para matéria de programação modular.
 * 
 * @author Gabriel Ribeiro Mendonça
 *
 */

public class Aula {
	private String data;

	
	
	public Aula(String data) {
		this.data = data;
	}


	public String getData() {
		return data;
	}


	public void setData(String data) {
		this.data = data;
	}

//metodo para dar falta em um aluno
	public static void darFalta(Aluno aluno) {
		aluno.setFrequencia(aluno.getFrequencia()*0.95);
		//diminui a frequencia do aluno em 5%
	}
}
