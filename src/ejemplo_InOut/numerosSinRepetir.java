package ejemplo_InOut;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class numerosSinRepetir {
    final static int cantNumeros = 100;
    final static int piso = 1;
    final static int techo = 1000;
    final static String NombreArchivo = "src/ejemplo_InOut/numerosSinRepetir.txt";

    public static void generarArchivo() throws IOException {
        int numeros[] = generarArreglo();
        BufferedWriter buff = new BufferedWriter(new FileWriter(NombreArchivo));
        int num;
        for (int i = 0; i < cantNumeros; i++) {
            boolean flag = true;
            while (flag) {
                num = (int) (piso + (Math.random() * (techo - piso)));
                if (numeros[num] != -1) {
                    flag = false;
                    numeros[num] = -1;
                    System.out.println(num);
                    buff.write(num + "\n");
                } else {
                    System.out.println("************");
                }
            }
        }
        buff.close();

    }

    public static int[] generarArreglo() {
        int longitud = techo + 1;
        int[] numeros = new int[longitud];

        for (int i = 0; i < longitud; i++) {
            numeros[i] = i;
        }
        return numeros;
    }

    public static void main(String[] args) throws IOException {

        long inicio = System.nanoTime(); // Tomamos la hora del sistema en nanosegundos
        generarArchivo();
        long fin = System.nanoTime();
        System.out.println("Se tardo: " + (fin - inicio) + " nanosegundos ");

    }
}
