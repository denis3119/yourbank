package com.yourbank.config;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaDialect;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.AbstractMap;
import java.util.Collections;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author Yugov Alexandr.
 */
@Configuration
@EnableTransactionManagement
@EnableJpaRepositories("com.yourbank.data.repository")
@PropertySource("classpath:/db.properties")
public class DatabaseConfig {

    @Autowired
    private Environment environment;

    @Bean
    public DataSource dataSource(
            @Value("${db.url}") String url,
            @Value("${db.username}") String username,
            @Value("${db.password}") String password,
            @Value("${db.driver}") String driver
    ) {
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setUrl(url);
        dataSource.setDriverClassName(driver);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        return dataSource;
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(DataSource dataSource) {
        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();

        LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
        factory.setJpaVendorAdapter(vendorAdapter);
        factory.setPackagesToScan("com.yourbank.data.model");
        factory.setDataSource(dataSource);

//        factory.setPersistenceProvider(persistenceInterceptorProvider);

        factory.setJpaPropertyMap(Collections.unmodifiableMap(Stream.<AbstractMap.SimpleEntry<String, Object>>of(
                new AbstractMap.SimpleEntry<>("hibernate.dialect", environment.getProperty("hibernate.dialect")),
                new AbstractMap.SimpleEntry<>("hibernate.show_sql", environment.getProperty("hibernate.show_sql")),
                new AbstractMap.SimpleEntry<>("hibernate.hbm2ddl.auto", environment.getProperty("hibernate.format_sql"))
        ).collect(Collectors.toMap(AbstractMap.SimpleEntry::getKey, AbstractMap.SimpleEntry::getValue))));

        return factory;
    }

    @Bean
    public JpaTransactionManager transactionManager() {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setJpaDialect(new HibernateJpaDialect());
        return transactionManager;
    }
}
