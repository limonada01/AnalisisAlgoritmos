package ejemplo_InOut;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;

public class numerosRandom {
    
    static final String NOMBRE_ARCHIVO = "src/ejemplo_InOut/numerosEj1-3.txt";
    static final int cantNumeros=100;
    static final double piso=-100;
    static final double techo=100;
    
    public static void generador(int cantNumeros,double piso, double techo,BufferedWriter buff) throws IOException{
        double num;
        DecimalFormat formato= new DecimalFormat("#.00");
        for(int i=0;i<cantNumeros;i++){
            num= piso+(Math.random()* (techo-piso));
            buff.write(formato.format(num) +"\n");
            System.out.println(formato.format(num));
        }
    }

    private static void generarArchivo(){
    	try{
    		BufferedWriter buff = new BufferedWriter(new FileWriter(NOMBRE_ARCHIVO));
    		generador(cantNumeros,piso,techo,buff);
    		buff.close();
    	}
    	catch (FileNotFoundException ex) {
            System.err.println(ex.getMessage() + "\nSignifica que el archivo del "
                    + "que queriamos leer no existe.");
        }
        catch (IOException ex) {
            System.err.println("Error leyendo o escribiendo en algun archivo.");
        }
    }

    
    public static void main(String[] args) {
        generarArchivo();
        
    }
}
