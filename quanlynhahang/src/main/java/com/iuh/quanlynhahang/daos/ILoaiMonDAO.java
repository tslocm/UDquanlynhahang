package com.iuh.quanlynhahang.daos;

import java.util.List;

import com.iuh.quanlynhahang.entities.LoaiMon;

public interface ILoaiMonDAO {
	public boolean createLoaiMon(LoaiMon loaiMon);

	public boolean updateLoaiMon(LoaiMon loaiMon);

	public boolean deleteLoaiMon(LoaiMon loaiMon);

	public LoaiMon getLoaiMonByTenLoai(String tenLoai);
	public LoaiMon getLoaiMonById(String maLoai);

	public List<LoaiMon> getAllLoaiMon();

}
