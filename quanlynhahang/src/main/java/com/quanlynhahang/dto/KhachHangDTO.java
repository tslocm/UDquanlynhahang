package com.quanlynhahang.dto;

public class KhachHangDTO {
	private String maKH;
	private String tenKH;
	private String soLanDat;
	private String sDT;
	private String gioiTinh;
	private String diaChi;

	public KhachHangDTO(String maKH, String tenKH, String soLanDat, String sDT, String gioiTinh, String diaChi) {
		super();
		this.maKH = maKH;
		this.tenKH = tenKH;
		this.soLanDat = soLanDat;
		this.sDT = sDT;
		this.gioiTinh = gioiTinh;
		this.diaChi = diaChi;
	}

	public String getMaKH() {
		return maKH;
	}

	public void setMaKH(String maKH) {
		this.maKH = maKH;
	}

	public String getTenKH() {
		return tenKH;
	}

	public void setTenKH(String tenKH) {
		this.tenKH = tenKH;
	}

	public String getSoLanDat() {
		return soLanDat;
	}

	public void setSoLanDat(String soLanDat) {
		this.soLanDat = soLanDat;
	}

	public String getsDT() {
		return sDT;
	}

	public void setsDT(String sDT) {
		this.sDT = sDT;
	}

	public String getGioiTinh() {
		return gioiTinh;
	}

	public void setGioiTinh(String gioiTinh) {
		this.gioiTinh = gioiTinh;
	}

	public String getDiaChi() {
		return diaChi;
	}

	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}

	@Override
	public String toString() {
		return "KhachHang [maKH=" + maKH + ", tenKH=" + tenKH + ", soLanDat=" + soLanDat + ", sDT=" + sDT
				+ ", gioiTinh=" + gioiTinh + ", diaChi=" + diaChi + "]";
	}

}
