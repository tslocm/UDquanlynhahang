package com.iuh.quanlynhahang.daoimpls;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.iuh.quanlynhahang.daos.IBanDAO;
import com.iuh.quanlynhahang.daos.MyEntityManager;
import com.iuh.quanlynhahang.entities.Ban;

public class BanDAOImpl implements IBanDAO {
	private EntityManager em;

	public BanDAOImpl() {
		em = MyEntityManager.getInstance().getEntityManager();
	}

	@Override
	public boolean createBan(Ban ban) {
		EntityTransaction tr = em.getTransaction();
		try {
			tr.begin();
			em.persist(ban);
			tr.commit();
			return true;
		} catch (Exception e) {
			tr.rollback();
			return false;
		}
	}

	@Override
	public boolean updateBan(Ban ban) {
		EntityTransaction tr = em.getTransaction();
		try {
			tr.begin();
			em.merge(ban);
			tr.commit();
			return true;
		} catch (Exception e) {
			tr.rollback();
			return false;
		}
	}

	@Override
	public boolean deleteBan(Ban ban) {
		EntityTransaction tr = em.getTransaction();
		try {
			tr.begin();
			em.remove(ban);
			tr.commit();
			return true;
		} catch (Exception e) {
			tr.rollback();
			return false;
		}
	}

	@Override
	public Ban getBanById(int maBan) {
		return em.find(Ban.class, maBan);
	}

	@Override
	public List<Ban> getBansBySanh(String sanh) {
		return em.createQuery("select b from Ban b where b.sanh.tenSanh=" + sanh, Ban.class).getResultList();
	}

	@Override
	public List<Ban> getAllBan() {
		return em.createQuery("select b from Ban b", Ban.class).getResultList();
	}

}
