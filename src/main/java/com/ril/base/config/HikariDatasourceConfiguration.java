package com.ril.base.config;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;
import java.security.KeyException;
import java.util.Properties;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.ril.util.EncryptionDecryptionHelper;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

@Configuration
@EnableTransactionManagement
//@PropertySource("classpath:hikari.properties")
@PropertySource({"classpath:hikari.properties","classpath:application.properties"})
public class HikariDatasourceConfiguration {

	private static final String tokenkey = "p@rtcentr@l_prod";
	
	@Value("${spring.datasource.driver-class-name}")
    private String DB_DRIVER;
	
/*	@Value("${driverClassName}")
    private String DB_DRIVER;

    @Value("${spring.datasource.password}")
    private String DB_PASSWORD;*/

    @Value("${spring.datasource.url}")
    private String DB_URL;

    @Value("${spring.datasource.username}")
    private String DB_USERNAME;
    
    @Value("${spring.datasource.password}")
    private String DB_PASSWORD;
    
  /*  @Value("${jdbcUrl}")
    private String DB_URL;

    @Value("${username}")
    private String DB_USERNAME;*/

    @Value("${spring.jpa.properties.hibernate.dialect}")
    private String HIBERNATE_DIALECT;

    @Value("${spring.jpa.show-sql}")
    private String HIBERNATE_SHOW_SQL;

    @Value("${spring.jpa.hibernate.ddl-auto}")
    private String HIBERNATE_HBM2DDL_AUTO;

    @Value("${entitymanager.packagesToScan}")
    private String ENTITYMANAGER_PACKAGES_TO_SCAN;
    
   /* @Value("${maximum-pool-size}")
    private int MAXIMUM_POOL_SIZE;*/
    
   /* @Value("${connection-timeout}")
    private int CONNECTION_TIME_OUT;
    
    @Value("${minimum-idle}")
    private int MINIMUM_IDLE;
    
    @Value("${idle-timeout}")
    private long IDLE_TIMEOUT;
    @Value("${max-lifetime}")
    private long MAXIMUM_LIFETIME;
    @Value("${auto-commit}")
    private boolean AUTO_COMMIT;
    
    @Value("${spring.datasource.hikari.maximum-pool-size}")
    private int MAXIMUM_POOL_SIZE;*/
    
    @Value("${spring.datasource.hikari.maximum-pool-size}")
    private int MAXIMUM_POOL_SIZE;
    
    @Value("${spring.datasource.hikari.connection-timeout}")
    private int CONNECTION_TIME_OUT;
    
    @Value("${spring.datasource.hikari.minimum-idle}")
    private int MINIMUM_IDLE;
    
    @Value("${spring.datasource.hikari.idle-timeout}")
    private long IDLE_TIMEOUT;
    @Value("${spring.datasource.hikari.max-lifetime}")
    private long MAXIMUM_LIFETIME;
    @Value("${spring.datasource.hikari.auto-commit}")
    private boolean AUTO_COMMIT;
/*
    @Value("${spring.datasource.type}")
    private String DATASOURCE_TYPE;*/
    
    @Bean
    public LocalSessionFactoryBean sessionFactory() throws KeyException, InvalidAlgorithmParameterException, IllegalBlockSizeException, BadPaddingException, GeneralSecurityException, IOException {
        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
        sessionFactory.setDataSource(dataSource());
        sessionFactory.setPackagesToScan(ENTITYMANAGER_PACKAGES_TO_SCAN);
        Properties hibernateProperties = new Properties();
        hibernateProperties.put("spring.jpa.properties.hibernate.dialect", HIBERNATE_DIALECT);
        hibernateProperties.put("spring.jpa.show-sql", HIBERNATE_SHOW_SQL);
        hibernateProperties.put("spring.jpa.hibernate.ddl-auto", HIBERNATE_HBM2DDL_AUTO);
        sessionFactory.setHibernateProperties(hibernateProperties);
        return sessionFactory;
    }

    @Bean
    public DataSource dataSource() throws KeyException, InvalidAlgorithmParameterException, IllegalBlockSizeException, BadPaddingException, GeneralSecurityException, IOException {
    //	String configFile = "src/main/resources/hikari.properties";
    	//String configFile = "src/main/resources/properties/hikari.properties";
    	HikariConfig config = new HikariConfig();
    	
    	config.setDriverClassName(DB_DRIVER);
    	config.setJdbcUrl(DB_URL);
    	config.setUsername(DB_USERNAME);
    	//config.setPassword("Pzrhw9$w");
    	config.setPassword(EncryptionDecryptionHelper.decrypt(EncryptionDecryptionHelper.decryptUtilities((DB_PASSWORD).trim()), tokenkey));
    	//dataSource.setPassword(DB_PASSWORD);
    	config.setMaximumPoolSize(MAXIMUM_POOL_SIZE);
    	config.setMinimumIdle(MINIMUM_IDLE);
    	config.setAutoCommit(AUTO_COMMIT);
    	config.setConnectionTimeout(CONNECTION_TIME_OUT);
    	config.setIdleTimeout(IDLE_TIMEOUT);
    	config.setMaxLifetime(MAXIMUM_LIFETIME);
        final HikariDataSource dataSource= new HikariDataSource(config);
        return dataSource;
    }
  
    @Bean
    public HibernateTransactionManager transactionManager() throws KeyException, InvalidAlgorithmParameterException, IllegalBlockSizeException, BadPaddingException, GeneralSecurityException, IOException {
        HibernateTransactionManager txManager = new HibernateTransactionManager();
        txManager.setSessionFactory(sessionFactory().getObject());
        return txManager;
    }
}
