package com.ltw.QLSach.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.web.multipart.MultipartFile;



@Entity
@Table(name = "books")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private int id;
    
    @NotEmpty
    @Column(name = "tensach")
    private String tensach;
    
    @NotEmpty
    @Column(name = "tacgia")
    private String tacgia;
    
    @NotEmpty
    @Column(name = "mota")
    private String mota;
    
    @NotEmpty
    @Column(name = "theloai")
    private String theloai;
    
    @NotEmpty
    @Column(name = "ngayphathanh")
    private String ngayphathanh;
    
    @NotNull
    @Column(name = "sotrang")
    private int sotrang;
    
//    @Column(name = "anh", length = 500, nullable = true)
//    private String anh ;
    
    
    
    @Column(name = "trangbia", length = 500, nullable = true)
    private String trangbia;
    
    @NotNull
    @Column(name = "giasach")
    private Double giasach;
    
    
    @Column(name = "danhgia")
    private String danhgia;
    
	public String getTensach() {
		return tensach;
	}

	public void setTensach(String tensach) {
		this.tensach = tensach;
	}

	public String getTrangbia() {
		return trangbia;
	}

	public void setTrangbia(String trangbia) {
		this.trangbia = trangbia;
	}

	public Double getGiasach() {
		return giasach;
	}

	public void setGiasach(Double giasach) {
		this.giasach = giasach;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}


	public String getTacgia() {
		return tacgia;
	}

	public void setTacgia(String tacgia) {
		this.tacgia = tacgia;
	}

	public String getMota() {
		return mota;
	}

	public void setMota(String mota) {
		this.mota = mota;
	}

	public String getTheloai() {
		return theloai;
	}

	public void setTheloai(String theloai) {
		this.theloai = theloai;
	}

	public String getNgayphathanh() {
		return ngayphathanh;
	}

	public void setNgayphathanh(String ngayphathanh) {
		this.ngayphathanh = ngayphathanh;
	}

	public int getSotrang() {
		return sotrang;
	}

	public void setSotrang(int sotrang) {
		this.sotrang = sotrang;
	}

	public String getDanhgia() {
		return danhgia;
	}

	public void setDanhgia(String danhgia) {
		this.danhgia = danhgia;
	}
	
//	public String getAnh() {
//		return anh;
//	}
//
//	public void setAnh(String anh) {
//		this.anh = anh;
//	}
    
    
    
}
