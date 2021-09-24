package ejemplo_InOut;
import algoritmoOrdenamiento.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class alumnos {
    final static int cantMaterias = 5;
    final static int cantEstudiantes = 20;
    final static String notas = "src/ejemplo_InOut/notas.txt";
    final static String mediaPorAlumno = "src/ejemplo_InOut/mediaPorAlumno.txt";
    final static String mediaPorAsignatura = "src/ejemplo_InOut/mediaPorAsignatura.txt";
    final static String mediaDeLaClase = "src/ejemplo_InOut/mediaDeLaClase.txt";
    final static String promedioPorAlumnoOrdenado = "src/ejemplo_InOut/promedioPorAlumnoOrdenado.txt";
    public static void calcularMediaPorAlumno() throws IOException {
        BufferedReader buffR = new BufferedReader(new FileReader(notas));
        BufferedWriter buffW = new BufferedWriter(new FileWriter(mediaPorAlumno));
        Scanner sc = new Scanner(buffR);

        int sumatoriaParcial = 0;

        for (int i = 0; i < cantEstudiantes; i++) {

            for (int j = 0; j < cantMaterias; j++) {
                sumatoriaParcial += sc.nextInt();
                //System.out.println(sumatoriaParcial);
            }
            int promedio = sumatoriaParcial / cantMaterias;
            buffW.write(promedio + "\n");
            sumatoriaParcial = 0;

        }
        buffW.close();
        buffR.close();
    }

    public static void calcularMediaPorAsignatura() throws IOException {
        BufferedReader buffR = new BufferedReader(new FileReader(notas));
        BufferedWriter buffW = new BufferedWriter(new FileWriter(mediaPorAsignatura));
        Scanner sc = new Scanner(buffR);
        int[] sumatoriasParciales = new int[cantMaterias];
        for (int i = 0; i < cantEstudiantes; i++) {

            for (int j = 0; j < cantMaterias; j++) {
                sumatoriasParciales[j] += sc.nextInt();
                //System.out.println(sumatoriasParciales[j]);
            }

        }
        int promedio = 0;
        for (int x = 0; x < cantMaterias; x++) {
            promedio = sumatoriasParciales[x] / cantEstudiantes;
            buffW.write(promedio + "\n");

        }
        buffW.close();
        buffR.close();
    }

    public static void mediaTotalClase() throws IOException{
        BufferedReader buffR = new BufferedReader(new FileReader(mediaPorAlumno));
        BufferedWriter buffW = new BufferedWriter(new FileWriter(mediaDeLaClase));
        Scanner sc = new Scanner(buffR);
        int promedio=0;
        for(int i=0;i<cantEstudiantes;i++){
            promedio+=sc.nextInt();
            System.out.println(promedio);
        }
        double media=promedio/cantEstudiantes;
        buffW.write(Double.toString(media));
        
        buffR.close();
        buffW.close();
    }

    public static void cargarTxt() throws IOException {
        BufferedWriter buff = new BufferedWriter(new FileWriter(notas));
        int notaRandom;
        for (int i = 0; i < cantEstudiantes; i++) {
            for (int j = 0; j < cantMaterias; j++) {
                notaRandom = (int) (1 + (Math.random() * (10 - 1)));
                buff.write(Integer.toString(notaRandom) + " ");
                if (j == (cantMaterias - 1)) {
                    buff.write("\n");
                }
            }
        }
        buff.close();
    }

    public static void ordenarNotas() throws IOException{
        BufferedReader buffR = new BufferedReader(new FileReader(mediaPorAlumno));
        BufferedWriter buffW = new BufferedWriter(new FileWriter(promedioPorAlumnoOrdenado));
        Scanner sc = new Scanner(buffR);
        int[] notas=new int[cantEstudiantes];
        for(int i=0;i<cantEstudiantes;i++){
            notas[i]=sc.nextInt();
        }

        MergeSortDes or=new MergeSortDes();

        or.ordenar(notas, 0, notas.length-1);

        for(int j=0;j<cantEstudiantes;j++){
            buffW.write(notas[j]+ " ");
        }
        buffW.close();
        buffR.close();

    }

    public static void main(String[] args) throws IOException {
        // cargarTxt();
        //calcularMediaPorAlumno();
        //calcularMediaPorAsignatura();
        //mediaTotalClase();
        ordenarNotas();

    }
}
