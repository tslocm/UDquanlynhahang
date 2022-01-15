package com.iuh.quanlynhahang.entities;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: ChiTietPhieuDat
 *
 */
@Entity(name = "ChiTietPhieuDatBan")
@IdClass(ChiTietPhieuDat_PK.class)
public class ChiTietPhieuDat implements Serializable {
	@Id
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "maPhieuDatBan")
	private PhieuDatBan phieuDatBan;
	@Id
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "maMon")
	private Mon mon;
	@Column(nullable = false)
	private int soLuong;
	@Column(columnDefinition = "nvarchar(30)",nullable = false)
	private String donViTinh;
	private static final long serialVersionUID = 1L;

	public ChiTietPhieuDat() {
		super();
	}

	public ChiTietPhieuDat(PhieuDatBan phieuDatBan, Mon mon, int soLuong, String donViTinh) {
		super();
		this.phieuDatBan = phieuDatBan;
		this.mon = mon;
		this.soLuong = soLuong;
		this.donViTinh = donViTinh;
	}

	public PhieuDatBan getPhieuDatBan() {
		return phieuDatBan;
	}

	public void setPhieuDatBan(PhieuDatBan phieuDatBan) {
		this.phieuDatBan = phieuDatBan;
	}

	public Mon getMon() {
		return mon;
	}

	public void setMon(Mon mon) {
		this.mon = mon;
	}

	public int getSoLuong() {
		return soLuong;
	}

	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}

	public String getDonViTinh() {
		return donViTinh;
	}

	public void setDonViTinh(String donViTinh) {
		this.donViTinh = donViTinh;
	}

}
