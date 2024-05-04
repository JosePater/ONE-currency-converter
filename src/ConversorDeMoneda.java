import com.google.gson.Gson;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.text.NumberFormat;
import java.util.Locale;
import java.util.Map;

public class ConversorDeMoneda {
    private final static String API_URL = "https://api.exchangerate-api.com/v4/latest/USD";
    private final HttpClient client = HttpClient.newHttpClient();
    private  final Gson gson = new Gson();

    public String convertirMoneda(int opcion, double cantidad) {
        String jsonRespuesta = obtenerTasasDeCambio();
        Map tasas = gson.fromJson(jsonRespuesta, Map.class);
        Map<String, Double> tasasDeCambio = (Map<String, Double>) tasas.get("rates");

        double resultado = 0.0;
        Locale locale = Locale.US;

        switch (opcion) {
            case 1:
                resultado = cantidad * tasasDeCambio.get("ARS");
                locale = new Locale("es", "AR");
                break;
            case 2:
                resultado = cantidad / tasasDeCambio.get("ARS");
                locale = Locale.US;
                break;
            case 3:
                resultado = cantidad * tasasDeCambio.get("BRL");
                locale = new Locale("pt", "BR");
                break;
            case 4:
                resultado = cantidad / tasasDeCambio.get("BRL");
                locale = Locale.US;
                break;
            case 5:
                resultado = cantidad * tasasDeCambio.get("COP");
                locale = new Locale("es", "CO");
                break;
            case 6:
                resultado = cantidad / tasasDeCambio.get("COP");
                locale = Locale.US;
                break;
            case 7:
                resultado = cantidad * tasasDeCambio.get("DOP");
                locale = new Locale("es", "DO");
                break;
            case 8:
                resultado = cantidad / tasasDeCambio.get("DOP");
                locale = Locale.US;
                break;
        }

        return formatoMoneda(resultado, locale);
    }

    private String obtenerTasasDeCambio() {
        HttpRequest peticion = HttpRequest.newBuilder()
                .uri(URI.create(API_URL))
                .GET()
                .build();
        try {
            HttpResponse<String> respuesta = client.send(peticion, HttpResponse.BodyHandlers.ofString());
            return respuesta.body();
        } catch (Exception e) {
            System.out.println("Ocurrió un error: " + e.getMessage());
            return "";
        }
    }

    private String formatoMoneda(double cantidad, Locale local) {
        NumberFormat formato = NumberFormat.getCurrencyInstance(local);
        return formato.format(cantidad);
    }


}
