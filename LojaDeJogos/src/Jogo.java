
public abstract class Jogo {
//atributos
private static final int TEMPO_DESC = 2;
private static final double PCT_DESCONTO = 0.2;
private static final double MARGEM_LUCRO = 0.35;
private static final int ANO_ATUAL= 2022;
protected String nome;
protected int anoLancamento;
protected double precoBase;
protected int avaliacoes[];
protected int totalAvaliacoes;




//contrutor 
public Jogo(String nome, int anoLancamento, double precoBase) {
	this.nome = nome;
	this.anoLancamento = anoLancamento;
	this.precoBase = precoBase;
	this.totalAvaliacoes = 0;
}



//getters e setters
public String getNome() {
	return nome;
}


public void setNome(String nome) {
	this.nome = nome;
}


public int getAnoLancamento() {
	return anoLancamento;
}


public void setAnoLancamento(int anoLancamento) {
	this.anoLancamento = anoLancamento;
}


public double getPrecoBase() {
	return precoBase;
}


public void setPrecoBase(double precoBase) {
	this.precoBase = precoBase;
}


public int[] getAvaliacoes() {
	return avaliacoes;
}


public void setAvaliacoes(int[] avaliacoes) {
	this.avaliacoes = avaliacoes;
}


public int getTotalAvaliacoes() {
	return totalAvaliacoes;
}


public void setTotalAvaliacoes(int totalAvaliacoes) {
	this.totalAvaliacoes = totalAvaliacoes;
}


public static double getMargemLucro() {
	return MARGEM_LUCRO;
}

//fim getters e setters

public double precoVenda() {
	double precoVenda;
	double margem;
	margem= precoBase()*MARGEM_LUCRO;
	precoVenda=this.precoBase+margem;
	return precoVenda;	
}

protected double precoBase() {
	this.precoBase=this.precoBase-descontoTempo();	
	return this.precoBase;
}

private double descontoTempo() {
	int idade;
	double desconto=0;
	idade=ANO_ATUAL-this.anoLancamento;
	while(idade>=TEMPO_DESC) {
		desconto=desconto+this.precoBase*PCT_DESCONTO;
		idade=idade/2;
	}
	return desconto;
}

public double avaliacaoMedia() {
	double soma=0;
	int cont=0;
	double media;
	for(int i=0;i<this.avaliacoes.length;i++) {
		soma=soma+this.avaliacoes[i];
		cont=cont+1;
	}
	media=soma/cont;	
	return media;
}

public void notaAvaliacao(int nota) {
	this.avaliacoes[totalAvaliacoes]=nota;
	totalAvaliacoes++;
}



public double getDescontoTempo() {
	double desconto = descontoTempo();
	return desconto;
}


}
