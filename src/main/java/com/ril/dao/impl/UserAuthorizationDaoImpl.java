package com.ril.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.CriteriaSpecification;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ril.dao.UserAuthorizationDao;
import com.ril.entity.ModuleMaster;

@Repository
public class UserAuthorizationDaoImpl implements UserAuthorizationDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<ModuleMaster> findAll(ModuleMaster module) {
		
		Session session = sessionFactory.getCurrentSession();
		List<ModuleMaster> modules = null;
		try {

			Criteria criteria = session.createCriteria(ModuleMaster.class, "moduleMaster");
			//criteria.createAlias("moduleMasterTx", "moduleMasterTx");
			criteria.add(Restrictions.eq("moduleMaster.partnerRoleType",module.getPartnerRoleType()));
			criteria.setResultTransformer(CriteriaSpecification.DISTINCT_ROOT_ENTITY);

			modules = criteria.list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return modules;
	}
	@Override
	public <S extends ModuleMaster> S save(S entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends ModuleMaster> Iterable<S> save(Iterable<S> entities) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ModuleMaster findOne(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean exists(Long id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Iterable<ModuleMaster> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterable<ModuleMaster> findAll(Iterable<Long> ids) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long count() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(ModuleMaster entity) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Iterable<? extends ModuleMaster> entities) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub

	}


}
