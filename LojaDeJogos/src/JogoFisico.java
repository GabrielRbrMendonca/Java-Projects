
public class JogoFisico extends Jogo{
	private static final double ADIC_DISCO = 15;
	private static final double ACRESC_ESCPECIAL = 0.10;
	private int quantDiscos;
	private boolean versaoEspecial;
	
	public JogoFisico(String nome, int anoLancamento, double precoBase, int quantDiscos,boolean versaoEspecial) {
		super(nome, anoLancamento, precoBase);
		this.quantDiscos= quantDiscos;
		this.versaoEspecial =versaoEspecial;
	}
	
	@Override
	public double precoVenda() {
		double precoVenda;
		double margem;
		margem= precoBase()*getMargemLucro();
		precoVenda=this.precoBase+margem+precoAdicionais();
		if(this.versaoEspecial==true) {
			precoVenda=precoVenda+precoVenda*ACRESC_ESCPECIAL;
		}
		return precoVenda; 
	}
	
	

	@Override
	protected double precoBase() {
		this.precoBase=this.precoBase-getDescontoTempo();	
		return this.precoBase;
	}
	
	private double precoAdicionais() {
		double precoAdicional;
		precoAdicional = ADIC_DISCO * this.quantDiscos;
		return precoAdicional;
		
	}
}

/*A loja de jogos que utilizou seus serviços anteriormente vai expandir seus negócios: agora estão recebendo e irão
vender os jogos em cópias físicas. As cópias físicas dos jogos podem estar gravadas em um ou mais discos e têm um
custo fixo adicional por disco: R$15. Caso seja uma versão especial, ainda há acréscimo de 10% na soma dos valores
anteriores. A regra de desconto por preço continua valendo, sendo aplicada após os cálculos anteriores. Os clientes
agora ganharam uma vantagem: ao completar R$500 em compras, terão desconto de 20% na próxima compra.
*/