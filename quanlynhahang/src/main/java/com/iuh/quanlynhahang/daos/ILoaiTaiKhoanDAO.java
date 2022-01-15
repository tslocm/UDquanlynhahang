package com.iuh.quanlynhahang.daos;

import java.util.List;

import com.iuh.quanlynhahang.entities.LoaiTaiKhoan;

public interface ILoaiTaiKhoanDAO {
	public boolean createLTK(LoaiTaiKhoan ltk);

	public boolean deleteLTK(LoaiTaiKhoan ltk);

	public LoaiTaiKhoan getLTKByTenLTK(String tenLTK);

	public LoaiTaiKhoan getLTKByMaLTK(String maLTK);

	public List<LoaiTaiKhoan> getAllLTK();

	public boolean updateLTK(LoaiTaiKhoan ltk);

}
