public class Main {
    public static void main(String[] args) {

        Menu menu = new Menu();
        ConexionAPI conexionAPI = new ConexionAPI();
        int opcion;
        double cantidad;
        boolean resultado = true;

        while (resultado) {
            menu.imprimirMenu();
            opcion = menu.opcionEscogida();
            if (opcion == 9) {
                System.out.println("Programa terminado");
                resultado = false;
            } else {
                menu.imprimirCantidad();
                cantidad = menu.cantidadEscogida();
                conexionAPI.SolicitarConexion(opcion,cantidad);
            }
        }
    }
}