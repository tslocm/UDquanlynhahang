package com.quanlynhahang.dto;

public class PhieuDatBan_Mon {
	private String maBanTiec;
	private String maMon;

	public PhieuDatBan_Mon() {
		// TODO Auto-generated constructor stub
	}

	public String getMaBanTiec() {
		return maBanTiec;
	}

	public void setMaBanTiec(String maBanTiec) {
		this.maBanTiec = maBanTiec;
	}

	public String getMaMon() {
		return maMon;
	}

	public void setMaMon(String maMon) {
		this.maMon = maMon;
	}

	public PhieuDatBan_Mon(String maBanTiec, String maMon) {
		super();
		this.maBanTiec = maBanTiec;
		this.maMon = maMon;
	}
	
	
}
