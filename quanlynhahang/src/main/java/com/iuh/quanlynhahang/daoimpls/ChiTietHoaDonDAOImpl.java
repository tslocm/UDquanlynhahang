package com.iuh.quanlynhahang.daoimpls;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.iuh.quanlynhahang.daos.IChiTietHoaDon;
import com.iuh.quanlynhahang.daos.MyEntityManager;
import com.iuh.quanlynhahang.entities.ChiTietHoaDon;

public class ChiTietHoaDonDAOImpl implements IChiTietHoaDon {
	private EntityManager em;

	public ChiTietHoaDonDAOImpl() {
		em = MyEntityManager.getInstance().getEntityManager();
	}

	@Override
	public boolean createCTHD(ChiTietHoaDon cthd) {
		EntityTransaction tr = em.getTransaction();
		try {
			tr.begin();
			em.persist(cthd);
			tr.commit();
			return true;
		} catch (Exception e) {
			tr.rollback();
			e.printStackTrace();
			return false;
		}
	}
	
	@Override
	public List<ChiTietHoaDon> getAllCTHD(){
		return em.createQuery("select c from ChiTietHoaDon c",ChiTietHoaDon.class).getResultList();
	}
	

}
