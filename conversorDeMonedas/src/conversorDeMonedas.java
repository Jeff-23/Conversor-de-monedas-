import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class conversorDeMonedas {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Bienvenido al Conversor de Monedas (COP - Pesos Colombianos)");
        System.out.println("Las monedas disponibles son: ");
        System.out.println("1. USD - Dólar estadounidense");
        System.out.println("2. EUR - Euro");
        System.out.println("3. GBP - Libra esterlina");
        System.out.print("Elija la moneda a la que desea convertir: ");
        int opcion = scanner.nextInt();

        String monedaDestino = "";
        switch (opcion) {
            case 1:
                monedaDestino = "USD";
                break;
            case 2:
                monedaDestino = "EUR";
                break;
            case 3:
                monedaDestino = "GBP";
                break;
            default:
                System.out.println("Opción no válida. Intente nuevamente.");
                return;
        }

        System.out.print("Ingrese la cantidad en COP (Pesos Colombianos): ");
        double cantidadCOP = scanner.nextDouble();

        try {
            double tasaCambio = obtenerTasaCambio(monedaDestino);
            double resultado = cantidadCOP * tasaCambio;

            System.out.printf("%,.2f COP equivale a %,.2f %s\n", cantidadCOP, resultado, monedaDestino);
        } catch (Exception e) {
            System.out.println("Ocurrió un error al obtener la tasa de cambio: " + e.getMessage());
        }

        scanner.close();
    }

    public static double obtenerTasaCambio(String monedaDestino) throws Exception {
        String apiUrl = "https://api.exchangerate-api.com/v4/latest/COP";

        URL url = new URL(apiUrl);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");

        int responseCode = connection.getResponseCode();
        if (responseCode != 200) {
            throw new Exception("Error en la conexión con la API");
        }

        BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        StringBuilder response = new StringBuilder();
        String line;

        while ((line = reader.readLine()) != null) {
            response.append(line);
        }
        reader.close();

        String jsonResponse = response.toString();

        // Extraer la tasa de cambio usando una librería JSON (opcional)
        int startIndex = jsonResponse.indexOf(monedaDestino) + monedaDestino.length() + 2;
        int endIndex = jsonResponse.indexOf(",", startIndex);
        if (endIndex == -1) {
            endIndex = jsonResponse.indexOf("}", startIndex);
        }
        String tasaCambioStr = jsonResponse.substring(startIndex, endIndex);

        return Double.parseDouble(tasaCambioStr);
    }
}