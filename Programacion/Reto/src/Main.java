
import javax.swing.JOptionPane;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Main {
    static ArrayList<String> todosLosJugadores = new ArrayList<>();
    static ArrayList<String> todosLosEquipos = new ArrayList<>();
    public static void main(String[] args) {
        int opcion;
        do {
            String entrada = JOptionPane.showInputDialog(
                    "------- Introducir jugador o equipo nuevo --------\n"
                            + "1 - JUGADOR\n"
                            + "2 - EQUIPO\n"
                            + "3 - MOSTRAR JUGADORES\n"
                            + "4 - MOSTRAR EQUIPOS\n"
                            + "5 - SALIR\n"
                            + "Introduce una opción: "
            );

            if (entrada == null) {
                JOptionPane.showMessageDialog(null, "Saliendo del programa.");
                break;
            }

            try{
                opcion = Integer.parseInt(entrada);

                switch (opcion) {
                    case 1:
                        jugador();
                        break;
                    case 2:
                        equipo();
                        break;
                    case 3:
                        mostrarJugadores();
                        break;
                    case 4:
                        mostrarEquipos();
                        break;
                    case 5:
                        JOptionPane.showMessageDialog(null,"saliendo del programa");
                        break;
                    default:
                        JOptionPane.showMessageDialog(null,"La opcion elegida no es valida ");
                        break;
                }
            }catch(NumberFormatException e){
                JOptionPane.showMessageDialog(null,"ERROR. La opcion no es valida ");
                opcion = 0;
            }
        }while(opcion!=5);
    }



    private static void jugador() {
        try {
            String nombreJugador;
            boolean nombreValido = false;
            do {
                nombreJugador = JOptionPane.showInputDialog(null, "Ingrese el nombre del JUGADOR");
                Pattern pt = Pattern.compile("^[A-Z]([a-z]+)$");
                Matcher mat = pt.matcher(nombreJugador);
                if (mat.matches()) {
                    JOptionPane.showMessageDialog(null, "Nombre Valido");
                    nombreValido = true;
                } else {
                    JOptionPane.showMessageDialog(null, "Nombre Invalido");
                    nombreValido = false;
                }
            } while (!nombreValido);

            String apellidoJugador;
            boolean apellidoValido = false;
            do {
                apellidoJugador = JOptionPane.showInputDialog(null, "Ingrese el Apellido del JUGADOR");
                Pattern pt = Pattern.compile("^[A-Z]([a-z]+)( [A-Za-z][a-z]+)*$");
                Matcher mat = pt.matcher(apellidoJugador);
                if (mat.matches()) {
                    JOptionPane.showMessageDialog(null, "Apellido Valido");
                    apellidoValido = true;
                } else {
                    JOptionPane.showMessageDialog(null, "Apellido Invalido");
                    apellidoValido = false;
                }
            } while (!apellidoValido);

            String nickname;
            boolean nicknameValido = false;
            do {
                nickname = JOptionPane.showInputDialog(null, "Ingrese el nickname JUGADOR");
                Pattern pt = Pattern.compile("^[A-Za-z0-9áéíóúÁÉÍÓÚ@_!$_><.*?¿/·#,; -]+$");
                Matcher mat = pt.matcher(nickname);
                if (mat.matches()) {
                    JOptionPane.showMessageDialog(null, "Nickname Valido");
                    nicknameValido = true;
                }else  {
                    JOptionPane.showMessageDialog(null, "Nickname Invalido");
                    nicknameValido = false;
                }
            }while(!nicknameValido);


            int edad;
            LocalDate fechaNacimiento = null;
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            boolean fechaValida = false;
            do {
                do {
                    String input = JOptionPane.showInputDialog(null, "Ingrese la fecha de nacimiento en fotrmato dd/MM/yyyy");
                    try {
                        fechaNacimiento = LocalDate.parse(input, formatter);
                        fechaValida = true;
                    } catch (DateTimeParseException e) {
                        JOptionPane.showMessageDialog(null, "ERROR. Datos introducidos no son validos");
                        fechaValida = false;
                    }
                } while (!fechaValida);
                JOptionPane.showMessageDialog(null, "fecha de nacimeinto del JUGADOR es de: " + fechaNacimiento);

                LocalDate fecha = LocalDate.now();
                Period periodo = Period.between(fechaNacimiento, fecha);
                edad = periodo.getYears();
                JOptionPane.showMessageDialog(null, "La Edad del JUGADOR es de: " + edad);
                if (edad > 18) {
                    JOptionPane.showMessageDialog(null, "Edad valida para jugar");
                } else {
                    JOptionPane.showMessageDialog(null, "debe de ser mayor de edad para jugar ");
                }

            } while (edad < 18);

            String nacionalidadjugador;
            boolean nacionalidadValida = false;
            do {
                nacionalidadjugador = JOptionPane.showInputDialog(null, "Ingrese la nacionalidad del JUGADOR");
                if(nacionalidadjugador.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Debe ingresar una nacionalidad");
                    nacionalidadValida = false;
                }else if(!nacionalidadjugador.matches("^[A-Za-záéíóúÁÉÍÓÚñÑ ]+$")){
                    JOptionPane.showMessageDialog(null, "ERROR: La nacionalidad solo puede contener letras");
                    nacionalidadValida = false;
                }else{
                    JOptionPane.showMessageDialog(null, "nacionalidad correcta");
                    nacionalidadValida = true;
                }
            }while(!nacionalidadValida);


            double sueldo = 0;
            boolean sueldoValida = false;
            do{
                try{
                    String input = JOptionPane.showInputDialog(null, "Ingrese el sueldo del JUGADOR");
                    sueldo = Double.parseDouble(input);
                    if (sueldo > 1184.0) {
                        JOptionPane.showMessageDialog(null, "Sueldo valido");
                        sueldoValida = true;
                    }else  {
                        JOptionPane.showMessageDialog(null, "Sueldo invalido");
                        sueldoValida = false;
                    }
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "ERROR. Sueldo Invalido");
                    sueldoValida = false;
                }
            }while(!sueldoValida);

            todosLosJugadores.add("Nombre: " + nombreJugador
                    + "\nApellido: " + apellidoJugador
                    + "\nNickname: " + nickname
                    + "\nFecha de Nacimiento: " + fechaNacimiento
                    + "\nEdad: " + edad
                    + "\nNacionalidad: " + nacionalidadjugador
                    + "\nSueldo: " + sueldo);
            JOptionPane.showMessageDialog(null, "Jugador añadido correctamente.");

        }catch(NullPointerException e){
            JOptionPane.showMessageDialog(null, "Saliendo del programa");
            System.exit(0);
        }
    }

    private static void equipo() {
        try {
            String nombreEquipo;
            boolean nombreEquipoValido = false;
            do {
                nombreEquipo = JOptionPane.showInputDialog(null, "Ingrese el nombre del EQUIPO");
                Pattern pt = Pattern.compile("^[A-Za-z0-9áéíóúÁÉÍÓÚ@#_'!$ ]+$");
                Matcher mat = pt.matcher(nombreEquipo);
                if (mat.matches()) {
                    JOptionPane.showMessageDialog(null, "Nombre Valido");
                    nombreEquipoValido = true;
                } else {
                    JOptionPane.showMessageDialog(null, "Nombre Invalido");
                    nombreEquipoValido = false;
                }
            } while (!nombreEquipoValido);


            int numeroJugadores = 0;
            boolean numeroJugadoresValidos = false;
            do {
                String input = JOptionPane.showInputDialog(null, "Ingrese el numero de jugadores en el equipo");
                try {
                    numeroJugadores = Integer.parseInt(input);
                    if (numeroJugadores >= 2 && numeroJugadores <= 6) {
                        JOptionPane.showMessageDialog(null, "Numero de jugadores en el equipo es valido");
                        numeroJugadoresValidos = true;

                    } else {
                        JOptionPane.showMessageDialog(null, "Numero de jugadores en el equipo es invalido");
                        numeroJugadoresValidos = false;

                    }
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "ERROR. El valor introducido no es valido");
                    numeroJugadoresValidos = false;
                }
            } while (!numeroJugadoresValidos);

            LocalDate fechaCreacionEqupio = null;
            boolean fechaEquipoValida = false;
            do{
                try {
                    String input = JOptionPane.showInputDialog(null, "Ingrese la fecha de creacion del equipo: ");
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                    fechaCreacionEqupio = LocalDate.parse(input, formatter);
                    if (fechaCreacionEqupio.isBefore(LocalDate.now())) {
                        JOptionPane.showMessageDialog(null, "Fecha correctamente introducida");
                        fechaEquipoValida = true;
                    }else {
                        JOptionPane.showMessageDialog(null, "Fecha introducida de creacion no es valida");
                        fechaEquipoValida = false;
                    }
                }catch(DateTimeParseException e){
                    JOptionPane.showMessageDialog(null, "ERROR. Datos introducidos no son validos");
                    fechaEquipoValida = false;
                }
            }while(!fechaEquipoValida);

            todosLosEquipos.add("Nombre: " + nombreEquipo
                    + "\nNumero de jugadores en el equipo: " + numeroJugadores
                    + "\nFecha de creracion del equipo: " + fechaCreacionEqupio);
            JOptionPane.showMessageDialog(null, "Equipo añadido correctamente.");

        }catch (NullPointerException e){
            JOptionPane.showMessageDialog(null, "Saliendo del programa");
            System.exit(0);
        }
    }

    private static void mostrarJugadores() {

        if (todosLosJugadores.isEmpty()) {
            JOptionPane.showMessageDialog(null, "todavia no se han ingresado jugadores");
            return;
        }

        StringBuilder mensaje = new StringBuilder("Jugadores creados hasta ahora:\n");
        for (int i = 0; i < todosLosJugadores.size(); i++) {
            mensaje.append(i + 1).append(" - ").append(todosLosJugadores.get(i)).append("\n");
        }

        JOptionPane.showMessageDialog(null, mensaje.toString());
    }

    private static void mostrarEquipos() {
        if (todosLosEquipos.isEmpty()) {
            JOptionPane.showMessageDialog(null, "todavia no se han ingresado ningun equipo");
            return;
        }
        StringBuilder mensaje = new StringBuilder("Jugadores creados hasta ahora:\n");
        for (int i = 0; i < todosLosEquipos.size(); i++) {
            mensaje.append(i + 1).append(" - ").append(todosLosEquipos.get(i)).append("\n");
        }

        JOptionPane.showMessageDialog(null, mensaje.toString());
    }
}