package ds.MOD1.DS.MOD1.zookeeper.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class DsMod11ZookeeperServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(DsMod11ZookeeperServerApplication.class, args);
	}

}
