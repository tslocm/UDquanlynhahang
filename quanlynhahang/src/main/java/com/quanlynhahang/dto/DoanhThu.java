package com.quanlynhahang.dto;

public class DoanhThu {
	private String maHD;
	private String ngayInHD;
	private String thanhTien;
	public DoanhThu(String maHD, String ngayInHD, String thanhTien) {
		super();
		this.maHD = maHD;
		this.ngayInHD = ngayInHD;
		this.thanhTien = thanhTien;
	}
	public String getMaHD() {
		return maHD;
	}
	public void setMaHD(String maHD) {
		this.maHD = maHD;
	}
	public String getNgayInHD() {
		return ngayInHD;
	}
	public void setNgayInHD(String ngayInHD) {
		this.ngayInHD = ngayInHD;
	}
	public String getThanhTien() {
		return thanhTien;
	}
	public void setThanhTien(String thanhTien) {
		this.thanhTien = thanhTien;
	}
	@Override
	public String toString() {
		return "DoanhThu [maHD=" + maHD + ", ngayInHD=" + ngayInHD + ", thanhTien=" + thanhTien + "]";
	}
	
}
