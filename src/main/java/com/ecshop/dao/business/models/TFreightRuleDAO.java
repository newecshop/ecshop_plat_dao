package com.ecshop.dao.business.models;

import java.util.List;
import static org.hibernate.criterion.Example.create;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.ecshop.dao.base.hibernate.HibernateGenericDao;

/**
 * A data access object (DAO) providing persistence and search support for
 * TFreightRule entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see com.ecshop.dao.business.models.TFreightRule
 * @author MyEclipse Persistence Tools
 */
@Component
public class TFreightRuleDAO extends HibernateGenericDao<TFreightRule, Long> {
	private static final Logger log = LoggerFactory
			.getLogger(TFreightRuleDAO.class);
	// property constants
	public static final String FREIGHT = "freight";
	public static final String FREE_AMOUNT = "freeAmount";
	public static final String MALL_ID = "mallId";
	public static final String IS_DEFAULT = "isDefault";

	public TFreightRule findById(java.lang.Long id) {
		log.debug("getting TFreightRule instance with id: " + id);
		try {
			TFreightRule instance = (TFreightRule) getSession().get(
					"com.vveplat.dao.business.models.TFreightRule", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<TFreightRule> findByExample(TFreightRule instance) {
		log.debug("finding TFreightRule instance by example");
		try {
			List<TFreightRule> results = (List<TFreightRule>) getSession()
					.createCriteria(
							"com.vveplat.dao.business.models.TFreightRule")
					.add(create(instance)).list();
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List<TFreightRule> findByFreight(Object freight) {
		return findByProperty(FREIGHT, freight);
	}

	public List<TFreightRule> findByFreeAmount(Object freeAmount) {
		return findByProperty(FREE_AMOUNT, freeAmount);
	}

	public List<TFreightRule> findByMallId(Object mallId) {
		return findByProperty(MALL_ID, mallId);
	}

	public List<TFreightRule> findByIsDefault(Object isDefault) {
		return findByProperty(IS_DEFAULT, isDefault);
	}

}