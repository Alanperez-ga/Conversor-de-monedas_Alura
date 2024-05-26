import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class ConexionAPI {

    ArrayList<String> moneda = new ArrayList<>();
    Gson gson = new GsonBuilder()
            .create();

    public void SolicitarConexion(int opcion, double cantidad) {

        moneda.add("USD");
        moneda.add("ARS");
        moneda.add("BRL");
        moneda.add("COP");
        moneda.add("CLP");

        String monedaConvertir ="";
        String monedaResultado ="";

        switch (opcion) {
            case 1:
                monedaConvertir = moneda.get(0);
                monedaResultado = moneda.get(1);
                break;
            case 2:
                monedaConvertir = moneda.get(1);
                monedaResultado = moneda.get(0);
                break;
            case 3:
                monedaConvertir = moneda.get(0);
                monedaResultado = moneda.get(2);
                break;
            case 4:
                monedaConvertir = moneda.get(2);
                monedaResultado = moneda.get(0);
                break;
            case 5:
                monedaConvertir = moneda.get(0);
                monedaResultado = moneda.get(3);
                break;
            case 6:
                monedaConvertir = moneda.get(3);
                monedaResultado = moneda.get(0);
                break;
            case 7:
                monedaConvertir = moneda.get(0);
                monedaResultado = moneda.get(4);
                break;
            case 8:
                monedaConvertir = moneda.get(4);
                monedaResultado = moneda.get(0);
                break;
        }

        String llave = "3bc279b5f18c7de5618c1c6d";
        String direccion = "https://v6.exchangerate-api.com/v6/" + llave + "/pair/" + monedaConvertir + "/" + monedaResultado;

        try {
            HttpClient cliente = HttpClient.newHttpClient();
            HttpRequest pedido = HttpRequest.newBuilder()
                    .uri(URI.create(direccion))
                    .build();
            HttpResponse<String> respuesta = cliente
                    .send(pedido, HttpResponse.BodyHandlers.ofString());

            String json = respuesta.body();

            JsonExchangerate conversionJson = gson.fromJson(json,JsonExchangerate.class);
            Conversion miConversion = new Conversion(conversionJson,cantidad);

            System.out.println("El valor " + String.format("%.2f",cantidad) + " [" + miConversion.getMonedaBase() + "] " + "corresponde al valor final de " + String.format("%.2f",miConversion.getTotalConvertido()) + " [" + miConversion.getMonedaObjetivo() + "]\n");

        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}