/*
 * 
 * Sistema de Turmas para matéria de programação modular.
 * 
 * @author Gabriel Ribeiro Mendonça
 *
 */

public class Atividade {
	protected String nome;	
	protected double valor;
	
	
	public Atividade(String nome) {
		this.nome = nome;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}
	
	
	
}
