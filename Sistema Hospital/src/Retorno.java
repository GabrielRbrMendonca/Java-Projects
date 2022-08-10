import java.time.LocalDate;

public class Retorno extends Consulta{
	
	private static int PRAZO_RETORNO=30;
	public Consulta consultaOriginal;
	
	

	public Retorno(LocalDate data, Especialidade espec, Consulta consultaOriginal) {
		super(data, espec);
		this.consultaOriginal = consultaOriginal;
		this.data=data;
		if(data.isAfter(consultaOriginal.data.plusDays(PRAZO_RETORNO))) {
			this.data=null;
		}
	}



	@Override
	public double valorAPagar() {
		return 0;
	}

}
