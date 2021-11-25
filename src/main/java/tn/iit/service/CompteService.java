package tn.iit.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.iit.dao.CompteDaoSpringData;
import tn.iit.entity.Compte;
@Service
public class CompteService {

	//private final CompteDaoJPA compteDao;

	private final CompteDaoSpringData compteDaoSpringData;

	@Autowired
	public CompteService(CompteDaoSpringData compteDaoSpringData) {
		super();
		this.compteDaoSpringData = compteDaoSpringData;
	}

	/*@Autowired
	public CompteService(CompteDaoJPA compteDao) {
		super();
		this.compteDao = compteDao;
	}*/

	public void save(Compte compte) {
		//compteDao.save(compte);
		compteDaoSpringData.saveAndFlush(compte);
	}

	public List<Compte> getAll() {
		//return compteDao.getAll();
		return compteDaoSpringData.findAll();
	}
	/*public int getCount() {
		return compteDaoSpringData.getCount();
	}*/
	/*public float getSum() {
		return compteDaoSpringData.getSum();
	}*/
	/*public float getTop() {
		return compteDaoSpringData.getTop();
	}*/
	public void delete(Compte compte) {
		//compteDao.delete(compte);
		compteDaoSpringData.delete(compte);
	}

	public void delete(Long rib) {
		//compteDao.delete(rib);
		compteDaoSpringData.deleteById(rib);
	}

	public Compte findById(Long rib) {

		//return compteDao.findById(rib);
		return compteDaoSpringData.findById(rib).get();
	}

	public void update(Compte compte) {
		//compteDao.update(compte);
		compteDaoSpringData.saveAndFlush(compte);
	}
}