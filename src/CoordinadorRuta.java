import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class CoordinadorRuta extends Trabajador {
    private List<Ruta> rutas; // 1:* con Ruta

    public CoordinadorRuta(int idTrabajador, String nombreCompleto, LocalDate fechaNacimiento, String rut) {
        super(idTrabajador, nombreCompleto, fechaNacimiento, rut);
        this.rutas = new ArrayList<>();
    }

    @Override
    public List<Ruta> solicitudRuta(int idTrabajador) {
        if (this.idTrabajador == idTrabajador) {
            System.out.println("Coordinador " + this.nombreCompleto + " - Viendo sus propias rutas: " + this.rutas.size());
            return new ArrayList<>(this.rutas);
        } else {
            System.out.println("Coordinador " + this.nombreCompleto + " - Buscando rutas del trabajador: " + idTrabajador);
            // Aquí iría lógica para buscar rutas de otro trabajador en una BD o gestor
            return new ArrayList<>();
        }
    }

    @Override
    protected List<Ruta> obtenerRutasAsociadas() {
        return new ArrayList<>(this.rutas);
    }

    public void asignarRuta(Ruta ruta) {
        if (!this.rutas.contains(ruta)) {
            this.rutas.add(ruta);
            ruta.setCoordinador(this);
            System.out.println("Ruta asignada al Coordinador: " + this.nombreCompleto);
        }
    }
    
    public void editarPuntoRecoleccion(int idRetiro, Retiro retiro, CoordinadorRutaOperaciones operaciones) {
        if (retiro != null && retiro.getIdRetiro() == idRetiro) {
            System.out.println("=== Editando Retiro ID: " + idRetiro + " ===");
            System.out.println("Retiro actual: " + retiro);
            
            operaciones.mostrarOpcionesEdicion(retiro);
        } else {
            System.out.println("Error: Retiro con ID " + idRetiro + " no encontrado");
        }
    }

    
    public void eliminarParadaruta(Retiro retiro, Paradaruta paradaruta) {
        if (retiro.getParadaruta() != null && retiro.getParadaruta().equals(paradaruta)) {
            retiro.setParadaruta(null);
            System.out.println("Paradaruta eliminada del retiro ID: " + retiro.getIdRetiro());
        } else {
            System.out.println("Error: Paradaruta no asociada a este retiro");
        }
    }

    
    public void cambiarEstadoRetiro(Retiro retiro, String nuevoEstado) {
        if (retiro != null) {
            Estado estadoAnterior = retiro.getEstado();
            retiro.setEstado(new Estado(nuevoEstado));
            System.out.println("Estado del retiro ID " + retiro.getIdRetiro() + " cambiado de " + 
                             (estadoAnterior != null ? estadoAnterior.getEstado() : "Sin estado") + 
                             " a " + nuevoEstado);
        }
    }

    // Getters y Setters
    public List<Ruta> getRutas() { return rutas; }
    public void setRutas(List<Ruta> rutas) { this.rutas = rutas; }

    @Override
    public String toString() {
        return "CoordinadorRuta{" +
                "idTrabajador=" + idTrabajador +
                ", nombreCompleto='" + nombreCompleto + '\'' +
                ", rut='" + rut + '\'' +
                ", rutasAsignadas=" + rutas.size() +
                '}';
    }
}