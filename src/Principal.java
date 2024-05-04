
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ConversorDeMoneda converter = new ConversorDeMoneda();

        System.out.println("\n****************************************");
        System.out.println("BIENVENIDO AL CONVERSOR DE MONEDAS");

        while (true) {
            System.out.println("\n1) Dólar =>> Peso Argentino");
            System.out.println("2) Peso Argentino =>> Dólar");
            System.out.println("3) Dólar =>> Real Brasileño");
            System.out.println("4) Real Brasileño =>> Dólar");
            System.out.println("5) Dólar =>> Peso Colombiano");
            System.out.println("6) Peso Colombiano =>> Dólar");
            System.out.println("7) Dólar =>> Peso Dominicano");
            System.out.println("8) Peso Dominicano =>> Dólar");
            System.out.println("9) Salir");
            System.out.println("\n****************************************");

            System.out.print("Elija su opción: ");
            int option = scanner.nextInt();
            if (option == 9) break;
            if (option>9) {
                System.out.println("Opcion invalida: Favor de seleccione la opcion correcta del menu");
            } else {
                System.out.print("Ingrese la cantidad a convertir: ");
                double amount = scanner.nextDouble();

                String result = converter.convertirMoneda(option, amount);
                System.out.println("Resultado: "+ result);
                System.out.println();
            }

        }

        System.out.println("** Ha finalizado el programa. Muchas gracias por usar nuestros servicios.**");
    }
}
