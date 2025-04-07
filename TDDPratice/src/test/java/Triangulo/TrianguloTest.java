package Triangulo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
public class TrianguloTest {

    @Test
    public void testTrianguloEscalenoValido() {
        Triangulo t = new Triangulo(3, 4, 5);
        assertTrue(t.formaTriangulo());
        assertEquals(TipoTriangulo.ESCALENO, t.getTipo());
    }

    @Test
    public void testTrianguloIsoscelesValido1() {
        Triangulo t = new Triangulo(5, 5, 3);
        assertTrue(t.formaTriangulo());
        assertEquals(TipoTriangulo.ISOSCELES, t.getTipo());
    }

    @Test
    public void testTrianguloIsoscelesValido2() {
        Triangulo t = new Triangulo(5, 3, 5);
        assertTrue(t.formaTriangulo());
        assertEquals(TipoTriangulo.ISOSCELES, t.getTipo());
    }

    @Test
    public void testTrianguloIsoscelesValido3() {
        Triangulo t = new Triangulo(3, 5, 5);
        assertTrue(t.formaTriangulo());
        assertEquals(TipoTriangulo.ISOSCELES, t.getTipo());
    }

    @Test
    public void testTrianguloEquilateroValido() {
        Triangulo t = new Triangulo(4, 4, 4);
        assertTrue(t.formaTriangulo());
        assertEquals(TipoTriangulo.EQUILATERO, t.getTipo());
    }

    @Test
    public void testValorZero() {
        Triangulo t = new Triangulo(0, 4, 4);
        assertFalse(t.formaTriangulo());
        assertEquals(TipoTriangulo.NAO_TRIANGULO, t.getTipo());
    }

    @Test
    public void testValorNegativo() {
        Triangulo t = new Triangulo(-1, 4, 4);
        assertFalse(t.formaTriangulo());
        assertEquals(TipoTriangulo.NAO_TRIANGULO, t.getTipo());
    }

    @Test
    public void testSomaDoisLadosIgualTerceiro1() {
        Triangulo t = new Triangulo(2, 3, 5);
        assertFalse(t.formaTriangulo());
        assertEquals(TipoTriangulo.NAO_TRIANGULO, t.getTipo());
    }

    @Test
    public void testSomaDoisLadosIgualTerceiro2() {
        Triangulo t = new Triangulo(3, 5, 2);
        assertFalse(t.formaTriangulo());
        assertEquals(TipoTriangulo.NAO_TRIANGULO, t.getTipo());
    }

    @Test
    public void testSomaDoisLadosIgualTerceiro3() {
        Triangulo t = new Triangulo(5, 2, 3);
        assertFalse(t.formaTriangulo());
        assertEquals(TipoTriangulo.NAO_TRIANGULO, t.getTipo());
    }

    @Test
    public void testSomaDoisLadosMenorTerceiro1() {
        Triangulo t = new Triangulo(2, 2, 5);
        assertFalse(t.formaTriangulo());
        assertEquals(TipoTriangulo.NAO_TRIANGULO, t.getTipo());
    }

    @Test
    public void testSomaDoisLadosMenorTerceiro2() {
        Triangulo t = new Triangulo(5, 2, 2);
        assertFalse(t.formaTriangulo());
        assertEquals(TipoTriangulo.NAO_TRIANGULO, t.getTipo());
    }

    @Test
    public void testSomaDoisLadosMenorTerceiro3() {
        Triangulo t = new Triangulo(2, 5, 2);
        assertFalse(t.formaTriangulo());
        assertEquals(TipoTriangulo.NAO_TRIANGULO, t.getTipo());
    }

    @Test
    public void testTodosValoresZero() {
        Triangulo t = new Triangulo(0, 0, 0);
        assertFalse(t.formaTriangulo());
        assertEquals(TipoTriangulo.NAO_TRIANGULO, t.getTipo());
    }
}