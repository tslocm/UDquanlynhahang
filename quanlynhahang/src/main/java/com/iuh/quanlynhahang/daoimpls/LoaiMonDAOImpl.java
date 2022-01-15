package com.iuh.quanlynhahang.daoimpls;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.iuh.quanlynhahang.daos.ILoaiMonDAO;
import com.iuh.quanlynhahang.daos.MyEntityManager;
import com.iuh.quanlynhahang.entities.LoaiMon;

public class LoaiMonDAOImpl implements ILoaiMonDAO {
	private EntityManager em;

	public LoaiMonDAOImpl() {
		em = MyEntityManager.getInstance().getEntityManager();
	}

	@Override
	public boolean createLoaiMon(LoaiMon loaiMon) {
		EntityTransaction tr = em.getTransaction();
		try {
			tr.begin();
			em.persist(loaiMon);
			tr.commit();
			return true;
		} catch (Exception e) {
			tr.rollback();
			return false;
		}
	}

	@Override
	public boolean updateLoaiMon(LoaiMon loaiMon) {
		EntityTransaction tr = em.getTransaction();
		try {
			tr.begin();
			em.merge(loaiMon);
			tr.commit();
			return true;
		} catch (Exception e) {
			tr.rollback();
			return false;
		}
	}

	@Override
	public boolean deleteLoaiMon(LoaiMon loaiMon) {
		EntityTransaction tr = em.getTransaction();
		try {
			tr.begin();
			em.remove(loaiMon);
			tr.commit();
			return true;
		} catch (Exception e) {
			tr.rollback();
			return false;
		}
	}

	@Override
	public LoaiMon getLoaiMonByTenLoai(String tenLoaiMon) {
		return em.createQuery("select lm from LoaiMon lm where tenLoaiMon=:tenLoaiMon", LoaiMon.class)
				.setParameter("tenLoaiMon", tenLoaiMon).getSingleResult();
	}

	@Override
	public LoaiMon getLoaiMonById(String maLoai) {
		return em.find(LoaiMon.class, maLoai);
	}

	@Override
	public List<LoaiMon> getAllLoaiMon() {
		return em.createQuery("select lm from LoaiMon lm", LoaiMon.class).getResultList();
	}

}
