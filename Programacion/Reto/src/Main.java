import javax.swing.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {

        solicitarEquipo();
        solicitarJugador();

    }
    public static String validarSolicitarDatos(String dato, String mensaje, String expresionRegular) {
        boolean error;
        String var = "";

        do {
            error = false; // Inicializar error aquí
            try {
                var = JOptionPane.showInputDialog(mensaje);

                if (var == null) {
                    // El usuario presionó cancelar
                    System.exit(0);
                }

                if (var.trim().isEmpty()) {
                    throw new DatoNoValido(dato + " no puede estar vacio");
                }

                // Solo validar con regex si se proporciona una expresión regular
                if (!expresionRegular.isEmpty()) {
                    Pattern patron = Pattern.compile(expresionRegular);
                    Matcher mat = patron.matcher(var);

                    if (!mat.matches()) {
                        throw new DatoNoValido(dato + " no tiene un formato valido");
                    }
                }

            } catch (Exception e) {
                error = true;
                JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        } while (error);

        return var;
    }

    public static void solicitarEquipo() {
        String nombre = validarSolicitarDatos("Nombre del equipo", "Introduce el nombre del equipo", "^[a-zA-Z]+[a-zA-Z0-9]*$");
        LocalDate fechaFundacion = solicitarValidarFechas("Fecha de fundacion del equipo", "Indica la fecha de fundacion del equipo (DD/MM/YYYY)");
        int numJugadores = Integer.parseInt(validarSolicitarDatos("Numero de jugadores", "Indica el numero de jugadores que tiene el equipo (6 como maximo)", "^[0-6]$"));

        // Mostrar resultados (opcional)
        JOptionPane.showMessageDialog(null,
                "Equipo registrado:\n" +
                        "Nombre: " + nombre + "\n" +
                        "Fecha Fundación: " + fechaFundacion.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")) + "\n" +
                        "Número de Jugadores: " + numJugadores);
    }

    public static LocalDate solicitarValidarFechas(String dato, String mensaje) {
        String var = "";
        boolean error;
        DateTimeFormatter formatoFecha = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate fecha = null;

        do {
            error = false; // Inicializar error aquí
            try {
                var = JOptionPane.showInputDialog(mensaje);

                if (var == null) {
                    // El usuario presionó cancelar
                    System.exit(0);
                }

                if (var.trim().isEmpty()) {
                    throw new DatoNoValido("La " + dato + " no puede estar vacia");
                }

                fecha = LocalDate.parse(var, formatoFecha);

            } catch (DateTimeParseException e) {
                error = true;
                JOptionPane.showMessageDialog(null, "La fecha no tiene un formato valido. Use DD/MM/YYYY", "Error", JOptionPane.ERROR_MESSAGE);
            } catch (DatoNoValido e) {
                error = true;
                JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        } while (error);

        return fecha;
    }

    public static void solicitarJugador() {
        String nombre = validarSolicitarDatos("Nombre", "Introduce el nombre del jugador", "^[a-zA-ZáéíóúÁÉÍÓÚñÑ\\s]+$");
        String apellido = validarSolicitarDatos("Apellido", "Introduce el apellido del jugador", "^[a-zA-ZáéíóúÁÉÍÓÚñÑ\\s]+$");
        String nacionalidad = validarSolicitarDatos("Nacionalidad", "Introduce la nacionalidad del jugador", "^[a-zA-ZáéíóúÁÉÍÓÚñÑ\\s]+$");
        String nickName = validarSolicitarDatos("NickName", "Introduce el nickName del jugador", "^[a-zA-Z0-9_]+$");
        String rol = validarSolicitarDatos("Rol", "Introduce el rol del jugador", "^[a-zA-ZáéíóúÁÉÍÓÚñÑ\\s]+$");
        double sueldo = validarSueldo("Sueldo", "Introduce el sueldo del jugador");

        // Mostrar resultados (opcional)
        JOptionPane.showMessageDialog(null,
                "Jugador registrado:\n" +
                        "Nombre: " + nombre + "\n" +
                        "Apellido: " + apellido + "\n" +
                        "Nacionalidad: " + nacionalidad + "\n" +
                        "NickName: " + nickName + "\n" +
                        "Rol: " + rol + "\n" +
                        "Sueldo: " + sueldo + "€");
    }

    public static double validarSueldo(String dato, String mensaje) {
        double sueldoMinimoInterpersonal = 1184;
        String var = "";
        boolean error;
        double sueldo = 0;

        do {
            error = false; // Inicializar error aquí
            try {
                var = JOptionPane.showInputDialog(mensaje);

                if (var == null) {
                    // El usuario presionó cancelar
                    System.exit(0);
                }

                if (var.trim().isEmpty()) {
                    throw new DatoNoValido(dato + " no puede estar vacio");
                }

                sueldo = Double.parseDouble(var.replace(",", "."));

                if (sueldo < sueldoMinimoInterpersonal) {
                    throw new DatoNoValido(dato + " no puede ser menor que el Salario Mínimo Interprofesional (1184€)");
                }

            } catch (NumberFormatException e) {
                error = true;
                JOptionPane.showMessageDialog(null, dato + " debe ser un número válido", "Error", JOptionPane.ERROR_MESSAGE);
            } catch (DatoNoValido e) {
                error = true;
                JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            } catch (Exception e) {
                error = true;
                JOptionPane.showMessageDialog(null, "Error inesperado: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        } while (error);

        return sueldo;
    }
}
