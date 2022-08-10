import java.time.LocalDate;

public class ProntoAtendimento extends Consulta{

	public ProntoAtendimento(LocalDate data, Especialidade espec) {
		super(data, espec);
	}

	@Override
	public double valorAPagar() {		
		return this.especialidade.preco()*1.20;
	}

}
