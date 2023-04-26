package com.example.ktratrenlop_tablayout.model;

import java.io.Serializable;

public class CongViec implements Serializable {
    private int id;
    private String ten, noidung, ngay,tinhtrang;
    private boolean  congtac;
    private String  radiobutton;

    public CongViec() {
    }

    public CongViec(int id, String ten, String noidung, String ngay, String tinhtrang, boolean congtac, String radiobutton) {
        this.id = id;
        this.ten = ten;
        this.noidung = noidung;
        this.ngay = ngay;
        this.tinhtrang = tinhtrang;
        this.congtac = congtac;
        this.radiobutton = radiobutton;
    }

    public String getRadiobutton() {
        return radiobutton;
    }

    public void setRadiobutton(String radiobutton) {
        this.radiobutton = radiobutton;
    }

    public CongViec(String ten, String noidung, String ngay, String tinhtrang, boolean congtac, String radiobutton) {
        this.ten = ten;
        this.noidung = noidung;
        this.ngay = ngay;
        this.tinhtrang = tinhtrang;
        this.congtac = congtac;
        this.radiobutton = radiobutton;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getNoidung() {
        return noidung;
    }

    public void setNoidung(String noidung) {
        this.noidung = noidung;
    }

    public String getNgay() {
        return ngay;
    }

    public void setNgay(String ngay) {
        this.ngay = ngay;
    }

    public String getTinhtrang() {
        return tinhtrang;
    }

    public void setTinhtrang(String tinhtrang) {
        this.tinhtrang = tinhtrang;
    }

    public boolean isCongtac() {
        return congtac;
    }

    public void setCongtac(boolean congtac) {
        this.congtac = congtac;
    }
}
