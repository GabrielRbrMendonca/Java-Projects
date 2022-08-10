
public class Completo implements IPlanoDeSaude {

	private static double VALOR_BASE = 280.00;
	@Override
	public double calcMensalidade(int idade) {
		double resto;
		if(idade>45)
		{
			resto = idade-45;
			if(resto>=5)
			{
				return ((resto%5)*0.10+1)*VALOR_BASE;
			}
		}
		return VALOR_BASE;
	}

	@Override
	public double coparticipacao() {
		
		return 0;
	}

}
