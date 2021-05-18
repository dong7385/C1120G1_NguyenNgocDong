package model;

public class XeTai extends PhuongTien {
    private int trongTai;

    public XeTai() {
    }

    public XeTai(String bienKiemSoat, String tenHang, String namSanXuat, String chuSoHuu, int trongTai) {
        super(bienKiemSoat, tenHang, namSanXuat, chuSoHuu);
        this.trongTai = trongTai;
    }
    public XeTai(String[]xeTai) {
        super(xeTai[0], xeTai[1], xeTai[2], xeTai[3]);
        this.trongTai = Integer.parseInt(xeTai[4]);
    }

    public int getTrongTai() {
        return trongTai;
    }

    public void setTrongTai(int trongTai) {
        this.trongTai = trongTai;
    }

    @Override
    public String toString() {
        return super.toString()+","+trongTai;
    }

    @Override
    public void hienThiThongTin() {
        System.out.println("XeTai{"
                + "bienKiemSoat=" + getBienKiemSoat()+ '\''
                + ", tenHang=" + getTenHang()+ '\''
                + ", namSanXuat=" + getNamSanXuat()+ '\''
                + ", chuSoHuu=" + getChuSoHuu()+ '\''
                +"trongTai=" + trongTai
                +"} " );
    }
}
