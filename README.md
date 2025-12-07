# Proyecto_semestral_ing_software_I

Resumen
- Implementación Java basada en el diagrama de clases UML (Usuario, Retiro, Paradaruta, Ruta, Trabajador, Recolector, CoordinadorRuta, Estado).
- No requiere base de datos ni interfaz gráfica.

Estructura de carpetas
- src/                -> archivos fuente (.java)
- bin/                -> archivos compilados (.class) (se crea al compilar)

Requisitos
- JDK 11+ instalado (javac y java).
- Windows PowerShell o CMD.
- (Opcional) Visual Studio Code con "Extension Pack for Java".

Compilar y ejecutar
PowerShell (desde la raíz del proyecto):
```powershell
# Crear carpeta bin
New-Item -ItemType Directory -Force -Path .\bin

# Compilar todos los .java en src -> .class en bin
javac -d .\bin .\src\*.java

# Ejecutar Main (paquete por defecto)
java -cp .\bin Main
```

Ejecutar desde Visual Studio Code
1. Abrir la carpeta del proyecto en VS Code.
2. Instalar "Extension Pack for Java" (Microsoft).
3. Abrir `Main.java` y usar el botón Run o la paleta de comandos.