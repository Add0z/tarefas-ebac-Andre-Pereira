package ds.MOD13.DS.MOD3.estrangulado;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "ds.MOD13.DS.MOD3.estrangulado.repositorios")
@EnableFeignClients(basePackages = "ds.MOD13.DS.MOD3.estrangulado.feign")
public class DsMod13EstranguladoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DsMod13EstranguladoApplication.class, args);
	}

}
