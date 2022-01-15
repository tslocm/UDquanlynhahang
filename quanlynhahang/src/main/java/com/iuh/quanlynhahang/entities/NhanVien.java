package com.iuh.quanlynhahang.entities;

import java.io.Serializable;
//import java.time.Date;
import java.util.Date;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: NhanVien
 *
 */
@Entity

public class NhanVien implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	private String maNhanVien;
	@Column(columnDefinition = "nvarchar(50)")
	private String hoTenNhanVien;
	private Date ngaySinh;
	@Column(columnDefinition = "nvarchar(10)")
	private String gioiTinh;
	@Column(columnDefinition = "nvarchar(200)")
	private String diaChi;
	private String soDienThoai;
	@Column(columnDefinition = "nvarchar(50)")
	private String tinhTrang;
	private String email;
//	@JoinColumn(name = "maTaiKhoan")
//	@OneToOne(optional=false, mappedBy="nhanVien")

//	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER, optional = false)
//	@JoinColumn(name = "maTaiKhoan", insertable = false, updatable = false, unique = true)
	
	@OneToOne(cascade = CascadeType.MERGE,optional = false)
	@JoinColumn(name = "maTaiKhoan",insertable = true, updatable = true, unique = true)
	private TaiKhoan taiKhoan;
//	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
//	@JoinColumn(name = "maChucVu")
//	private ChucVu chucVu;

	public NhanVien() {
		super();
	}

	public NhanVien(String maNhanVien, String hoTenNhanVien, Date ngaySinh, String gioiTinh, String diaChi,
			String soDienThoai, String tinhTrang, String email, TaiKhoan taiKhoan) {
		super();
		this.maNhanVien = maNhanVien;
		this.hoTenNhanVien = hoTenNhanVien;
		this.ngaySinh = ngaySinh;
		this.gioiTinh = gioiTinh;
		this.diaChi = diaChi;
		this.soDienThoai = soDienThoai;
		this.tinhTrang = tinhTrang;
		this.email = email;
		this.taiKhoan = taiKhoan;
	}
	
//	public NhanVien(String maNhanVien, String hoTenNhanVien, Date ngaySinh, String gioiTinh, String diaChi,
//			String soDienThoai, String tinhTrang, String email) {
//		super();
//		this.maNhanVien = maNhanVien;
//		this.hoTenNhanVien = hoTenNhanVien;
//		this.ngaySinh = ngaySinh;
//		this.gioiTinh = gioiTinh;
//		this.diaChi = diaChi;
//		this.soDienThoai = soDienThoai;
//		this.tinhTrang = tinhTrang;
//		this.email = email;
//	}

	public String getMaNhanVien() {
		return maNhanVien;
	}

	public void setMaNhanVien(String maNhanVien) {
		this.maNhanVien = maNhanVien;
	}

	public String getHoTenNhanVien() {
		return hoTenNhanVien;
	}

	public void setHoTenNhanVien(String hoTenNhanVien) {
		this.hoTenNhanVien = hoTenNhanVien;
	}

	public Date getNgaySinh() {
		return ngaySinh;
	}

	public void setNgaySinh(Date ngaySinh) {
		this.ngaySinh = ngaySinh;
	}

	public String getGioiTinh() {
		return gioiTinh;
	}

	public void setGioiTinh(String gioiTinh) {
		this.gioiTinh = gioiTinh;
	}

	public String getDiaChi() {
		return diaChi;
	}

	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}

	public String getSoDienThoai() {
		return soDienThoai;
	}

	public void setSoDienThoai(String soDienThoai) {
		this.soDienThoai = soDienThoai;
	}

	public String getTinhTrang() {
		return tinhTrang;
	}

	public void setTinhTrang(String tinhTrang) {
		this.tinhTrang = tinhTrang;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public TaiKhoan getTaiKhoan() {
		return taiKhoan;
	}

	public void setTaiKhoan(TaiKhoan taiKhoan) {
		this.taiKhoan = taiKhoan;
	}

//	public ChucVu getChucVu() {
//		return chucVu;
//	}
//
//	public void setChucVu(ChucVu chucVu) {
//		this.chucVu = chucVu;
//	}

}
