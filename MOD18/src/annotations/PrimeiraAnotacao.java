package annotations;

import java.lang.annotation.*;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.FIELD})
public @interface PrimeiraAnotacao {

    String NomeDaTabela();

    String[] TitutloColunas();

    int numeroLinhas() default 5;


}
