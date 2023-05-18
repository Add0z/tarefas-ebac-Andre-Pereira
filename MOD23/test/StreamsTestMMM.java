import org.junit.Assert;
import java.util.List;
import org.junit.Test;



public class StreamsTestMMM {
    /*EXISTE ANDRÉ NA LISTA*/
    @Test
    public void mainAndre() {
        Streams streams = new Streams();
        List<String> chavesComValorM = streams.chavesComValorM;
        Assert.assertTrue(chavesComValorM.contains("Andre"));
    }
    /*NÃO EXISTE JOSÉ NA LISTA*/
    @Test
    public void mainJose() {
        Streams streams = new Streams();
        List<String> chavesComValorM = streams.chavesComValorM;
        Assert.assertTrue(chavesComValorM.contains("José"));
    }
}