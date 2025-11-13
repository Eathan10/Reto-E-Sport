import javax.swing.*;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


public class Main {
    //Datos jugador//
    static String nombre;
    static String apellido;
    static String nacionalidad;
    static String fechaInput;
    static String fechaInput2;
    static LocalDate fechaDeNacimiento;
    static String nickname;
    static String rol;
    static double sueldo;

    //Datos equipo//
    static String nombreEquipo;
    static LocalDate fechaFundacion;
    static int numJugadores;


    static DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    static String continuar;


    public static void main(String[] args) {

        obtenerDatosEquipos();
        obtenerDatosJugadores();
    }

    public static void obtenerDatosEquipos() {

    do {
        obtenerNombreEquipo();
        obtenerFechaFundacion();
        obtenerNumJugadores();

        continuar = JOptionPane.showInputDialog("¿DESEA INTRODUCIR OTRO EQUIPO?");
    }while(continuar.equalsIgnoreCase("SI"));

    }


    //maximo 6 y minimo 2 jugadores//
    public static void obtenerDatosJugadores() {




        for (int i = 0; i < numJugadores; i++) {


            JOptionPane.showMessageDialog(null, "A CONTINUACIÓN INDIQUE LA INFORMACIÓN DEL JUGADOR:");

            obtenerNombre();
            obtenerApellido();
            obtenerNacionalidad();
            obtenerFechaDeNacimiento();
            obtenerNickname();
            obtenerRol();
            obtenerSalario();

        }
    }





    //////////////////DATOS EQUIPOS/////////////////////////////

    public static void obtenerNombreEquipo() {

        if (nombreEquipo.isEmpty()){
            throw new RuntimeException("El nombre no puede estar vacio");
        }
        nombreEquipo = JOptionPane.showInputDialog("Ingrese el nombre del equipo");

    }

    public static void obtenerFechaFundacion() {

        try {
            fechaInput2 = JOptionPane.showInputDialog("Ingrese la fecha de nacimiento");
            fechaFundacion = LocalDate.parse(fechaInput2, formato);
        }catch (DateTimeException e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }


    public static void obtenerNumJugadores(){

        do {
            try {
                numJugadores = Integer.parseInt(JOptionPane.showInputDialog("Ingrese una cantidad de jugadores (MÍNIMO 2 MÁXIMO 6"));
            }catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
        } while (2 >= numJugadores | numJugadores >= 6);

    }



    //////////////////DATOS JUGADORES//////////////////////////

    public static void obtenerNombre() {

        try{
            nombre = JOptionPane.showInputDialog("Ingrese el nombre del jugador:");
        } catch (Exception e){
            JOptionPane.showMessageDialog(null, "Introduzca un nombre valido");
        }
    }

    public static void obtenerApellido() {

        try{
            apellido = JOptionPane.showInputDialog("Ingrese el apellido del jugador:");
        } catch (Exception e){
            JOptionPane.showMessageDialog(null, "Introduzca un apellido valido");
        }
    }

    public static void obtenerNacionalidad() {

        try{
            nacionalidad = JOptionPane.showInputDialog("Ingrese el nacionalidad del jugador:");
        } catch (Exception e){
            JOptionPane.showMessageDialog(null, "Introduzca una nacionalidad valida");
        }
    }


    public static void obtenerFechaDeNacimiento() {
        try{
            fechaInput = JOptionPane.showInputDialog("Ingrese la fecha de nacimiento (dd/MM/yyyy)");
            fechaDeNacimiento = LocalDate.parse(fechaInput, formato);

        } catch (DateTimeException a){
            JOptionPane.showMessageDialog(null, a.getMessage());
        }
    }

    public static void obtenerNickname() {

        try{
            nickname = JOptionPane.showInputDialog("Ingrese el nickname del jugador:");
        } catch (Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    public static void obtenerRol(){

        try{
            rol = JOptionPane.showInputDialog("Ingrese el rol del jugador:");
        } catch (Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }



    public static void obtenerSalario() {
        do {
            try {
                sueldo = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el sueldo del jugador:"));
                if (sueldo < 1.184) {
                    JOptionPane.showMessageDialog(null, "ERROR: EL SUELDO DEBE SER SUPERIOR AL SMI (1.184)");
                }

            } catch (NumberFormatException e) {

                JOptionPane.showMessageDialog(null, "Introduce un numero correcto");
                sueldo = 0;
            }

        } while (sueldo > 1.184);

    }



};

