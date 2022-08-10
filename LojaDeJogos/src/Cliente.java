
public class Cliente {
	public String nome;
	private Jogo[] historico = new Jogo[100];
	private int totalJogos;
	private double proxDesconto;
	
	
	
	public Cliente(String nome) {
		this.nome = nome;
		this.totalJogos = 0;
		this.proxDesconto=0.0;
	}

	public void incluirJogo(Jogo jogo) {
		boolean desconto;
		double preco;
		desconto = verificarDesconto();
		if(desconto==true) {
			preco=jogo.precoVenda()*0.80;
		}
		else
		{
			preco=jogo.precoVenda();
		}
		this.historico[totalJogos]=jogo;
		this.proxDesconto = this.proxDesconto + preco;
		this.totalJogos++;
		
	}

	public String getUltimoJogoComprado() {
		return this.historico[totalJogos-1].nome;
	}
	

	private boolean verificarDesconto() {
		if(this.proxDesconto >= 500) {
			this.proxDesconto = this.proxDesconto-500;
			return true;
		}
		else {
			return false;
		}
		
		
	}

	public double getProxDesconto() {
		return proxDesconto;
	}
	
}
