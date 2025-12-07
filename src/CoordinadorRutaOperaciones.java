import java.util.Scanner;

public class CoordinadorRutaOperaciones {
    private Scanner scanner;

    public CoordinadorRutaOperaciones() {
        this.scanner = new Scanner(System.in);
    }

    /**
     * Muestra un menú interactivo para editar un retiro
     */
    public void mostrarOpcionesEdicion(Retiro retiro) {
        boolean editando = true;
        
        while (editando) {
            System.out.println("\n--- Opciones de Edición ---");
            System.out.println("1. Ver detalles del retiro");
            System.out.println("2. Cambiar estado");
            System.out.println("3. Eliminar paradaruta");
            System.out.println("4. Ver paradaruta actual");
            System.out.println("5. Salir");
            System.out.print("Selecciona una opción: ");
            
            int opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar buffer
            
            switch (opcion) {
                case 1:
                    verDetallesRetiro(retiro);
                    break;
                case 2:
                    cambiarEstado(retiro);
                    break;
                case 3:
                    eliminarParadaruta(retiro);
                    break;
                case 4:
                    verParadaruta(retiro);
                    break;
                case 5:
                    editando = false;
                    System.out.println("Saliendo de edición...");
                    break;
                default:
                    System.out.println("Opción no válida");
            }
        }
    }

    private void verDetallesRetiro(Retiro retiro) {
        System.out.println("\n=== Detalles del Retiro ===");
        System.out.println("ID: " + retiro.getIdRetiro());
        System.out.println("Tipo de Material: " + retiro.getTipoMaterial());
        System.out.println("Kg Material: " + retiro.getKgMaterial());
        System.out.println("Usuario: " + retiro.getUsuario().getNombreCompleto());
        System.out.println("Estado: " + (retiro.getEstado() != null ? retiro.getEstado().getEstado() : "Sin estado"));
    }

    private void cambiarEstado(Retiro retiro) {
        System.out.print("Ingresa el nuevo estado (Pendiente/En proceso/Completado/Cancelado): ");
        String nuevoEstado = scanner.nextLine();
        retiro.setEstado(new Estado(nuevoEstado));
        System.out.println("✓ Estado actualizado a: " + nuevoEstado);
    }

    private void eliminarParadaruta(Retiro retiro) {
        if (retiro.getParadaruta() != null) {
            Paradaruta paradarutaEliminada = retiro.getParadaruta();
            retiro.setParadaruta(null);
            System.out.println("✓ Paradaruta eliminada: Orden " + paradarutaEliminada.getOrden());
        } else {
            System.out.println("! Este retiro no tiene paradaruta asociada");
        }
    }

    private void verParadaruta(Retiro retiro) {
        if (retiro.getParadaruta() != null) {
            Paradaruta p = retiro.getParadaruta();
            System.out.println("\n=== Paradaruta Asociada ===");
            System.out.println("ID: " + p.getId());
            System.out.println("Orden: " + p.getOrden());
            System.out.println("Ruta: " + (p.getRuta() != null ? p.getRuta().getIdRuta() : "Sin asignar"));
        } else {
            System.out.println("! Este retiro no tiene paradaruta asociada");
        }
    }

    public void cerrarScanner() {
        scanner.close();
    }
}