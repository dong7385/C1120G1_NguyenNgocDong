package model;

public class XeMay extends Xe {
    private String congXuat;

    public XeMay() {
    }

    public XeMay(String bienKiemSoat, String tenHangSanXuat, String namSanXuat, String chuSanXuat, String congXuat) {
        super(bienKiemSoat, tenHangSanXuat, namSanXuat, chuSanXuat);
        this.congXuat = congXuat;
    }
    public XeMay(String[]xemay) {
        super(xemay[0], xemay[1], xemay[2], xemay[3]);
        this.congXuat = xemay[4];
    }

    @Override
    public String toString() {
        return super.toString()+","+congXuat;
    }
    @Override
    public void showInFor() {
        System.out.println("\"XeMay{\" +\n" +
                "                \"congXuat='\" + congXuat + '\\'' +\n" +
                "                \"} \" + super.toString();");
    }
}
