import javax.swing.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    StringBuilder info;

    public static void main(String[] args) {

        solicitarEquipo();
        solicitarJugador();

    }

    public static String validarSolicitarDatos(String dato, String mensaje, String exprecionRegular) {

        boolean error;
        String var = "";

        do {
            try {

                var = JOptionPane.showInputDialog(mensaje);

                if (var.trim().isEmpty()){
                    throw new DatoNoValido(dato + " no puede estar vacio");
                }

                Pattern patron = Pattern.compile(exprecionRegular);
                Matcher mat = patron.matcher(var);

                if (!mat.matches()) {
                    throw new DatoNoValido(dato + " no tiene un formato valido");
                }
            }catch(Exception e) {
                error = true;
                JOptionPane.showMessageDialog(null,e.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
            }
            error = false;
        }while (error);

        return var;
    }

    public static void solicitarEquipo() {
        String nombre = validarSolicitarDatos("Nombre del equipo","Introduce el nombre del equipo","^[a-zA-Z]+[a-zA-Z0-9]*$]$");
        LocalDate fechaFundacion = solicitarValidarFechas("Fecha de fundacion del equipo","Indica la fecha de fundacion del equipo (DD/MM/YYYY)");
        int numJugadores = Integer.parseInt(validarSolicitarDatos("Numero de jugadores","Indica el numero de jugadores que tiene el equipo (6 como maximo)","^[0-6]$"));
    }

    public static LocalDate solicitarValidarFechas(String dato, String mensaje) {

        String var = "";
        boolean error;
        DateTimeFormatter formatoFecha = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate fecha = null;

        do {
            try {
                var = JOptionPane.showInputDialog(mensaje);
                if (var.trim().isEmpty()){
                    throw new DatoNoValido("La " + dato + " no puede estar vacia");
                }

                fecha = LocalDate.parse(var,formatoFecha);

            }catch(DateTimeParseException e) {
                error = true;
                JOptionPane.showMessageDialog(null,"La fecha no tiene un formato valido.","Error",JOptionPane.ERROR_MESSAGE);
            } catch (DatoNoValido e) {
                error = true;
                throw new RuntimeException(e);
            }
            error = false;
        }while (error);

        return fecha;

    }

    public static void solicitarJugador() {
        String nombre = validarSolicitarDatos("Nombre","Introduce el nombre del jugador","");
        String apellido = validarSolicitarDatos("Apellido","Introduce el apellido del jugador","");
        String nacionalidad = validarSolicitarDatos("Nombre","Introduce la nacionalidad del jugador","");
        String nickName = validarSolicitarDatos("NickName","Introduce el nickName del jugador","");
        String rol = validarSolicitarDatos("Rol","Introduce el rol del jugador","");
        double sueldo = validarSueldo("Sueldo","Introduce el sueldo del jugador","");
    }

    public static double validarSueldo(String dato, String mensaje, String exprecionRegular) {
        double sueldoMinimoInterpersonal = 1184;

        String var = "";
        boolean error;
        double sueldo = 0;

        do {
            try {

                var = JOptionPane.showInputDialog(mensaje);

                if (var.trim().isEmpty()){
                    throw new DatoNoValido(dato + " no puede estar vacio");
                }

                Pattern patron = Pattern.compile(exprecionRegular);
                Matcher mat = patron.matcher(var);

                if (!mat.matches()) {
                    throw new DatoNoValido(dato + " no tienene un formato valido");
                }

                sueldo = Double.parseDouble(var);

                if (sueldo < sueldoMinimoInterpersonal) {
                    throw new DatoNoValido(dato + " no puede ser menor que el Salario Mínimo Interprofesional (1184€)");
                }

            }catch (Exception e) {
                error = true;
                JOptionPane.showMessageDialog(null,e.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
            }
            error = false;
        }while (error);

        return sueldo;

    }

}