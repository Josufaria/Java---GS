package model;

import abstracts.Transporte;

public class Entrega {
    private String codigo;
    private String origem;
    private String destino;
    private double distancia;
    private Transporte transporteAlocado;
    private boolean prioridade;

    // Construtor sem prioridade (sobrecarga)
    public Entrega(String codigo, String origem, String destino, double distancia, Transporte transporteAlocado) {
        this(codigo, origem, destino, distancia, transporteAlocado, false);
    }

    // Construtor completo com prioridade (sobrecarga)
    public Entrega(String codigo, String origem, String destino, double distancia, Transporte transporteAlocado, boolean prioridade) {
        this.codigo = codigo;
        this.origem = origem;
        this.destino = destino;
        this.distancia = distancia;
        this.transporteAlocado = transporteAlocado;
        this.prioridade = prioridade;
    }

    public void iniciarEntrega() {
        if(transporteAlocado != null) {
            transporteAlocado.setStatus("EM TRÂNSITO");
            System.out.println("Entrega " + codigo + " iniciada com o veículo " + transporteAlocado.getId() + ".");
            if (prioridade) {
                System.out.println(">> ATENÇÃO: Esta é uma entrega PRIORITÁRIA.");
            }
        } else {
            System.out.println("Erro: Não há transporte alocado para a entrega " + codigo);
        }
    }

    public String exibirDetalhes() {
        double tempo = transporteAlocado != null ? transporteAlocado.calcularTempoEstimado(distancia) : 0;
        return "Entrega: " + codigo + " | De: " + origem + " Para: " + destino + 
               " | Distância: " + distancia + "km\nTempo estimado: " + String.format("%.2f", tempo) + " horas" +
               "\nTransporte: " + (transporteAlocado != null ? transporteAlocado.toString() : "Nenhum");
    }

    public String getCodigo() {
        return codigo;
    }

    public Transporte getTransporteAlocado() {
        return transporteAlocado;
    }
}
