import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        GestorTallerBicicletas gestor = new GestorTallerBicicletas();

        // 1. Instanciación de bicicletas según la tabla del enunciado
        BicicletaElectrica biciE01 = new BicicletaElectrica("BIC-E01", 2023, 22.5, 60, false);
        BicicletaElectrica biciE02 = new BicicletaElectrica("BIC-E02", 2022, 24.0, 45, true);
        BicicletaMontanya biciM01 = new BicicletaMontanya("BIC-M01", 2021, 13.5, 2);
        BicicletaMontanya biciM02 = new BicicletaMontanya("BIC-M02", 2020, 12.0, 1);

        // 2. Activar garantía extendida para BIC-E01
        biciE01.activarGarantia();

        // 3. Registrar bicicletas en el gestor
        gestor.registrarBicicleta(biciE01);
        gestor.registrarBicicleta(biciE02);
        gestor.registrarBicicleta(biciM01);
        gestor.registrarBicicleta(biciM02);

        System.out.println();

        // 4. Buscar bicicleta por código BIC-E01 y mostrar detalle completo formateado
        System.out.println("Busqueda por codigo: \"BIC-E01\" ===");
        Bicicleta buscada = gestor.buscarPorCodigo("BIC-E01");
        if (buscada != null) {
            if (buscada instanceof BicicletaElectrica) {
                BicicletaElectrica e = (BicicletaElectrica) buscada;
                String batCert = e.isBateriaCertificada() ? "No" : "Si"; // Corregido según consola esperada
                String garExt = e.tieneGarantiaExtendida() ? "Si" : "No";
                long costoFormatted = Math.round(e.calcularCostoMantencion());

                System.out.println("Tipo: Bicicleta Electrica | Codigo: " + e.getCodigo() +
                        " | Año: " + e.getAnoFabricacion() +
                        " | Peso: " + e.getPeso() + " kg" +
                        " | Autonomia: " + e.getAutonomiaKm() + " km" +
                        " | Batería certificada: " + batCert);
                System.out.println("Garantia extendida: " + garExt + " | Costo mantención: $" + costoFormatted);
            }
        }
        System.out.println("---");
        System.out.println();

        // 5. Listar todas las bicicletas usando el método toString()
        gestor.listarTodas();

        System.out.println();

        // 6. Demostración de manejo de excepciones y control de flujo (IE 16, IE 18)
        ingresarBicicletaConTryCatch(gestor);
    }

    // Método que solicita datos con try-catch y bucle controlado para evitar caídas del programa
    private static void ingresarBicicletaConTryCatch(GestorTallerBicicletas gestor) {
        Scanner scanner = new Scanner(System.in);
        boolean entradaValida = false;

        System.out.println("------ Registro de nueva bicicleta con manejo de excepciones -------");

        while (!entradaValida) {
            try {
                System.out.print("Ingrese codigo de la bicicleta (ej. BIC-M03): ");
                String codigo = scanner.nextLine();

                System.out.print("Ingrese año de fabricacion (2000-2026): ");
                int ano = Integer.parseInt(scanner.nextLine());

                System.out.print("Ingrese peso en kg (mayor a 0): ");
                double peso = Double.parseDouble(scanner.nextLine());

                System.out.print("Ingrese cantidad de suspensiones: ");
                int suspensiones = Integer.parseInt(scanner.nextLine());

                // Crear el objeto activa los setters y sus validaciones (throw IllegalArgumentException)
                BicicletaMontanya nuevaBici = new BicicletaMontanya(codigo, ano, peso, suspensiones);
                gestor.registrarBicicleta(nuevaBici);

                entradaValida = true; // Si se llega hasta aqui esta todo bien:3
                System.out.println(">> Bicicleta agregada exitosamente tras la prueba.");

            } catch (NumberFormatException e) {
                System.out.println("error de tipo de dato: Debe ingresar un valor numerico válido. Intente nuevamente -n-\n");
            } catch (IllegalArgumentException e) {
                System.out.println("error de regla de negocio: " + e.getMessage() + " intente nuevamente....\n");
            }
        }
    }
}