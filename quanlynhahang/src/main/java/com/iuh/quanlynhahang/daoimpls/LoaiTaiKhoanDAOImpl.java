package com.iuh.quanlynhahang.daoimpls;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.iuh.quanlynhahang.daos.ILoaiTaiKhoanDAO;
import com.iuh.quanlynhahang.daos.MyEntityManager;
import com.iuh.quanlynhahang.entities.LoaiTaiKhoan;

public class LoaiTaiKhoanDAOImpl implements ILoaiTaiKhoanDAO {
	private EntityManager em;

	public LoaiTaiKhoanDAOImpl() {
		em = MyEntityManager.getInstance().getEntityManager();
	}

	@Override
	public boolean createLTK(LoaiTaiKhoan ltk) {
		EntityTransaction tr = em.getTransaction();
		try {
			tr.begin();
			em.persist(ltk);
			tr.commit();
			return true;
		} catch (Exception e) {
			tr.rollback();
			return false;
		}
	}

	@Override
	public boolean deleteLTK(LoaiTaiKhoan ltk) {
		EntityTransaction tr = em.getTransaction();
		try {
			tr.begin();
			em.remove(ltk);
			tr.commit();
			return true;
		} catch (Exception e) {
			tr.rollback();
			return false;
		}
	}

	@Override
	public LoaiTaiKhoan getLTKByTenLTK(String tenLTK) {
//		return em.createQuery("select ltk from LoaiTaiKhoan ltk where tenLoaiTaiKhoan=" + "'" + tenLTK + "'",
//				LoaiTaiKhoan.class).getSingleResult();
		return em.createQuery("select ltk from LoaiTaiKhoan ltk where tenLoaiTaiKhoan=:tenLTK", LoaiTaiKhoan.class)
				.setParameter("tenLTK", tenLTK).getSingleResult();
	}

	@Override
	public LoaiTaiKhoan getLTKByMaLTK(String maLTK) {
		return em.find(LoaiTaiKhoan.class, maLTK);
	}

	@Override
	public List<LoaiTaiKhoan> getAllLTK() {
		return em.createQuery("select ltk from LoaiTaiKhoan ltk", LoaiTaiKhoan.class).getResultList();
	}

	@Override
	public boolean updateLTK(LoaiTaiKhoan ltk) {
		EntityTransaction tr = em.getTransaction();
		try {
			tr.begin();
			em.merge(ltk);
			tr.commit();
			return true;
		} catch (Exception e) {
			tr.rollback();
			return false;
		}
	}

}
