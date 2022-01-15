package com.iuh.quanlynhahang.daos;

import java.util.List;

import com.iuh.quanlynhahang.entities.NhanVien;

public interface INhanVienDAO {
	public boolean createNV(NhanVien nv);

	public List<NhanVien> getAllNV();

	public boolean updateNV(NhanVien nv);

	public NhanVien getNVByID(String maNV);

	public NhanVien getNVBySDT(String sDT);

	public NhanVien getNVByMaTaiKhoan(String maTk);

}
