package com.ecshop.dao.business.models;

import java.sql.Timestamp;
import java.util.List;
import static org.hibernate.criterion.Example.create;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.ecshop.dao.base.hibernate.HibernateGenericDao;

/**
 * A data access object (DAO) providing persistence and search support for
 * TAppBoutiqueRecommended entities. Transaction control of the save(), update()
 * and delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see com.ecshop.dao.business.models.TAppBoutiqueRecommended
 * @author MyEclipse Persistence Tools
 */
@Component
public class TAppBoutiqueRecommendedDAO extends
		HibernateGenericDao<TAppBoutiqueRecommended, Long> {
	private static final Logger log = LoggerFactory
			.getLogger(TAppBoutiqueRecommendedDAO.class);
	// property constants
	public static final String GOODS_ID = "goodsId";
	public static final String SCOPE = "scope";
	public static final String CENTER_ID = "centerId";
	public static final String STATION_ID = "stationId";
	public static final String ORDER_NO = "orderNo";

	public TAppBoutiqueRecommended findById(java.lang.Long id) {
		log.debug("getting TAppBoutiqueRecommended instance with id: " + id);
		try {
			TAppBoutiqueRecommended instance = (TAppBoutiqueRecommended) getSession()
					.get(
							"com.vveplat.dao.business.models.TAppBoutiqueRecommended",
							id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<TAppBoutiqueRecommended> findByExample(
			TAppBoutiqueRecommended instance) {
		log.debug("finding TAppBoutiqueRecommended instance by example");
		try {
			List<TAppBoutiqueRecommended> results = (List<TAppBoutiqueRecommended>) getSession()
					.createCriteria(
							"com.vveplat.dao.business.models.TAppBoutiqueRecommended")
					.add(create(instance)).list();
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List<TAppBoutiqueRecommended> findByGoodsId(Object goodsId) {
		return findByProperty(GOODS_ID, goodsId);
	}

	public List<TAppBoutiqueRecommended> findByScope(Object scope) {
		return findByProperty(SCOPE, scope);
	}

	public List<TAppBoutiqueRecommended> findByCenterId(Object centerId) {
		return findByProperty(CENTER_ID, centerId);
	}

	public List<TAppBoutiqueRecommended> findByStationId(Object stationId) {
		return findByProperty(STATION_ID, stationId);
	}

	public List<TAppBoutiqueRecommended> findByOrderNo(Object orderNo) {
		return findByProperty(ORDER_NO, orderNo);
	}

}