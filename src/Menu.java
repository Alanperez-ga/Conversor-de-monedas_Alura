import java.util.Scanner;

public class Menu {

    public void imprimirMenu(){
        this.imprimirAsteriscos();
        System.out.println("\nSea bienvenido/a al conversor de moneda =)\n");
        System.out.println("1) Dólar => Peso argentino");
        System.out.println("2) Peso argentino => Dólar");
        System.out.println("3) Dólar => Real brasileño");
        System.out.println("4) Real brasileño => Dólar");
        System.out.println("5) Dólar => Peso colombiano");
        System.out.println("6) Peso colombiano => Dólar");
        System.out.println("7) Dólar => Peso chileno");
        System.out.println("8) Peso chileno => Dólar");
        System.out.println("9) Salir");
        System.out.println("Elija una opción válida");
        this.imprimirAsteriscos();
        System.out.println("");

    }

    public void imprimirCantidad(){
        System.out.println("Ingresa la cantidad que deseas convertir");
    }

    private static void imprimirAsteriscos(){
        for (int i = 0; i < 50; i++) {
            System.out.print("*");
        }
    }

    public int opcionEscogida() {
        Scanner scan = new Scanner(System.in);
        boolean esNumeroValido = true;
        int entero = 0;

        while (esNumeroValido) {
            var opcion = scan.next();
                try {
                    entero = Integer.parseInt(opcion);
                    if ((entero >= 1) && (entero <= 9)) {
                        esNumeroValido = false;
                    } else {
                        System.out.println("Inserta una opción válida!");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Ingresa un número!");
                }
            }
        return entero;
        }

    public double cantidadEscogida() {
        Scanner scan = new Scanner(System.in);
        boolean esNumeroValido = true;
        double doble = 0;

        while (esNumeroValido) {
            var opcion = scan.next();
            try {
                doble = Double.parseDouble(opcion);
                if (doble >= 1) {
                    esNumeroValido = false;
                } else {
                    System.out.println("Inserta un cantidad válida!");
                }
            } catch (NumberFormatException e) {
                System.out.println("Ingresa un número!");
            }
        }
        return doble;
    }
    }
