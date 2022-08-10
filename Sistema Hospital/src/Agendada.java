import java.time.LocalDate;

public class Agendada extends Consulta {

	public Agendada(LocalDate data, Especialidade espec) {
		super(data, espec);
	}

	@Override
	public double valorAPagar() {
		return this.especialidade.preco();
	}

}
