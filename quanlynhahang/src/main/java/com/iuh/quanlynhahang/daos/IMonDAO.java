package com.iuh.quanlynhahang.daos;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import com.iuh.quanlynhahang.entities.Mon;

public interface IMonDAO {
	public boolean createMon(Mon mon);

	public boolean updateMon(Mon mon);

	public boolean deleteMon(Mon mon);

	public Mon getMonByTen(String tenMon);

	public List<Mon> getMonsByTen(String tenMon);

	public Mon getMonByMa(String maMon);

	public List<Mon> getMonsByMa(String maMon);

	public List<Mon> getMonsByLoai(String tenLoaiMon);

	public List<Mon> getMonsByFromGiaToGia(BigDecimal from, BigDecimal to);

	public List<Mon> getAllMon();

	public List<String> ThongKeMonAn(String chon, Date tuNgay, Date denNgay);

	public List<String> getAllMaMon(List<Mon> mons);

	public List<String> ThongKeMonAnNhieuNhatTrongThang(int thang, int nam,String tenLoaiMon);

	public List<String> ThongKeMonAnItNhatTrongThang(int thang, int nam,String tenLoaiMon);

	public List<String> ThongKeMonAnItNhatTrongNam(int nam, String tenLoaiMon);

	public List<String> ThongKeMonAnNhieuNhatTrongNam(int nam, String tenLoaiMon);

	public List<String> ThongKeDoUongNhieuNhatTrongThang(int thang, int nam, String tenLoaiMon);

	public List<String> ThongKeDoUongItNhatTrongThang(int thang, int nam, String tenLoaiMon);

	public List<String> ThongKeDoUongItNhatTrongNam(int nam, String tenLoaiMon);

	public List<String> ThongKeDoUongNhieuNhatTrongNam(int nam, String tenLoaiMon);

	public List<String> ThongKeSoLanDatNhieuNhatTrongThang(int thang, int nam);

	public List<Mon> searchMon(String tenMon, String loaiMon, BigDecimal tienMin, BigDecimal tienMax);

	public List<Integer> getAllNamsInHoaDon();

}
