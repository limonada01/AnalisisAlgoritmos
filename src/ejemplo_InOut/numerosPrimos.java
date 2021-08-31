package ejemplo_InOut;

import java.util.Scanner;

public class numerosPrimos {

    public static boolean esPrimo(int n) {
        boolean exito = true;
        int i = 2;
        if (n != 2) {
            while (i < n && exito) {
                if (n % i == 0) {
                    exito = false;
                }
                i++;
            }
        }
        return exito;
    }

    public static void cantNumerosPrimos() {
        Scanner sc = new Scanner(System.in);
        System.err.println("Ingrese el numero N");
        int n = sc.nextInt();
        int cantNumerosPrimos = 0;
        if (n > 2) {
            cantNumerosPrimos = 1;
        }

        for (int i = 3; i < n; i = i + 2) {
            if (esPrimo(i)) {
                cantNumerosPrimos += 1;
            }

        }
        System.out.println("La cantidad de numeros primos entre 1 y " + n + " es: " + cantNumerosPrimos);
    }

    public static void main(String[] args) {
        
        cantNumerosPrimos();
        
    }
}
