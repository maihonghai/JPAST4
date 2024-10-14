package vn.iotstar.dao.impl;

import java.util.List;

import vn.iotstar.dao.IUserDao;
import vn.iotstar.entity.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

import jakarta.persistence.TypedQuery;
import vn.iotstar.configs.JPAConfig;


public class UserDao implements IUserDao {

	@Override
	public void insert(User user) {
		EntityManager em = JPAConfig.getEntityManager();
        EntityTransaction trans = em.getTransaction();
        try {
            trans.begin();
            em.persist(user);
            trans.commit();
        } catch (Exception e) {
            trans.rollback();
            throw e;
        } finally {
            em.close();
        }
		
	}

	@Override
	public void update(User user) {
		 EntityManager em = JPAConfig.getEntityManager();
	        EntityTransaction trans = em.getTransaction();
	        try {
	            trans.begin();
	            em.merge(user);
	            trans.commit();
	        } catch (Exception e) {
	            trans.rollback();
	            throw e;
	        } finally {
	            em.close();
	        }
	}

	@Override
	public void delete(int userId) {
		 EntityManager em = JPAConfig.getEntityManager();
	        EntityTransaction trans = em.getTransaction();
	        try {
	            trans.begin();
	            User user = em.find(User.class, userId);
	            if (user != null) {
	                em.remove(user);
	                trans.commit();
	            }
	        } catch (Exception e) {
	            trans.rollback();
	            throw e;
	        } finally {
	            em.close();
	        }
		
	}

	@Override
	public User findById(int userId) {
		EntityManager em = JPAConfig.getEntityManager();
        return em.find(User.class, userId);
	}

	@Override
	public List<User> searchByName(String username) {
		 EntityManager em = JPAConfig.getEntityManager();
	        String jpql = "SELECT u FROM User u WHERE u.username LIKE :username";
	        TypedQuery<User> query = em.createQuery(jpql, User.class);
	        query.setParameter("username", "%" + username + "%");
	        return query.getResultList();
	}
	public List<User> findAll() {
		EntityManager enma = JPAConfig.getEntityManager();
		TypedQuery<User>query= enma.createNamedQuery("User.findAll", User.class);
		return query.getResultList();
    }

}
