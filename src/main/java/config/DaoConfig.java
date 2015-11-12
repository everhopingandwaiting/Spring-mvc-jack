package config;

import dao.*;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

/**
 * Created by john on 15-9-29.
 */
@Configuration
@EnableTransactionManagement
public class DaoConfig {

    @Bean
    public ClassDao classDao(HibernateTemplate hibernateTemplate) {
        return new ClassDao(hibernateTemplate);
    }

    @Bean
    public CourseDao courseDao(HibernateTemplate hibernateTemplate) {
        return new CourseDao(hibernateTemplate);
    }

    @Bean
    public NumberDao numberDao(HibernateTemplate hibernateTemplate) {
        return new NumberDao(hibernateTemplate);
    }

    @Bean
    public StudentDao studentDao(HibernateTemplate hibernateTemplate) {
        return new StudentDao(hibernateTemplate);
    }

    @Bean
    public RoleDao roleDao(HibernateTemplate hibernateTemplate) {
        return new RoleDao(hibernateTemplate);
    }

    @Bean
    public HibernateTemplate hibernateTemplate(SessionFactory sessionFactory) {
        return new HibernateTemplate(sessionFactory);
    }

    @Bean
    public SessionFactory sessionFactory(DataSource dataSource) {
        return new LocalSessionFactoryBuilder(dataSource)
                .scanPackages("domain")
                .setProperty("hibernate.show_sql", "true")
                .setProperty("hibernate.dialect", "org.hibernate.dialect.H2Dialect")
                .setProperty("hibernate.hbm2ddl.auto", "create-drop")
                .buildSessionFactory();
    }

    @Bean
    @Profile("prod")
    @Primary
    public DataSource DataSource() {
        //TODO replace DriverManagerDataSource to support connection pool etc.
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setUrl("jdbc:h2:tcp://localhost:9092/~/stusys");
        dataSource.setDriverClassName("org.h2.Driver");
        dataSource.setUsername("sa");
        dataSource.setPassword("");
        return dataSource;
    }

    @Bean(destroyMethod = "shutdown", name = "dataSource")
    @Profile("dev")
    public DataSource devDataSource() {
        return new EmbeddedDatabaseBuilder()
                .setType(EmbeddedDatabaseType.H2)
                .setName("devdb")
                .build();
    }

    @Bean
    public PlatformTransactionManager transactionManager(SessionFactory sessionFactory) {
        return new HibernateTransactionManager(sessionFactory);
    }
}
