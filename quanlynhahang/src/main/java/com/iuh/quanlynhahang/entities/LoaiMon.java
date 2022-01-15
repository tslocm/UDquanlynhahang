package com.iuh.quanlynhahang.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Entity implementation class for Entity: LoaiMonAn
 *
 */
@Entity

public class LoaiMon implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	private String maLoaiMon;
	@Column(columnDefinition = "nvarchar(100)")
	private String tenLoaiMon;

	public LoaiMon() {
		super();
	}

	public LoaiMon(String maLoaiMon, String tenLoaiMon) {
		super();
		this.maLoaiMon = maLoaiMon;
		this.tenLoaiMon = tenLoaiMon;
	}

	public String getMaLoaiMon() {
		return maLoaiMon;
	}

	public void setMaLoaiMon(String maLoaiMon) {
		this.maLoaiMon = maLoaiMon;
	}

	public String getTenLoaiMon() {
		return tenLoaiMon;
	}

	public void setTenLoaiMon(String tenLoaiMon) {
		this.tenLoaiMon = tenLoaiMon;
	}

}
