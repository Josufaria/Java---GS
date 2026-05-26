package service;

import abstracts.Transporte;
import model.Entrega;
import java.util.ArrayList;
import java.util.List;

public class GerenciadorEntregas {
    private List<Transporte> transportes;
    private List<Entrega> entregas;

    public GerenciadorEntregas() {
        this.transportes = new ArrayList<>();
        this.entregas = new ArrayList<>();
    }

    public void cadastrarTransporte(Transporte t) {
        transportes.add(t);
        System.out.println("Transporte " + t.getId() + " cadastrado com sucesso.");
    }

    public Transporte buscarTransporteDisponivel() {
        for (Transporte t : transportes) {
            if (t.getStatus().equals("DISPONIVEL")) {
                return t;
            }
        }
        return null;
    }

    public void registrarEntrega(Entrega entrega) {
        entregas.add(entrega);
        entrega.iniciarEntrega();
    }

    public void listarTransportes() {
        if(transportes.isEmpty()) {
            System.out.println("Nenhum transporte cadastrado.");
            return;
        }
        System.out.println("--- Lista de Transportes ---");
        for (Transporte t : transportes) {
            System.out.println(t.toString());
        }
    }

    public void listarEntregas() {
        if(entregas.isEmpty()) {
            System.out.println("Nenhuma entrega registrada.");
            return;
        }
        System.out.println("--- Lista de Entregas ---");
        for (Entrega e : entregas) {
            System.out.println(e.exibirDetalhes());
            System.out.println("-------------------------");
        }
    }
}
