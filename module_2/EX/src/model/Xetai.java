package model;

public class Xetai extends Xe{
    private String trongTai;

    public Xetai() {
    }

    public Xetai(String bienKiemSoat, String tenHangSanXuat, String namSanXuat, String chuSanXuat, String trongTai) {
        super(bienKiemSoat, tenHangSanXuat, namSanXuat, chuSanXuat);
        this.trongTai = trongTai;
    }

    public Xetai(String[]xeTai) {
        super(xeTai[0], xeTai[1], xeTai[2], xeTai[3]);
        this.trongTai = xeTai[4];
    }

    @Override
    public String toString() {
        return  super.toString()+","+trongTai;
    }

    @Override
    public void showInFor() {
        System.out.println("Xe Tai ="+super.toString()+"trong tai=  "+trongTai) ;
    }

}
