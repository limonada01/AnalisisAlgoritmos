package ejemplo_InOut;
import java.util.Scanner;

import javax.swing.plaf.synth.SynthSpinnerUI;
public class adivinar {
    
    public static void juego(int piso, int techo){
        int num=(int)(piso + (Math.random()* (techo-piso)));
        boolean win=false;
        Scanner sc=new Scanner(System.in);
        int eleccion;
        while(!win){
            {
            System.out.println("ingrese un numero");
            eleccion=sc.nextInt();
            }while(eleccion<piso && eleccion >techo);
            if(eleccion==num){
                win=true;
                System.out.println("acertaste! congratulation");
            }else{
                if(eleccion<num){
                    System.out.println("el numero ingresado es menor");
                }else{
                    System.out.println("el numero ingresado es mayor");
                }
            }
            
        }
    }

    public static void main(String[] args) {
        int piso=1;
        int techo=3;
        juego(piso,techo);
        
        
    }
}
