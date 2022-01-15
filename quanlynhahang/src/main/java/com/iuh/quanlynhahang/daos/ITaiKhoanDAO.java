package com.iuh.quanlynhahang.daos;

import java.util.List;

import com.iuh.quanlynhahang.entities.TaiKhoan;

public interface ITaiKhoanDAO {
	public boolean createTK(TaiKhoan tk);

	public boolean updateTK(TaiKhoan tk);

	public boolean deleteTK(TaiKhoan tk);

	public TaiKhoan getTKByTenTK(String tenTK);
	
	public TaiKhoan getTKByMaTK(String maTK);

	public List<TaiKhoan> getAllTK();

}
