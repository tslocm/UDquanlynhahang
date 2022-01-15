package com.iuh.quanlynhahang.daos;

import java.util.List;

import com.iuh.quanlynhahang.entities.ChiTietHoaDon;

public interface IChiTietHoaDon {
	public boolean createCTHD(ChiTietHoaDon cthd);

	public List<ChiTietHoaDon> getAllCTHD();
}
