package MisFunciones;

public interface Arrays {
    public static int[] CreaArray(int longitud) {
        int[] array = new int[longitud];
        return array;
    }

    public static int[] CreaArrayRandom(int longitud, int min, int max) {
        int[] array = CreaArray(longitud);
        for (int i = 0; i < array.length; i++) {
            array[i] = (int) (Math.random() * (max - min + 1) + min);
        }
        return array;
    }

    public static int sumaMismoArray(int[] array) {
        int suma = 0;
        for (int i = 0; i < array.length; i++) {
            suma += array[i];
        }
        return suma;
    }

    @SuppressWarnings("ManualArrayToCollectionCopy")
    public static int[] copiarArray(int[] array) {
        int[] copia = CreaArray(array.length);
        for (int i = 0; i < array.length; i++) {
            copia[i] = array[i];
        }
        return copia;
    }

    public static int aptitud(int[] poblacion, int OBJETIVO) {
        int suma = sumaMismoArray(poblacion);
        return Math.abs(OBJETIVO - suma);
    }

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
