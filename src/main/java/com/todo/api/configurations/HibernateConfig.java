package com.todo.api.configurations;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@EnableTransactionManagement
public class HibernateConfig {
    @Autowired
    private Environment env;
    /*@Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
        LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(getDataSource());
        em.setPackagesToScan("com.todo.api.domain.models");

        JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        em.setJpaVendorAdapter(vendorAdapter);
        em.setJpaProperties(hibernateProperties());

        return em;
    }/*

    @Bean
    public DataSource dataSource() {
        DataSourceBuilder dataSource = DataSourceBuilder.create();
        //dataSource.driverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.driverClassName("org.postgresql.Driver");
        dataSource.url("jdbc:postgresql://localhost:5432/ToDoDb");
        dataSource.username("springbootuser");
        dataSource.password("$test1234");

        return dataSource.build();
    }
    private Properties hibernateProperties() {
        Properties hibernateProperties = new Properties();
        hibernateProperties.setProperty(
                "hibernate.hbm2ddl.auto", "update");
        /*hibernateProperties.setProperty(
                "hibernate.dialect", "org.hibernate.dialect.MySQL57DialectPostgreSQLDialect");
        hibernateProperties.setProperty(
                "hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect");

        hibernateProperties.setProperty(
                "current_session_context_class", "spring.jpa.properties.hibernate.current_session_context_class");

        return hibernateProperties;
    }*/

    @Bean(name = "dataSource")
    public DataSource getDataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();

        // See: application.properties
        dataSource.setDriverClassName(env.getProperty("spring.datasource.driver-class-name"));
        dataSource.setUrl(env.getProperty("spring.datasource.url"));
        dataSource.setUsername(env.getProperty("spring.datasource.username"));
        dataSource.setPassword(env.getProperty("spring.datasource.password"));
        System.out.println("## getDataSource: " + dataSource);
        return dataSource;
    }
    @Autowired
    @Bean(name = "entityManagerFactory")
    public SessionFactory getSessionFactory(DataSource dataSource) throws Exception {
        Properties properties = new Properties();
        // See: application.properties
        properties.put("hibernate.dialect", env.getProperty("spring.jpa.properties.hibernate.dialect"));
        properties.put("hibernate.show_sql", env.getProperty("spring.jpa.show-sql"));
        properties.put("current_session_context_class", //
                env.getProperty("spring.jpa.properties.hibernate.current_session_context_class"));
        properties.put("hibernate.hbm2ddl.auto", //
                env.getProperty("spring.jpa.hibernate.ddl-auto"));
        // Fix Postgres JPA Error:
        // Method org.postgresql.jdbc.PgConnection.createClob() is not yet implemented.
        // properties.put("hibernate.temp.use_jdbc_metadata_defaults",false);
        LocalSessionFactoryBean factoryBean = new LocalSessionFactoryBean();
        // Package contain entity classes
        factoryBean.setPackagesToScan(new String[] { "com.todo.api.domain.models" });
        factoryBean.setDataSource(dataSource);
        factoryBean.setHibernateProperties(properties);
        factoryBean.afterPropertiesSet();
        //
        SessionFactory sf = factoryBean.getObject();
        System.out.println("## getSessionFactory: " + sf);
        return sf;
    }

    @Autowired
    @Bean(name = "transactionManager")
    public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory) {
        HibernateTransactionManager transactionManager = new HibernateTransactionManager(sessionFactory);
        return transactionManager;
    }

}
