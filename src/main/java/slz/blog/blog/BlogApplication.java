package slz.blog.blog;

import javax.sql.DataSource;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.jpa.JpaRepositoriesAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication(scanBasePackages = {"test"} , exclude = JpaRepositoriesAutoConfiguration.class)
@PropertySource({"classpath:application.properties"})
public class BlogApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(BlogApplication.class, args);
	}
	
	  @Override
      protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
          return application.sources(BlogApplication.class);
      }
	  
	  @Bean
	  @ConfigurationProperties(prefix = "spring.mysql.datasource")
	  public DataSource mysqlDataSource() {
	  	return DataSourceBuilder
	  				.create()
	  				.build();
	  }
}
