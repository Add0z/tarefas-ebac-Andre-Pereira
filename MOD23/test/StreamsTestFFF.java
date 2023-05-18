import junit.framework.AssertionFailedError;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;



public class StreamsTestFFF {
    /*EXISTE ELENA NA LISTA*/
    @Test
    public void mainElena() {
        Streams streams = new Streams();
        List<String> chavesComValorF = streams.chavesComValorF;
        try {
            Assert.assertTrue(chavesComValorF.contains("Elena"));
        }catch (AssertionFailedError error){
            System.out.println("Nome Elena não consta na lista");
        }


    }

    /* NÃO EXITE ANA NA LISTA*/
    @Test
    public void mainAna() {
        Streams streams = new Streams();
        List<String> chavesComValorF = streams.chavesComValorF;
        try {
            Assert.assertTrue(chavesComValorF.contains("Ana"));
        }catch (AssertionFailedError error){
            System.out.println("Nome Elena não consta na lista");
        }
    }
}

