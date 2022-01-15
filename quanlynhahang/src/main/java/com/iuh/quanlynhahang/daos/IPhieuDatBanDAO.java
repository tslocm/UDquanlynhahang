package com.iuh.quanlynhahang.daos;

import java.util.List;

import com.iuh.quanlynhahang.entities.PhieuDatBan;

public interface IPhieuDatBanDAO {
	public boolean createPhieuDatBan(PhieuDatBan phieuDatBan);

	public boolean updatePhieuDatBan(PhieuDatBan phieuDatBan);

	public PhieuDatBan getPhieuDatBanById(String id);

	public PhieuDatBan getPhieuDatBanBySDT(String sdt);

	public List<PhieuDatBan> getPhieuDatBansBySDT(String sdt);

	public List<PhieuDatBan> getAllPhieuDatBan();

}
