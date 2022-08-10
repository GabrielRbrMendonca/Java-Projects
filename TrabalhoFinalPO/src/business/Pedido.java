package business;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Pedido {

//atributos
	private static final int MAX_ITENS = 10;
	private int id;
	private LocalDateTime dataRealizacao;
	private double desconto;
	private int avaliacao;
	private Cliente cliente;
	private double valorPago;
	private List<Produto> itens;

	public Pedido(Cliente cliente) {
		this.dataRealizacao = LocalDateTime.now();
		this.avaliacao = 0;
		this.cliente = cliente;
		List<Produto> iniciaItens = new ArrayList<Produto>(10);
		this.itens = iniciaItens;
		this.desconto = cliente.getNivelFidelidade().getDesconto();
		setValorPago();
	}

	public String gerarNotaDeCompra() {
		String nota;
		nota = "CARNE DE CAPIVARA\n" + "Pedido: " + this.id + " Data " + this.dataRealizacao.toString() + "\n"
				+ "Dados do Cliente\n\n" + "Nome: " + this.cliente.getNome() + "\n" + "CPF: " + this.cliente.getCpf()
				+ "\n\n" + "ITENS DO PEDIDO\n\n";
		for (int i = 0; i <= itens.size(); i++) {
			nota = nota + i + " " + itens.get(i).getId() + " " + itens.get(i).toString() + " "
					+ itens.get(i).getPrecoBase() + "\n";
		}
		nota = nota + "Valor Total: " + getValorTotal() + "\n" + "Desconto: "
				+ this.cliente.getNivelFidelidade().getDesconto() * 100 + "%\n" + "Valor Pago: " + getValorPago();

		return nota;
	}

	private double getValorTotal() {
		double valor = 0;
		for (int i = 0; i <= itens.size(); i++) {
			valor = valor + itens.get(i).getPrecoBase();
		}
		return valor;
	}

	public void addItem(Produto p) throws LimiteDeItens {
		if (this.itens.size() < MAX_ITENS) {
			itens.add(p);
		} else {
			throw new LimiteDeItens(p);
		}

	}

//getters e setters

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getDesconto() {
		return desconto;
	}

	public void setDesconto(double desconto) {
		this.desconto = desconto;
	}

	public int getAvaliacao() {
		return avaliacao;
	}

	public void setAvaliacao(int avaliacao) {
		this.avaliacao = avaliacao;
	}

	public static int getMaxItens() {
		return MAX_ITENS;
	}

	public LocalDateTime getDataRealizacao() {
		return dataRealizacao;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public List<Produto> getItens() {
		return itens;
	}

	public double getValorPago() {
		return valorPago;
	}

	private void setValorPago() {
		this.valorPago = getValorTotal() * (1 - desconto);
	}
	
	public String toString() {
		return getId()+" "+getDataRealizacao().toString()+" "+cliente.getNome();
	}

}
