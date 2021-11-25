package tn.iit.dao;

import org.springframework.stereotype.Repository;
import tn.iit.entity.Compte;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public class CompteDaoJPA {

	@PersistenceContext
	private EntityManager em;

	@Transactional
	public void save(Compte compte) {
		em.persist(compte);
	}

	// sa or 1=1--
	public List<Compte> getAll() {
		/*
		 * // c'est pas sql c'est du jpql --> orienté objet return
		 * em.createQuery("select c from Compte c",Compte.class).getResultList();
		 */
		// 2éme maniére: requete décalreé dans l'entite
		return em.createNamedQuery("all-compte", Compte.class).getResultList();

	}
	/*public int getCount() {
		return em.createNamedQuery("count-compte", Compte.class).getFirstResult();
	}*/
	/*public float getSum() {
		return em.createNamedQuery("sum-money", Compte.class).getFirstResult();
	}*/
	/*public float getTop() {
		return em.createNamedQuery("top-money", Compte.class).getFirstResult();
	}*/
	public Compte findById(Long rib) {
		return em.find(Compte.class, rib);
	}

	@Transactional
	public void delete(Compte compte) {
		em.remove(compte);
	}

	@Transactional
	public void delete(Long rib) {
		em.remove(findById(rib));
	}

	@Transactional
	public void update(Compte compte) {
		em.merge(compte);
	}

}
