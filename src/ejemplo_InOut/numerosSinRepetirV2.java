package ejemplo_InOut;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class numerosSinRepetirV2 {
    final static int cantNumeros=100;
    final static int piso=1;
    final static int techo=1001;
    final static String NombreArchivo = "src/ejemplo_InOut/numerosSinRepetirV2.txt";
    
    public static void generarArchivo() throws IOException {
        int numeros[] = new int[techo];
        BufferedWriter buff = new BufferedWriter(new FileWriter(NombreArchivo));
        int num;
        for (int i = 0; i < cantNumeros; i++) {
            boolean flag = true;
            while (flag) {
                num = (int) (piso + (Math.random() * (techo - piso)));
                if (numeros[num] == 0) {
                    flag = false;
                    numeros[num] = -1;
                    //System.out.println(num);
                    buff.write(num + "\n");
                } 
            }
        }
        buff.close();

    }
    public static void main(String[] args) throws IOException {
        long inicio = System.nanoTime(); // Tomamos la hora del sistema en nanosegundos
        generarArchivo();
        long fin = System.nanoTime();
        System.out.println("Se tardo: " + (fin - inicio) + " nanosegundos ");

    }
}
