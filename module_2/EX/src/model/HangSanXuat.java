package model;

public class HangSanXuat {
    private String maSanPham;
    private String tenSanPham;
    private String noiXuatSu;

    public HangSanXuat() {
    }

    public HangSanXuat(String maSanPham, String tenSanPham, String noiXuatSu) {
        this.maSanPham = maSanPham;
        this.tenSanPham = tenSanPham;
        this.noiXuatSu = noiXuatSu;
    }
    public HangSanXuat(String []hangSanXuat) {
        this.maSanPham = hangSanXuat[0];
        this.tenSanPham = hangSanXuat[1];
        this.noiXuatSu = hangSanXuat[2];
    }

    public String getMaSanPham() {
        return maSanPham;
    }

    public void setMaSanPham(String maSanPham) {
        this.maSanPham = maSanPham;
    }

    public String getTenSanPham() {
        return tenSanPham;
    }

    public void setTenSanPham(String tenSanPham) {
        this.tenSanPham = tenSanPham;
    }

    public String getNoiXuatSu() {
        return noiXuatSu;
    }

    public void setNoiXuatSu(String noiXuatSu) {
        this.noiXuatSu = noiXuatSu;
    }

    @Override
    public String toString() {
        return maSanPham + "," + tenSanPham + "," + noiXuatSu;
    }
}
