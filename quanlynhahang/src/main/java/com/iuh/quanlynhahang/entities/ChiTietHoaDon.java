package com.iuh.quanlynhahang.entities;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: ChiTietHoaDon
 *
 */
@Entity
@IdClass(ChiTietHoaDon_PK.class)
public class ChiTietHoaDon implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "maHoaDon")
	private HoaDon hoaDon;
	@Id
	@OneToOne(fetch = FetchType.EAGER, optional = false)
	@JoinColumn(name = "maPhieuDatBan", insertable = false, updatable = false, unique = true)
	private PhieuDatBan phieuDatBan;

	public ChiTietHoaDon() {
		super();
	}

	public ChiTietHoaDon(HoaDon hoaDon, PhieuDatBan phieuDatBan) {
		super();
		this.hoaDon = hoaDon;
		this.phieuDatBan = phieuDatBan;
	}

	public HoaDon getHoaDon() {
		return hoaDon;
	}

	public void setHoaDon(HoaDon hoaDon) {
		this.hoaDon = hoaDon;
	}

	public PhieuDatBan getPhieuDatBan() {
		return phieuDatBan;
	}

	public void setPhieuDatBan(PhieuDatBan phieuDatBan) {
		this.phieuDatBan = phieuDatBan;
	}

}
