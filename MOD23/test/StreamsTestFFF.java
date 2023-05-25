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
    @Test(expected = AssertionError.class)
    public void mainAna() throws AssertionFailedError {
        Streams streams = new Streams();
        List<String> chavesComValorF = streams.chavesComValorF;
        Assert.assertTrue(chavesComValorF.contains("Ana"));
//        throw new AbstractMethodError("Não encontrado na lista");
    }
}

