import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // 2. Prueba de la clase Tornillo
        Tornillo t1 = new Tornillo();
        Tornillo t2 = new Tornillo(25.5, 5.0);
        Tornillo t3 = new Tornillo(40.0, 8.0, "Torx");
        Tornillo t4 = new Tornillo(t1);

        System.out.println(t1);
        System.out.println(t2);
        System.out.println(t3);
        System.out.println("¿t1 es compatible con t4? " + t1.esCompatible(t4));

        // 3. Prueba del método extenderVector()
        double[] vectorOriginal = {3.5, 4.5, 8.0};
        double[] vectorExtendido = extenderVector(vectorOriginal);

        System.out.print("Vector original: ");
        for (double valor : vectorOriginal) {
            System.out.print(valor + " ");
        }
        System.out.println();

        System.out.print("Vector extendido: ");
        for (double valor : vectorExtendido) {
            System.out.print(valor + " ");
        }
        System.out.println();

        try ( // 4. Programa para datos meteorológicos
                Scanner scanner = new Scanner(System.in)) {
            System.out.print("Introduce el número de días: ");
            int numDias = scanner.nextInt();
            scanner.nextLine(); // Consume la nueva línea
            
            int diasSinLluvia = 0;
            int diasSoleados = 0;
            int diasVientoFlojoModerado = 0;
            int diasHumedadAlta = 0;
            int diasAptosTenis = 0;
            
            for (int i = 0; i < numDias; i++) {
                System.out.print("Introduce los datos del día " + (i + 1) + " (Clima Humedad Viento): ");
                String linea = scanner.nextLine();
                String[] datos = linea.split(" ");
                
                try {
                    String clima = datos[0];
                    double humedad = Double.parseDouble(datos[1]);
                    int viento = Integer.parseInt(datos[2]);
                    
                    // Estadísticas
                    if (!clima.equals("Lluvioso")) {
                        diasSinLluvia++;
                    }
                    if (clima.equals("Soleado")) {
                        diasSoleados++;
                    }
                    if (viento <= 38) {
                        diasVientoFlojoModerado++;
                    }
                    if (humedad > 60) {
                        diasHumedadAlta++;
                    }
                    
                    // Días aptos para tenis
                    if (clima.equals("Nublado") || (clima.equals("Soleado") && humedad <= 60) || (clima.equals("Lluvioso") && viento <= 38)) {
                        diasAptosTenis++;
                    }
                } catch (ArrayIndexOutOfBoundsException e) {
                    System.out.println("Error: Formato de entrada incorrecto. Debes ingresar Clima Humedad Viento separados por espacios.");
                } catch (NumberFormatException e) {
                    System.out.println("Error: Humedad y Viento deben ser números.");
                }
            }
            
            // Imprimir resultados
            System.out.println("Porcentaje de días sin lluvia: " + (double) diasSinLluvia / numDias * 100 + "%");
            System.out.println("Porcentaje de días soleados: " + (double) diasSoleados / numDias * 100 + "%");
            System.out.println("Porcentaje de días con viento flojo o moderado: " + (double) diasVientoFlojoModerado / numDias * 100 + "%");
            System.out.println("Porcentaje de días con humedad alta: " + (double) diasHumedadAlta / numDias * 100 + "%");
            System.out.println("Porcentaje de días aptos para tenis: " + (double) diasAptosTenis / numDias * 100 + "%");
        }

        // 5. Prueba del método indiceMayorCP()
        int[] vectorCP = {4, 9, 16, 25, 36, 49, 64, 81, 100};
        int indiceMayorCP = indiceMayorCP(vectorCP);
        System.out.printf("El mayor cuadrado perfecto es %d y se encuentra en la posición %d.%n", vectorCP[indiceMayorCP], indiceMayorCP);
    }

    // 3. Método extenderVector()
    public static double[] extenderVector(double[] vector) {
        int longitudOriginal = vector.length;
        int longitudNueva = 2 * longitudOriginal - 1;
        double[] nuevoVector = new double[longitudNueva];

        for (int i = 0, j = 0; i < longitudOriginal; i++) {
            nuevoVector[j++] = vector[i]; // Copia el valor original

            if (i < longitudOriginal - 1) {
                nuevoVector[j++] = (vector[i] + vector[i + 1]) / 2.0; // Calcula la media
            }
        }

        return nuevoVector;
    }

    // 5. Método indiceMayorCP()
    public static int indiceMayorCP(int[] vector) {
        int indiceMayor = -1;
        int mayorCuadradoPerfecto = -1;

        for (int i = 0; i < vector.length; i++) {
            double raiz = Math.sqrt(vector[i]);
            if (raiz == (int) raiz) { // Es un cuadrado perfecto
                if (vector[i] > mayorCuadradoPerfecto) {
                    mayorCuadradoPerfecto = vector[i];
                    indiceMayor = i;
                }
            }
        }

        return indiceMayor;
    }
}