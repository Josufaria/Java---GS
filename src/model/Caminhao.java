package model;

import abstracts.Transporte;
import interfaces.Notificavel;
import interfaces.Rastreavel;

public class Caminhao extends Transporte implements Rastreavel, Notificavel {
    private String placa;
    private double velocidadeMedia = 80.0; // km/h

    public Caminhao(String id, double capacidadeCarga, String placa) {
        super(id, capacidadeCarga);
        this.placa = placa;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    @Override
    public double calcularTempoEstimado(double distancia) {
        // Caminhão tem velocidade média de 80 km/h e precisa de pausas
        double tempo = distancia / velocidadeMedia;
        // Adiciona 1 hora de pausa a cada 4 horas de viagem
        tempo += Math.floor(tempo / 4.0);
        return tempo;
    }

    @Override
    public String obterLocalizacaoAtual() {
        return "Caminhão placa " + placa + " (ID: " + getId() + ") - Localização: Rodovia Principal, km 120";
    }

    @Override
    public void enviarNotificacao(String mensagem) {
        System.out.println("[NOTIFICAÇÃO CAMINHÃO " + placa + "]: " + mensagem);
    }

    @Override
    public String toString() {
        return "Caminhao [" + super.toString() + ", placa=" + placa + "]";
    }
}
