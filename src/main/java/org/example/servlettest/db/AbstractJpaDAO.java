package org.example.servlettest.db;

import jakarta.persistence.EntityManager;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;


public abstract class AbstractJpaDAO<PK extends Serializable, T> implements AutoCloseable {

    private Class<T> clazz;
    protected JPAService jpaService;

    @SuppressWarnings("unchecked")
    public AbstractJpaDAO() {
        this.clazz = (Class<T>) ((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[1];
        this.jpaService = JPAService.getInstance();
    }

    public T findById(PK pk) {
        return jpaService.findById(clazz, pk);
    }

    public List<T> findAll() {
        return jpaService.findAll(clazz);
    }

    public List<T> findAll(String condition) {
        return jpaService.findAll(clazz, condition);
    }

    public void createOrUpdate(T entity) {
        jpaService.saveOrUpdate(entity);
    }

    public void create(T entity) {
        jpaService.create(entity);
    }

    public T update(T entity) {
        return jpaService.update(entity);
    }

    public void delete(T entity) {
        jpaService.delete(entity);
    }

    public void deleteById(PK pk) {
        jpaService.deleteById(clazz, pk);
    }

    protected EntityManager getEntityManager() {
        return jpaService.getEntityManager();
    }

    @Override
    public void close() throws Exception {
        this.jpaService.close();

    }
}
