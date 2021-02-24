package model;

public abstract class Xe {
    private String bienKiemSoat;
    private String tenHangSanXuat;
    private String namSanXuat;
    private String chuSanXuat;

    public Xe() {
    }

    public Xe(String bienKiemSoat, String tenHangSanXuat, String namSanXuat, String chuSanXuat) {
        this.bienKiemSoat = bienKiemSoat;
        this.tenHangSanXuat = tenHangSanXuat;
        this.namSanXuat = namSanXuat;
        this.chuSanXuat = chuSanXuat;
    }
    public Xe(String []xe) {
        this.bienKiemSoat = xe[0];
        this.tenHangSanXuat = xe[1];
        this.namSanXuat = xe[2];
        this.chuSanXuat = xe[3];
    }

    public String getBienKiemSoat() {
        return bienKiemSoat;
    }

    public void setBienKiemSoat(String bienKiemSoat) {
        this.bienKiemSoat = bienKiemSoat;
    }

    public String getTenHangSanXuat() {
        return tenHangSanXuat;
    }

    public void setTenHangSanXuat(String tenHangSanXuat) {
        this.tenHangSanXuat = tenHangSanXuat;
    }

    public String getNamSanXuat() {
        return namSanXuat;
    }

    public void setNamSanXuat(String namSanXuat) {
        this.namSanXuat = namSanXuat;
    }

    public String getChuSanXuat() {
        return chuSanXuat;
    }

    public void setChuSanXuat(String chuSanXuat) {
        this.chuSanXuat = chuSanXuat;
    }

    @Override
    public String toString() {
        return bienKiemSoat +","+ tenHangSanXuat +","+namSanXuat+","+chuSanXuat;
    }
    public abstract void showInFor();
}
