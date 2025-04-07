package Triangulo;

public class Triangulo {
    private int ladoA, ladoB, ladoC;

    public Triangulo(int ladoA, int ladoB, int ladoC) {
        this.ladoA = ladoA;
        this.ladoB = ladoB;
        this.ladoC = ladoC;
    }

    public boolean formaTriangulo() {
        return ladoA > 0 && ladoB > 0 && ladoC > 0 &&
                ladoA + ladoB > ladoC &&
                ladoA + ladoC > ladoB &&
                ladoB + ladoC > ladoA;
    }

    public TipoTriangulo getTipo() {
        if (!formaTriangulo()) {
            return TipoTriangulo.NAO_TRIANGULO;
        }

        if (ladoA == ladoB && ladoB == ladoC) {
            return TipoTriangulo.EQUILATERO;
        } else if (ladoA == ladoB || ladoA == ladoC || ladoB == ladoC) {
            return TipoTriangulo.ISOSCELES;
        } else {
            return TipoTriangulo.ESCALENO;
        }
    }
}
