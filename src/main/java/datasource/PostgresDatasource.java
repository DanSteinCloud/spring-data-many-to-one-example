package datasource;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import com.zaxxer.hikari.HikariDataSource;

@Configuration
public class PostgresDatasource {
	@Bean
	@Primary
	@ConfigurationProperties("app.datasource")
  public HikariDataSource hikariDataSource() {
	  return DataSourceBuilder
			  .create()
			  .type(HikariDataSource.class)
			  .build();
  }
}
