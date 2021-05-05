package model;

public class VnKhachHang extends KhachHang {
    private String loaiKhachHang;
    private String dinhMucTieuThu;

    public VnKhachHang() {
    }

    public VnKhachHang(String maKhachHang, String hoten, String loaiKhachHang, String dinhMucTieuThu) {
        super(maKhachHang, hoten);
        this.loaiKhachHang = loaiKhachHang;
        this.dinhMucTieuThu = dinhMucTieuThu;
    }
    public VnKhachHang(String []vnkhachHang) {
        super(vnkhachHang[0], vnkhachHang[1]);
        this.loaiKhachHang = vnkhachHang[2];
        this.dinhMucTieuThu = vnkhachHang[3];
    }

    @Override
    public String toString() {
        return super.toString()+","+loaiKhachHang+","+dinhMucTieuThu ;
    }

    @Override
    public void showInfor() {
        System.out.println("VnKhachHang{"+ super.toString() +
                "loaiKhachHang='" + loaiKhachHang + '\'' +
                ", dinhMucTieuThu='" + dinhMucTieuThu + '\'' +
                "} ");
    }
}