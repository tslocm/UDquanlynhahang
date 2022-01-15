package com.iuh.quanlynhahang.entities;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * Entity implementation class for Entity: Ban
 *
 */
@Entity

public class Ban implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int maBan;
//	@ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
//	@JoinColumn(name = "maLoaiBan")
//	private LoaiBan loaiBan;
//	private int soLuongBan;
	@Column(columnDefinition = "nvarchar(50)")
	private String trangThaiHoatDong;
	@Column(columnDefinition = "nvarchar(50)")
	private String trangThaiDatBan;

	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "maSanh")
	private Sanh sanh;

//	@ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
//	@JoinColumn(name = "maBanTiec")
//	private Ban ban;

//	@OneToMany(cascade = CascadeType.ALL)
//	@JoinColumn(name = "maBan")
//	private Set<BanTiec> banTiecs;

	public Ban() {
		super();
	}

	public Ban(String trangThaiHoatDong, String trangThaiDatBan, Sanh sanh) {
		this.trangThaiHoatDong = trangThaiHoatDong;
		this.trangThaiDatBan = trangThaiDatBan;
		this.sanh = sanh;
	}

	public int getMaBan() {
		return maBan;
	}

	public void setMaBan(int maBan) {
		this.maBan = maBan;
	}

//	public LoaiBan getLoaiBan() {
//		return loaiBan;
//	}
//
//	public void setLoaiBan(LoaiBan loaiBan) {
//		this.loaiBan = loaiBan;
//	}

//	public int getSoLuongBan() {
//		return soLuongBan;
//	}
//
//	public void setSoLuongBan(int soLuongBan) {
//		this.soLuongBan = soLuongBan;
//	}

	public Sanh getSanh() {
		return sanh;
	}

	public void setSanh(Sanh sanh) {
		this.sanh = sanh;
	}

	public String getTrangThaiHoatDong() {
		return trangThaiHoatDong;
	}

	public void setTrangThaiHoatDong(String trangThaiHoatDong) {
		this.trangThaiHoatDong = trangThaiHoatDong;
	}

	public String gettrangThaiDatBan() {
		return trangThaiDatBan;
	}

	public void settrangThaiDatBan(String trangThaiDatBan) {
		this.trangThaiDatBan = trangThaiDatBan;
	}

}
