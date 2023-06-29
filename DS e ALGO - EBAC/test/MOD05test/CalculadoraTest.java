package MOD05test;

import MOD05.Calculadora;
import org.junit.Test;

import static java.lang.System.*;
import static org.junit.Assert.assertEquals;


public class CalculadoraTest {
    final Calculadora calculadora = new Calculadora();

    @Test
    public void testSum() {
       final int soma = calculadora.sum(1, 2);
        System.out.println("Soma = " + soma);
        assertEquals(3, soma);


    }

    @Test
    public void testSub() {
        final int sub = calculadora.sub(1, 2);
        System.out.println("Subtração = " + sub);
        assertEquals(-1, sub);
    }

    @Test
    public void testMul() {
        final int mul = calculadora.mul(1, 2);
        System.out.println("Multiplicação = " + mul);
        assertEquals(2, mul);
    }

    @Test
    public void testDiv() {
        final int div = calculadora.div(1, 2);
        System.out.println("Divisão = " + div);
        assertEquals(0, div);
        final int div2 = calculadora.div(1, 0);
        System.out.println("Divisão por 0 = " + div);
        assertEquals(0, div);
    }



}
