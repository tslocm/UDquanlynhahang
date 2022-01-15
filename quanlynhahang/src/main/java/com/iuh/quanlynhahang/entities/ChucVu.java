//package com.iuh.quanlynhahang.entities;
//
//import java.io.Serializable;
//
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.Id;
//
//@Entity
//public class ChucVu implements Serializable {
//	@Id
//	private String maChucVu;
//	@Column(columnDefinition = "nvarchar(50)")
//	private String tenChucVu;
//
//	public String getMaChucVu() {
//		return maChucVu;
//	}
//
//	public void setMaChucVu(String maChucVu) {
//		this.maChucVu = maChucVu;
//	}
//
//	public String getTenChucVu() {
//		return tenChucVu;
//	}
//
//	public void setTenChucVu(String tenChucVu) {
//		this.tenChucVu = tenChucVu;
//	}
//
//	@Override
//	public int hashCode() {
//		final int prime = 31;
//		int result = 1;
//		result = prime * result + ((maChucVu == null) ? 0 : maChucVu.hashCode());
//		return result;
//	}
//
//	@Override
//	public boolean equals(Object obj) {
//		if (this == obj)
//			return true;
//		if (obj == null)
//			return false;
//		if (getClass() != obj.getClass())
//			return false;
//		ChucVu other = (ChucVu) obj;
//		if (maChucVu == null) {
//			if (other.maChucVu != null)
//				return false;
//		} else if (!maChucVu.equals(other.maChucVu))
//			return false;
//		return true;
//	}
//
//}
