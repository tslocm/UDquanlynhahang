package com.iuh.quanlynhahang.entities;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: ChiTietPhieuDat_PK
 *
 */
@Embeddable

public class ChiTietPhieuDat_PK implements Serializable {

	private String phieuDatBan;
	private String mon;

	private static final long serialVersionUID = 1L;

	public ChiTietPhieuDat_PK() {
		super();
	}

	public String getphieuDatBan() {
		return phieuDatBan;
	}

	public void setphieuDatBan(String phieuDatBan) {
		this.phieuDatBan = phieuDatBan;
	}

	public String getMon() {
		return mon;
	}

	public void setMon(String mon) {
		this.mon = mon;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((phieuDatBan == null) ? 0 : phieuDatBan.hashCode());
		result = prime * result + ((mon == null) ? 0 : mon.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ChiTietPhieuDat_PK other = (ChiTietPhieuDat_PK) obj;
		if (phieuDatBan == null) {
			if (other.phieuDatBan != null)
				return false;
		} else if (!phieuDatBan.equals(other.phieuDatBan))
			return false;
		if (mon == null) {
			if (other.mon != null)
				return false;
		} else if (!mon.equals(other.mon))
			return false;
		return true;
	}

}
