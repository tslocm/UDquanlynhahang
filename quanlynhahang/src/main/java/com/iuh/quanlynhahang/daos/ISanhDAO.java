package com.iuh.quanlynhahang.daos;

import java.util.List;

import com.iuh.quanlynhahang.entities.Sanh;

public interface ISanhDAO {
	public boolean createSanh(Sanh sanh);

	public boolean updateSanh(Sanh sanh);

	public boolean deleteSanh(Sanh sanh);

	public Sanh getSanhById(String maSanh);

	public Sanh getSanhByTen(String tenSanh);

	public List<Sanh> getAllSanh();

	public List<String> getAllTenSanh();
//	public List<String> getAllTenSanhDHD();
}
