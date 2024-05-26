public class Conversion {

    private String monedaBase;
    private String monedaObjetivo;
    private Double totalConvertido;

    public Conversion (JsonExchangerate opcionMoneda, double valorAConvertir) {
        monedaBase = opcionMoneda.base_code();
        monedaObjetivo = opcionMoneda.target_code();
        totalConvertido = valorAConvertir * opcionMoneda.conversion_rate();
    }

    public String getMonedaBase() {
        return monedaBase;
    }

    public String getMonedaObjetivo() {
        return monedaObjetivo;
    }

    public Double getTotalConvertido() {
        return totalConvertido;
    }
}
