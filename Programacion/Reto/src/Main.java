import Excepciones.*;

import javax.swing.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    private static String todosLosDias = "";

    public static void main(String[] args) {
        JOptionPane.showMessageDialog(null, "CONSULTORIA E-SPORT");
        try {
            int continuar;
            do {
                String equipo = solicitarEquipo();
                String jugador = solicitarJugador();

                todosLosDias += equipo + "\n" + jugador + "\n\n";

                continuar = JOptionPane.showConfirmDialog(null, "¿Quieres introducir otro equipo?");
            } while (continuar == 0);

            JOptionPane.showMessageDialog(null, todosLosDias);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERROR." + e.getMessage());
        }
    }

    private static String solicitarJugador() throws Exception{
        String nombre = solicitarNombre();
        String apellido = solicitarApellido();
        String nacionalidad = solicitarNacionalidad();
        LocalDate fechaNacimiento = solicitarFechaNacimiento("nacimiento");
        String nickname = solicitarNickName();
        String rol = solicitarRol();
        double sueldo = solicitarSueldo();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        /*JOptionPane.showMessageDialog(null, "JUGADOR\n" +
                "Nombre: " + nombre + " " + apellido +
                "\nNacionalidad: " + nacionalidad +
                "\nFecha de nacimiento: " + fechaNacimiento.format(formatter) +
                "\nNickname: " + nickname +
                "\nRol: " + rol +
                "\nSueldo: " + sueldo + " €");*/
        return "Jugador:" + nombre + " " + apellido +
                "\nNacionalidad: " + nacionalidad +
                "\nFecha de nacimiento: " + fechaNacimiento.format(formatter) +
                "\nNickname: " + nickname +
                "\nRol: " + rol +
                "\nSueldo: " + sueldo + " €";

    }

    private static String solicitarNombre() throws Exception {
        boolean error = true;
        String nombre = "";

        do {
            try {
                nombre = JOptionPane.showInputDialog(null, "Introduce el nombre del jugador");

                if (nombre.isEmpty())
                    throw new DatoNoValidoException();

                Pattern pat = Pattern.compile("^[A-Za-zÁÉÍÓÚáéíóúüÜñÑ ]+$");
                Matcher mat = pat.matcher(nombre);
                if (!mat.matches())
                    throw new DatoNoValidoException();
                error = false;

            } catch (DatoNoValidoException | NullPointerException e) {
                JOptionPane.showMessageDialog(null, "El nombre del jugador no puede contener números ni estar vacío.");
            }
        } while (error);
        return nombre.trim();
    }

    public static String solicitarApellido() throws Exception {
        boolean error = true;
        String apellido = "";
        do {
            try {
                apellido = JOptionPane.showInputDialog("Introduce el apellido del jugador:");

                if (apellido.isEmpty())
                    throw new DatoNoValidoException();

                Pattern pat = Pattern.compile("^[A-Za-zÁÉÍÓÚáéíóúüÜñÑ ]+$");
                Matcher mat = pat.matcher(apellido);

                if (!mat.matches()) throw new DatoNoValidoException();
                error = false;

            } catch (DatoNoValidoException | NullPointerException e) {
                JOptionPane.showMessageDialog(null, "El apellido no puede contener números ni estar vacío.");
            }

        } while (error);
        return apellido.trim();
    }

    public static String solicitarNacionalidad() throws Exception {
        boolean error = true;
        String nacionalidad = "";
        do {
            try {
                nacionalidad = JOptionPane.showInputDialog("Introduce la nacionalidad del jugador:");

                if (nacionalidad.isEmpty())
                    throw new DatoNoValidoException();

                Pattern pat = Pattern.compile("^[A-Za-zÁÉÍÓÚáéíóúüÜñÑ ]+$");
                Matcher mat = pat.matcher(nacionalidad);

                if (!mat.matches())
                    throw new DatoNoValidoException();
                error = false;
            } catch (DatoNoValidoException | NullPointerException e) {
                JOptionPane.showMessageDialog(null, "La nacionalidad no puede contener números ni estar vacía.");
            }
        } while (error);
        return nacionalidad.trim();
    }

    public static LocalDate solicitarFechaNacimiento(String tipo) throws Exception {
        boolean error = true;
        LocalDate fecha = null;
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        do {
            try {
                String fecha1 = JOptionPane.showInputDialog("Introduce la fecha de " + tipo + " (dd/MM/yyyy):");
                Pattern pat = Pattern.compile("^\\d{2}/\\d{2}/\\d{4}$");
                Matcher mat = pat.matcher(fecha1);
                if (!mat.matches())
                    throw new FechaNoValidaException();
                fecha = LocalDate.parse(fecha1, formato);

                if (fecha.isAfter(LocalDate.now()))
                    throw new FechaNoValidaException();
                error = false;


            } catch (DateTimeParseException | FechaNoValidaException | NullPointerException e) {
                JOptionPane.showMessageDialog(null, "La fecha no es válida o es posterior a hoy.");
            }
        } while (error);
        return fecha;
    }

    public static String solicitarNickName() throws Exception {
        boolean error = true;
        String nickname = "";
        do {
            try {
                nickname = JOptionPane.showInputDialog("Introduce el nickname del jugador:");

                if (nickname.isEmpty())
                    throw new DatoNoValidoException();

                Pattern pat = Pattern.compile("^[A-Za-z0-9_]{0,10}$");
                Matcher mat = pat.matcher(nickname);
                if (!mat.matches())
                    throw new DatoNoValidoException();
                error = false;

            } catch (DatoNoValidoException | NullPointerException e) {
                JOptionPane.showMessageDialog(null, "El nickname no puede estar vacío.");
            }
        } while (error);
        return nickname.trim();
    }

    public static String solicitarRol() throws Exception {
        boolean error = true;
        String rol = "";
        do {
            try {
                rol = JOptionPane.showInputDialog("Introduce el rol del jugador:");

                if (rol.isEmpty())
                    throw new DatoNoValidoException();

                Pattern pat = Pattern.compile("^[A-Za-zÁÉÍÓÚáéíóúüÜñÑ ]+$");
                Matcher mat = pat.matcher(rol);

                if (!mat.matches())
                    throw new DatoNoValidoException();
                error = false;

            } catch (DatoNoValidoException | NullPointerException e) {
                JOptionPane.showMessageDialog(null, "El rol no puede contener números ni estar vacío.");
            }
        } while (error);
        return rol.trim();
    }

    public static double solicitarSueldo() throws Exception {
        boolean error = true;
        double sueldo = 0.0;
        double salarioMin = 1100.0;
        do {
            try {
                String texto = JOptionPane.showInputDialog("Introduce el sueldo del jugador (€):");
                sueldo = Double.parseDouble(texto);

                if (sueldo < salarioMin)
                    throw new DatoNoValidoException();
                error = false;
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "El sueldo debe ser un número válido.");

            } catch (DatoNoValidoException e) {
                JOptionPane.showMessageDialog(null, "El sueldo debe ser superior a " + salarioMin + " €.");
            }

        } while (error);
        return sueldo;
    }

    private static String solicitarEquipo() {
        String nombreEquipo = solictarNombreEquipo();
        LocalDate fechaFundacion = solicitarFecha();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        return "Equipo: " + nombreEquipo +
                "\nFecha de fundación: " + fechaFundacion.format(formatter);

        /*JOptionPane.showMessageDialog(null, "EQUIPO E-SPORT\n" +
                "Nombre del equipo: " + nombreEquipo +
                "\nFecha de fundación: " + fechaFundacion.format(formatter) );*/
    }

    private static String solictarNombreEquipo() {
        String nombreEquipo = "";
        boolean error = true;
        do {
            try {
                nombreEquipo = JOptionPane.showInputDialog("Introduce el nombre del equipo:");
                if (nombreEquipo.isEmpty())
                    throw new DatoNoValidoException();
                error = false;

                Pattern pat = Pattern.compile("^[A-Za-zÁÉÍÓÚáéíóúüÜñÑ0-9'\\- ]+$");
                Matcher mat = pat.matcher(nombreEquipo);

            } catch (DatoNoValidoException e) {
                JOptionPane.showMessageDialog(null, "ERROR. Intente de nuevo");
            }
        } while (error);
        return nombreEquipo.trim();
    }

    private static  LocalDate solicitarFecha() {
        boolean error = true;
        LocalDate fecha = null;
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        do {
            try {
                String fecha1 = JOptionPane.showInputDialog(
                        "Introduce la fecha de fundación del equipo (dd/MM/yyyy):");

                Pattern pat = Pattern.compile("^\\d{2}/\\d{2}/\\d{4}$");
                if (!pat.matcher(fecha1).matches())
                    throw new FechaNoValidaException();

                fecha = LocalDate.parse(fecha1, formato);

                if (fecha.isAfter(LocalDate.now()))
                    throw new FechaNoValidaException();

                error = false;
            } catch (FechaNoValidaException e) {
                JOptionPane.showMessageDialog(null, ("La fecha no es válida. Intente de nuevo poniendo una fecha válida"));
            }
        } while (error);
        return fecha;
    }
}