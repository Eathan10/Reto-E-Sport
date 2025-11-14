import javax.swing.*;
import javax.swing.JOptionPane;
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        System.out.printf("Hello and welcome!");

        for (int i = 1; i <= 5; i++) {
            //TIP Press <shortcut actionId="Debug"/> to start debugging your code. We have set one <icon src="AllIcons.Debugger.Db_set_breakpoint"/> breakpoint
            // for you, but you can always add more by pressing <shortcut actionId="ToggleLineBreakpoint"/>.
            System.out.println("i = " + i);
            System.out.println("i = " + i);
        }
    }
}

class EquipoJugador {
    public static void main(String[] args) {
        String nombreEquipo = "";
        String ciudad = "";
        int anioFundacion = 0;
        String nombreJugador = "";
        int edad = 0;
        String posicion = "";

        do {
            nombreEquipo = JOptionPane.showInputDialog("Introduce el nombre del equipo:");
            if (nombreEquipo == null) return;
        } while (nombreEquipo.trim().isEmpty());

        do {
            ciudad = JOptionPane.showInputDialog("Introduce la ciudad del equipo:");
            if (ciudad == null) return;
        } while (ciudad.trim().isEmpty());

        boolean valido = false;
        do {
            try {
                anioFundacion = Integer.parseInt(JOptionPane.showInputDialog("Introduce el año de fundación del equipo:"));
                if (anioFundacion > 1850 && anioFundacion <= 2025) {
                    valido = true;
                } else {
                    JOptionPane.showMessageDialog(null, "El año debe estar entre 1850 y 2025.");
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Debes introducir un número válido.");
            }
        } while (!valido);
        do {
            nombreJugador = JOptionPane.showInputDialog("Introduce el nombre del jugador:");
            if (nombreJugador == null) return;
        } while (nombreJugador.trim().isEmpty());
        valido = false;
        do {
            try {
                edad = Integer.parseInt(JOptionPane.showInputDialog("Introduce la edad del jugador:"));
                if (edad > 0 && edad <= 50) {
                    valido = true;
                } else {
                    JOptionPane.showMessageDialog(null, "La edad debe estar entre 1 y 50 años.");
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Debes introducir un número válido.");
            }
        } while (!valido);
        do {
            posicion = JOptionPane.showInputDialog("Introduce la posición del jugador:");
            if (posicion == null) return;
        } while (posicion.trim().isEmpty());
        String mensaje = "DATOS DEL EQUIPO\n"
                + "Nombre: " + nombreEquipo + "\n"
                + "Ciudad: " + ciudad + "\n"
                + "Año de fundación: " + anioFundacion + "\n\n"
                + " DATOS DEL JUGADOR\n"
                + "Nombre: " + nombreJugador + "\n"
                + "Edad: " + edad + "\n"
                + "Posición: " + posicion;

        JOptionPane.showMessageDialog(null, mensaje);

    }
}