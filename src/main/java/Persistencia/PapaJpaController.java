
package Persistencia;

import Logica.Papa;
import Persistencia.exceptions.NonexistentEntityException;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;


public class PapaJpaController implements Serializable {

    public PapaJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;
    
    public PapaJpaController() {
        emf = Persistence.createEntityManagerFactory("EscuelaPu");
    }

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Papa papa) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(papa);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Papa papa) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            papa = em.merge(papa);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = papa.getNum_Papa();
                if (findPapa(id) == null) {
                    throw new NonexistentEntityException("The papa with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(int id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Papa papa;
            try {
                papa = em.getReference(Papa.class, id);
                papa.getNum_Papa();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The papa with id " + id + " no longer exists.", enfe);
            }
            em.remove(papa);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Papa> findPapaEntities() {
        return findPapaEntities(true, -1, -1);
    }

    public List<Papa> findPapaEntities(int maxResults, int firstResult) {
        return findPapaEntities(false, maxResults, firstResult);
    }

    private List<Papa> findPapaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Papa.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public Papa findPapa(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Papa.class, id);
        } finally {
            em.close();
        }
    }

    public int getPapaCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Papa> rt = cq.from(Papa.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
