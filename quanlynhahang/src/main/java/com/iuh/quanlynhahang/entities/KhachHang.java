package com.iuh.quanlynhahang.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Entity implementation class for Entity: KhachHang
 *
 */
@Entity

public class KhachHang implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	private String maKhachHang;
	@Column(columnDefinition = "nvarchar(50)")
	private String tenKhachHang;
	@Column(columnDefinition = "nvarchar(10)")
	private String gioiTinh;
	private String soDienThoai;
	@Column(columnDefinition = "nvarchar(200)")
	private String diaChi;


	public KhachHang() {
		super();
	}
	

	public KhachHang(String maKhachHang, String tenKhachHang, String gioiTinh, String soDienThoai, String diaChi) {
		super();
		this.maKhachHang = maKhachHang;
		this.tenKhachHang = tenKhachHang;
		this.gioiTinh = gioiTinh;
		this.soDienThoai = soDienThoai;
		this.diaChi = diaChi;
	}
	


	public KhachHang(String tenKhachHang, String soDienThoai, String diaChi, String gioiTinh) {
		super();
		this.tenKhachHang = tenKhachHang;
		this.gioiTinh = gioiTinh;
		this.soDienThoai = soDienThoai;
		this.diaChi = diaChi;
	}


	public String getMaKhachHang() {
		return maKhachHang;
	}

	public void setMaKhachHang(String maKhachHang) {
		this.maKhachHang = maKhachHang;
	}

	public String getTenKhachHang() {
		return tenKhachHang;
	}

	public void setTenKhachHang(String tenKhachHang) {
		this.tenKhachHang = tenKhachHang;
	}

	public String getGioiTinh() {
		return gioiTinh;
	}

	public void setGioiTinh(String gioiTinh) {
		this.gioiTinh = gioiTinh;
	}

	public String getSoDienThoai() {
		return soDienThoai;
	}

	public void setSoDienThoai(String soDienThoai) {
		this.soDienThoai = soDienThoai;
	}

	public String getDiaChi() {
		return diaChi;
	}

	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}

}
