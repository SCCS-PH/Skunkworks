package com.hccs.skunkworks.jpa.controllers;

/**
 *
 * @author DCSalenga
 */
import com.hccs.skunkworks.jpa.models.CommandBean;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Query;

public class CommandBeanJpaController implements Serializable {

    private EntityManagerFactory emf = null;

    public CommandBeanJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }

    public EntityManager getEntityManager() {
        if (emf != null) {
            emf.getCache().evictAll();
        }
        return emf.createEntityManager();
    }

    public boolean create(CommandBean registrationBean) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(registrationBean);
            em.getTransaction().commit();
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public boolean edit(CommandBean registrationBean) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.merge(registrationBean);
            em.getTransaction().commit();
            return true;
        } catch (Exception ex) {
            return false;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public boolean destroy(CommandBean bean) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            CommandBean cBean = null;
            try {
                cBean = em.getReference(CommandBean.class, bean.getCommandid());
                cBean.getCommandid();
            } catch (EntityNotFoundException enfe) {
            }
            em.remove(cBean == null ? bean : cBean);
            em.getTransaction().commit();
            return true;
        } catch (Exception ex) {
            return false;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<CommandBean> findAllCommands() {
        EntityManager em = getEntityManager();
        Query q = em.createNamedQuery("CommandBean.findAll");
        return q.getResultList();
    }
}
