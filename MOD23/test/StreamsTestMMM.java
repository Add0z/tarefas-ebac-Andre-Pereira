import org.junit.Assert;
import org.junit.jupiter.api.Test;
import java.util.List;



class StreamsTestMMM {
    @Test
    void mainAndre() {
        Streams streams = new Streams();
        List<String> chavesComValorM = streams.chavesComValorM;
        Assert.assertTrue(chavesComValorM.contains("Andre"));
    }
    @Test
    void mainJose() {
        Streams streams = new Streams();
        List<String> chavesComValorM = streams.chavesComValorM;
        Assert.assertTrue(chavesComValorM.contains("José"));
    }
}