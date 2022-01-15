package com.iuh.quanlynhahang.entities;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: KhuVuc
 *
 */
@Entity

public class Sanh implements Serializable {

	@Id
	private String maSanh;
	@Column(columnDefinition = "nvarchar(50)")
	private String tenSanh;
	@Column(columnDefinition = "nvarchar(50)")
	private String trangThai;

	private static final long serialVersionUID = 1L;

	public Sanh() {
		super();
	}

	public Sanh(String maSanh, String tenSanh, String trangThai) {
		super();
		this.maSanh = maSanh;
		this.tenSanh = tenSanh;
		this.trangThai = trangThai;
	}

	public String getMaSanh() {
		return maSanh;
	}

	public void setMaSanh(String maSanh) {
		this.maSanh = maSanh;
	}

	public String getTenSanh() {
		return tenSanh;
	}

	public void setTenSanh(String tenSanh) {
		this.tenSanh = tenSanh;
	}

	public String getTrangThai() {
		return trangThai;
	}

	public void setTrangThai(String trangThai) {
		this.trangThai = trangThai;
	}

}
