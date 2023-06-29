package MOD05test;

import org.junit.Test;

import static MOD02.fibo.FindFibo;
import static org.junit.Assert.assertEquals;

public class FiboTest {

    @Test
    public void FindFiboTest() {
        int n = 4;
        int f = FindFibo(n);
        int resposta = 3;

        assertEquals(resposta, f);

    }

    @Test
    public void FindFiboTest2() {
        int n = 0;
        int f = FindFibo(n);
        int resposta = 0;

        assertEquals(resposta, f);
    }

    @Test
    public void FindFiboTest3() {
        int n = 7;
        int f = FindFibo(n);
        int resposta = 13;


        assertEquals(resposta, f);
    }
}
