package com.iuh.quanlynhahang.entities;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * Entity implementation class for Entity: HoaDon
 *
 */
@Entity

public class HoaDon implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	private String maHoaDon;
	
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
	@JoinColumn(name = "maKhachHang")
	private KhachHang khachHang;
	
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
	@JoinColumn(name = "maNhanVien")
	private NhanVien nhanVien;
	
	private LocalDate ngayXuatHoaDon;
	
//	@OneToMany(cascade = CascadeType.ALL)
//	@JoinColumn(name = "maHoaDon")
//	private Set<ChiTietHoaDon> chiTietHoaDons;

	public HoaDon() {
		super();
	}
	
	

	public HoaDon(String maHoaDon, NhanVien nhanVien, LocalDate ngayXuatHoaDon) {
	super();
	this.maHoaDon = maHoaDon;
	this.nhanVien = nhanVien;
	this.ngayXuatHoaDon = ngayXuatHoaDon;
}



	public HoaDon(String maHoaDon, KhachHang khachHang, NhanVien nhanVien, LocalDate ngayXuatHoaDon) {
		super();
		this.maHoaDon = maHoaDon;
		this.khachHang = khachHang;
		this.nhanVien = nhanVien;
		this.ngayXuatHoaDon = ngayXuatHoaDon;
	}



	public String getMaHoaDon() {
		return maHoaDon;
	}

	public void setMaHoaDon(String maHoaDon) {
		this.maHoaDon = maHoaDon;
	}

	public KhachHang getKhachHang() {
		return khachHang;
	}

	public void setKhachHang(KhachHang khachHang) {
		this.khachHang = khachHang;
	}

	public NhanVien getNhanVien() {
		return nhanVien;
	}

	public void setNhanVien(NhanVien nhanVien) {
		this.nhanVien = nhanVien;
	}

	public LocalDate getNgayXuatHoaDon() {
		return ngayXuatHoaDon;
	}

	public void setNgayXuatHoaDon(LocalDate ngayXuatHoaDon) {
		this.ngayXuatHoaDon = ngayXuatHoaDon;
	}

}
