package org;

import java.util.Observable;

public class Carro extends Observable {

    private String marca;
    private String modelo;
    private Integer ano;

    public Carro(String marca, String modelo, Integer ano) {
        this.marca = marca;
        this.modelo = modelo;
        this.ano = ano;
    }

    public void realizarManutencao() {
        setChanged();
        notifyObservers();
    }

    @Override
    public String toString() {
        return "Carro{" +
                "marca='" + marca + '\'' +
                ", modelo='" + modelo + '\'' +
                ", ano=" + ano +
                '}';
    }
}
