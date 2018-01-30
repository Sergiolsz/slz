package slz.blog.global.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.lookup.JndiDataSourceLookup;

@Configuration
public class MySQLDataSourceConfiguration {

	@Value("${spring.mysql.datasource.jndi-name}")
	private String mySQLJNDIName;

	@Bean(destroyMethod = "")
	public DataSource mySQLDataSource() {
		JndiDataSourceLookup dataSourceLookup = new JndiDataSourceLookup();
		return dataSourceLookup.getDataSource(mySQLJNDIName);
	}

	@Bean()
	@Qualifier("mySQLJdbcTemplate")
	public JdbcTemplate mySQLrJdbcTemplate() {
		return new JdbcTemplate(mySQLDataSource());
	}
}
