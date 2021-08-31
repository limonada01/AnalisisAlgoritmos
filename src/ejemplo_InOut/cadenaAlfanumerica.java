package ejemplo_InOut;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class cadenaAlfanumerica {
    static final String caracteres="0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
    static final int longitudCaracteres=caracteres.length();
    static final int longitudCadenas= 10;
    static final int cantCadenas=20;
    static final String ArchivoSalida="src/ejemplo_InOut/salidaAlfanumericos.txt";
    public static void generarArchivo() throws IOException{
        BufferedWriter buff= new BufferedWriter(new FileWriter(ArchivoSalida));
        String cadena="";
        char caracter;
        for(int i=0;i<cantCadenas;i++){
            for(int j=0; j< longitudCadenas;j++){
                cadena+=caracteres.charAt((int) (Math.random()*longitudCaracteres)); 
            }
            System.out.println(cadena);
            buff.write(cadena+"\n");
            cadena="";
        }
        buff.close();
        
    }

    public static void main(String[] args) throws IOException {
        generarArchivo();

    }
}
