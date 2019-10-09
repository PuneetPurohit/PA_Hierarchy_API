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
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
/*
import org.springframework.beans.factory.annotation.Autowired;
import freemarker.core.Environment;
*/
//@Configuration
//@PropertySource("file:${catalina.home}/conf/pcretailconf/database.properties")
//@EnableTransactionManagement
public class HibernateConfiguration {

	private static final String tokenkey = "p@rtcentr@l_prod";
	/*
	@Autowired
	private Environment env;
	*/
	
	@Value("${spring.datasource.driver-class-name}")
    private String DB_DRIVER;

    @Value("${spring.datasource.password}")
    private String DB_PASSWORD;

    @Value("${spring.datasource.url}")
    private String DB_URL;

    @Value("${spring.datasource.username}")
    private String DB_USERNAME;

    @Value("${spring.jpa.properties.hibernate.dialect}")
    private String HIBERNATE_DIALECT;

    @Value("${spring.jpa.show-sql}")
    private String HIBERNATE_SHOW_SQL;

    @Value("${spring.jpa.hibernate.ddl-auto}")
    private String HIBERNATE_HBM2DDL_AUTO;

    @Value("${entitymanager.packagesToScan}")
    private String ENTITYMANAGER_PACKAGES_TO_SCAN;
    
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
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(DB_DRIVER);
        dataSource.setUrl(DB_URL);
        dataSource.setUsername(DB_USERNAME);
       // dataSource.setPassword(EncryptionDecryptionHelper.decrypt(EncryptionDecryptionHelper.decryptUtilities((DB_PASSWORD).trim()), tokenkey));
        dataSource.setPassword(DB_PASSWORD);
        return dataSource;
    }

    @Bean
    public HibernateTransactionManager transactionManager() throws KeyException, InvalidAlgorithmParameterException, IllegalBlockSizeException, BadPaddingException, GeneralSecurityException, IOException {
        HibernateTransactionManager txManager = new HibernateTransactionManager();
        txManager.setSessionFactory(sessionFactory().getObject());
        return txManager;
    }
}

/*package com.ril.base.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
public class HibernateConfiguration {

	 @Value("${db.driver}")
	    private String DB_DRIVER;

	    @Value("${db.password}")
	    private String DB_PASSWORD;

	    @Value("${db.url}")
	    private String DB_URL;

	    @Value("${db.username}")
	    private String DB_USERNAME;

	    @Value("${hibernate.dialect}")
	    private String HIBERNATE_DIALECT;

	    @Value("${hibernate.show_sql}")
	    private String HIBERNATE_SHOW_SQL;
	    
	    @Value("${hibernate.format_sql}")
	    private String HIBERNATE_FORMAT_SQL;

	    @Value("${hibernate.hbm2ddl.auto}")
	    private String HIBERNATE_HBM2DDL_AUTO;

	    @Value("${entitymanager.packagesToScan}")
	    private String ENTITYMANAGER_PACKAGES_TO_SCAN;


	    @Bean
	    public LocalSessionFactoryBean sessionFactory() {
	        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
	        sessionFactory.setDataSource(dataSource());
	        sessionFactory.setPackagesToScan(ENTITYMANAGER_PACKAGES_TO_SCAN);
	        Properties hibernateProperties = new Properties();
	        hibernateProperties.put("hibernate.dialect", HIBERNATE_DIALECT);
	        hibernateProperties.put("hibernate.show_sql", HIBERNATE_SHOW_SQL);
	        hibernateProperties.put("hibernate.format_sql", HIBERNATE_FORMAT_SQL);
	        hibernateProperties.put("hibernate.hbm2ddl.auto", HIBERNATE_HBM2DDL_AUTO);
	        sessionFactory.setHibernateProperties(hibernateProperties);
	        return sessionFactory;
	    }

    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(DB_DRIVER);
        dataSource.setUrl(DB_URL);
        dataSource.setUsername(DB_USERNAME);
        dataSource.setPassword(DB_PASSWORD);
        return dataSource;
    }

    @Bean
    public HibernateTransactionManager transactionManager() {
        HibernateTransactionManager txManager = new HibernateTransactionManager();
        txManager.setSessionFactory(sessionFactory().getObject());
        return txManager;
    }
    
    @Bean
    public ModelMapper modelMapper(){
    	return new ModelMapper();
    }
}
*/