package com.iuh.quanlynhahang.daoimpls;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.iuh.quanlynhahang.daos.IHoaDonDAO;
import com.iuh.quanlynhahang.daos.MyEntityManager;
import com.iuh.quanlynhahang.entities.ChiTietHoaDon;
import com.iuh.quanlynhahang.entities.HoaDon;
import com.iuh.quanlynhahang.entities.KhachHang;
import com.iuh.quanlynhahang.entities.NhanVien;

public class HoaDonDAOImpl implements IHoaDonDAO {
	private EntityManager em;

	public HoaDonDAOImpl() {
		em = MyEntityManager.getInstance().getEntityManager();
	}

	@Override
	public boolean createHoaDon(HoaDon hd) {
		EntityTransaction tr = em.getTransaction();
		try {
			tr.begin();
			em.persist(hd);
			tr.commit();
			return true;
		} catch (Exception e) {
			tr.rollback();
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public HoaDon getHoaDonById(String id) {
		return em.find(HoaDon.class, id);
	}

	@Override
	public List<HoaDon> getAllHoaDon() {
		return em.createQuery("select hd from HoaDon hd", HoaDon.class).getResultList();
	}

	@Override
	public List<HoaDon> getAllHoaDon(int thang, int nam) {
		return em.createQuery("select hd from HoaDon hd where MONTH(hd.ngayXuatHoaDon) ='" + thang
				+ "' and YEAR(hd.ngayXuatHoaDon)='" + nam + "'", HoaDon.class).getResultList();
	}

	@Override
	public List<HoaDon> getHoaDonByDate(String ngayBD, String ngayEnd) {
		return em.createQuery(
				"select hd from HoaDon hd where ngayXuatHoaDon between '" + ngayBD + "' and '" + ngayEnd + "'",
				HoaDon.class).getResultList();
	}

	@Override
	public List<HoaDon> searchHD(String tenKhachHang, String hoTenNhanVien, String tuNgay, String denNgay) {
		return em
				.createQuery("select kh.tenKhachHang,nv.hoTenNhanVien,hd.ngayXuatHoaDon from " + HoaDon.class.getName()
						+ " hd join " + KhachHang.class.getName() + " kh on kh.maKhachHang=hd.KhachHang.maKhachHang "
						+ "join " + NhanVien.class.getName()
						+ " nv on nv.maNhanVien=hd.NhanVien.maNhanVien where kh.tenKhachHang like :tenKhachHang and "
						+ "nv.hoTenNhanVien like: hoTenNhanVien and hd.ngayXuatHoaDon between '" + tuNgay + "' and '"
						+ denNgay + "'", HoaDon.class)
				.setParameter("tenKhachHang", tenKhachHang).setParameter("hoTenNhanVien", hoTenNhanVien)
				.getResultList();
	}

	@Override
	public List<HoaDon> getHoaDonsById(String maHoaDon) {
		return em.createQuery("select hd from HoaDon hd where hd.maHoaDon LIKE CONCAT('%',:maHoaDon,'%')", HoaDon.class)
				.setParameter("maHoaDon", maHoaDon).getResultList();
	}

	@Override
	public List<HoaDon> getHoaDonsByTenNV(String hoTenNhanVien) {
		return em.createQuery("select hd from HoaDon hd where hd.nhanVien.hoTenNhanVien=:hoTenNhanVien", HoaDon.class)
				.setParameter("hoTenNhanVien", hoTenNhanVien).getResultList();
//		return em.createQuery(
//				"select hd from HoaDon hd join NhanVien nv on hd.nhanVien.maNhanVien=nv.maNhanVien where nv.hoTenNhanVien='Nguyễn Ngọc Thoại'",
//				HoaDon.class).getResultList();
//		return em.createQuery("select hd from HoaDon hd where hd.nhanVien.hoTenNhanVien LIKE CONCAT(:hoTenNhanVien)", HoaDon.class)
//				.setParameter("hoTenNhanVien", hoTenNhanVien).getResultList();
	}

	@Override
	public List<HoaDon> getHoaDonsByTenKH(String tenKhachHang) {
		return em.createQuery(
				"select hd from HoaDon hd where hd.khachHang.tenKhachHang LIKE CONCAT('%',:tenKhachHang,'%')",
				HoaDon.class).setParameter("tenKhachHang", tenKhachHang).getResultList();
	}

	@Override
	public List<HoaDon> getHoaDonsFromDateToDate(LocalDate from, LocalDate to) {
		return em.createQuery("select hd from HoaDon hd where hd.ngayXuatHoaDon BETWEEN :from AND :to", HoaDon.class)
				.setParameter("from", from).setParameter("to", to).getResultList();
	}

	@Override
	public List<String> ThongKeKhachHangNhieuNhatTrongThang(int thang, int nam) {
		return em.createQuery(
				"select hd.khachHang.maKhachHang from HoaDon hd where hd.khachHang.maKhachHang != 'NULL' and month(hd.ngayXuatHoaDon)="
						+ thang + " and year(hd.ngayXuatHoaDon)=" + nam
						+ " group by hd.khachHang.maKhachHang order by COUNT(hd.khachHang.maKhachHang) desc",
				String.class).setMaxResults(10).getResultList();
	}

	@Override
	public List<Long> ThongKeSoLanDatKhachHangNhieuNhatTrongThang(int thang, int nam) {
		return em.createQuery(
				"select count(hd.khachHang.maKhachHang) from HoaDon hd where hd.khachHang.maKhachHang != 'NULL' and month(hd.ngayXuatHoaDon)="
						+ thang + " and year(hd.ngayXuatHoaDon)=" + nam
						+ " group by hd.khachHang.maKhachHang order by COUNT(hd.khachHang.maKhachHang) desc",
				Long.class).setMaxResults(10).getResultList();
	}

	@Override
	public List<String> ThongKeKhachHangItNhatTrongThang(int thang, int nam) {
		return em.createQuery(
				"select hd.khachHang.maKhachHang from HoaDon hd where hd.khachHang.maKhachHang != 'NULL' and month(hd.ngayXuatHoaDon)="
						+ thang + " and year(hd.ngayXuatHoaDon)=" + nam
						+ " group by hd.khachHang.maKhachHang order by COUNT(hd.khachHang.maKhachHang) asc",
				String.class).setMaxResults(10).getResultList();
	}

	@Override
	public List<Long> ThongKeSoLanDatKhachHangItNhatTrongThang(int thang, int nam) {
		return em.createQuery(
				"select count(hd.khachHang.maKhachHang) from HoaDon hd where hd.khachHang.maKhachHang != 'NULL' and month(hd.ngayXuatHoaDon)="
						+ thang + " and year(hd.ngayXuatHoaDon)=" + nam
						+ " group by hd.khachHang.maKhachHang  order by COUNT(hd.khachHang.maKhachHang) asc",
				Long.class).setMaxResults(10).getResultList();
	}

	@Override
	public List<String> ThongKeKhachHangItNhatTrongNam(int nam) {
		return em.createQuery(
				"select hd.khachHang.maKhachHang from HoaDon hd where hd.khachHang.maKhachHang != 'NULL' and year(hd.ngayXuatHoaDon)="
						+ nam + " group by hd.khachHang.maKhachHang order by COUNT(hd.khachHang.maKhachHang) asc",
				String.class).setMaxResults(10).getResultList();
	}

	@Override
	public List<Long> ThongKeSoLanDatKhachHangItNhatTrongNam(int nam) {
		return em.createQuery(
				"select count(hd.khachHang.maKhachHang) from HoaDon hd where hd.khachHang.maKhachHang != 'NULL' and year(hd.ngayXuatHoaDon)="
						+ nam + " group by hd.khachHang.maKhachHang order by COUNT(hd.khachHang.maKhachHang) asc",
				Long.class).setMaxResults(10).getResultList();
	}

	@Override
	public List<String> ThongKeKhachHangNhieuNhatTrongNam(int nam) {
		return em.createQuery(
				"select hd.khachHang.maKhachHang from HoaDon hd where hd.khachHang.maKhachHang != 'NULL' and year(hd.ngayXuatHoaDon)="
						+ nam + " group by hd.khachHang.maKhachHang order by COUNT(hd.khachHang.maKhachHang) desc",
				String.class).setMaxResults(10).getResultList();
	}

	@Override
	public List<Long> ThongKeSoLanDatKhachHangNhieuNhatTrongNam(int nam) {
		return em.createQuery(
				"select count(hd.khachHang.maKhachHang) from HoaDon hd where hd.khachHang.maKhachHang != 'NULL' and year(hd.ngayXuatHoaDon)="
						+ nam + " group by hd.khachHang.maKhachHang order by COUNT(hd.khachHang.maKhachHang) desc",
				Long.class).setMaxResults(10).getResultList();
	}

	public List<ChiTietHoaDon> getAllHoaDonByNgay(int ngay, int thang, int nam) {
		return em.createQuery(
				"select c from ChiTietHoaDon c join HoaDon hd on hd.maHoaDon=c.hoaDon.maHoaDon where month(hd.ngayXuatHoaDon)="
						+ thang + " and year(hd.ngayXuatHoaDon)=" + nam + " and day(hd.ngayXuatHoaDon)=" + ngay,
				ChiTietHoaDon.class).getResultList();
	}

	public List<ChiTietHoaDon> getAllHoaDonByThang(int thang, int nam) {
		return em.createQuery(
				"select c from ChiTietHoaDon c join HoaDon hd on hd.maHoaDon=c.hoaDon.maHoaDon where month(hd.ngayXuatHoaDon)="
						+ thang + " and year(hd.ngayXuatHoaDon)=" + nam,
				ChiTietHoaDon.class).getResultList();
	}

	public List<ChiTietHoaDon> getAllHoaDonByNam(int nam) {
		return em.createQuery(
				"select c from ChiTietHoaDon c join HoaDon hd on hd.maHoaDon=c.hoaDon.maHoaDon where year(hd.ngayXuatHoaDon)="
						+ nam,
				ChiTietHoaDon.class).getResultList();
	}

	@Override
	public List<ChiTietHoaDon> getAllHoaDonFromDateToDate(LocalDate from, LocalDate to) {
		return em.createQuery(
				"select c from ChiTietHoaDon c join HoaDon hd on hd.maHoaDon=c.hoaDon.maHoaDon where hd.ngayXuatHoaDon BETWEEN :from AND :to",
				ChiTietHoaDon.class).setParameter("from", from).setParameter("to", to).getResultList();
	}
}
