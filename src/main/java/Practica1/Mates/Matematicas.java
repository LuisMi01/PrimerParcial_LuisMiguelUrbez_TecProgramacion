package Practica1.Mates;

public class Matematicas {
    public static double generarNumeroPi(long pasos){
        int puntosTotales = 0;
        int puntosCirculo = 0;
        double x;
        double y;
        double pi;
        for (int i = 0; i < pasos; i++){
            x = Math.random();
            y = Math.random();
            if (Math.pow(x, 2) + Math.pow(y, 2) <= 1){
                puntosCirculo++;
            }
            puntosTotales++;
        }
        pi = (double) 4 * puntosCirculo / puntosTotales;
        return pi;
    }


}
