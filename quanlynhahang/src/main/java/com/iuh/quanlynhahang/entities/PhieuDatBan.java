//package com.iuh.quanlynhahang.entities;
//
//import java.io.Serializable;
//import java.math.BigDecimal;
//import java.time.LocalDate;
//import java.util.Set;
//
//import javax.persistence.CascadeType;
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.FetchType;
//import javax.persistence.Id;
//import javax.persistence.JoinColumn;
//import javax.persistence.JoinTable;
//import javax.persistence.ManyToMany;
//import javax.persistence.ManyToOne;
//
///**
// * Entity implementation class for Entity: DatMon
// *
// */
//@Entity
//public class PhieuDatBan implements Serializable {
//	private static final long serialVersionUID = 1L;
//	@Id
//	private String maBanTiec;
//	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
//	@JoinColumn(name = "maKhachhang")
////	@Column(nullable = true)
//	private KhachHang khachHang;
//
//	@ManyToMany(fetch = FetchType.EAGER)
//	@JoinTable(name = "PhieuDatBan_Ban", joinColumns = @JoinColumn(name = "maBanTiec", referencedColumnName = "maBanTiec"), inverseJoinColumns = @JoinColumn(name = "maBan", referencedColumnName = "maBan"))
////	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
////	@JoinColumn(name = "maBanTiec")
//	@Column(nullable = true)
//	private Set<Ban> bans;
//	@ManyToMany(fetch = FetchType.EAGER)
//	@JoinTable(name = "PhieuDatBan_Mon", joinColumns = @JoinColumn(name = "maBanTiec", referencedColumnName = "maBanTiec"), inverseJoinColumns = @JoinColumn(name = "maMon", referencedColumnName = "maMon"))
//	private Set<Mon> monAns;
//	@Column(nullable = true)
//	private LocalDate ngayDatMon;
//	@Column(nullable = true)
//	private LocalDate ngaySuDung;
//	@Column(nullable = true)
//	private String gioSuDung;
//	@Column(columnDefinition = "nvarchar(30)", nullable = true)
//	private String trangThaiThanhToan;
//	@Column(nullable = true)
//	private int soLuongNguoi;
//	@Column(nullable = true)
//	private int soLuongMon;
//	@Column(nullable = true)
//	private BigDecimal tienCoc;
////	@Column(columnDefinition = "nvarchar(30)")
////	private String donViTinh;
//	@Column(columnDefinition = "nvarchar(30)")
//	private String trangThai;
//
//	public PhieuDatBan() {
//		super();
//	}
//
//	public PhieuDatBan(String maBanTiec, KhachHang khachHang, Set<Ban> bans, Set<Mon> monAns, LocalDate ngayDatMon,
//			LocalDate ngaySuDung, String gioSuDung, String trangThaiThanhToan, int soLuongNguoi, int soLuongMon,
//			BigDecimal tienCoc, String trangThai) {
//		super();
//		this.maBanTiec = maBanTiec;
//		this.khachHang = khachHang;
//		this.bans = bans;
//		this.monAns = monAns;
//		this.ngayDatMon = ngayDatMon;
//		this.ngaySuDung = ngaySuDung;
//		this.gioSuDung = gioSuDung;
//		this.trangThaiThanhToan = trangThaiThanhToan;
//		this.soLuongNguoi = soLuongNguoi;
//		this.soLuongMon = soLuongMon;
//		this.tienCoc = tienCoc;
//		this.trangThai = trangThai;
//	}
//
//	public PhieuDatBan(String maBanTiec, Set<Mon> monAns, String trangThaiThanhToan) {
//		super();
//		this.maBanTiec = maBanTiec;
//		this.monAns = monAns;
//		this.trangThaiThanhToan = trangThaiThanhToan;
//	}
//
//	public PhieuDatBan(String maBanTiec, Set<Mon> monAns, LocalDate ngayDatMon, LocalDate ngaySuDung, String trangThai,
//			String trangThaiThanhToan, BigDecimal tienCoc) {
//		super();
//		this.maBanTiec = maBanTiec;
//		this.monAns = monAns;
//		this.ngayDatMon = ngayDatMon;
//		this.ngaySuDung = ngaySuDung;
//		this.trangThai = trangThai;
//		this.trangThaiThanhToan = trangThaiThanhToan;
//		this.tienCoc = tienCoc;
//	}
//
//	public String getMaBanTiec() {
//		return maBanTiec;
//	}
//
//	public void setMaBanTiec(String maBanTiec) {
//		this.maBanTiec = maBanTiec;
//	}
//
//	public KhachHang getKhachHang() {
//		return khachHang;
//	}
//
//	public void setKhachHang(KhachHang khachHang) {
//		this.khachHang = khachHang;
//	}
//
////	public Set<Ban> getBans() {
////		return bans;
////	}
////
////	public void setBans(Set<Ban> bans) {
////		this.bans = bans;
////	}
////
////	public Set<Mon> getMonAns() {
////		return monAns;
////	}
////
////	public void setMonAns(Set<Mon> monAns) {
////		this.monAns = monAns;
////	}
//
//	public Set<Ban> getBans() {
//		return bans;
//	}
//
//	public void setBans(Set<Ban> bans) {
//		this.bans = bans;
//	}
//
//	public Set<Mon> getMonAns() {
//		return monAns;
//	}
//
//	public void setMonAns(Set<Mon> monAns) {
//		this.monAns = monAns;
//	}
//
//	public int getSoLuongMon() {
//		return soLuongMon;
//	}
//
//	public void setSoLuongMon(int soLuongMon) {
//		this.soLuongMon = soLuongMon;
//	}
//
//	public BigDecimal getTienCoc() {
//		return tienCoc;
//	}
//
//	public void setTienCoc(BigDecimal tienCoc) {
//		this.tienCoc = tienCoc;
//	}
//
//	public LocalDate getNgayDatMon() {
//		return ngayDatMon;
//	}
//
//	public void setNgayDatMon(LocalDate ngayDatMon) {
//		this.ngayDatMon = ngayDatMon;
//	}
//
//	public LocalDate getNgaySuDung() {
//		return ngaySuDung;
//	}
//
//	public void setNgaySuDung(LocalDate ngaySuDung) {
//		this.ngaySuDung = ngaySuDung;
//	}
//
//	public String getGioSuDung() {
//		return gioSuDung;
//	}
//
//	public void setGioSuDung(String gioSuDung) {
//		this.gioSuDung = gioSuDung;
//	}
//
////	public int getSoLuong() {
////		return soLuong;
////	}
////
////	public void setSoLuong(int soLuong) {
////		this.soLuong = soLuong;
////	}
//
//	public int getSoLuongNguoi() {
//		return soLuongNguoi;
//	}
//
//	public void setSoLuongNguoi(int soLuongNguoi) {
//		this.soLuongNguoi = soLuongNguoi;
//	}
//
//	public String getTrangThaiThanhToan() {
//		return trangThaiThanhToan;
//	}
//
//	public void setTrangThaiThanhToan(String trangThaiThanhToan) {
//		this.trangThaiThanhToan = trangThaiThanhToan;
//	}
//
//	public String getTrangThai() {
//		return trangThai;
//	}
//
//	public void setTrangThai(String trangThai) {
//		this.trangThai = trangThai;
//	}
//
//}

package com.iuh.quanlynhahang.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

/**
 * Entity implementation class for Entity: DatMon
 *
 */
@Entity
public class PhieuDatBan implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	private String maPhieuDatBan;

	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
	@JoinColumn(name = "maKhachhang")
	private KhachHang khachHang;

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "PhieuDatBan_ChiTietBan", joinColumns = @JoinColumn(name = "maPhieuDatBan", referencedColumnName = "maPhieuDatBan"), inverseJoinColumns = @JoinColumn(name = "maBan", referencedColumnName = "maBan"))
//	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
//	@JoinColumn(name = "maBanTiec")
	@Column(nullable = true)
	private Set<Ban> bans;
//	@ManyToMany(fetch = FetchType.EAGER)
//	@JoinTable(name = "PhieuDatBan_Mon", joinColumns = @JoinColumn(name = "maBanTiec", referencedColumnName = "maBanTiec"), inverseJoinColumns = @JoinColumn(name = "maMon", referencedColumnName = "maMon"))
//	private Set<Mon> monAns;
	@Column(nullable = true)
	private LocalDate ngayDatMon;
	@Column(nullable = true)
	private LocalDate ngaySuDung;
	@Column(nullable = true)
	private String gioSuDung;
	@Column(columnDefinition = "nvarchar(30)", nullable = true)
	private String trangThaiThanhToan;
	@Column(nullable = true)
	private int soLuongNguoi;
//	@Column(nullable = false)
//	private int soLuongMon;
	@Column(nullable = true)
	private BigDecimal tienCoc;
//	@Column(columnDefinition = "nvarchar(30)")
//	private String donViTinh;
	@Column(columnDefinition = "nvarchar(30)")
	private String trangThai;

	public PhieuDatBan() {
		super();
	}

	public PhieuDatBan(String maPhieuDatBan, KhachHang khachHang, Set<Ban> bans, LocalDate ngayDatMon,
			LocalDate ngaySuDung, String gioSuDung, String trangThaiThanhToan, int soLuongNguoi, BigDecimal tienCoc,
			String trangThai) {
		super();
		this.maPhieuDatBan = maPhieuDatBan;
		this.khachHang = khachHang;
		this.bans = bans;
		this.ngayDatMon = ngayDatMon;
		this.ngaySuDung = ngaySuDung;
		this.gioSuDung = gioSuDung;
		this.trangThaiThanhToan = trangThaiThanhToan;
		this.soLuongNguoi = soLuongNguoi;
		this.tienCoc = tienCoc;
		this.trangThai = trangThai;
	}

//	public PhieuDatBan(String maBanTiec, Set<Mon> monAns, String trangThaiThanhToan) {
//		super();
//		this.maBanTiec = maBanTiec;
//		this.trangThaiThanhToan = trangThaiThanhToan;
//	}
//
//	public PhieuDatBan(String maBanTiec, Set<Mon> monAns, LocalDate ngayDatMon, LocalDate ngaySuDung, String trangThai,
//			String trangThaiThanhToan, BigDecimal tienCoc) {
//		super();
//		this.maBanTiec = maBanTiec;
//		this.monAns = monAns;
//		this.ngayDatMon = ngayDatMon;
//		this.ngaySuDung = ngaySuDung;
//		this.trangThai = trangThai;
//		this.trangThaiThanhToan = trangThaiThanhToan;
//		this.tienCoc = tienCoc;
//	}

	public PhieuDatBan(String maPhieuDatBan, LocalDate ngayDatMon, LocalDate ngaySuDung, String trangThaiThanhToan,
			BigDecimal tienCoc, String trangThai) {
		super();
		this.maPhieuDatBan = maPhieuDatBan;
		this.ngayDatMon = ngayDatMon;
		this.ngaySuDung = ngaySuDung;
		this.trangThaiThanhToan = trangThaiThanhToan;
		this.tienCoc = tienCoc;
		this.trangThai = trangThai;
	}

	public String getMaPhieuDatBan() {
		return maPhieuDatBan;
	}

	public void setMaPhieuDatBan(String maPhieuDatBan) {
		this.maPhieuDatBan = maPhieuDatBan;
	}

	public KhachHang getKhachHang() {
		return khachHang;
	}

	public void setKhachHang(KhachHang khachHang) {
		this.khachHang = khachHang;
	}

//	public Set<Ban> getBans() {
//		return bans;
//	}
//
//	public void setBans(Set<Ban> bans) {
//		this.bans = bans;
//	}
//
//	public Set<Mon> getMonAns() {
//		return monAns;
//	}
//
//	public void setMonAns(Set<Mon> monAns) {
//		this.monAns = monAns;
//	}

	public Set<Ban> getBans() {
		return bans;
	}

	public void setBans(Set<Ban> bans) {
		this.bans = bans;
	}

//	public Set<Mon> getMonAns() {
//		return monAns;
//	}
//
//	public void setMonAns(Set<Mon> monAns) {
//		this.monAns = monAns;
//	}
//
//	public int getSoLuongMon() {
//		return soLuongMon;
//	}
//
//	public void setSoLuongMon(int soLuongMon) {
//		this.soLuongMon = soLuongMon;
//	}

	public BigDecimal getTienCoc() {
		return tienCoc;
	}

	public void setTienCoc(BigDecimal tienCoc) {
		this.tienCoc = tienCoc;
	}

	public LocalDate getNgayDatMon() {
		return ngayDatMon;
	}

	public void setNgayDatMon(LocalDate ngayDatMon) {
		this.ngayDatMon = ngayDatMon;
	}

	public LocalDate getNgaySuDung() {
		return ngaySuDung;
	}

	public void setNgaySuDung(LocalDate ngaySuDung) {
		this.ngaySuDung = ngaySuDung;
	}

	public String getGioSuDung() {
		return gioSuDung;
	}

	public void setGioSuDung(String gioSuDung) {
		this.gioSuDung = gioSuDung;
	}

//	public int getSoLuong() {
//		return soLuong;
//	}
//
//	public void setSoLuong(int soLuong) {
//		this.soLuong = soLuong;
//	}

	public int getSoLuongNguoi() {
		return soLuongNguoi;
	}

	public void setSoLuongNguoi(int soLuongNguoi) {
		this.soLuongNguoi = soLuongNguoi;
	}

	public String getTrangThaiThanhToan() {
		return trangThaiThanhToan;
	}

	public void setTrangThaiThanhToan(String trangThaiThanhToan) {
		this.trangThaiThanhToan = trangThaiThanhToan;
	}

	public String getTrangThai() {
		return trangThai;
	}

	public void setTrangThai(String trangThai) {
		this.trangThai = trangThai;
	}

}
