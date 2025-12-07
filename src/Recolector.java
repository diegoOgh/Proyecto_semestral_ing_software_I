import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Recolector extends Trabajador {
    private Ruta ruta; // 1:1 con Ruta

    public Recolector(int idTrabajador, String nombreCompleto, LocalDate fechaNacimiento, String rut) {
        super(idTrabajador, nombreCompleto, fechaNacimiento, rut);
        this.ruta = null;
    }

    @Override
    public List<Ruta> solicitudRuta(int idTrabajador) {
        if (this.idTrabajador == idTrabajador) {
            List<Ruta> misRutas = new ArrayList<>();
            if (this.ruta != null) {
                misRutas.add(this.ruta);
                System.out.println("Recolector " + this.nombreCompleto + " - Ruta asignada: " + this.ruta);
            } else {
                System.out.println("Recolector " + this.nombreCompleto + " - No tiene ruta asignada");
            }
            return misRutas;
        } else {
            System.out.println("Acceso denegado: Solo puedes ver tus propias rutas");
            return new ArrayList<>();
        }
    }

    @Override
    protected List<Ruta> obtenerRutasAsociadas() {
        List<Ruta> rutas = new ArrayList<>();
        if (this.ruta != null) {
            rutas.add(this.ruta);
        }
        return rutas;
    }

    public void asignarRuta(Ruta ruta) {
        this.ruta = ruta;
        ruta.setTrabajador(this);
        System.out.println("Ruta asignada al Recolector: " + this.nombreCompleto);
    }

    // Getters y Setters
    public Ruta getRuta() { return ruta; }
    public void setRuta(Ruta ruta) { this.ruta = ruta; }

    @Override
    public String toString() {
        return "Recolector{" +
                "idTrabajador=" + idTrabajador +
                ", nombreCompleto='" + nombreCompleto + '\'' +
                ", rut='" + rut + '\'' +
                ", ruta=" + (ruta != null ? ruta.getIdRuta() : "Sin asignar") +
                '}';
    }
}