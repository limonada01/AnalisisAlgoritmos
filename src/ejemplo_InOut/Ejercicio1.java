package ejemplo_InOut;

//import java.io.*
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

public class Ejercicio1 {

    public static void main(String[] args) {
       
        String nombreArchivoEntrada = "src/ejemplo_InOut/entrada.txt";
        //String nombreArchivoSalida = "src/ejemplo_InOut/sinEspacios.txt";
        String nombreArchivoSalida = "src/ejemplo_InOut/lineasImpares.txt";
        
        
        
        String linea = null;

        try {
          
            FileReader lectorArchivo = new FileReader(nombreArchivoEntrada);
           
            FileWriter escritorArchivo = new FileWriter(nombreArchivoSalida);

          
            BufferedReader bufferLectura = new BufferedReader(lectorArchivo);
            BufferedWriter bufferEscritura = new BufferedWriter(escritorArchivo);

            
            //escribirSinEspacios(linea, bufferLectura, bufferEscritura);
            escribirLineasImpares(linea, bufferLectura, bufferEscritura);
            
            bufferLectura.close();
            bufferEscritura.close();
        } catch (FileNotFoundException ex) {
            System.err.println(ex.getMessage() + "\nSignifica que el archivo del " + "que queriamos leer no existe.");
        } catch (IOException ex) {
            System.err.println("Error leyendo o escribiendo en algun archivo.");
        }
    }

    public static void escribirSinEspacios(String linea, BufferedReader bufferLectura, BufferedWriter bufferEscritura)
            throws IOException {
        while (((linea = bufferLectura.readLine()) != null)) {
            if (!linea.equals("")) {
                linea = quitarEspacios(linea);
                System.out.println(linea);
                bufferEscritura.write(linea + "\n");
            }
        }
    }

    public static String quitarEspacios(String linea) {
        String retorno = "";
        String[] temp = linea.split(" ");
        int longitud = temp.length;
        for (int i = 0; i < longitud; i++) {
            retorno = retorno + temp[i];
        }
        return retorno;
    }

    public static void escribirLineasImpares(String linea, BufferedReader bufferLectura, BufferedWriter bufferEscritura)throws IOException {
        int i=1;
        while (((linea = bufferLectura.readLine()) != null)) {
            if(i % 2==1){
                System.out.println(linea);
                bufferEscritura.write(linea + "\n");
            }
            i++;
        }
    }
}