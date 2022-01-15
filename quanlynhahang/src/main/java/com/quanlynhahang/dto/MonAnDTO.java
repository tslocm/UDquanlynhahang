package com.quanlynhahang.dto;

public class MonAnDTO {
	private String maMon;
	private String tenMon;
	private String loaiMon;
	private String giatienMon;
	public MonAnDTO(String maMon, String tenMon, String loaiMon, String giatienMon) {
		super();
		this.maMon = maMon;
		this.tenMon = tenMon;
		this.loaiMon = loaiMon;
		this.giatienMon = giatienMon;
	}
	public String getMaMon() {
		return maMon;
	}
	public void setMaMon(String maMon) {
		this.maMon = maMon;
	}
	public String getTenMon() {
		return tenMon;
	}
	public void setTenMon(String tenMon) {
		this.tenMon = tenMon;
	}
	public String getLoaiMon() {
		return loaiMon;
	}
	public void setLoaiMon(String loaiMon) {
		this.loaiMon = loaiMon;
	}
	public String getGiatienMon() {
		return giatienMon;
	}
	public void setGiatienMon(String giatienMon) {
		this.giatienMon = giatienMon;
	}
	@Override
	public String toString() {
		return "BCMonAn [maMon=" + maMon + ", tenMon=" + tenMon + ", loaiMon=" + loaiMon + ", giatienMon=" + giatienMon
				+ "]";
	}
	
	
}
