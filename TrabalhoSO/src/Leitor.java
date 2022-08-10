//Leitor para simulação com ordenação por prazo 
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Leitor {
	static String nome;
	static int numero;
	static int prazo;
	double tempoGastoPelaEsteira = 0.5;
	int numeroDePacotesFechados = 0;
	int entregasForaDoPrazo = 0;

	public static void main(String[] args) throws IOException {
		Esteira e = new Esteira();
		FileInputStream stream = new FileInputStream("");//inserir caminho dos dados 
		InputStreamReader reader = new InputStreamReader(stream);
		BufferedReader br = new BufferedReader(reader);

		String linha = br.readLine();
		while (linha != null) {
			nome = linha.substring(0, linha.indexOf(';'));
			String num = linha.substring(linha.indexOf(';') + 1, linha.lastIndexOf(';'));
			numero = Integer.parseInt(num);
			String pra = linha.substring(linha.lastIndexOf(';') + 1, linha.length());
			prazo = Integer.parseInt(pra);
			e.addPedido(nome, numero, prazo);
			linha = br.readLine();
		}
		br.close();

		e.ordenarEsteira();

		double tempoGastoPelaEsteira = 0.5;
		int numeroDePacotesFechados = 0;
		int entregasForaDoPrazo = 0;
		while (tempoGastoPelaEsteira < 14394.5) {
			int i = 0;
			tempoGastoPelaEsteira += 5.5;
			numeroDePacotesFechados++;
			if (e.pacotes.get(i).getPrazo() > tempoGastoPelaEsteira) {
				entregasForaDoPrazo++;
			}
		}
		int totalClientesPrioritarios = 0;
		for (int i = 0; i < e.pacotes.size(); i++) {
			if (e.pacotes.get(i).getPrazo() != 999) {
				totalClientesPrioritarios++;
			}
		}

		while (tempoGastoPelaEsteira < 14394.5) {
			int i = 0;
			tempoGastoPelaEsteira += 5.5;
			numeroDePacotesFechados++;
			if (e.pacotes.get(i).getPrazo() > tempoGastoPelaEsteira) {
				entregasForaDoPrazo++;
			}
		}

		System.out.println("Número total de pacotes para entrega independente do prazo: " + e.pacotes.size());
		System.out.println("Número de pacotes prioritários: " + totalClientesPrioritarios);
		System.out.println("Pacotes fechados até 12:00: " + numeroDePacotesFechados);
		System.out.println(
				"Pacotes prioritários entregues fora do prazo com a organização por prazo: " + entregasForaDoPrazo);
	}
}