import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({ClienteDaoTest.class, ClienteServiceTest.class,ProdutoDaoTest.class, ProdutoServiceTest.class})
public class AllTests {
}