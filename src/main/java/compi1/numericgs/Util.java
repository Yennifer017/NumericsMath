package compi1.numericgs;

import java.util.Scanner;

/**
 *
 * @author yennifer
 */
public class Util {

    private Scanner scanner;

    public Util() {
        scanner = new Scanner(System.in);
    }

    public double getNumber(String mss) {
        boolean lecturaValida;
        String lecturaConsola;
        double numeroIngresado = 0;

        System.out.print(mss + ": ");
        do {
            try {
                lecturaConsola = scanner.nextLine();
                numeroIngresado = Double.parseDouble(lecturaConsola);
                lecturaValida = true;
            } catch (NumberFormatException e) {
                System.out.println("Ingresa un numero valido: ");
                lecturaValida = false;
            }
        } while (!lecturaValida);
        return numeroIngresado;
    }
    
    public int getIntNumber(String mss) {
        boolean lecturaValida;
        String lecturaConsola;
        int numeroIngresado = 0;

        System.out.print(mss + ": ");
        do {
            try {
                lecturaConsola = scanner.nextLine();
                numeroIngresado = Integer.parseInt(lecturaConsola);
                lecturaValida = true;
            } catch (NumberFormatException e) {
                System.out.println("Ingresa un numero valido: ");
                lecturaValida = false;
            }
        } while (!lecturaValida);
        return numeroIngresado;
    }
}
