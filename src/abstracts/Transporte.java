package abstracts;

public abstract class Transporte {
    private String id;
    private double capacidadeCarga; // em kg
    private String status;

    public Transporte(String id, double capacidadeCarga) {
        this.id = id;
        this.capacidadeCarga = capacidadeCarga;
        this.status = "DISPONIVEL";
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public double getCapacidadeCarga() {
        return capacidadeCarga;
    }

    public void setCapacidadeCarga(double capacidadeCarga) {
        this.capacidadeCarga = capacidadeCarga;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * Método abstrato para calcular o tempo estimado de chegada.
     * Deve ser implementado pelas classes filhas de acordo com suas características (ex: Drone vs Caminhão).
     * @param distancia em km
     * @return tempo estimado em horas
     */
    public abstract double calcularTempoEstimado(double distancia);

    @Override
    public String toString() {
        return "Transporte [id=" + id + ", capacidadeCarga=" + capacidadeCarga + "kg, status=" + status + "]";
    }
}
