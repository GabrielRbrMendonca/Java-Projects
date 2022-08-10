/*
 * 
 * Sistema de Turmas para matéria de programação modular.
 * 
 * @author Gabriel Ribeiro Mendonça
 *
 */

import java.util.ArrayList;
import java.util.Collections;


public abstract class Turma {
	private int nivel;
	private int dia;
	private int turno;
	protected String codigo;
	protected ArrayList<Aluno> alunos;
	
	
	
	//construtor
	public Turma(int nivel, int dia, int turno) {
		this.nivel = nivel;
		this.dia = dia;
		this.turno = turno;
		this.codigo = codMaker(nivel,dia,turno); 
		ArrayList<Aluno> alunosConstruct = new ArrayList<>(); //gera lista vazia de alunos
		this.alunos = alunosConstruct;
	}
	
	
	//getters e setters

	public String getCodigo() {
		return codigo;
	}
	
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	
	
	
	public ArrayList<Aluno> getAlunos() {
		return alunos;
	}
	//getters setters fim
	
	
	//gerando codigo de turma
	public String codMaker(int nivel, int dia, int turno) {
		return ""+this.nivel + this.dia + this.turno;
		
	}
	
	//relatorio em ordem alfabetica
	public  ArrayList<Aluno> relatorio(){
		Collections.sort(this.alunos);
		//System.out.println(alunos); a lista "alunos" agora será impressa em ordem lexicografica
		return this.alunos;
	}
	
	
	
	// cadastro de alunos
	public boolean adicionarAluno(Aluno aluno)
	{	
		boolean verif;
			this.alunos.add(aluno);
		verif =	aluno.isMatriculado(); 
		if(verif==false)
		{
			return true;
		}
		else
		{
			return false;
		}
		
	}
	public void removerAluno(int i) {
		this.alunos.remove(i);
	}
	
}


