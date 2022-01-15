package com.iuh.quanlynhahang.daoimpls;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.iuh.quanlynhahang.daos.IPhieuDatBanDAO;
import com.iuh.quanlynhahang.daos.MyEntityManager;
import com.iuh.quanlynhahang.entities.PhieuDatBan;

public class PhieuDatBanDAOImpl implements IPhieuDatBanDAO {
	private EntityManager em;

	public PhieuDatBanDAOImpl() {
		em = MyEntityManager.getInstance().getEntityManager();
	}

	@Override
	public boolean createPhieuDatBan(PhieuDatBan phieuDatBan) {
		em.clear();
		EntityTransaction tr = em.getTransaction();
		try {
			tr.begin();
			em.persist(phieuDatBan);
			tr.commit();
			return true;
		} catch (Exception e) {
			tr.rollback();
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean updatePhieuDatBan(PhieuDatBan phieuDatBan) {
		EntityTransaction tr = em.getTransaction();
		try {
			tr.begin();
			em.merge(phieuDatBan);
			tr.commit();
			return true;
		} catch (Exception e) {
			tr.rollback();
			return false;
		}
	}

	@Override
	public PhieuDatBan getPhieuDatBanById(String id) {
		return em.find(PhieuDatBan.class, id);
	}

	@Override
	public List<PhieuDatBan> getPhieuDatBansBySDT(String soDienThoai) {
		return em.createQuery("select p from PhieuDatBan p where p.khachHang.soDienThoai=:soDienThoai",
				PhieuDatBan.class).setParameter("soDienThoai", soDienThoai).getResultList();
	}

	@Override
	public PhieuDatBan getPhieuDatBanBySDT(String soDienThoai) {
		return em.createQuery("select p from PhieuDatBan p where p.khachHang.soDienThoai=:soDienThoai",
				PhieuDatBan.class).setParameter("soDienThoai", soDienThoai).getSingleResult();
	}

	@Override
	public List<PhieuDatBan> getAllPhieuDatBan() {
		return em.createQuery("select p from PhieuDatBan p", PhieuDatBan.class).getResultList();
	}

}
