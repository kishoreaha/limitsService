//package com.product.crudDemo.configurtions;
//
//
//import jakarta.persistence.EntityManagerFactory;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.boot.context.properties.ConfigurationProperties;
//import org.springframework.boot.jdbc.DataSourceBuilder;
//import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.Primary;
//import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
//import org.springframework.orm.jpa.JpaTransactionManager;
//import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
//import org.springframework.transaction.PlatformTransactionManager;
//import org.springframework.transaction.annotation.EnableTransactionManagement;
//
//import javax.sql.DataSource;
//import java.util.HashMap;
//
//@Configuration
//@EnableTransactionManagement
//@EnableJpaRepositories(entityManagerFactoryRef = "entityManagerFactory",
//basePackages = "com.product.crudDemo.db1.repository")
//public class DB1Configuration {
//    @Primary
//    @Bean(name="dataSource")
//    @ConfigurationProperties(prefix="spring.db1.datasource")
//    public DataSource datasource(){
//        return DataSourceBuilder.create().build();
//    }
//
//    @Primary
//    @Bean(name="entityManagerFactory")
//    public LocalContainerEntityManagerFactoryBean entityManagerFactory(EntityManagerFactoryBuilder builder,
//                                                                       @Qualifier("dataSource") DataSource datasource){
//
//        HashMap <String,Object>hm = new HashMap();
//        hm.put("hibernate.hbm2ddl.auto","update");
//        return builder.
//                dataSource(datasource).
//                properties(hm).
//                packages("com.product.crudDemo.db1.model").
//                persistenceUnit("db1").build();
//    }
//
//    @Primary
//    @Bean(name="trasactionManager")
//    public PlatformTransactionManager trasactionManager(@Qualifier("entityManagerFactory") EntityManagerFactory entityManagerFactory ){
//        return new JpaTransactionManager(entityManagerFactory);
//    }
//
//}
