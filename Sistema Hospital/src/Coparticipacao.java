
public class Coparticipacao implements IPlanoDeSaude{
	private static double VALOR_BASE =150.00;
	@Override
	public double calcMensalidade(int idade) {
		if(idade>=45&&idade<55) {
			return VALOR_BASE*1.15;
		}
		else 
			if(idade>=55&&idade<=65) {
				return VALOR_BASE*1.25;
			}
			else
				if(idade>65) {
					return VALOR_BASE*1.40;
				}
		return VALOR_BASE;
	}

	@Override
	public double coparticipacao() {
		// TODO Auto-generated method stub
		return 0.30;
	}

	
}
