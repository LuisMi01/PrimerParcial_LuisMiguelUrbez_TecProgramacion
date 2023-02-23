package Pactica2.Application;

import Pactica2.dominio.Tablero;
import java.util.concurrent.TimeUnit;
import java.lang.InterruptedException;
public class Principal {
    public static void main(String[] args){
        try {
            Tablero tablero = new Tablero(); System.out.println("SIMULACIÓN CON TABLERO LEÍDO ");

            tablero.generarEstadoInicial(); System.out.println(tablero); for(int i = 0; i <= 5; i++) {
                TimeUnit.SECONDS.sleep(1); tablero.transitarEstadoSiguiente(); System.out.println(tablero);
            }
            System.out.println("SIMULACIÓN CON TABLERO GENERADO MEDIANTE MONTECARLO");
            tablero.generarEstadoActualMontecarlo(); System.out.println(tablero);
            for(int i = 0; i <= 15; i++)
            {
                TimeUnit.SECONDS.sleep(1); tablero.transitarEstadoSiguiente(); System.out.println(tablero);
            } }catch(InterruptedException e) {
            System.out.println(e); }
    }
}
