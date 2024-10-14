package vn.iotstar.dao.impl;

import java.util.List;

import vn.iotstar.dao.IVideoDao;
import vn.iotstar.entity.Video;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

import jakarta.persistence.TypedQuery;
import vn.iotstar.configs.JPAConfig;

public class VideoDao implements IVideoDao {

	@Override
	public void insert(Video video) {
		 EntityManager em = JPAConfig.getEntityManager();
	        EntityTransaction trans = em.getTransaction();
	        try {
	            trans.begin();
	            em.persist(video);
	            trans.commit();
	        } catch (Exception e) {
	            trans.rollback();
	            throw e;
	        } finally {
	            em.close();
	        }
		
	}

	@Override
	public void update(Video video) {
		EntityManager em = JPAConfig.getEntityManager();
        EntityTransaction trans = em.getTransaction();
        try {
            trans.begin();
            em.merge(video);
            trans.commit();
        } catch (Exception e) {
            trans.rollback();
            throw e;
        } finally {
            em.close();
        }
		
	}

	@Override
	public void delete(String videoId) {
		EntityManager em = JPAConfig.getEntityManager();
        EntityTransaction trans = em.getTransaction();
        try {
            trans.begin();
            Video video = em.find(Video.class, videoId);
            if (video != null) {
                em.remove(video);
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
	public Video findById(String videoId) {
		 EntityManager em = JPAConfig.getEntityManager();
	       return em.find(Video.class, videoId);
	}

	@Override
	public List<Video> searchByName(String title) {
		EntityManager em = JPAConfig.getEntityManager();
        String jpql = "SELECT v FROM Video v WHERE v.title LIKE :title";
        TypedQuery<Video> query = em.createQuery(jpql, Video.class);
        query.setParameter("title", "%" + title + "%");
        return query.getResultList();
	}

}
