package com.iuh.quanlynhahang.daoimpls;

import java.util.List;

import javax.persistence.EntityManager;

import com.iuh.quanlynhahang.daos.IConverDTO;
import com.iuh.quanlynhahang.daos.MyEntityManager;
import com.quanlynhahang.dto.PhieuDatBan_Mon;

public class ConverDTOImpl implements IConverDTO{

	private EntityManager em;
	public ConverDTOImpl(){
		em=MyEntityManager.getInstance().getEntityManager();
	}
	@Override
	public List<PhieuDatBan_Mon> getAllPM() {
		// TODO Auto-generated method stub
		return em.createQuery("select pm from PhieuDatBan_Mon pm",PhieuDatBan_Mon.class).getResultList();
	}

}
