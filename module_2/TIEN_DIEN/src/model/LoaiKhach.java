package model;

public class LoaiKhach {
    private String maKhachHang;
    private String mucDichSuDung;

    public LoaiKhach() {
    }

    public LoaiKhach(String maKhachHang, String mucDichSuDung) {
        this.maKhachHang = maKhachHang;
        this.mucDichSuDung = mucDichSuDung;
    }
    public LoaiKhach(String[]loaiKhach) {
        this.maKhachHang = loaiKhach[0];
        this.mucDichSuDung = loaiKhach[1];
    }

    public String getMaKhachHang() {
        return maKhachHang;
    }

    public void setMaKhachHang(String maKhachHang) {
        this.maKhachHang = maKhachHang;
    }

    public String getMucDichSuDung() {
        return mucDichSuDung;
    }

    public void setMucDichSuDung(String mucDichSuDung) {
        this.mucDichSuDung = mucDichSuDung;
    }

    @Override
    public String toString() {
        return maKhachHang+","+mucDichSuDung;
    }
    public void showInfor(){
        System.out.println("LoaiKhach{" +
                "maKhachHang='" + maKhachHang + '\'' +
                ", mucDichSuDung='" + mucDichSuDung + '\'' +
                '}');
    }
}
