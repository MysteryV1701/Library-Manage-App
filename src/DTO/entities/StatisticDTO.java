/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO.entities;

import java.time.LocalDate;

/**
 *
 * @author Tính
 */
public class StatisticDTO {
    public float bank;
    public int soLuotMuonBC;
    public int soLuotTra;
    public int soSachHong;
    public LocalDate thoiGian;

    public StatisticDTO() {
        super();
    }

    public StatisticDTO(float bank, int soLuotMuonBC, int soLuotTra, int soSachHong, LocalDate thoiGian) {
        this.bank = bank;
        this.soLuotMuonBC = soLuotMuonBC;
        this.soLuotTra = soLuotTra;
        this.soSachHong = soSachHong;
        this.thoiGian = thoiGian;
    }

    public float getBank() {
        return bank;
    }

    public void setBank(float bank) {
        this.bank = bank;
    }

    public int getSoLuotMuonBC() {
        return soLuotMuonBC;
    }

    public void setSoLuotMuonBC(int soLuotMuonBC) {
        this.soLuotMuonBC = soLuotMuonBC;
    }

    public int getSoLuotTra() {
        return soLuotTra;
    }

    public void setSoLuotTra(int soLuotTra) {
        this.soLuotTra = soLuotTra;
    }

    public int getSoSachHong() {
        return soSachHong;
    }

    public void setSoSachHong(int soSachHong) {
        this.soSachHong = soSachHong;
    }

    public LocalDate getThoiGian() {
        return thoiGian;
    }

    public void setThoiGian(LocalDate thoiGian) {
        this.thoiGian = thoiGian;
    }

    
}
