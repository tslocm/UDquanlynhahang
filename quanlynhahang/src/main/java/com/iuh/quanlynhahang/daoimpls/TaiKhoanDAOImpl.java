package com.iuh.quanlynhahang.daoimpls;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.iuh.quanlynhahang.daos.ITaiKhoanDAO;
import com.iuh.quanlynhahang.daos.MyEntityManager;
import com.iuh.quanlynhahang.entities.TaiKhoan;

public class TaiKhoanDAOImpl implements ITaiKhoanDAO {
	private EntityManager em;

	public TaiKhoanDAOImpl() {
		em = MyEntityManager.getInstance().getEntityManager();
	}

	@Override
	public boolean createTK(TaiKhoan tk) {
		EntityTransaction tr = em.getTransaction();
		try {
			tr.begin();
			em.persist(tk);
			tr.commit();
			return true;
		} catch (Exception e) {
			tr.rollback();
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean deleteTK(TaiKhoan tk) {
		EntityTransaction tr = em.getTransaction();
		try {
			tr.begin();
			em.remove(tk);
			tr.commit();
			return true;
		} catch (Exception e) {
			tr.rollback();
			return false;
		}
	}

	@Override
	public TaiKhoan getTKByTenTK(String tenTK) {
		return em.find(TaiKhoan.class, tenTK);
	}

	@Override
	public List<TaiKhoan> getAllTK() {
		return em.createQuery("select tk from TaiKhoan tk", TaiKhoan.class).getResultList();
	}

	@Override
	public boolean updateTK(TaiKhoan tk) {
		EntityTransaction tr = em.getTransaction();
		try {
			tr.begin();
			em.merge(tk);
			tr.commit();
			return true;
		} catch (Exception e) {
			tr.rollback();
			return false;
		}
	}

	@Override
	public TaiKhoan getTKByMaTK(String maTK) {
		return em.createQuery("select tk from TaiKhoan tk where maTaiKhoan=" + "'" + maTK + "'", TaiKhoan.class)
				.getSingleResult();
	}

}
