package model;

import abstracts.Transporte;
import interfaces.Rastreavel;

public class Drone extends Transporte implements Rastreavel {
    private double altitudeMaxima;
    private double velocidadeMedia = 60.0; // km/h (linha reta)

    public Drone(String id, double capacidadeCarga, double altitudeMaxima) {
        super(id, capacidadeCarga);
        this.altitudeMaxima = altitudeMaxima;
    }

    public double getAltitudeMaxima() {
        return altitudeMaxima;
    }

    public void setAltitudeMaxima(double altitudeMaxima) {
        this.altitudeMaxima = altitudeMaxima;
    }

    @Override
    public double calcularTempoEstimado(double distancia) {
        // Drone vai em linha reta, sem pausas
        return distancia / velocidadeMedia;
    }

    @Override
    public String obterLocalizacaoAtual() {
        return "Drone ID " + getId() + " - Altitude: " + (altitudeMaxima * 0.8) + "m - Coordenadas: -23.5505, -46.6333";
    }

    @Override
    public String toString() {
        return "Drone [" + super.toString() + ", altitudeMaxima=" + altitudeMaxima + "m]";
    }
}
