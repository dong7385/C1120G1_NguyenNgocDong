package model;

public class Oto extends PhuongTien{
    private int soChoNgoi;
    private String kieuXe;

    public Oto() {
    }

    public Oto(String bienKiemSoat, String tenHang, String namSanXuat, String chuSoHuu, int soChoNgoi, String kieuXe) {
        super(bienKiemSoat, tenHang, namSanXuat, chuSoHuu);
        this.soChoNgoi = soChoNgoi;
        this.kieuXe = kieuXe;
    }
    public Oto(String[]oto) {
        super(oto[0], oto[1], oto[2], oto[3]);
        this.soChoNgoi = Integer.parseInt(oto[4]);
        this.kieuXe = oto[5];
    }


    public int getSoChoNgoi() {
        return soChoNgoi;
    }

    public void setSoChoNgoi(int soChoNgoi) {
        this.soChoNgoi = soChoNgoi;
    }

    public String getKieuXe() {
        return kieuXe;
    }

    public void setKieuXe(String kieuXe) {
        this.kieuXe = kieuXe;
    }

    @Override
    public String toString() {
        return super.toString()+","+soChoNgoi+","+kieuXe;
    }

    @Override
    public void hienThiThongTin() {
        System.out.println("Oto{"
                + "bienKiemSoat=" + getBienKiemSoat()+ '\''
                + ", tenHang=" + getTenHang()+ '\''
                + ", namSanXuat=" + getNamSanXuat()+ '\''
                + ", chuSoHuu=" + getChuSoHuu()+ '\''
                +", soChoNgoi=" + soChoNgoi+ '\''
                +", kieuXe='" + kieuXe+ '\''
                +"} ");
    }

}
