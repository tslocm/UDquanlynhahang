package com.iuh.quanlynhahang.daos;

import java.util.List;

import com.iuh.quanlynhahang.entities.ChiTietPhieuDat;

public interface IChiTietPhieuDat {
	public boolean createCTPD(ChiTietPhieuDat ctpd);

	public List<ChiTietPhieuDat> getAllCTPD();
	public List<ChiTietPhieuDat> getAllCTPDByMaBanTiec(String maBanTiec);
	public boolean updateCTPD(ChiTietPhieuDat ctpd);
}
