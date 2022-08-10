/*
 * 
 * Sistema de Turmas para matéria de programação modular.
 * 
 * @author Gabriel Ribeiro Mendonça
 *
 */

import java.util.ArrayList;

public class Material {
 private ArrayList<Aluno> vizualizadores;
 
 Material(){
	 ArrayList<Aluno> vizualizadoresConstruct = new ArrayList<>(); //gera lista vazia de materiais
	 this.setVizualizadores(vizualizadoresConstruct);
 }

public void adicionarVizualizacao(Aluno aluno) {
	getVizualizadores().add(aluno);
}

public ArrayList<Aluno> getVizualizadores() {
	return vizualizadores;
}

public void setVizualizadores(ArrayList<Aluno> vizualizadores) {
	this.vizualizadores = vizualizadores;
}


}
 
	

