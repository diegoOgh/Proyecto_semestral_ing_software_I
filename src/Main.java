import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== SISTEMA DE GESTIÓN DE RETIROS ===\n");

        // 1. Crear Usuarios
        System.out.println("--- Creando Usuarios ---");
        Usuario usuario1 = new Usuario(1, "Juan Pérez", LocalDate.of(1990, 5, 15), 
                                       "12345678-9", "Calle Principal 123");
        Usuario usuario2 = new Usuario(2, "María García", LocalDate.of(1985, 8, 20), 
                                       "87654321-0", "Avenida Secundaria 456");
        System.out.println("✓ " + usuario1.getNombreCompleto() + " creado");
        System.out.println("✓ " + usuario2.getNombreCompleto() + " creado\n");

        // 2. Crear Retiros
        System.out.println("--- Creando Retiros ---");
        Retiro retiro1 = usuario1.solicitudRetiro("Plástico", 50.5f);
        Retiro retiro2 = usuario1.solicitudRetiro("Cartón", 30.0f);
        Retiro retiro3 = usuario2.solicitudRetiro("Vidrio", 20.0f);
        System.out.println("✓ Retiro 1 creado: " + retiro1);
        System.out.println("✓ Retiro 2 creado: " + retiro2);
        System.out.println("✓ Retiro 3 creado: " + retiro3 + "\n");

        // 3. Validar Retiros
        System.out.println("--- Validando Retiros ---");
        boolean valido1 = retiro1.validarRetiro("Calle Principal 123");
        boolean valido2 = retiro1.validarRetiro("Dirección incorrecta");
        System.out.println("Retiro 1 validado con dirección correcta: " + valido1);
        System.out.println("Retiro 1 validado con dirección incorrecta: " + valido2 + "\n");

        // 4. Crear Estados
        System.out.println("--- Asignando Estados ---");
        Estado estadoPendiente = new Estado("Pendiente");
        Estado estadoEnProceso = new Estado("En proceso");
        retiro1.setEstado(estadoPendiente);
        retiro2.setEstado(estadoPendiente);
        retiro3.setEstado(estadoEnProceso);
        System.out.println("✓ Retiro 1 estado: " + retiro1.getEstado().getEstado());
        System.out.println("✓ Retiro 2 estado: " + retiro2.getEstado().getEstado());
        System.out.println("✓ Retiro 3 estado: " + retiro3.getEstado().getEstado() + "\n");

        // 5. Crear Rutas
        System.out.println("--- Creando Rutas ---");
        Ruta ruta1 = new Ruta(1, "Zona Norte");
        Ruta ruta2 = new Ruta(2, "Zona Sur");
        System.out.println("✓ " + ruta1 + " creada");
        System.out.println("✓ " + ruta2 + " creada\n");

        // 6. Crear Paradarutas
        System.out.println("--- Creando Paradarutas ---");
        Paradaruta paradaruta1 = new Paradaruta(1);
        Paradaruta paradaruta2 = new Paradaruta(2);
        Paradaruta paradaruta3 = new Paradaruta(1);
        System.out.println("✓ " + paradaruta1 + " creada");
        System.out.println("✓ " + paradaruta2 + " creada");
        System.out.println("✓ " + paradaruta3 + " creada\n");

        // 7. Asociar Retiros con Paradarutas (Navegabilidad Bidireccional)
        System.out.println("--- Asociando Retiros con Paradarutas (Bidireccional) ---");
        retiro1.asignarParadaruta(paradaruta1);
        retiro2.asignarParadaruta(paradaruta2);
        retiro3.asignarParadaruta(paradaruta3);
        System.out.println("✓ Retiro 1 ↔ Paradaruta 1");
        System.out.println("  - Retiro ve Paradaruta: " + (retiro1.getParadaruta() != null));
        System.out.println("  - Paradaruta ve Retiro: " + (paradaruta1.getRetiro() != null) + "\n");

        // 8. Asociar Paradarutas con Rutas (Navegabilidad Bidireccional)
        System.out.println("--- Asociando Paradarutas con Rutas (Bidireccional) ---");
        paradaruta1.asignarRuta(ruta1);
        paradaruta2.asignarRuta(ruta1);
        paradaruta3.asignarRuta(ruta2);
        System.out.println("✓ Paradaruta 1 ↔ Ruta 1");
        System.out.println("  - Paradaruta ve Ruta: " + (paradaruta1.getRuta() != null));
        System.out.println("  - Ruta contiene Paradaruta: " + ruta1.getParadarutas().contains(paradaruta1) + "\n");

        // 9. Crear Trabajadores (Recolector y Coordinador)
        System.out.println("--- Creando Trabajadores ---");
        Recolector recolector1 = new Recolector(101, "Carlos López", LocalDate.of(1992, 3, 10), 
                                                "11111111-1");
        Recolector recolector2 = new Recolector(102, "Ana Martínez", LocalDate.of(1995, 7, 25), 
                                                "22222222-2");
        CoordinadorRuta coordinador1 = new CoordinadorRuta(201, "Pedro Rodríguez", 
                                                           LocalDate.of(1988, 1, 5), "33333333-3");
        System.out.println("✓ " + recolector1.getNombreCompleto() + " (Recolector) creado");
        System.out.println("✓ " + recolector2.getNombreCompleto() + " (Recolector) creado");
        System.out.println("✓ " + coordinador1.getNombreCompleto() + " (Coordinador) creado\n");

        // 10. Asignar Rutas a Recolectores (Navegabilidad Bidireccional)
        System.out.println("--- Asignando Rutas a Recolectores (Bidireccional) ---");
        recolector1.asignarRuta(ruta1);
        recolector2.asignarRuta(ruta2);
        System.out.println("✓ Ruta 1 asignada a " + recolector1.getNombreCompleto());
        System.out.println("  - Recolector ve Ruta: " + (recolector1.getRuta() != null));
        System.out.println("  - Ruta ve Recolector: " + (ruta1.getTrabajador() != null) + "\n");

        // 11. Asignar Rutas a Coordinador (Navegabilidad Bidireccional)
        System.out.println("--- Asignando Rutas a Coordinador (Bidireccional) ---");
        coordinador1.asignarRuta(ruta1);
        coordinador1.asignarRuta(ruta2);
        System.out.println("✓ Rutas asignadas a " + coordinador1.getNombreCompleto());
        System.out.println("  - Coordinador gestiona " + coordinador1.getRutas().size() + " rutas");
        System.out.println("  - Ruta 1 ve Coordinador: " + (ruta1.getCoordinador() != null) + "\n");

        // 12. Solicitud de Rutas - Recolector
        System.out.println("--- Solicitud de Rutas (Recolector) ---");
        recolector1.solicitudRuta(101); // Ve sus propias rutas
        recolector1.solicitudRuta(102); // Intenta ver rutas de otro
        System.out.println();

        // 13. Solicitud de Rutas - Coordinador
        System.out.println("--- Solicitud de Rutas (Coordinador) ---");
        coordinador1.solicitudRuta(201); // Ve sus propias rutas
        coordinador1.solicitudRuta(101); // Intenta ver rutas de otro trabajador
        System.out.println();

        // 14. Editar Punto de Recolección
        System.out.println("--- Editando Retiro (Demo sin interactividad) ---");
        System.out.println("Retiro a editar: " + retiro1);
        System.out.println("Estado actual: " + retiro1.getEstado().getEstado());
        System.out.println("Paradaruta asociada: " + (retiro1.getParadaruta() != null ? retiro1.getParadaruta().getId() : "Ninguna") + "\n");

        // Cambiar estado
        System.out.println(">>> Cambiando estado a 'Completado'");
        coordinador1.cambiarEstadoRetiro(retiro1, "Completado");
        System.out.println("Estado nuevo: " + retiro1.getEstado().getEstado() + "\n");

        // Eliminar paradaruta
        System.out.println(">>> Eliminando Paradaruta");
        coordinador1.eliminarParadaruta(retiro1, paradaruta1);
        System.out.println("Paradaruta después de eliminar: " + (retiro1.getParadaruta() != null ? retiro1.getParadaruta().getId() : "Ninguna"));
        System.out.println("Bidireccional verificado - Paradaruta ve Retiro: " + (paradaruta1.getRetiro() != null ? paradaruta1.getRetiro().getIdRetiro() : "Ninguno") + "\n");

        // 15. Resumen Final
        System.out.println("=== RESUMEN FINAL ===");
        System.out.println("Total Usuarios: 2");
        System.out.println("Total Retiros: 3");
        System.out.println("Total Rutas: 2");
        System.out.println("Total Paradarutas: 3");
        System.out.println("Total Recolectores: 2");
        System.out.println("Total Coordinadores: 1");
        System.out.println("\n✓ PRUEBA COMPLETADA EXITOSAMENTE");
    }
}