package com.ecshop.dao.business.models;

import java.util.List;
import static org.hibernate.criterion.Example.create;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.ecshop.dao.base.hibernate.HibernateGenericDao;

/**
 * A data access object (DAO) providing persistence and search support for
 * TConfig entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.ecshop.dao.business.models.TConfig
 * @author MyEclipse Persistence Tools
 */
@Component
public class TConfigDAO extends HibernateGenericDao<TConfig, String> {
	private static final Logger log = LoggerFactory.getLogger(TConfigDAO.class);
	// property constants
	public static final String CONFIG_TITLE = "configTitle";
	public static final String CONFIG_VALUE = "configValue";

	public TConfig findById(java.lang.String id) {
		log.debug("getting TConfig instance with id: " + id);
		try {
			TConfig instance = (TConfig) getSession().get(
					"com.vveplat.dao.business.models.TConfig", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<TConfig> findByExample(TConfig instance) {
		log.debug("finding TConfig instance by example");
		try {
			List<TConfig> results = (List<TConfig>) getSession()
					.createCriteria("com.vveplat.dao.business.models.TConfig")
					.add(create(instance)).list();
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List<TConfig> findByConfigTitle(Object configTitle) {
		return findByProperty(CONFIG_TITLE, configTitle);
	}

	public List<TConfig> findByConfigValue(Object configValue) {
		return findByProperty(CONFIG_VALUE, configValue);
	}

}