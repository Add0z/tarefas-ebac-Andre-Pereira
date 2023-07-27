package ds.MOD13.DS.MOD3.agente.estrangulador;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "ds.MOD13.DS.MOD3.agente.estrangulador.repo")
public class DsMod13AgenteEstranguladorApplication {

	public static void main(String[] args) {
		SpringApplication.run(DsMod13AgenteEstranguladorApplication.class, args);
	}

}
