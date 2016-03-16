package MVC;

import JavaBeans.userBean;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

/**
 * Created by JordanHope on 3/15/2016.
 */
public class HibernateConfig {
    private SessionFactory sessionFactory;

    public HibernateConfig() {
        Configuration config = new Configuration();

        config.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");

        config.setProperty("hibernate.connection.driver_class", "com.mysql.jdbc.Driver");

        //change the next line of code to match your MySQL URL and port

        config.setProperty("hibernate.connection.url", "jdbc:mysql://localhost:3306/?user=root");

        //change the next two lines of code to match your MySQL user name and password.

        config.setProperty("hibernate.connection.username", "root");

        config.setProperty("hibernate.connection.password", "Jordan3Hope");

        //change the pool size to reflect how many users you expect your application to have initially

        config.setProperty("hibernate.connection.pool_size", "15");

        config.setProperty("hibernate.connection.autocommit", "true");

        config.setProperty("hibernate.cache.provider_class", "org.hibernate.cache.NoCacheProvider");

		/*
		 * un-comment the next line of code if you want to be able to drop and recreate tables for your data classes listed below.  This is generally a bad idea for security reasons.
		 */

        //config.setProperty("hibernate.hbm2ddl.auto", "create-drop");

        config.setProperty("hibernate.show_sql", "true");

        config.setProperty("hibernate.transaction.factory_class", "org.hibernate.transaction.JDBCTransactionFactory");

        config.setProperty("hibernate.current_session_context_class", "thread");

		/*
		 *  Add your classes here that you want to match your database tables
		 *  The example has a User and a PhoneNumber class.
		 */

        config.addAnnotatedClass(userBean.class);

        ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(config.getProperties()).buildServiceRegistry();

        sessionFactory = config.buildSessionFactory(serviceRegistry);
    }

    public Session getCurrentSession() {

        return sessionFactory.getCurrentSession();

    }

}
