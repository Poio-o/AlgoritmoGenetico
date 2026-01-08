package MisFunciones;

/**
 * Interfaz que contiene métodos estáticos de utilidad
 * para la creación y manipulación de arrays de enteros.
 */
public interface Arrays {

    /**
     * Crea un array de enteros con la longitud indicada.
     * Los valores se inicializan a 0 por defecto.
     *
     * @param longitud tamaño del array
     * @return array de enteros con la longitud especificada
     */
    public static int[] CreaArray(int longitud) {
        int[] array = new int[longitud];
        return array;
    }

    /**
     * Crea un array de enteros con valores aleatorios dentro
     * de un rango determinado.
     *
     * @param longitud tamaño del array
     * @param min valor mínimo (incluido)
     * @param max valor máximo (incluido)
     * @return array de enteros con valores aleatorios
     */
    public static int[] CreaArrayRandom(int longitud, int min, int max) {
        int[] array = CreaArray(longitud);
        for (int i = 0; i < array.length; i++) {
            array[i] = (int) (Math.random() * (max - min + 1) + min);
        }
        return array;
    }

    /**
     * Calcula la suma de todos los elementos de un array.
     *
     * @param array array de enteros
     * @return suma de los valores del array
     */
    public static int sumaMismoArray(int[] array) {
        int suma = 0;
        for (int i = 0; i < array.length; i++) {
            suma += array[i];
        }
        return suma;
    }

    /**
     * Crea una copia exacta de un array de enteros.
     *
     * @param array array original
     * @return nuevo array con los mismos valores
     */
    @SuppressWarnings("ManualArrayToCollectionCopy")
    public static int[] copiarArray(int[] array) {
        int[] copia = CreaArray(array.length);
        for (int i = 0; i < array.length; i++) {
            copia[i] = array[i];
        }
        return copia;
    }

    /**
     * Calcula la aptitud de un individuo comparando la suma
     * de su array con un valor objetivo.
     *
     * @param poblacion array que representa un individuo
     * @param OBJETIVO valor objetivo a alcanzar
     * @return diferencia absoluta entre la suma y el objetivo
     */
    public static int aptitud(int[] poblacion, int OBJETIVO) {
        int suma = sumaMismoArray(poblacion);
        return Math.abs(OBJETIVO - suma);
    }

    /**
     * Determina el índice del peor individuo del array,
     * entendiendo como peor aquel cuya eliminación (poner a 0)
     * genera la mayor diferencia respecto al objetivo.
     *
     * @param poblacion array de enteros
     * @param OBJETIVO valor objetivo
     * @return índice del peor individuo
     */
    public static int peorIndividuo(int[] poblacion, int OBJETIVO) {
        int peor = 0;
        int indicepeor = 0;
        for (int i = 0; i < poblacion.length; i++) {
            int[] copia = copiarArray(poblacion);
            copia[i] = 0;
            int diferencia = aptitud(copia, OBJETIVO);
            if (diferencia > peor) {
                peor = diferencia;
                indicepeor = i;
            }
        }
        return indicepeor;
    }
}
