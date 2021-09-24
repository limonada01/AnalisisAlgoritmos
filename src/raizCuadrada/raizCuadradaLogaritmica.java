package raizCuadrada;

public class raizCuadradaLogaritmica {

    public static long raizCuadradaLog(long x) {
        // caso base
        if (x < 2) {
            return x;
        }
        // para almacenar el piso de la raiz de x
        long resultado = -1;

        // la raiz cuadrada de 'x' no puede ser mayor que 'x/2' para 'x > 1'
        long inicio = 1;
        long fin = x / 2;
        long medio = 0;
        long cuadrado = 0;
        boolean flag = true;

        while (flag && inicio <= fin) {
            // encuentra el elemento del medio
            medio = (inicio + fin) / 2;
            cuadrado = medio * medio;
            // retorna 'medio' si 'x' es una raiz perfecta
            if (cuadrado == x) {
                resultado = medio;
                flag = false;
            } // si 'medio x medio' es menor que 'x'
            else if (cuadrado < x) {
                // se descarta la busqueda a izquierda
                inicio = medio + 1;
                // actualiza el resultado ya que necesitamos un piso
                resultado = medio;
            } // si 'medio x medio' es mayor que 'x'
            else {
                // se descarta la busqueda a derecha
                fin = medio - 1;
            }
            
        }
        // retorno resultado
        return resultado;
    }

    public static void main(String[] args) {
        System.out.println(raizCuadradaLog(65));
    }

}