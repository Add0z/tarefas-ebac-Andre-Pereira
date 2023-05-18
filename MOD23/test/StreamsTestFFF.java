import org.junit.Assert;
import org.junit.jupiter.api.Test;
import java.util.List;



class StreamsTestFFF {
    /*EXISTE ELENA NA LISTA*/
    @Test
    void mainElena() {
        Streams streams = new Streams();
        List<String> chavesComValorF = streams.chavesComValorF;
        Assert.assertTrue(chavesComValorF.contains("Elena"));
    }

    /* NÃO EXITE ANA NA LISTA*/
    @Test
    void mainAna() {
        Streams streams = new Streams();
        List<String> chavesComValorF = streams.chavesComValorF;
        Assert.assertTrue(chavesComValorF.contains("Ana"));
    }
}

