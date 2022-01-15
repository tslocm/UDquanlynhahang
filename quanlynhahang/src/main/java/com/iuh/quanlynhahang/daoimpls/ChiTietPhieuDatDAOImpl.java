package com.iuh.quanlynhahang.daoimpls;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.iuh.quanlynhahang.daos.IChiTietPhieuDat;
import com.iuh.quanlynhahang.daos.MyEntityManager;
import com.iuh.quanlynhahang.entities.ChiTietPhieuDat;

public class ChiTietPhieuDatDAOImpl implements IChiTietPhieuDat {
	private EntityManager em;

	public ChiTietPhieuDatDAOImpl() {
		em = MyEntityManager.getInstance().getEntityManager();
	}

	@Override
	public boolean createCTPD(ChiTietPhieuDat ctpd) {
		EntityTransaction tr = em.getTransaction();
		try {
			tr.begin();
			em.persist(ctpd);
			tr.commit();
			return true;
		} catch (Exception e) {
			tr.rollback();
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public List<ChiTietPhieuDat> getAllCTPD() {
		return em.createQuery("select c from ChiTietPhieuDat c", ChiTietPhieuDat.class).getResultList();
	}

	@Override
	public List<ChiTietPhieuDat> getAllCTPDByMaBanTiec(String maPhieuDatBan) {
		return em.createQuery("select c from ChiTietPhieuDatBan c where c.phieuDatBan.maPhieuDatBan=:maPhieuDatBan",
				ChiTietPhieuDat.class).setParameter("maPhieuDatBan", maPhieuDatBan).getResultList();
	}

	@Override
	public boolean updateCTPD(ChiTietPhieuDat ctpd) {
		EntityTransaction tr = em.getTransaction();
		try {
			tr.begin();
			em.merge(ctpd);
			tr.commit();
			return true;
		} catch (Exception e) {
			tr.rollback();
			return false;
		}
	}

}
