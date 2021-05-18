package model;

public class BenhAnVip extends BenhAn {
    private String loaiVip;
    private String thoiHanVip;

    public BenhAnVip() {
    }

    public BenhAnVip(String loaiVip, String thoiHanVip) {
        this.loaiVip = loaiVip;
        this.thoiHanVip = thoiHanVip;
    }

    public BenhAnVip(int soThutuBenhAn, String maBenhAn, String maBenhNhan, String tenBenhNhan, String ngayNhapVien, String ngayRaVien, String lyDoNhapVien, String loaiVip, String thoiHanVip) {
        super(soThutuBenhAn, maBenhAn, maBenhNhan, tenBenhNhan, ngayNhapVien, ngayRaVien, lyDoNhapVien);
        this.loaiVip = loaiVip;
        this.thoiHanVip = thoiHanVip;
    }

    public BenhAnVip(String[] benhAnVip) {
        super(Integer.parseInt(benhAnVip[0]), benhAnVip[1], benhAnVip[2], benhAnVip[3], benhAnVip[4], benhAnVip[5], benhAnVip[6]);
        this.loaiVip = benhAnVip[7];
        this.thoiHanVip = benhAnVip[8];
    }

    public String getLoaiVip() {
        return loaiVip;
    }

    public void setLoaiVip(String loaiVip) {
        this.loaiVip = loaiVip;
    }

    public String getThoiHanVip() {
        return thoiHanVip;
    }

    public void setThoiHanVip(String thoiHanVip) {
        this.thoiHanVip = thoiHanVip;
    }

    @Override
    public String toString() {
        return super.toString() + "," + loaiVip + "," + thoiHanVip;
    }

    @Override
    public void hienThiThongTin() {
        System.out.println("BenhAnVip{"
                + "soThutuBenhAn=" + getSoThutuBenhAn() + '\''
                + ", maBenhAn=" + getMaBenhAn() + '\''
                + ", maBenhNhan=" + getMaBenhNhan() + '\''
                + ", tenBenhNhan=" + getTenBenhNhan() + '\''
                + ", ngayNhapVien=" + getNgayNhapVien() + '\''
                + ", ngayRaVien=" + getNgayRaVien() + '\''
                + ", lyDoNhapVien=" + getLyDoNhapVien() + '\''
                + ", loaiVip=" + loaiVip + '\''
                + ", thoiHanVip=" + thoiHanVip + '\''
                + "} ");
    }
}
