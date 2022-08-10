/*
 * 
 * Sistema de Turmas para matéria de programação modular.
 * 
 * @author Gabriel Ribeiro Mendonça
 *
 */

public class Aluno implements Comparable<Aluno>{
	private String nome;
	private double[] notas;
	private double frequencia;
	private String aprovacao;
	private Turma turmaMatriculada;
	private boolean matriculado;
	
	//contrutores
	private void init (String nome)
	{
		double[] notasZeradas= {0.00, 0.00, 0.00, 0.00};
		this.nome=nome;
		this.notas=new double[4];
		this.notas=notasZeradas;//todo aluno começa com notas zeradas
		this.frequencia =100.00;//todo aluno começa com 100% de frequencia
		this.matriculado=false;
	}
	
	public Aluno(String nome)
	{
		this.init(nome);
	}
	
	//fim contrutores
	
	//getters e setters
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getAprovacao() {
		return aprovacao;
	}

	public void setAprovacao(String aprovacao) {
		this.aprovacao = aprovacao;
	}

	public double getFrequencia() {
		return frequencia;
	}

	public void setFrequencia(double frequencia) {
		this.frequencia = frequencia;
	}
	
	public void setNotas(double[] notas) {
		this.notas = notas;
	}

	public double[] getNotas() {
		return notas;
	}
	
	public boolean isMatriculado() {
		return matriculado;
	}
	//getters e setters fim
	
	
	public boolean Matricular(Turma turmaMatriculada)
	{
		if(this.turmaMatriculada== null) //apenas uma turma por aluno
		{
			this.turmaMatriculada = turmaMatriculada;
			this.matriculado=true;
			return true;
		}
		return false;
	}
	
	public void cancelarMatricula() {
		this.turmaMatriculada=null; //
	}
		
	//retorna um char baseado no tipo da turma matriculada
	public char getTipoTurma() {
		char tipoTurma;
		tipoTurma = this.turmaMatriculada.getCodigo().charAt(turmaMatriculada.getCodigo().length()-1); 
		return tipoTurma;
	}
	
	

	
	//to string
	@Override
	public String toString()
	{
		if(this.getTipoTurma() == 'L') {//caso a turma for livre
			return"Nome: "+this.nome + ", Status: " + getAprovacao();
		}
		else//caso a turma for avaliativa
		{
			return"Nome: "+this.nome + " Nota: " + TurmaAvaliativa.somarNotas(this.notas) + ", Status: " + getAprovacao();
		}
	}
	
	
	//metodo para permitir a comparação lexicografica
	@Override
	public int compareTo(Aluno aluno2) {		
			return this.nome.compareTo(aluno2.nome);	
	}

	
}

