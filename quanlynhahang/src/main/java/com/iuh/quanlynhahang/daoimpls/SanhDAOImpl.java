package com.iuh.quanlynhahang.daoimpls;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.iuh.quanlynhahang.daos.ISanhDAO;
import com.iuh.quanlynhahang.daos.MyEntityManager;
import com.iuh.quanlynhahang.entities.Sanh;

public class SanhDAOImpl implements ISanhDAO {
	private EntityManager em;

	public SanhDAOImpl() {
		em = MyEntityManager.getInstance().getEntityManager();
	}

	@Override
	public boolean createSanh(Sanh sanh) {
		EntityTransaction tr = em.getTransaction();
		try {
			tr.begin();
			em.persist(sanh);
			tr.commit();
			return true;
		} catch (Exception e) {
			tr.rollback();
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean updateSanh(Sanh sanh) {
		EntityTransaction tr = em.getTransaction();
		try {
			tr.begin();
			em.merge(sanh);
			tr.commit();
			return true;
		} catch (Exception e) {
			tr.rollback();
			return false;
		}
	}

	@Override
	public boolean deleteSanh(Sanh sanh) {
		EntityTransaction tr = em.getTransaction();
		try {
			tr.begin();
			em.remove(sanh);
			tr.commit();
			return true;
		} catch (Exception e) {
			tr.rollback();
			return false;
		}
	}

	@Override
	public Sanh getSanhById(String maSanh) {
		return em.find(Sanh.class, maSanh);
	}

	@Override
	public Sanh getSanhByTen(String tenSanh) {
		return em.createQuery("select s from Sanh s where tenSanh=:tenSanh", Sanh.class)
				.setParameter("tenSanh", tenSanh).getSingleResult();
	}

	@Override
	public List<Sanh> getAllSanh() {
		return em.createQuery("select s from Sanh s", Sanh.class).getResultList();
	}

	@Override
	public List<String> getAllTenSanh() {
		List<Sanh> sanhs = getAllSanh();
		List<String> tenSanhs = new ArrayList<String>();
		for (Sanh sanh : sanhs) {
			tenSanhs.add(sanh.getTenSanh());
		}
		return tenSanhs;
	}
	
//	public List<Sanh> getAllTenSanhDHD() {
//		List<Sanh> sanhs = getAllSanh();
//		List<String> tenSanhs = new ArrayList<String>();
//		for (Sanh sanh : sanhs) {
//			tenSanhs.add(sanh.getTenSanh());
//		}
//		return tenSanhs;
//	}

}
