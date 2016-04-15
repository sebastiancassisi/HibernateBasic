/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.hibernate.dao;

import ar.com.hibernate.conf.SessionManager;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author educacionit
 * @param <E>
 * @param <Pk>
 */
public abstract class Dao<E, Pk extends Serializable> {

    public void grabar(E entity) {

        Session session = null;
        Transaction transaction = null;
        try {
            session = SessionManager.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            // el metodo saveOrUpdate realiza automaticamente la operacion correcta
            session.saveOrUpdate(entity);
            transaction.commit();

        } catch (HibernateException ex) {
            if (transaction != null) {
                transaction.rollback(); // Realiza un rollback si re realiza una sucesion de operaciones en la base y alguna no se cumple correctamente.
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public void modificar(E entity) {

        Session session = null;
        Transaction transaction = null;
        try {
            session = SessionManager.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            // el metodo saveOrUpdate realiza automaticamente la operacion correcta
            session.update(entity);
            transaction.commit();

        } catch (HibernateException ex) {
            if (transaction != null) {
                transaction.rollback(); // Realiza un rollback si re realiza una sucesion de operaciones en la base y alguna no se cumple correctamente.
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public void eliminar(E entity) {

        Session session = null;
        try {
            session = SessionManager.getSessionFactory().openSession();
            Transaction transaction = session.beginTransaction();
            session.delete(entity);
            transaction.commit();
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public E buscarPorId(Pk id) {

        Session session = null;
        try {
            session = SessionManager.getSessionFactory().openSession();

            return (E) session.get(getType(), id);
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    private Class getType() {

        Type superClass = this.getClass().getGenericSuperclass();
        ParameterizedType parameterizerClass = (ParameterizedType) superClass;
        Type[] args = parameterizerClass.getActualTypeArguments();
        return (Class) args[0];
    }

    public <T> List<T> obtenerTodos(Class<T> clazz) {
        Session s = SessionManager.getSessionFactory().openSession();
        Query q = s.createQuery("from " + clazz.getName());
        List<T> entities = q.list();
        s.close();
        return entities;
    }
}
