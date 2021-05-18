package model;

public abstract class KhachHang {
    private String maKhachHang;
    private String hoten;

    public KhachHang() {
    }

    public KhachHang(String maKhachHang, String hoten) {
        this.maKhachHang = maKhachHang;
        this.hoten = hoten;
    }
    public KhachHang(String []khachHang) {
        this.maKhachHang = khachHang[0];
        this.hoten = khachHang[1];
    }

    public String getMaKhachHang() {
        return maKhachHang;
    }

    public void setMaKhachHang(String maKhachHang) {
        this.maKhachHang = maKhachHang;
    }

    public String getHoten() {
        return hoten;
    }

    public void setHoten(String hoten) {
        this.hoten = hoten;
    }

    @Override
    public String toString() {
        return maKhachHang+","+hoten;
    }
    public abstract void showInfor();
}

