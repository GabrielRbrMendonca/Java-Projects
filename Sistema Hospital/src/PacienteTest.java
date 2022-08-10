import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;




public class PacienteTest {

    
     Paciente pac;
     IPlanoDeSaude planoCompleto;
     IPlanoDeSaude planoCopart;

    @BeforeEach
    public void init(){
       pac = new Paciente("Teste", "26/01/1972");
       planoCopart = new Coparticipacao();
    }

   

    @Test
    @Order(1)
    public void valorConsultaNeuroCoparticipacao(){
        Consulta c = new Agendada(LocalDate.now(), Especialidade.NEUROLOGIA);
        pac.adicionarPlano(planoCopart);
        pac.addConsulta(c);
        assertEquals(120, c.valorPago, 0.1);
    }

    @Test
    @Order(2)
    public void valorMensalidadeCoparticipacao50Anos(){
        pac.adicionarPlano(planoCopart);
        assertEquals(172.5, pac.calcularMensalidade(), 0.1d);
    }

    

}
