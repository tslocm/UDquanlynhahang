package com.quanlynhahang.dto;

public class DoUongDTO {
	private String maDoUong;
	private String tenDoUong;
	private String loaiDoUong;
	private String giatienDoUong;

	public DoUongDTO(String maDoUong, String tenDoUong, String loaiDoUong, String giatienDoUong) {
		super();
		this.maDoUong = maDoUong;
		this.tenDoUong = tenDoUong;
		this.loaiDoUong = loaiDoUong;
		this.giatienDoUong = giatienDoUong;
	}

	public String getDoUong() {
		return maDoUong;
	}

	public void setDoUong(String maDoUong) {
		this.maDoUong = maDoUong;
	}

	public String getTenMon() {
		return tenDoUong;
	}

	public void setTenMon(String tenDoUong) {
		this.tenDoUong = tenDoUong;
	}

	public String getLoaiDoUong() {
		return loaiDoUong;
	}

	public void setLoaiDoUong(String loaiDoUong) {
		this.loaiDoUong = loaiDoUong;
	}

	public String getGiatienDoUong() {
		return giatienDoUong;
	}

	public void setGiatienDoUong(String giatienDoUong) {
		this.giatienDoUong = giatienDoUong;
	}

	@Override
	public String toString() {
		return "DoUong [maDoUong=" + maDoUong + ", tenDoUong=" + tenDoUong + ", loaiDoUong=" + loaiDoUong
				+ ", giatienDoUong=" + giatienDoUong + "]";
	}

}
