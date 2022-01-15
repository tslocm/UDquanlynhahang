package com.iuh.quanlynhahang.daos;

import java.time.LocalDate;
import java.util.List;

import com.iuh.quanlynhahang.entities.ChiTietHoaDon;
import com.iuh.quanlynhahang.entities.HoaDon;

public interface IHoaDonDAO {
	public boolean createHoaDon(HoaDon hd);

	public HoaDon getHoaDonById(String id);

	public List<HoaDon> getHoaDonsById(String maHoaDon);

	public List<HoaDon> getHoaDonsByTenNV(String tenNhanVien);

	public List<HoaDon> getHoaDonsByTenKH(String tenKhachHang);

	public List<HoaDon> getHoaDonsFromDateToDate(LocalDate from, LocalDate to);

	public List<HoaDon> getAllHoaDon();

	public List<HoaDon> getAllHoaDon(int thang, int nam);

	public List<HoaDon> getHoaDonByDate(String ngayBD, String ngayEnd);

	public List<String> ThongKeKhachHangNhieuNhatTrongThang(int thang, int nam);

	public List<Long> ThongKeSoLanDatKhachHangNhieuNhatTrongThang(int thang, int nam);

	public List<String> ThongKeKhachHangItNhatTrongThang(int thang, int nam);

	public List<Long> ThongKeSoLanDatKhachHangItNhatTrongThang(int thang, int nam);

	public List<String> ThongKeKhachHangItNhatTrongNam(int nam);

	public List<Long> ThongKeSoLanDatKhachHangItNhatTrongNam(int nam);

	public List<String> ThongKeKhachHangNhieuNhatTrongNam(int nam);

	public List<Long> ThongKeSoLanDatKhachHangNhieuNhatTrongNam(int nam);

	public List<HoaDon> searchHD(String tenKhachHang, String hoTenNhanVien, String tuNgay, String denNgay);

	public List<ChiTietHoaDon> getAllHoaDonByNgay(int ngay, int thang, int nam);

	public List<ChiTietHoaDon> getAllHoaDonByThang(int thang, int nam);

	public List<ChiTietHoaDon> getAllHoaDonByNam(int nam);

	public List<ChiTietHoaDon> getAllHoaDonFromDateToDate(LocalDate from, LocalDate to);
}
