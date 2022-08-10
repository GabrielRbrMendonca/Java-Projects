import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

public class Testes {

	@Test
	public void verificar_Preco_Jogo_Fisico() {	
		JogoFisico jogo = new JogoFisico("Nome",2019,100,2,true);
		//Preco Base= 100
		//Idade do jogo = 3, 20% de desconto sobre o preço base, novo preço base = 80
		//Margem de lucro = 35% sobre o preço base, preço de venda = 108
		//Dois discos = + 15*2 no preço de venda = 138
		//Versão especial = + 10% sobre a soma dos outros valores, 138 + 13.8 preço de venda esperado = 151.8 
		assertEquals((151.8),(jogo.precoVenda()),(000.1));
	}
	
	
	@Test
	public void verificar_Desconto_Cliente_Apos_Compra(){
		Cliente cliente = new Cliente("Jorginho");
		
		//74.12* margem de 35% ~= 100
		
		JogoDigital jogo1 = new JogoDigital("Jogo1",2022,74.12);
		cliente.incluirJogo(jogo1);
		//Adicionando um jogo de preco de venda ~= 100
		
		assertEquals((100.00),(cliente.getProxDesconto()),(0.1));
		//A soma para o proximo desconto recebe valor do preço de venda do jogo
		
		JogoDigital jogo2 = new JogoDigital("Jogo2",2022,296.48);
		cliente.incluirJogo(jogo2);
		/*Adicionando um jogo com preço de venda ~= 400 para ultrapassar o valor estipulado
		para o desconto */
		
		assertEquals((500.00),(cliente.getProxDesconto()),(1));
		//A soma para o proximo desconto agora esta acima de 500
		
		//Na proxima compra o preço de venda deve receber um desconto de 20%
		
		JogoDigital jogo3 = new JogoDigital("Jogo2",2022,74.12);
		cliente.incluirJogo(jogo3);
		//Adicionando mais um jogo ao historico com preço de venda ~= 100
		
		assertEquals((80),(cliente.getProxDesconto()),(1));
		/*A soma para o proximo desconto deve receber o valor de venda do ultimo 
		jogo comprado - 20% ~=80 */
		
	}
}
