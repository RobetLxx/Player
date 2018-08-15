package com.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.orm.hibernate5.HibernateTemplate;

import com.bean.Player;
import com.dao.PlayerDao;

public class PlayerDaoImpl  implements PlayerDao{
	private SessionFactory sessionfactory;

	public SessionFactory getSessionfactory() {
		return sessionfactory;
	}

	public void setSessionfactory(SessionFactory sessionfactory) {
		this.sessionfactory = sessionfactory;
	}

	@Override
	public List<Player> list() {
		List<Player> vList = new ArrayList<Player>();
		String hql=" from t_device order by d_id asc ";
		try {
			Query query=this.sessionfactory.getCurrentSession().createQuery(hql);
			//将数据存放在vlist对象中。
			vList=query.list();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}finally {
			
		}
		return vList;
	}


}
