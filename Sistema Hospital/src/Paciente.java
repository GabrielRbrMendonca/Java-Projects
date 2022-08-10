import java.time.LocalDate;
import java.time.Period;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;


public class Paciente {

    public String nome;
    private Map<LocalDate, Consulta> consultas;
    private IPlanoDeSaude plano;
    private LocalDate dataNascimento;
    
    public Paciente(String nome, String dataString){
        this.nome = nome;
        String[] dadosData = dataString.split("/");
        int dia = Integer.parseInt(dadosData[0]);
        int mes = Integer.parseInt(dadosData[1]);
        int ano = Integer.parseInt(dadosData[2]);
        
        this.dataNascimento = LocalDate.of(ano, mes, dia);
        this.plano = null;
        this.consultas = new HashMap<LocalDate, Consulta>();
    }

    

    private int idade(){
        return Period.between(this.dataNascimento, LocalDate.now()).getYears();
    }



	public void adicionarPlano(IPlanoDeSaude planoCopart) {
		this.plano=planoCopart;
		
	}



	public void addConsulta(Consulta c) {
		c.valorPago= calcularValorConsulta(c);
		this.consultas.put(c.data, c); //correção feita
		
	}

	public double calcularValorConsulta(Consulta c) {
		return c.valorAPagar()*this.plano.coparticipacao(); //correcao feita	
	}

	public double calcularMensalidade() {		
		return this.plano.calcMensalidade(this.idade());
	}


	public String historicoEspecialidade(Especialidade e) {
		String historico = "Historico para especialidade "+e.toString()+":";
		int count=0;
		for(Entry<LocalDate, Consulta> aux : this.consultas.entrySet()) {
			LocalDate chave = aux.getKey();
		    Consulta consulta = aux.getValue();
		    if(consulta.especialidade==e) {
		    	historico=historico+"\n"+consultas.get(chave).toString();
		    	count=count+1;
		    }
		}
		if(count>0) {
			return historico;
		}
		else {
			return historico+"\n Não foram feitas consultas nesta especialidade";
		}
	}
	

    
}
