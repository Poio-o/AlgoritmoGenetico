import MisFunciones.Arrays;

public class App {
    public static void main(String[] args) throws Exception {
        final int OBJETIVO = 100; // Número que se obtiene sumando
        final int INDIVIDUOS = 5; // Tamaño de la población
        final double MUTABILIDAD = 0.2; // Probabilidad de mutaciones
        final int VERGENERACIONES = 1000; // Cada cuántas generaciones se muestra en pantalla
        int otroPadre;
        int generaciones = 0; // Contador de generaciones

        int[] poblacion = Arrays.CreaArrayRandom(INDIVIDUOS, -100, 100); // Crea población

        do {
            generaciones++;

            if (generaciones % VERGENERACIONES == 0) {
                System.out.println("Generación " + generaciones + ": " + java.util.Arrays.toString(poblacion));
            }

            int peor = Arrays.peorIndividuo(poblacion, OBJETIVO); // Encuentra el peor individuo

            otroPadre = (int) (Math.random() * INDIVIDUOS); // Selecciona aleatoriamente otro de los individuos
            while (peor == otroPadre) { //Asegura que no elige al peor individuo
                otroPadre = (int) (Math.random() * INDIVIDUOS);
            }
            poblacion[peor] = poblacion[peor] + (int) ((poblacion[otroPadre] - poblacion[peor]) * Math.random());  // Cruza al peor con otro individuo

            if (Math.random() <= MUTABILIDAD) { // Mutación 1
                poblacion[(int) (Math.random() * INDIVIDUOS)] *= -1; 
            }
            if (Math.random() <= MUTABILIDAD) { // Mutación 2
                poblacion[(int) (Math.random() * INDIVIDUOS)] += 5;
            }
            if (Math.random() <= MUTABILIDAD) { // Mutación 3
                poblacion[(int) (Math.random() * INDIVIDUOS)] -= 5;
            }

        } while (Arrays.aptitud(poblacion, OBJETIVO) != 0);

        System.out.println();
        System.out.println("Se ha encontrado una solución:");
        System.out.println(java.util.Arrays.toString(poblacion));
        System.out.println("Se alcanzó en la generación: " + generaciones);
    }
}
