package ejemplo_InOut;

public class busquedaBinaria {
    public int buscar(int[] números, int número) {

        int inicio = 0, fin = números.length - 1;
    
        while (inicio <= fin) {
                
            int centro = (inicio + fin) / 2;
                
            if (número < números[centro]) {
                fin = centro - 1;
            }
    
            if (número > números[centro]) {
                inicio = centro + 1;
            }
                
            if (número == números[centro]) {
                return centro;
            }
        }
    
        return -1;
    }
}
