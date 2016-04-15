/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.hibernate.conf;


import ar.com.hibernate.model.CajaAhorro;
import ar.com.hibernate.model.Cliente;
import ar.com.hibernate.model.Cuenta;
import ar.com.hibernate.model.CuentaCorriente;
import ar.com.hibernate.model.Poliza;
import ar.com.hibernate.model.Seguro;
import java.util.Properties;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

/**
 *
 * @author alumno
 */
public class SessionManager {

    private Configuration configuration;
    private SessionFactory sessionFactory;
    private static SessionManager sessionManager;

    private SessionManager() {

        configuration = new Configuration();
        registerClases();
        Properties properties = getProperties();
        configuration.setProperties(properties);
        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(properties).build();
        sessionFactory = configuration.buildSessionFactory(serviceRegistry);

    }

    private void registerClases() {
        configuration.addAnnotatedClass(CajaAhorro.class);
        configuration.addAnnotatedClass(Cliente.class);
        configuration.addAnnotatedClass(Cuenta.class);
        configuration.addAnnotatedClass(CuentaCorriente.class);
        configuration.addAnnotatedClass(Poliza.class);
        configuration.addAnnotatedClass(Seguro.class);
    }

    private Properties getProperties() {
        Properties properties = new Properties();
        properties.put("hibernate.connection.driver_class", "com.mysql.jdbc.Driver");
        properties.put("hibernate.connection.url", "jdbc:mysql://localhost/ovhibernate");
        properties.put("hibernate.connection.username", "root");
        properties.put("hibernate.connection.password", "root");
        properties.put("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
        properties.put("hibernate.show_sql", "true");
        properties.put("hibernate.hbm2ddl.auto", "create");
        return properties;
    }

    public static SessionFactory getSessionFactory() {

        if (sessionManager == null) {
            sessionManager = new SessionManager();
        }
        return sessionManager.sessionFactory;

    }

    public static void cerrar() {
        sessionManager.sessionFactory.close();

    }

}
