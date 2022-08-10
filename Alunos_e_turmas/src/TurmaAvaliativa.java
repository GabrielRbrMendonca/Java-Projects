/*
 * 
 * Sistema de Turmas para matéria de programação modular.
 * 
 * @author Gabriel Ribeiro Mendonça
 *
 */

import java.util.ArrayList;
import java.util.List;

public abstract class TurmaAvaliativa extends Turma{

	protected double melhorScore;
	protected Aluno melhorAluno;
	private List<Atividade> atividades;
	private int qteAtividades;
	private double valorPadrao;

	
	
	
	public TurmaAvaliativa(int nivel, int dia, int turno) {
		super(nivel, dia, turno);
		this.melhorScore=0;
		List<Atividade> atividadesConstruct = new ArrayList<Atividade>();//gera lista vazia de atividades
		this.atividades = atividadesConstruct;
	}
	
	//getters e setters
	public double getMelhorScore() {
		return melhorScore;
	}
	
	public Aluno getMelhorAluno() {
		return melhorAluno;
	}

	public void setMelhorScore(double melhorScore) { 
		if(melhorScore>this.melhorScore) {
			this.melhorScore = melhorScore;
		}		
	}
	
	//O cadastro para a primeira atividade serve de base para o restante
	public boolean adPrimeiraAtividade(String nome, double valor){
		if(100%valor != 0) { //100 tem que ser divisivel pelo valor da atividade
			return false;
		}
		else {
			Atividade primeira = new Atividade(nome);
			primeira.valor = valor;
			atividades.add(primeira);
			this.valorPadrao=valor;//o valor da primeira atividade vira o padrão para o restante
			return true;
		}
	
	}
	
	//Delimita a quantidade de atividades baseada no valor padrão
	public void setLimiteAtividades() {
		this.qteAtividades = (int) (100/this.valorPadrao);
		
	}
	
	//metodo para adicionar atividades avaliativas
	public boolean adicionaAtividade(Atividade atividade) {
		if(atividades.size() == this.qteAtividades) {
			return false;
		}
		else
		{
			atividades.add(atividade);
			atividade.valor=this.valorPadrao;
			return true;
		}
		
		
	}
		
	//retorna as media de notas da turma
	public double notasMedia(ArrayList<Aluno> alunos){
		double soma=0;
		double media;
		int y=0;
		for(int i = 0; i < alunos.size(); i++){
			//System.out.println(alunos.get(i).getNotaFinal());
			soma=soma+somarNotas(alunos.get(i).getNotas());
			y=y+1;
		}
		media=soma/y;
		return media;
	
	}
	
	
	//metodo para somar notas de todas as provas
	public static double somarNotas(double notas[])
	{
		int i;
		double soma=0.00;
		for (i=0; i<4; i++) {
			  soma=soma + notas[i]; 
			}
		
		return soma;
	}
	
	//verifica se o aluno atingiu mais de 60% da nota 
	public boolean estaAprovado(Aluno aluno) {
		double soma=somarNotas(aluno.getNotas());
				if(soma>=60)
				{
					aluno.setAprovacao("Aprovado");
					return true;
				}
				else
				{
					aluno.setAprovacao("Reprovado");
					return false;
				}
		
	}
	//metodos para melhor desempenho
			public void melhorAluno(ArrayList<Aluno> alunos) {
				alunos.forEach((Aluno)->setMelhorScore((calculoMelhorScore(Aluno))));			
				alunos.forEach((Aluno)->setMelhorAluno(Aluno));
			}
			
			//calcula a maior pontuação da turma 
			protected double calculoMelhorScore(Aluno aluno){
				double aux;
				double aux2 =0;
				aux = somarNotas(aluno.getNotas())*10;
				if(aux2<aux)
				{
					aux2=aux;
				}
				return aux2;
			}
			
			//compara as pontuações dos alunos com a melhor pontuação para encontrar o melhor aluno
			protected void setMelhorAluno(Aluno aluno){
				double aux;
				aux = somarNotas(aluno.getNotas())*10;
				if(aux==melhorScore) {
				    this.melhorAluno=aluno;	
				}
			}
}
