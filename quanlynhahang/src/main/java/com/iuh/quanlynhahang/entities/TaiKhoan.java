package com.iuh.quanlynhahang.entities;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * Entity implementation class for Entity: TaiKhoan
 *
 */
@Entity

public class TaiKhoan implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	private String maTaiKhoan;

//	@OneToOne(mappedBy = "taiKhoan", cascade = CascadeType.ALL, fetch = FetchType.EAGER, optional = false)
//	private NhanVien nhanVien;
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
	@JoinColumn(name = "maLoaiTaiKhoan")
	private LoaiTaiKhoan loaiTaiKhoan;
	@Column(columnDefinition = "nvarchar(20)")
	private String tenTaiKhoan;
	private String matKhau;

	public TaiKhoan() {
		super();
	}

	public TaiKhoan(String maTaiKhoan, LoaiTaiKhoan loaiTaiKhoan, String tenTaiKhoan, String matKhau) {
		super();
		this.maTaiKhoan = maTaiKhoan;
		this.loaiTaiKhoan = loaiTaiKhoan;
		this.tenTaiKhoan = tenTaiKhoan;
		this.matKhau = matKhau;
	}

	public String getMaTaiKhoan() {
		return maTaiKhoan;
	}

	public void setMaTaiKhoan(String maTaiKhoan) {
		this.maTaiKhoan = maTaiKhoan;
	}

	public LoaiTaiKhoan getLoaiTaiKhoan() {
		return loaiTaiKhoan;
	}

	public void setLoaiTaiKhoan(LoaiTaiKhoan loaiTaiKhoan) {
		this.loaiTaiKhoan = loaiTaiKhoan;
	}

	public String getTenTaiKhoan() {
		return tenTaiKhoan;
	}

	public void setTenTaiKhoan(String tenTaiKhoan) {
		this.tenTaiKhoan = tenTaiKhoan;
	}

	public String getMatKhau() {
		return matKhau;
	}

	public void setMatKhau(String matKhau) {
		this.matKhau = matKhau;
	}

}
