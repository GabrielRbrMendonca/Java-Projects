import java.time.LocalDate;

public class App {
    public static void main(String[] args) throws Exception {
    	Paciente p = new Paciente("Joao","01/01/2000");
    	//Completo c = new Completo();
    	Coparticipacao c = new Coparticipacao();
    	p.adicionarPlano(c);
    	Agendada a = new Agendada(LocalDate.of(2022, 12, 1),Especialidade.ALERGOLOGIA);
    	Agendada b = new Agendada(LocalDate.of(2022, 12, 2),Especialidade.ALERGOLOGIA);
    	p.addConsulta(a);
    	p.addConsulta(b);
    	System.out.println(p.historicoEspecialidade(Especialidade.ALERGOLOGIA));
    	System.out.println(p.historicoEspecialidade(Especialidade.NEUROLOGIA));
    }  
}
