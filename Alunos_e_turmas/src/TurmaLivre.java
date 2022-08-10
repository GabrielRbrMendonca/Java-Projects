/*
 * 
 * Sistema de Turmas para matéria de programação modular.
 * 
 * @author Gabriel Ribeiro Mendonça
 *
 */

import java.util.ArrayList;
import java.util.Collections;

public class TurmaLivre extends Turma{

	private ArrayList<Material> materiais;
	
	public TurmaLivre(int nivel, int dia, int turno) {
		super(nivel, dia, turno);
		ArrayList<Material> materiaisConstruct = new ArrayList<>(); //gera lista vazia de materiais
		this.materiais=materiaisConstruct;
	}
	
	public void adicionarMaterial(Material material) {
		this.materiais.add(material);
	}
	
	//verifica se o aluno vizualizou um material especifico
	public boolean verificarVizualizacao(Material material, Aluno aluno) {
		return material.getVizualizadores().contains(aluno);					
	}
	
	//verifica se o aluno vizualizou todos os materiais disponiveis na lista
	public boolean verificarAprovacao(Aluno aluno) {
		boolean verif;
		for(int i=0; i< materiais.size();i++) {
			verif= verificarVizualizacao(materiais.get(i),aluno);
			if(verif==false) {
				aluno.setAprovacao("Reprovado");
				return false;
			}	
		}
		aluno.setAprovacao("Aprovado");
		return true;
	}
	
	
	@Override
	public String codMaker(int nivel, int dia, int turno) {
		return super.codMaker(nivel, dia, turno) + "L";
	}
	
	@Override
	public  ArrayList<Aluno> relatorio(){
		Collections.sort(this.alunos);
		alunos.forEach((Aluno)->this.toString());
		//System.out.println(alunos); a lista "alunos" agora será impressa em ordem lexicografica
		return this.alunos;
	}
	
	
}
