
public class JogoDigital extends Jogo {

	public JogoDigital(String nome, int anoLancamento, double precoBase) {
		super(nome, anoLancamento, precoBase);
	}
	
	@Override
	public double precoVenda() {
		double precoVenda;
		double margem;
		margem= precoBase()*getMargemLucro();
		precoVenda=this.precoBase+margem;
		return precoVenda;	
	}

	@Override
	protected double precoBase() {
		this.precoBase=this.precoBase-getDescontoTempo();	
		return this.precoBase;
	}

}
