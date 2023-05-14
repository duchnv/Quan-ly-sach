package com.ltw.QLSach.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(name = "buy")
public class BuyBook{
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
	private int id;
	
	
    @Column(name = "tensach")
	private String tensach;
	
    @DecimalMin(value = "0.0", inclusive = false, message = "Phải là số dương!")
    @Column(name = "gia")
	private double gia;
	
    @DecimalMin(value = "0.0", inclusive = false, message = "Phải là số dương!")
    @Column(name = "qty")
	private int qty = 1;
	
	
    @Column(name = "tenuser")
	private String tenuser;
	
    @Column(name = "sdt")
	private String sdt;
    
    @Column(name = "diachi")
	private String diachi;
    
    @Column(name = "trangbia", length = 500, nullable = true)
    private String trangbia;
    
	public String getTrangbia() {
		return trangbia;
	}
	public void setTrangbia(String trangbia) {
		this.trangbia = trangbia;
	}
	public String getSdt() {
		return sdt;
	}
	public void setSdt(String sdt) {
		this.sdt = sdt;
	}
	public String getDiachi() {
		return diachi;
	}
	public void setDiachi(String diachi) {
		this.diachi = diachi;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getTensach() {
		return tensach;
	}
	public void setTensach(String tensach) {
		this.tensach = tensach;
	}
	public double getGia() {
		return gia;
	}
	public void setGia(double gia) {
		this.gia = gia;
	}
	public int getQty() {
		return qty;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}
	public String getTenuser() {
		return tenuser;
	}
	public void setTenuser(String tenuser) {
		this.tenuser = tenuser;
	}
	
	

}
