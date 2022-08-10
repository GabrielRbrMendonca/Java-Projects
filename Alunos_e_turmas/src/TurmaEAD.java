/*
 * 
 * Sistema de Turmas para matéria de programação modular.
 * 
 * @author Gabriel Ribeiro Mendonça
 *
 */

public class TurmaEAD extends TurmaAvaliativa{

	public TurmaEAD(int nivel, int dia, int turno) {
		super(nivel, dia, turno);
		
	}
	
	
	@Override
	public String codMaker(int nivel, int dia, int turno) {
		return super.codMaker(nivel, dia, turno) + "E";
	}
}
