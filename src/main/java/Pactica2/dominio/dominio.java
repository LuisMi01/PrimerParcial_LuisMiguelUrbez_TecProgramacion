package Pactica2.dominio;

public class dominio {

    private int[][] estadoActual;
    private int[][] estadoSiguiente = new int[30][30];

    public void generarEstadoInicial() {
        estadoActual = new int[30][30];
        for (int i = 0; i < 30; i++) {
            for (int j = 0; j < 30; j++) {
                estadoActual[i][j] = (int) (Math.random() * 2);
            }
        }
    }
    public void generarEstadoActualMontecarlo() {

    }
    public void transitarEstadoSiguiente() {
        for (int i = 0; i < 30; i++) {
            for (int j = 0; j < 30; j++) {
                int vecinos = contarVecinos(i, j);
                if (vecinos < 2) {
                    estadoSiguiente[i][j] = 0;
                } else if (vecinos == 2) {
                    estadoSiguiente[i][j] = estadoActual[i][j];
                } else if (vecinos == 3) {
                    estadoSiguiente[i][j] = 1;
                } else if (vecinos > 3) {
                    estadoSiguiente[i][j] = 0;
                }
            }
        }
        estadoActual = estadoSiguiente;
    }

    public String toString() {
        String cadena = "";
        for (int i = 0; i < 30; i++) {
            for (int j = 0; j < 30; j++) {
                cadena += estadoActual[i][j] + " ";
            }
            cadena += "";
        }
        return cadena;
    }

    public int contarVecinos(int i, int j) {
        int vecinos = 0;
        if (i > 0 && j > 0) {
            vecinos += estadoActual[i - 1][j - 1];
        }
        if (i > 0) {
            vecinos += estadoActual[i - 1][j];
        }
        if (i > 0 && j < 29) {
            vecinos += estadoActual[i - 1][j + 1];
        }
        if (j > 0) {
            vecinos += estadoActual[i][j - 1];
        }
        if (j < 29) {
            vecinos += estadoActual[i][j + 1];
        }
        if (i < 29 && j > 0) {
            vecinos += estadoActual[i + 1][j - 1];
        }
        if (i < 29) {
            vecinos += estadoActual[i + 1][j];
        }
        if (i < 29 && j < 29) {
            vecinos += estadoActual[i + 1][j + 1];
        }
        return vecinos;
    }
}
