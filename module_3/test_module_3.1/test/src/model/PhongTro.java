package model;

public class PhongTro {
    private String phongTroId;
    private String phongTroTen;
    private int Sdt;
    private String ngayBatDauThue;
    ThanhToan thanhToan;
    private String ghiChu;

    public PhongTro() {
    }

    public PhongTro(String phongTroId, String phongTroTen, int sdt, String ngayBatDauThue, ThanhToan thanhToan, String ghiChu) {
        this.phongTroId = phongTroId;
        this.phongTroTen = phongTroTen;
        Sdt = sdt;
        this.ngayBatDauThue = ngayBatDauThue;
        this.thanhToan = thanhToan;
        this.ghiChu = ghiChu;
    }

    public String getPhongTroId() {
        return phongTroId;
    }

    public void setPhongTroId(String phongTroId) {
        this.phongTroId = phongTroId;
    }

    public String getPhongTroTen() {
        return phongTroTen;
    }

    public void setPhongTroTen(String phongTroTen) {
        this.phongTroTen = phongTroTen;
    }

    public int getSdt() {
        return Sdt;
    }

    public void setSdt(int sdt) {
        Sdt = sdt;
    }

    public String getNgayBatDauThue() {
        return ngayBatDauThue;
    }

    public void setNgayBatDauThue(String ngayBatDauThue) {
        this.ngayBatDauThue = ngayBatDauThue;
    }

    public ThanhToan getThanhToan() {
        return thanhToan;
    }

    public void setThanhToan(ThanhToan thanhToan) {
        this.thanhToan = thanhToan;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }
}
