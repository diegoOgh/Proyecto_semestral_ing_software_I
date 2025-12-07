public class Retiro {
    private static int contadorId = 1;
    private int idRetiro;
    private String tipoMaterial;
    private float kgMaterial;
    private Usuario usuario;
    private Paradaruta paradaruta;
    private Estado estado;

    public Retiro(String tipoMaterial, float kgMaterial, Usuario usuario) {
        this.idRetiro = contadorId++;
        this.tipoMaterial = tipoMaterial;
        this.kgMaterial = kgMaterial;
        this.usuario = usuario;
    }

    public boolean validarRetiro(String direccion) {
        return direccion != null && !direccion.isEmpty() && 
               this.usuario.getDireccion().equals(direccion);
    }

    public void asignarParadaruta(Paradaruta paradaruta) {
        // Desasociar la paradaruta anterior si existe
        if (this.paradaruta != null && this.paradaruta != paradaruta) {
            Paradaruta anterior = this.paradaruta;
            this.paradaruta = null;
            if (anterior.getRetiro() == this) {
                anterior.setRetiro(null);
            }
        }

        // Asociar la nueva paradaruta
        this.paradaruta = paradaruta;
        if (paradaruta != null && paradaruta.getRetiro() != this) {
            paradaruta.setRetiro(this);
        }
    }

    

    // Getters y Setters
    public int getIdRetiro() { return idRetiro; }

    public String getTipoMaterial() { return tipoMaterial; }
    public void setTipoMaterial(String tipoMaterial) { this.tipoMaterial = tipoMaterial; }

    public float getKgMaterial() { return kgMaterial; }
    public void setKgMaterial(float kgMaterial) { this.kgMaterial = kgMaterial; }

    public Usuario getUsuario() { return usuario; }
    public void setUsuario(Usuario usuario) { this.usuario = usuario; }

    public Paradaruta getParadaruta() { return paradaruta; }
    public void setParadaruta(Paradaruta paradaruta) {
        asignarParadaruta(paradaruta);
    }
    
    public Estado getEstado() { return estado; }
    public void setEstado(Estado estado) { this.estado = estado; }

    @Override
    public String toString() {
        return "Retiro{" +
                "idRetiro=" + idRetiro +
                ", tipoMaterial='" + tipoMaterial + '\'' +
                ", kgMaterial=" + kgMaterial +
                '}';
    }
}