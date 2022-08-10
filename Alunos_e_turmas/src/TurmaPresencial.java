/*
 * 
 * Sistema de Turmas para matéria de programação modular.
 * 
 * @author Gabriel Ribeiro Mendonça
 *
 */

import java.util.ArrayList;

public class TurmaPresencial extends TurmaAvaliativa {

	protected ArrayList<Aula> aulas;
	
	public TurmaPresencial(int nivel, int dia, int turno) {
		super(nivel, dia, turno);
		ArrayList<Aula> aulasConstruct = new ArrayList<>(); //gera lista vazia de aulas
		this.aulas=aulasConstruct;
	}
	
	//retorna frequencia media da turma
	public double frequenciaMedia(ArrayList<Aluno> alunos){
		double soma=0;
		double media;
		int y=0;
		for(int i = 0; i < alunos.size(); i++){
			//System.out.println(alunos.get(i).getFrequencia());
			soma=soma+alunos.get(i).getFrequencia();
			y=y+1;
		}
		media=soma/y;
		return media;
	
	}
	
	//adiciona uma aula na lista de aulas
	public boolean adicionarAula(Aula aula)
	{
		if(this.aulas.size()<=20)
		{
			this.aulas.add(aula);
			return true; //adiciona aula na lista e retorna True 
		}
		else
		{
			return false;//retorna falso se tiver mais que 20 aulas
		}
	}
	
	
	//metodo para adicionar um aluno na lista de alunos da turma
	@Override
	public boolean adicionarAluno(Aluno aluno)
	{
		boolean verif;
		verif=super.adicionarAluno(aluno);
		if (verif==false)
		{
			return false;
		}
		else
		if(this.alunos.size()<=20)
		{ 
			return true;
		}
		else
		{
			super.removerAluno(alunos.size()-1);
			return false;
		}	
	}
	
	//sobrepõe o metodo da classe mae para verificar se o aluno obteve a frequencia minima para aprovação
	@Override
	public boolean estaAprovado(Aluno aluno) {
		if(super.estaAprovado(aluno)==true) 
		{
			if(aluno.getFrequencia()>75)
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
		else
		{
			aluno.setAprovacao("Reprovado");
			return false;
		}
				
	}
	
	
	@Override
	//calcula a maior pontuação da turma 
	public double calculoMelhorScore(Aluno aluno){
		double aux;
		double aux2 =0;
		aux = super.calculoMelhorScore(aluno)*8+aluno.getFrequencia()*2;
		if(aux2<aux)
		{
			aux2=aux;
		}
		return aux2;
	}
	
	//compara as pontuações dos alunos com a melhor pontuação para encontrar o melhor aluno
	public void setMelhorAluno(Aluno aluno){
		double aux;
		aux = somarNotas(aluno.getNotas())*8+aluno.getFrequencia()*2;
		if(aux==melhorScore) {
		    this.melhorAluno=aluno;	
		}
	}
	
}
