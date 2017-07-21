package com.shenma.database;

import com.github.pagehelper.PageInterceptor;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.TransactionManagementConfigurer;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@ConfigurationProperties("spring.datasource")
public class DataBaseConfiguration extends DruidDataSourceConfig implements TransactionManagementConfigurer {
	private static final long serialVersionUID = 1L;

	@Bean(name = "dataSource")
	@Primary
	DataSource dataSource() {
		return this;
	}

	@Bean(name = "jdbcTemplate")
	@Primary
	public JdbcTemplate jdbcTemplate(DataSource dsItems) {
		return new JdbcTemplate(dsItems);
	}
	
	public void setPassword(String password) {
		//this.password = ConfigTools.decrypt(password);
		this.password = password;
	}
	
	@Bean(name = "sqlSessionFactory") // 3
	@Primary
	public SqlSessionFactory sqlSessionFactoryBean() {
		SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
		bean.setDataSource(dataSource());

//		// 分页拦截器-begin
//		PageInterceptor interceptor = new PageInterceptor();
//		Properties properties = new Properties();
//		properties.setProperty("helperDialect", "mysql");
//		properties.setProperty("offsetAsPageNum", "false");
//		interceptor.setProperties(properties);
//		// 分页拦截器-end

		try {
//			bean.getObject().getConfiguration().addInterceptor(interceptor);
			return bean.getObject();
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	@Bean(name="sqlSessionTemplate")
	@Primary
	public SqlSessionTemplate sqlSessionTemplate(SqlSessionFactory sqlSessionFactory) {
		return new SqlSessionTemplate(sqlSessionFactory);
	}

	@Bean(name = "transactionManager")
	@Primary
	public PlatformTransactionManager annotationDrivenTransactionManager() {
		return new DataSourceTransactionManager(dataSource());
	}
}