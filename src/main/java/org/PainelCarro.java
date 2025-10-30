package org;

import java.util.Observable;
import java.util.Observer;

public class PainelCarro implements Observer {

    private String nomePainel;
    private String ultimaNotificacao;

    public PainelCarro(String nomePainel) {
        this.nomePainel = nomePainel;
    }

    public String getUltimaNotificacao() {
        return this.ultimaNotificacao;
    }

    public void conectar(Carro carro) {
        carro.addObserver(this);
    }

    @Override
    public void update(Observable carro, Object arg1) {
        this.ultimaNotificacao = this.nomePainel + " recebeu alerta: manutenção realizada no " + carro.toString();
        // System.out.println(this.ultimaNotificacao);
    }
}
