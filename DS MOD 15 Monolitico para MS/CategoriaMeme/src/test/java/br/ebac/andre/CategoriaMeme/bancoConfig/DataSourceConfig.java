package br.ebac.andre.CategoriaMeme.bancoConfig;

import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

@Configuration
public class DataSourceConfig {

    // Configuração do primeiro DataSource (datasource1)
    @Bean(name = "dataSource1")
    @Primary
    @ConfigurationProperties(prefix = "spring.datasource.datasource1")
    public DataSource dataSource1(DataSourceProperties properties) {
        return properties.initializeDataSourceBuilder().build();
    }

    // Configuração do segundo DataSource (datasource2)
    @Bean(name = "dataSource2")
    @ConfigurationProperties(prefix = "spring.datasource.datasource2")
    public DataSource dataSource2(DataSourceProperties properties) {
        return properties.initializeDataSourceBuilder().build();
    }
}