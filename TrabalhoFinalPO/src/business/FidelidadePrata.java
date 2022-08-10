package business;

import java.time.LocalDateTime;
import java.util.List;

public class FidelidadePrata implements IFidelizavel {
	public static final double DESCONTO = 0.05;
	public static final int MIN_PEDIDOS = FidelidadeBranco.MAX_PEDIDOS;
	public static final int MIN_GASTOS = FidelidadeBranco.MAX_GASTOS;
	public static final int MAX_PEDIDOS = 10;
	public static final int MAX_GASTOS = 250;
	private int numPedidosUltimoMes;
	private double gastosUltimoMes;
	
	public FidelidadePrata(List<Pedido> pedidos) {
		this.numPedidosUltimoMes=getNumPedidosUltimoMes(pedidos);
		this.gastosUltimoMes=getGastoUltimoMes(pedidos);
		this.validarFidelidade(pedidos);
	}

	@Override
	public IFidelizavel validarFidelidade(List<Pedido> pedidos) {
		if ((this.numPedidosUltimoMes >= MIN_PEDIDOS && this.numPedidosUltimoMes < MAX_PEDIDOS)
				|| (this.gastosUltimoMes >= MIN_GASTOS && this.gastosUltimoMes < MAX_GASTOS)) {
			return new FidelidadePrata(pedidos);
		} else if (this.numPedidosUltimoMes < MAX_PEDIDOS || this.gastosUltimoMes < MIN_GASTOS) {
			return new FidelidadeBranco(pedidos);
		} else {
			return new FidelidadePreto(pedidos);
		}
	}

	@Override
	public double getDesconto() {
		return DESCONTO;
	}

	@Override
	public int getNumPedidosUltimoMes(List<Pedido> pedidos) {
		int mesAtual = LocalDateTime.now().getMonthValue();
		int numPedidos = 0;
		for (int i = 0; i < pedidos.size(); i++) {
			if (pedidos.get(i).getDataRealizacao().getMonthValue() == mesAtual - 1)
				numPedidos++;
		}
		return numPedidos;
	}

	@Override
	public double getGastoUltimoMes(List<Pedido> pedidos) {
		int mesAtual = LocalDateTime.now().getMonthValue();
		double gastos = 0;
		for (int i = 0; i < pedidos.size(); i++) {
			if (pedidos.get(i).getDataRealizacao().getMonthValue() == mesAtual - 1)
				gastos += pedidos.get(i).getValorPago();
		}
		return gastos;
	}
}
