package model;

public class BenhAnThuong extends BenhAn {
    private int phiNamVien;

    public BenhAnThuong() {
    }

    public BenhAnThuong(int phiNamVien) {
        this.phiNamVien = phiNamVien;
    }

    public BenhAnThuong(int soThutuBenhAn, String maBenhAn, String maBenhNhan, String tenBenhNhan, String ngayNhapVien, String ngayRaVien, String lyDoNhapVien, int phiNamVien) {
        super(soThutuBenhAn, maBenhAn, maBenhNhan, tenBenhNhan, ngayNhapVien, ngayRaVien, lyDoNhapVien);
        this.phiNamVien = phiNamVien;
    }

    public BenhAnThuong(String[] benhAnThuong) {
        super(Integer.parseInt(benhAnThuong[0]), benhAnThuong[1], benhAnThuong[2], benhAnThuong[3], benhAnThuong[4], benhAnThuong[5], benhAnThuong[6]);
        this.phiNamVien = Integer.parseInt(benhAnThuong[7]);
    }

    public int getPhiNamVien() {
        return phiNamVien;
    }

    public void setPhiNamVien(int phiNamVien) {
        this.phiNamVien = phiNamVien;
    }

    @Override
    public String toString() {
        return super.toString() + "," + phiNamVien;
    }

    @Override
    public void hienThiThongTin() {
        System.out.println("BenhAnThuong{"
                + "soThutuBenhAn=" + getSoThutuBenhAn() + '\''
                + ", maBenhAn=" + getMaBenhAn() + '\''
                + ", maBenhNhan=" + getMaBenhNhan() + '\''
                + ", tenBenhNhan=" + getTenBenhNhan() + '\''
                + ", ngayNhapVien=" + getNgayNhapVien() + '\''
                + ", ngayRaVien=" + getNgayRaVien() + '\''
                + ", lyDoNhapVien=" + getLyDoNhapVien() + '\''
                + ", phiNamVien=" + phiNamVien + '\''
                + "} ");
    }
}
