import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String cliente, cuenta, denominacion, mensajeMenu;
        double saldo = 1599.99;
        double retiro;
        double deposito;
        double saldoTemporal;
        int opcion = 0;
        Scanner scanner = new Scanner(System.in);

        mensajeMenu = """
                Escriba el número de la opción deseada
                1 - Consultar saldo.
                2 - Retirar.
                3 - Depositar.
                9 - Salir.
                """;
        cliente = "Tony S.";
        cuenta = "Corriente";
        denominacion = "$";

        String infoCliente = """
                Nombre del cliente: %s
                Tipo de cuenta: %s
                Saldo disponible: %.2f %s
                
                *************************************
                """.formatted(cliente, cuenta, saldo, denominacion);

        System.out.println(infoCliente);

        while (opcion != 9) {
            System.out.println(mensajeMenu);
            opcion = scanner.nextInt();
            switch (opcion) {
                case 1:
                    System.out.printf("El saldo actualizado es: %.2f %s%n", saldo, denominacion);
                    break;
                case 2:
                    while (true) {
                        System.out.println("¿Cuál es el valor que desea retirar?");
                        retiro = scanner.nextDouble();
                        if (retiro < 0) {
                            System.out.println("Cantidad no reconocida, intente de nuevo.");
                        }else {
                            break;
                        }
                    }
                    saldoTemporal = saldo - retiro;
                    if (!(saldoTemporal < 0.0) && cuenta.equals("Corriente"))  {
                        saldo = saldoTemporal;
                        System.out.printf("Saldo restante: %.2f %s%n", saldo, denominacion);
                    } else {
                        System.out.println("Saldo insuficiente");
                    }
                    break;
                case 3:
                    while (true) {
                        System.out.println("¿Cuál es el saldo que vas a depositar?");
                        deposito = scanner.nextDouble();
                        if (deposito < 0) {
                            System.out.println("Cantidad no reconocida intente de nuevo.");
                        }else {
                            break;
                        }
                    }
                    saldoTemporal = saldo + deposito;
                    //.................Espacio para validación
                    saldo = saldoTemporal;
                    System.out.printf("El saldo actualizado es: %.2f %s%n", saldo, denominacion);
                    break;
                case 9:
                    System.out.println("Finalizando el programa. Muchas gracias por usar nuestros servicios.");
                    break;
                default:
                    System.out.println("Opción no válida!, intente de nuevo.");
            }
        }
    }
}