public class Paradaruta {
    private static int contadorId = 1;
    private int id;
    private int orden;
    private Retiro retiro;
    private Ruta ruta;

    public Paradaruta(int orden) {
        this.id = contadorId++;
        this.orden = orden;
    }

    /**
     * Asigna un Retiro manteniendo la navegabilidad bidireccional.
     */
    public void asignarRetiro(Retiro retiro) {
        if (this.retiro != null && this.retiro != retiro) {
            Retiro anterior = this.retiro;
            this.retiro = null;
            if (anterior.getParadaruta() == this) {
                anterior.setParadaruta(null);
            }
        }
        this.retiro = retiro;
        if (retiro != null && retiro.getParadaruta() != this) {
            retiro.asignarParadaruta(this);
        }
    }

    /**
     * Asigna una Ruta manteniendo la navegabilidad bidireccional.
     */
    public void asignarRuta(Ruta ruta) {
        this.ruta = ruta;
        if (ruta != null && !ruta.getParadarutas().contains(this)) {
            ruta.agregarParadaruta(this);
        }
    }

    // Getters y Setters
    public int getId() { return id; }

    public int getOrden() { return orden; }
    public void setOrden(int orden) { this.orden = orden; }

    public Retiro getRetiro() { return retiro; }
    public void setRetiro(Retiro retiro) { asignarRetiro(retiro); }

    public Ruta getRuta() { return ruta; }
    public void setRuta(Ruta ruta) { asignarRuta(ruta); }

    @Override
    public String toString() {
        return "Paradaruta{" +
                "id=" + id +
                ", orden=" + orden +
                '}';
    }
}