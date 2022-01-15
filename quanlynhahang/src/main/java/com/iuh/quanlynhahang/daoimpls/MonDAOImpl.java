package com.iuh.quanlynhahang.daoimpls;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.iuh.quanlynhahang.daos.IMonDAO;
import com.iuh.quanlynhahang.daos.MyEntityManager;
import com.iuh.quanlynhahang.entities.Mon;

public class MonDAOImpl implements IMonDAO {
	private EntityManager em;

	public MonDAOImpl() {
		em = MyEntityManager.getInstance().getEntityManager();
	}

	@Override
	public boolean createMon(Mon mon) {
		EntityTransaction tr = em.getTransaction();
		try {
			tr.begin();
			em.persist(mon);
			tr.commit();
			return true;
		} catch (Exception e) {
			tr.rollback();
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean updateMon(Mon mon) {
		EntityTransaction tr = em.getTransaction();
		try {
			tr.begin();
			em.merge(mon);
			tr.commit();
			return true;
		} catch (Exception e) {
			tr.rollback();
			return false;
		}
	}

	@Override
	public boolean deleteMon(Mon mon) {
		EntityTransaction tr = em.getTransaction();
		try {
			tr.begin();
			em.remove(mon);
			tr.commit();
			return true;
		} catch (Exception e) {
			tr.rollback();
			return false;
		}
	}

	@Override
	public Mon getMonByTen(String tenMon) {
		return em.createQuery("select m from Mon m where m.tenMon=:tenMon", Mon.class).setParameter("tenMon", tenMon)
				.getSingleResult();
	}

	@Override
	public Mon getMonByMa(String maMon) {
		return em.find(Mon.class, maMon);
	}

	@Override
	public List<Mon> getAllMon() {
		return em.createQuery("select m from Mon m", Mon.class).getResultList();
	}

	@Override
	public List<String> ThongKeMonAn(String chon, Date tuNgay, Date denNgay) {
//		return em.createQuery("select pm.maMon, count(pm.maMon) as counts from PhieuDatBan_Mon pm group by pm.maMon order by counts desc", Mon.class).getResultList();
		return em.createQuery("select maMon from PhieuDatBan_Mon  group by maMon order by count(maMon) desc",
				String.class).getResultList();
	}

	@Override
	public List<String> getAllMaMon(List<Mon> mons) {
		List<String> list = new ArrayList<String>();
		mons = getAllMon();
		for (Mon m : mons) {
			list.add(m.getMaMon());
		}

		return list;
	}

	/**
	 * SELECT count(*) FROM BillDetails bd JOIN bd.billProductSet bps WHERE
	 * bd.client.id = 1 AND bps.product.id = 1002
	 */

	@Override
	public List<String> ThongKeSoLanDatNhieuNhatTrongThang(int thang, int nam) {
		return em.createQuery(
				"select count(pm.maMon) as counts from PhieuDatBan_Mon pm group by pm.maMon order by counts desc",
				String.class).getResultList();
	}

	@Override
	public List<Mon> searchMon(String tenMon, String loaiMon, BigDecimal tienMin, BigDecimal tienMax) {
		return em.createQuery("select m.tenMon,giaTien,m.LoaiMon.tenLoaiMon from Mon m", Mon.class).getResultList();
	}

	@Override
	public List<Mon> getMonsByTen(String tenMon) {
		return em.createQuery("select m from Mon m where m.tenMon LIKE CONCAT('%',:tenMon,'%')", Mon.class)
				.setParameter("tenMon", tenMon).getResultList();
	}

	@Override
	public List<Mon> getMonsByMa(String maMon) {
		return em.createQuery("select m from Mon m where m.maMon LIKE CONCAT('%',:maMon,'%')", Mon.class)
				.setParameter("maMon", maMon).getResultList();
	}

	@Override
	public List<Mon> getMonsByLoai(String tenLoaiMon) {
		return em.createQuery("select m from Mon m where m.loaiMon.tenLoaiMon=:tenLoaiMon", Mon.class)
				.setParameter("tenLoaiMon", tenLoaiMon).getResultList();
	}

	@Override
	public List<Mon> getMonsByFromGiaToGia(BigDecimal from, BigDecimal to) {
		return em.createQuery("select m from Mon m where m.giaTien BETWEEN :from AND :to", Mon.class)
				.setParameter("from", from).setParameter("to", to).getResultList();
	}

	@Override
	public List<String> ThongKeMonAnNhieuNhatTrongThang(int thang, int nam, String tenLoaiMon) {
//		return em.createQuery("select m.maMon from p.monAns m join PhieuDatBan p where m.maMon=p.maMon group by m.maMon order by count(m.maMon) desc", String.class).getSingleResult();
//		return em.createQuery(
//				"select m.maMon from PhieuDatBan p join p.monAns m where not m.loaiMon.tenLoaiMon=:tenLoaiMon and MONTH(p.ngayDatMon) ="
//						+ thang + " and YEAR(p.ngayDatMon)=" + nam + " group by m.maMon order by count(m.maMon) desc",
//				String.class).setParameter("tenLoaiMon", tenLoaiMon).setMaxResults(10).getResultList();
//		return em.createQuery(
//				"select m.mon.maMon from PhieuDatBan p join ChiTietPhieuDatBan m where not m.mon.loaiMon.tenLoaiMon=:tenLoaiMon and MONTH(p.ngayDatMon) ="
//						+ thang + " and YEAR(p.ngayDatMon)=" + nam
//						+ " group by m.mon.maMon order by count(m.mon.maMon) desc",
//				String.class).setParameter("tenLoaiMon", tenLoaiMon).setMaxResults(10).getResultList();
		return em.createQuery(
				"select c.mon.maMon from PhieuDatBan p join ChiTietPhieuDatBan c on p.maPhieuDatBan=c.phieuDatBan.maPhieuDatBan where not c.mon.loaiMon.tenLoaiMon=:tenLoaiMon and MONTH(p.ngayDatMon)="
						+ thang + " and YEAR(p.ngayDatMon)=" + nam
						+ " group by c.mon.maMon order by count(c.mon.maMon) desc",
				String.class).setParameter("tenLoaiMon", tenLoaiMon).setMaxResults(10).getResultList();

	}

	@Override
	public List<String> ThongKeMonAnItNhatTrongThang(int thang, int nam, String tenLoaiMon) {
		return em.createQuery(
				"select c.mon.maMon from PhieuDatBan p join ChiTietPhieuDatBan c on p.maPhieuDatBan=c.phieuDatBan.maPhieuDatBan where not c.mon.loaiMon.tenLoaiMon=:tenLoaiMon and MONTH(p.ngayDatMon)="
						+ thang + " and YEAR(p.ngayDatMon)=" + nam
						+ " group by c.mon.maMon order by count(c.mon.maMon) asc",
				String.class).setParameter("tenLoaiMon", tenLoaiMon).setMaxResults(10).getResultList();
	}

	@Override
	public List<String> ThongKeMonAnItNhatTrongNam(int nam, String tenLoaiMon) {
		return em.createQuery(
				"select c.mon.maMon from PhieuDatBan p join ChiTietPhieuDatBan c on p.maPhieuDatBan=c.phieuDatBan.maPhieuDatBan where not c.mon.loaiMon.tenLoaiMon=:tenLoaiMon and YEAR(p.ngayDatMon)="
						+ nam + " group by c.mon.maMon order by count(c.mon.maMon) asc",
				String.class).setParameter("tenLoaiMon", tenLoaiMon).setMaxResults(10).getResultList();
	}

	@Override
	public List<String> ThongKeMonAnNhieuNhatTrongNam(int nam, String tenLoaiMon) {
		return em.createQuery(
				"select c.mon.maMon from PhieuDatBan p join ChiTietPhieuDatBan c on p.maPhieuDatBan=c.phieuDatBan.maPhieuDatBan where not c.mon.loaiMon.tenLoaiMon=:tenLoaiMon and YEAR(p.ngayDatMon)="
						+ nam + " group by c.mon.maMon order by count(c.mon.maMon) desc",
				String.class).setParameter("tenLoaiMon", tenLoaiMon).setMaxResults(10).getResultList();
	}

	@Override
	public List<String> ThongKeDoUongItNhatTrongThang(int thang, int nam, String tenLoaiMon) {
		return em.createQuery(
				"select c.mon.maMon from PhieuDatBan p join ChiTietPhieuDatBan c on p.maPhieuDatBan=c.phieuDatBan.maPhieuDatBan where c.mon.loaiMon.tenLoaiMon=:tenLoaiMon and MONTH(p.ngayDatMon)="
						+ thang + " and YEAR(p.ngayDatMon)=" + nam
						+ " group by c.mon.maMon order by count(c.mon.maMon) asc",
				String.class).setParameter("tenLoaiMon", tenLoaiMon).setMaxResults(10).getResultList();
	}

	@Override
	public List<String> ThongKeDoUongNhieuNhatTrongThang(int thang, int nam, String tenLoaiMon) {
//		return em.createQuery("select m.maMon from p.monAns m join PhieuDatBan p where m.maMon=p.maMon group by m.maMon order by count(m.maMon) desc", String.class).getSingleResult();
//		return em.createQuery("select top 1 pm.maMon, count(pm.maMon) as counts from PhieuDatBan_Mon pm group by pm.maMon order by counts desc", String.class).getSingleResult();
		return em.createQuery(
				"select c.mon.maMon from PhieuDatBan p join ChiTietPhieuDatBan c on p.maPhieuDatBan=c.phieuDatBan.maPhieuDatBan where c.mon.loaiMon.tenLoaiMon=:tenLoaiMon and MONTH(p.ngayDatMon)="
						+ thang + " and YEAR(p.ngayDatMon)=" + nam
						+ " group by c.mon.maMon order by count(c.mon.maMon) desc",
				String.class).setParameter("tenLoaiMon", tenLoaiMon).setMaxResults(10).getResultList();
	}

	@Override
	public List<String> ThongKeDoUongItNhatTrongNam(int nam, String tenLoaiMon) {
		return em.createQuery(
				"select c.mon.maMon from PhieuDatBan p join ChiTietPhieuDatBan c on p.maPhieuDatBan=c.phieuDatBan.maPhieuDatBan where c.mon.loaiMon.tenLoaiMon=:tenLoaiMon and YEAR(p.ngayDatMon)="
						+ nam + " group by c.mon.maMon order by count(c.mon.maMon) asc",
				String.class).setParameter("tenLoaiMon", tenLoaiMon).setMaxResults(10).getResultList();
	}

	@Override
	public List<String> ThongKeDoUongNhieuNhatTrongNam(int nam, String tenLoaiMon) {
		return em.createQuery(
				"select c.mon.maMon from PhieuDatBan p join ChiTietPhieuDatBan c on p.maPhieuDatBan=c.phieuDatBan.maPhieuDatBan where c.mon.loaiMon.tenLoaiMon=:tenLoaiMon and YEAR(p.ngayDatMon)="
						+ nam + " group by c.mon.maMon order by count(c.mon.maMon) desc",
				String.class).setParameter("tenLoaiMon", tenLoaiMon).setMaxResults(10).getResultList();
	}

	@Override
	public List<Integer> getAllNamsInHoaDon() {
		return em.createQuery("select YEAR(p.ngayDatMon) from PhieuDatBan p", Integer.class).getResultList();
	}
}
