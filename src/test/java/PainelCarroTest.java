import org.*;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PainelCarroTest {

    @Test
    void deveNotificarUmPainel() {
        Carro carro = new Carro("Honda", "Civic", 2020);
        PainelCarro painel = new PainelCarro("Painel 1");
        painel.conectar(carro);
        carro.realizarManutencao();
        assertEquals("Painel 1 recebeu alerta: manutenção realizada no Carro{marca='Honda', modelo='Civic', ano=2020}", painel.getUltimaNotificacao());
    }

    @Test
    void deveNotificarVariosPaineis() {
        Carro carro = new Carro("Honda", "Civic", 2020);
        PainelCarro painel1 = new PainelCarro("Painel 1");
        PainelCarro painel2 = new PainelCarro("Painel 2");
        painel1.conectar(carro);
        painel2.conectar(carro);
        carro.realizarManutencao();
        assertEquals("Painel 1 recebeu alerta: manutenção realizada no Carro{marca='Honda', modelo='Civic', ano=2020}", painel1.getUltimaNotificacao());
        assertEquals("Painel 2 recebeu alerta: manutenção realizada no Carro{marca='Honda', modelo='Civic', ano=2020}", painel2.getUltimaNotificacao());
    }

    @Test
    void naoDeveNotificarPainelNaoConectado() {
        Carro carro = new Carro("Honda", "Civic", 2020);
        PainelCarro painel = new PainelCarro("Painel 1");
        carro.realizarManutencao();
        assertEquals(null, painel.getUltimaNotificacao());
    }

    @Test
    void deveNotificarPainelDoCarroCorreto() {
        Carro carroA = new Carro("Honda", "Civic", 2020);
        Carro carroB = new Carro("Toyota", "Corolla", 2020);
        PainelCarro painelA = new PainelCarro("Painel A");
        PainelCarro painelB = new PainelCarro("Painel B");
        painelA.conectar(carroA);
        painelB.conectar(carroB);
        carroA.realizarManutencao();
        assertEquals("Painel A recebeu alerta: manutenção realizada no Carro{marca='Honda', modelo='Civic', ano=2020}", painelA.getUltimaNotificacao());
        assertEquals(null, painelB.getUltimaNotificacao());
    }
}